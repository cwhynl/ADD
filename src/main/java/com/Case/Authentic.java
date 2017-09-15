package com.Case;

import org.testng.annotations.Test;
import com.logic.Logic;
import com.test.name;

public class Authentic extends Logic {

 
	@Test
	public void case1() {
		login(phoneNum(), phoneNum());	
		name.printResult();
	}

	// @Test
	// public void case2() {
		// seeker_auth(phoneNum(), phoneNum());
		// name.printResult();
	// }

	// @Test
	// public void case3() {
		// hunter_auth();
		// name.printResult();
	// }

//	@BeforeMethod
//	public void beforeMethod() {
//		System.out.println("测试开始了");
//
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//		System.out.println("测试结束了");
//	}

}
