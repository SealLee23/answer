package com.example.solution.service.imp;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

//import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.solution.dao.IUserRepository;
import com.example.solution.entity.po.UserEntity;
import com.example.solution.entity.vo.UserVO;
import com.example.solution.service.IUserService;

@Service
public class IUserServiceImp implements IUserService{

	private @Autowired IUserRepository userRepo;
	
	@Override
	@Transactional
	public void create(UserVO user) {
		UserEntity u = new UserEntity();
		u.setId(UUID.randomUUID().toString());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		userRepo.save(u);
	}
	
	

	@Override
	public List<UserEntity> getUser(UserVO user) {
		UserEntity u = new UserEntity();
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		Example<UserEntity> example = Example.of(u);
		
		List<UserEntity>list = this.userRepo.findAll(example);
		return list;
	}

	@Override
	@Transactional
	public void update(String id, UserVO userVO) {
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setFirstName(userVO.getFirstName());
		user.setLastName(userVO.getLastName());
		user.setEmail(userVO.getEmail());
		this.userRepo.save(user);
	}

	@Override
	public void delete(String id) {
		this.userRepo.deleteById(id);
	}
	

	@Override
	public UserEntity getUser(String id) {
		return userRepo.getOne(id);
	}



	@Override
	public List<UserEntity> getAllUser() {
		return this.userRepo.findAll();
	}



	@Override
	@Transactional
	public void create(List<UserVO> userVOs) {
		if(userVOs==null||userVOs.isEmpty())
			return;
		List<UserEntity> users = userVOs.stream().filter(t->t!=null).map(t->{UserEntity u = new UserEntity();u.setId(UUID.randomUUID().toString());u.setEmail(t.getEmail());u.setFirstName(t.getFirstName());u.setLastName(t.getLastName()); return u;}).collect(Collectors.toList());
		this.userRepo.saveAll(users);    
		
	}

}
