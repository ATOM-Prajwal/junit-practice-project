package com.nttdata.data.api;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ToDoServiceStub implements TodoService {

	
	public List<String> retriveToDos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Spring MVC","Spring"," Dance");
	}

	public void deleteToDo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
