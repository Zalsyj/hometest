package org.hometest.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
	private Model model;
	
	@Before
	public void setUp() throws Exception {
		
		this.model = new Model();		
	}
	
	@Test
	public void testGetHelloWorld() {
		Assert.assertEquals("Hello World", this.model.getHelloWorld());		
	}
	
	@Test
	public void testDummy() {
		Assert.assertEquals(true, true);		
	}
}


