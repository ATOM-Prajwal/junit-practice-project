package com.nttdata.mockito;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.everyItem;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;



public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99, 100, 105, 109);

		assertThat(scores, hasSize(109));// to check the size of the object
		assertThat(scores, hasItems(99, 109));// used to check item present in object or not
		assertThat(scores, everyItem(greaterThan(90)));// to check every item is > all values
		assertThat(scores, everyItem(lessThan(120)));// to check every item is < all values

		assertThat("", isEmptyString());// to check string empty or not
		assertThat(null, isEmptyOrNullString());// to check string null/empty or not

		Integer[] marks = { 1, 2, 3 };
		assertThat(marks, arrayWithSize(3));// to check the size of the array object
		assertThat(marks, arrayContaining(1, 2, 3));// to check item present in array object or not
		assertThat(marks, arrayContainingInAnyOrder(2, 1, 3));
	}

}
