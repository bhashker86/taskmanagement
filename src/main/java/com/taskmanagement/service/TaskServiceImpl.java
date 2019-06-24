package com.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.taskmanagement.dto.TaskDTO;
import com.taskmanagement.entity.TaskEntity;
import com.taskmanagement.repository.TaskRepository;

@Service
public class TaskServiceImpl  implements TaskService{

	
	@Autowired
	private TaskRepository task_repo;
	
	
	public TaskDTO createTask(TaskDTO task) {
		
		TaskEntity task_entity=new TaskEntity();
		task_entity.setName(task.getName());
		task_entity.setDescription(task.getDescription());
		task_entity.setStatus(task.isStatus());
		
		
		TaskEntity generated_task=task_repo.save(task_entity);
		TaskDTO new_task=new TaskDTO();
		new_task.setId(generated_task.getId());
		new_task.setName(generated_task.getName());
		new_task.setDescription(generated_task.getDescription());
		new_task.setStatus(generated_task.isStatus());
		return new_task;
	
	}
	
	
}
