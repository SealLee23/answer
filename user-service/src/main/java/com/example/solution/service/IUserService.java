package com.example.solution.service;

import java.util.List;

import com.example.solution.entity.po.UserEntity;
import com.example.solution.entity.vo.UserVO;

public interface IUserService {
	
	public void create(UserVO user);
	
	public void create(List<UserVO> users);
	
	public List<UserEntity> getUser(UserVO user);
	
	public UserEntity getUser(String id);

	public void update(String id, UserVO user);
	
	public void delete(String id);
	
	public List<UserEntity> getAllUser();
}
