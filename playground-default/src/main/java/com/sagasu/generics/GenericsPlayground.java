package com.sagasu.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsPlayground<T> {

	private T t;
	
	// illegal w/o specifying type
	//private ArrayList<> al;

	public List<String> getArrayList(){
		List<String> list = new ArrayList<>();
		return list;
	}
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
