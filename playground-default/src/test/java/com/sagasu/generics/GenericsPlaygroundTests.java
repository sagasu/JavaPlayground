package com.sagasu.generics;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GenericsPlaygroundTests {
	
	@Test
	public void setT_string_expectSetStringToBeReturned(){
		GenericsPlayground<String> gps = new GenericsPlayground<String>();
		gps.setT("foo");
		
		Assert.assertEquals("foo", gps.getT());
	}
	
	@Test
	public void setT_int_expectSetIntToBeReturned(){
		GenericsPlayground<Integer> gps = new GenericsPlayground<Integer>();
		gps.setT(1);
		
		// This is crazy, that: assertEquals(1, gps.getT())  doesn't work
		// with: The method assertEquals(Object, Object) is ambiguous for the type 
		assertEquals(Integer.valueOf(1), gps.getT());
	}

}
