package com.insurance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	@RequestMapping("/insurance")
	public String getContect() {
		return "contect";
	}
}
