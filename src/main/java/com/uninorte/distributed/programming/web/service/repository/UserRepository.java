package com.uninorte.distributed.programming.web.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninorte.distributed.programming.web.service.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
