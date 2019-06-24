package com.taskmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.taskmanagement.entity.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer>{

	public Iterable<TaskEntity> findByNameOrDescriptionAllIgnoreCase(String name,String description);
	public TaskEntity findById(int id);
	public TaskEntity findByName(String name);
	public void deleteByName(String name);
}
