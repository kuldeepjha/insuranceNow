package com.insurance.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.bean.ErrorDetails;
import com.insurance.model.EmailServiceModel;
import com.insurance.service.EmailService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/insurance")
public class EmailServiceController {

    @Autowired
    EmailService emailService;
    
    @ApiOperation(value = "Retrieve a date by @PathVariable.", notes = "Retrieves the content of the specified model.", response = EmailServiceController.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = EmailServiceController.class),
	    @ApiResponse(code = 400, message = "Bad Request...", response = EmailServiceController.class),
	    @ApiResponse(code = 404, message = "Not found", response = EmailServiceController.class),
	    @ApiResponse(code = 500, message = "Internal Server Error", response = EmailServiceController.class) })
    @RequestMapping(value = "/getMessage", produces = { "application/json" }, method = RequestMethod.PUT)
    public void getMessage(@ApiParam(value = "message", required = true) String message, String email, String subject,
	    Date date, Integer phone) {
	
	emailService.getMessageDate(message, email, subject, date, phone);

    }

    @ApiOperation(value = "Retrieve a model by ID.", notes = "Retrieves the content of the specified model.", response = ErrorDetails.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ErrorDetails.class),
	    @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetails.class),
	    @ApiResponse(code = 404, message = "Not found", response = ErrorDetails.class) })
    @RequestMapping(value = "/getMessageUsingEntity", produces = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<String> getMessage(
	    @ApiParam(value = "send coustomer query to admin", required = true) @RequestBody EmailServiceModel mailServiceModel) {

	emailService.getMessageDate(mailServiceModel);
	return new ResponseEntity<String>(HttpStatus.OK);
    }

}
