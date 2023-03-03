package com.nttdata.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.nttdata.buisiness.TodoBusinessImpl;
import com.nttdata.data.api.ToDoServiceStub;
import com.nttdata.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testretriveToDoRelatedToSpring_UsingMock() {
		// 1.use mock method
		TodoService todoServiceMock = mock(TodoService.class);

		// 2.dummy values
		List<String> todos = Arrays.asList("Learn To Spring MVC", "Learn To Spring ", "Learn To Dance");

		// 3.if calling servcie method then returning some values
		// AKA dynaminc stunning method
		when(todoServiceMock.retriveToDos("Dummy")).thenReturn(todos);

		// Don't prefer stub technique
		// TodoService todoServiceStub = new ToDoServiceStub();

		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filterTodos = todobusinessImpl.retriveToDoRelatedToSpring("Dummy");
		assertEquals(2, filterTodos.size());
	}

	@Test
	public void testretriveToDoRelatedToSpring_emptyListMock() {

		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retriveToDos("Dummy")).thenReturn(todos);

		// TodoService todoServiceStub = new ToDoServiceStub();

		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filterTodos = todobusinessImpl.retriveToDoRelatedToSpring("Dummy");
		assertEquals(0, filterTodos.size());
	}

	//BDD Method
	@Test
	public void testretriveToDoRelatedToSpring_UsingBDDMock() {
		// Given= setup
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn To Spring MVC", "Learn To Spring ", "Learn To Dance");

		given(todoServiceMock.retriveToDos("Dummy")).willReturn(todos);

		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When=calling method
		List<String> filterTodos = todobusinessImpl.retriveToDoRelatedToSpring("Dummy");

		// Then=assertion
		
		//instead assertEquals used
		assertThat(filterTodos.size(),is(2) );
		
		//assertEquals(2, filterTodos.size());
	}

	@Test
	public void testretriveToDoNotRelatedToSpring_UsingBDDMock() {
		// Given= setup
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn To Spring MVC", "Learn To Spring ", "Learn To Dance");

		given(todoServiceMock.retriveToDos("Dummy")).willReturn(todos);

		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When=calling method
		todobusinessImpl.deleteToDoRelatedToSpring("Dummy");

		// Then=assertion
		//verify(todoServiceMock).deleteToDo("Learn To Dance");
		// mockito method
		verify(todoServiceMock,never()).deleteToDo("Learn To Spring");
		verify(todoServiceMock,times(1)).deleteToDo("Learn To Dance");
		
		//or used BDD method 
		then(todoServiceMock).should().deleteToDo("Learn To Dance");
		then(todoServiceMock).should(never()).deleteToDo("Learn To Spring");
			
	}
	
	//argument capture
	@Test
	public void testretriveToDoNotRelatedToSpring_UsingArgumentCapture() {
		
		//declare argument capture
		ArgumentCaptor<String> stringArgCapture=ArgumentCaptor.forClass(String.class);
		
		// Given= setup
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn To Spring MVC", "Learn To Spring ", "Learn To Dance");

		given(todoServiceMock.retriveToDos("Dummy")).willReturn(todos);

		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When=calling method
		todobusinessImpl.deleteToDoRelatedToSpring("Dummy");

		// Then=assertion
		
		//define argument capture on method & capture the argument
		then(todoServiceMock).should().deleteToDo(stringArgCapture.capture());
		assertThat(stringArgCapture.getValue(), is("Learn To Dance"));
			
	}
}
