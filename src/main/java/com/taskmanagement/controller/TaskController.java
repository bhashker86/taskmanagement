package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dto.TaskDTO;
import com.taskmanagement.service.TaskService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
@RequestMapping("api/v1/task")
public class TaskController {
	
	@Autowired
	private TaskService  task_Service;
	

	@PostMapping("add")	
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO task){
	    return new ResponseEntity<>(task_Service.createTask(task),HttpStatus.CREATED);	
	}

}
