package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

public class ContainerClass extends Task {
	
	private ArrayList<Task> subTask = new ArrayList<>();
	
	public ContainerClass(String name, String description, TaskPriority priority) {
		super(name, description, priority);
	}
	
	@Override
	public ContainerClass addTask(Task currTask) {
		this.subTask.add(currTask);
		return this;
		
	}

	@Override
	public ArrayList<Task> getSubTask(){
		return this.subTask;
	}
	
	@Override
	public String toString() {
		return super.getName() + this.getName();
	}
}
