package kr.co.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSample {
	
	

	@Test
	public void test() {
		//int a = 5/0;
		System.out.println("테스트");
		int count = 30;
		assertEquals(30, count);
		assertTrue(true);
	}
	@Test
	public void test2() {
		System.out.println("테스트2");
	}
	
	@Before // 각 메서드 실행 전
	public void before() {
		System.out.println("before");
	}
	@After // 각 메서드 실행 후
	public void after() {
		System.out.println("after");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("처음 한번만");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("마지막 한번만");
	}
}
