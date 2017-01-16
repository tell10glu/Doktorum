package com.doktorum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doktorum.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
