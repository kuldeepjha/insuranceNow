package com.insurance.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.insurance.model.EmailServiceModel;

@Service
public interface EmailService {

    void getMessageDate(@PathVariable String message, String email, @PathVariable String subject,
	    @PathVariable Date date, int phone);

    void getMessageDate(EmailServiceModel emailServiceModel);
}
