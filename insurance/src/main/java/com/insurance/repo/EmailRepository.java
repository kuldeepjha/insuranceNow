package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.EmailServiceModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailServiceModel, Long> {

}
