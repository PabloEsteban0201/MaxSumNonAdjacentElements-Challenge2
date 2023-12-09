package com.challengetheft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengetheft.app.request.MoneyRequest;
import com.challengetheft.app.response.MoneyStolenResponse;
import com.challengetheft.app.service.StealMoneyService;

/**
 * Controller for StealMoney Service
 */
@RestController
@RequestMapping("/")
public class StealMoneyController {
	
	/**
	 * StealMoney Service
	 */
	@Autowired
	private StealMoneyService stealService;
	
	/**
	 * End-point to test the API
	 * @return 200 and Hello world
	 */
	@GetMapping
	public ResponseEntity<?> helloWorld(){
		
		return ResponseEntity.status(HttpStatus.OK).body("Hello world");
	}
	
	/**
	 * End-point to computes the maximum sum in an array of non-adjacent numbers
	 * @param houseMoney The array of numbers representing the money of each house
	 * @return 200 and the maximum amount of money stolen
	 * @return 404 if an error occurs
	 */
	@PostMapping("/rob")
	public ResponseEntity<?> rob(@RequestBody MoneyRequest houseMoney){
		
		try {
			
			MoneyStolenResponse moneyStolen = new MoneyStolenResponse(stealService.stealMoney(houseMoney.getMoney()));
			return ResponseEntity.status(HttpStatus.OK).body(moneyStolen);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	}

}
