package com.example.solution.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.solution.amqp.configuration.AMQPConfiguration;
import com.example.solution.entity.po.UserEntity;
import com.example.solution.entity.vo.UserVO;
import com.example.solution.service.IUserService;

@RestController
@CrossOrigin(origins= "*", maxAge=3600)
@RequestMapping(path="/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	private @Autowired IUserService userService;
	private @Autowired RabbitTemplate msgTemplate;
	@RequestMapping(path="/create", method=RequestMethod.PUT)
	ResponseEntity createUsers(@RequestBody @Valid @NotNull @NotEmpty List<UserVO>userVOs) {
//		List<UserEntity> users = userVOs.stream().filter(t-> t!=null).map(t,)map
		this.userService.create(userVOs);
		Map<String,List<UserVO>>map = new HashMap<>();
		map.put("OK", userVOs);
		msgTemplate.convertSendAndReceive(AMQPConfiguration.topicExchangeName, "user.creation.successful", "Great creation!");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@RequestMapping(path="/get/{id}", method=RequestMethod.GET)
	ResponseEntity<UserEntity> findUser(@NotNull @PathVariable String id) {
		UserEntity user = this.userService.getUser(id);
		if(user==null || user.getId()==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(path="/getAll", method=RequestMethod.GET)
	ResponseEntity<List<UserEntity>> findAll() {
		List<UserEntity> users = this.userService.getAllUser();
		if(users==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(path="/update", method=RequestMethod.POST)
	void updateUser(UserEntity user) {
		this.updateUser(user);
	}
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	void deleteUser() {
		this.deleteUser();
	}
}
