package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.exception.TouristNotFoundException;
import com.telusko.pojo.Tourist;
import com.telusko.service.ITouristMangement;

@RestController
@RequestMapping("/api")
public class TouristController 
{
	@Autowired
	private ITouristMangement service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
	{
		String msg = service.registerTourist(tourist);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllTourist()
	{
		
		List<Tourist> list = service.fetchAllTourists();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/findByid/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable("id")Integer id)
	{
		
		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<>(tourist,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTouristRecord(@RequestBody Tourist tourist)
	{
		
		String status=service.updateTouristData(tourist);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
	@PatchMapping("/updateBudget/{id}/{budget}")
	public ResponseEntity<String> updateTouristRecord(@PathVariable("id") Integer id,@PathVariable("budget")Double budget)
	{
		
		String status=service.updateTouristDataById(id,budget);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristRecord(@PathVariable("id") Integer id)
	{

		String status=service.deleteTouristById(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
}
