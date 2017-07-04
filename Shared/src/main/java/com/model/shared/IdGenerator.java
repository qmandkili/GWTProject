package com.model.shared;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	
	private AtomicInteger nextId;
	
	public int getId() {
		return nextId.getAndIncrement();
	}

}
