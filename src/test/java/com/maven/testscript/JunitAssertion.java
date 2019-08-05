package com.maven.testscript;

import org.junit.Test;

import junit.framework.Assert;



@SuppressWarnings("deprecation")
public class JunitAssertion {
	@Test
	public void test1() {
		String s="Hello";
		Assert.assertEquals("Hello", s);
	}
@SuppressWarnings("deprecation")
@Test

public void test2() {
	String expected="Hello";
	String actual="Hello";
	Assert.assertEquals(expected, actual);
	System.out.println("Test Passed");
}
}
