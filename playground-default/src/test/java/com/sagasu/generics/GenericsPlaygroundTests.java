package com.sagasu.generics;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GenericsPlaygroundTests {
	
	@Test
	public void setT_string_expectSetStringToBeReturned(){
		GenericsPlayground<String> gps = new GenericsPlayground<String>();
		String expectedString = "foo";
		gps.setT(expectedString);
		
		Assert.assertEquals("foo", gps.getT());
	}
	
	@Test
	public void setT_int_expectSetIntToBeReturned(){
		GenericsPlayground<Integer> gps = new GenericsPlayground<Integer>();
		Integer expectedInt = 1;
		gps.setT(expectedInt);
		
		// This is crazy, that: assertEquals(1, gps.getT())  doesn't work
		// with: The method assertEquals(Object, Object) is ambiguous for the type 
		assertEquals(Integer.valueOf(expectedInt), gps.getT());
	}

}
