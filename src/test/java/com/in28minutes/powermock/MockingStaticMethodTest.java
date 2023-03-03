package com.in28minutes.powermock;

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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nttdata.buisiness.TodoBusinessImpl;
import com.nttdata.data.api.ToDoServiceStub;
import com.nttdata.data.api.TodoService;

//specific runner.class 
//initialized utility class 
//mock

//step:1
@RunWith(PowerMockRunner.class)
//step:2
@PrepareForTest(UtilityClass.class) //class containing static method to be mocked
public class MockingStaticMethodTest {

		
	@org.mockito.Mock// it will create mock of specific class with the help of mock method  
	 Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemundertest;
	
	@Test
	public void testretriveToDoRelatedToSpring_UsingMock() {
		
		// 2.dummy values
		List<Integer> stats = Arrays.asList(1,2,3);

		// 3.if calling servcie method then returning some values
		// AKA dynaminc stunning method
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		//step:3
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(1)).thenReturn(150);
		
		int result=systemundertest.methodCallingAStaticMethod();
		
		assertEquals(150, result);
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
	}


}
