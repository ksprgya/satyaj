package com.satyaj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyaj.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
