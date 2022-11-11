package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BusException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.model.Route;
import com.tj.service.RouteService;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService rService;
	
	@PostMapping("/routes")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) throws RouteException{
		
		 Route r = rService.addRoute(route);
		 
		 return new ResponseEntity<Route>(r,HttpStatus.OK);
		
	}
	
	@GetMapping("/book/{routeId}/{busId}/{ticketId}")
	public ResponseEntity<Route> bookTicket(@PathVariable("routeId") Integer routeId ,@PathVariable("busId") Integer busId,@PathVariable("ticketId") Integer ticketId) throws RouteException, BusException, TicketException{
		Route r = rService.ticketBook(routeId, busId, ticketId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
	@PutMapping("/routes")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) throws RouteException{
		Route r = rService.updateRoute(route);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{routeId}")
	public ResponseEntity<Route> removeRoute(@PathVariable("routeId") Integer routeId) throws RouteException{
		Route r = rService.removeRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
		List<Route> routeList = rService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
		
	}
	
	@GetMapping("/routesbyid")
	public ResponseEntity<Route> searchRoute(Integer routeId) throws RouteException{
		
		Route r = rService.searchRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}

}
