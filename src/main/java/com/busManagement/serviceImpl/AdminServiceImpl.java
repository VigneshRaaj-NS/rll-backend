package com.busManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busManagement.Dao.*;
import com.busManagement.entity.Admin;
import com.busManagement.entity.BookingDetails;
import com.busManagement.entity.BusDetails;
import com.busManagement.entity.Passenger;
import com.busManagement.exception.AdminAlreadyExistException;
import com.busManagement.exception.AdminDoesnotExistException;
import com.busManagement.exception.BookingDoesNotFoundException;
import com.busManagement.exception.BusDetailsNotFoundException;
import com.busManagement.exception.NullAdminException;
import com.busManagement.exception.NullBusDetailsException;
import com.busManagement.service.AdminService;
import com.busManagement.utils.AdminAuth;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	BusDetailsDao busDao;
	
	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	BookingDetailsDao bookingDao;

	//adding admin to the database
	@Override
	public Admin addAdmin(Admin admin) {
		if (admin == null)
			throw new NullAdminException("no data provided");
		Integer adminId = (int) ((Math.random() * 900) + 100); //
		
		admin.setAdminId(adminId);
		Optional<Admin> checkAdmin = adminDao.findById(admin.getAdminId());
		if (checkAdmin.isPresent()) {
			throw new AdminAlreadyExistException("admin already exist exception");
		} else {
			adminDao.save(admin);
			System.out.println(adminId);
			return admin;
		}
	}
	
	
//for getting admin by ID
	@Override
	public Admin getAdmin(Integer adminId) {
		if (adminId == null)
			throw new NullAdminException("no data provided");
		Optional<Admin> admin = adminDao.findById(adminId);
		if (!admin.isPresent()) {
			throw new AdminDoesnotExistException("admin does not exist ");
		}
		return admin.get();
	}
	
	//FOR DELETING ADMIN
	@Override
	public void deleteAdmin(Integer adminId) {
		if (adminId == null)
			throw new NullAdminException("no data provided");
		Optional<Admin> admin = adminDao.findById(adminId);
		if (!admin.isPresent()) {
			throw new AdminDoesnotExistException("admin Doesnot Exist Exception");
		}
		adminDao.deleteById(adminId);
	}
    
	//a
	@Override
	public Admin adminLogin(AdminAuth auth) {
		if (auth == null) {
			throw new NullAdminException("no data provided");
		}
		Optional<Admin> admin = adminDao.findById(auth.getAdminId());
		if (admin.isPresent()) {
			
			///////Check
			if (admin.get().getAdminId() == auth.getAdminId() && admin.get().getPassword().equals(auth.getPassword())) {
				return admin.get();
			} else {
				throw new AdminDoesnotExistException("invalid login id or password");
			}
			
		} else
			throw new AdminDoesnotExistException("admin doesnot exist");
	}
     
	
	//For getting all the bus details
	@Override
	public List<BusDetails> getAllBusDetails() {
		return busDao.findAll();
	}
    
	//For adding bus details
	@Override
	public BusDetails addBusDetails(BusDetails details) {
		if (details == null) {
			throw new NullBusDetailsException("no data provided");
		}
		Integer busNumber = (int) ((Math.random() * 9000) + 1000);
		details.setBusNumber(busNumber);
		busDao.save(details);
		return details;
	}

	//Deleting Bus By ID
	@Override
	public void deleteBus(Integer busNumber) {
		if (busNumber == null)
			throw new NullBusDetailsException("No data recieved..");
		Optional<BusDetails> details = busDao.findById(busNumber);
		if (!details.isPresent()) {
			throw new BusDetailsNotFoundException("Bus Details not found");
		}
		busDao.deleteById(busNumber);
	}
    
	//Updating the bus details By ID
	@Override
	public BusDetails updateBus(BusDetails details) {
		if (details == null)
			throw new NullBusDetailsException("No data recieved..");
		Optional<BusDetails> busDetails = busDao.findById(details.getBusNumber());
		if (!busDetails.isPresent()) {
			throw new BusDetailsNotFoundException("Bus with busNumber: " + details.getBusNumber() + " not exists..");
		}
		busDao.save(details);
		return details;
	}
	
	
	//Gettin all the passengers
	public List<Passenger> getAllPassengers(){
		return passengerDao.findAll();
	}
	
	//Getting list of passengers by ID
	public List<Passenger> getPassengersByBooking(Integer id){
		if (id == null) throw new BookingDoesNotFoundException("no data provided");
		Optional<BookingDetails> details = bookingDao.findById(id);
		if (!details.isPresent())
			throw new BookingDoesNotFoundException("booking not found");
		return details.get().getPassengers();
	}

}
