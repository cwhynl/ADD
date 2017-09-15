package com.Case;

import org.testng.annotations.Test;

import com.logic.login_Logic;
import com.test.name;


public class Verilogin extends login_Logic {
	@Test
	public void case32() { 
		getvericode("");
		 name.printResult();
	 } 
	@Test
	public void case33() {
		getvericode("1376543234");
		 name.printResult();
	 } 
//	@Test
//	public void case34() {
//		getvericode("23790887788");
//		 name.printResult();
//	 } 
//	@Test
//	public void case35() { 	 
//		getvericode("11111112222");
//		 name.printResult();
//	 } 
//	@Test
//	public void case36() { 	 
//		longinput("134234323432");
//		 name.printResult();
//	 } 
//	@Test
//	public void case37() { 	 
//		isbtngrey("13423432343","");
//		 name.printResult();
//	 } 
//	@Test
//	public void case38() { 	 
//		isbtngrey("13423432343","1111");
//		 name.printResult();
//	 } 
//	@Test
//	public void case39() { 	 
//		snslogin(phoneNum(),0);
//		 name.printResult();
//	 } 
//	@Test
//	public void case40() { 	 
//		correctInput(pn);
//		 name.printResult();
//	 } 
//	@Test
//	public void case41() { 	 
//		snslogin(pn,1);
//		 name.printResult();
//	 } 
//	@Test
//	public void case42() { 	 
//		oldlogin("17700000002");
//		 name.printResult();
//	 } 
}
