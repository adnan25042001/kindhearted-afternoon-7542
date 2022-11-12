package com.tj.controller;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import javax.validation.Valid;

>>>>>>> 5ec7d91eceae3d076303784df4f3bb4f4b0232b5
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Hotel;
import com.tj.service.HotelService;
import com.tj.model.Package;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> viewAllHoltels() throws HotelException {
		List<Hotel> hList = hotelService.viewAllHotels();
		return new ResponseEntity<List<Hotel>>(hList,HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hId}/{pId}")
	public ResponseEntity<Package> addPackage(@PathVariable("hId") Integer hotelId, @PathVariable("pId") Integer packageId) throws HotelException, PackageException{
		
	         Package p = hotelService.addPackage(hotelId, packageId);
	         
	         return new ResponseEntity<Package>(p,HttpStatus.OK);
	}

}
