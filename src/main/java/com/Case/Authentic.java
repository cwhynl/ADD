package com.Case;

import org.testng.annotations.Test;

import com.logic.Logic;
import com.test.Xml;
import com.test.name;

public class Authentic extends Logic {

 
	@Test
	public void case1() {
//		login(phoneNum(), phoneNum());	
		ClickandInput(new String[][]{
				{Xml.read("welcome"),""},
				{Xml.read("p_edt"),phoneNum()},
				{Xml.read("sms_btn"),""},
				{Xml.read("code_edt"),"1111"},
				{Xml.read("loginbtn"),""}
		});
		name.printResult();
	}

//     @Test
     public void case2() {
		seeker_auth(phoneNum(), phoneNum());
		name.printResult();
	 }

//	  @Test   
	  public void case3() {
		 hunter_auth();
	     name.printResult();
	  }

	

}
