package com.example.solution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.solution.entity.po.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {
 
}