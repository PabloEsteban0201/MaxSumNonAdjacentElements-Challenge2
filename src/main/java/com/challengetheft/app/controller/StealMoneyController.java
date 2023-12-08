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

@RestController
@RequestMapping("/")
public class StealMoneyController {
	
	@Autowired
	private StealMoneyService stealService;
	
	@GetMapping
	public ResponseEntity<?> helloWorld(){
		
		return ResponseEntity.status(HttpStatus.OK).body("Hello world");
	}
	
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
