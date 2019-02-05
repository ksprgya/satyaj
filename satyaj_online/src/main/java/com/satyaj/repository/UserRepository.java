package com.satyaj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satyaj.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
