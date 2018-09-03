package com.insurance.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.insurance.model.EmailServiceModel;
import com.insurance.repo.EmailRepository;
import com.insurance.service.EmailService;

public class EmailServiceImpl implements EmailService{

    @Autowired
    EmailServiceModel emailServiceModel;
    
    @Autowired
    EmailRepository emailRepository;
    
    @Override
    public void getMessageDate(String message, String email, String subject, Date date, int phone) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void getMessageDate(EmailServiceModel emailServiceModel) {
	// TODO Auto-generated method stub
	emailRepository.save(emailServiceModel);
    }

}
