package com.nttdata.buisiness;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.data.api.TodoService;

public class TodoBusinessImpl {

	
	private TodoService todoservice;

	public TodoBusinessImpl(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	public List<String> retriveToDoRelatedToSpring(String user) {
		List<String> filtertodo = new ArrayList<String>();
		
		List<String> todos = todoservice.retriveToDos(user);

		for (String todo : todos) {

			if (todo.contains("Spring")) {
				filtertodo.add(todo);
			}
		}
		return filtertodo;
	}
	
	public void  deleteToDoRelatedToSpring(String user) {
	
		List<String> todos = todoservice.retriveToDos(user);

		for (String todo : todos) {

			if (!todo.contains("Spring")) {
				todoservice.deleteToDo(todo);
			}
		}
		
	}
}
