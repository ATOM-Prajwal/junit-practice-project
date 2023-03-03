package com.nttdata.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.nttdata.buisiness.TodoBusinessImpl;
import com.nttdata.data.api.ToDoServiceStub;
import com.nttdata.data.api.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void testretriveToDoRelatedToSpring_UsingStub() {
		TodoService todoServiceStub =new ToDoServiceStub();
		TodoBusinessImpl todobusinessImpl =new TodoBusinessImpl(todoServiceStub);
		
		List<String> filterTodos=todobusinessImpl.retriveToDoRelatedToSpring("Dummy");
		
		assertEquals(2, filterTodos.size());
	}

}
