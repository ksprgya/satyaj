package com.satyaj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyaj.model.UserDocuments;

public interface UserDocumentsRepository extends JpaRepository<UserDocuments, Long>{

}
