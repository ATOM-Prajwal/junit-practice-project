package com.nttdata.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListsize() {
		List listmock=mock(List.class);
		when(listmock.size()).thenReturn(2);
		assertEquals(2, listmock.size());
	}
	
	@Test
	public void mockListsizewithMultipleValues() {
		List listmock=mock(List.class);
		when(listmock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listmock.size());
		assertEquals(3, listmock.size());
	}
	
	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", list.get(0));
		assertEquals(null, list.get(1));
		assertNull(list.get(1));
	}
	
	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		//argument Matcher
		when(list.get(anyInt())).thenReturn("in28Minutes");
		
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}
	
	@Test
	public void letsMockListGetWithAny_UsingBDD() {
		//Given
		List<String> list = mock(List.class);
		when(list.get(anyInt())).thenReturn("in28Minutes");
		
		//When
		String firstElement=list.get(0);
		
		//Then
		assertThat(firstElement, is("in28Minutes"));
		
		//assertEquals("in28Minutes", list.get(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockListThrowsException() {
		List list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("something"));
		
		 list.get(0);
		}

}
