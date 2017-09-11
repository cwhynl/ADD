package com.Case;

import org.testng.annotations.Test;

import com.logic.Logic1;
import com.test.name;

public class Login extends Logic1 {
	@Test
	public void case11() {
		btngrey("13765456789", "");
		name.printResult();
	}
	 @Test
	public void case12() {
		btngrey("13765456789", "12345");
		name.printResult();
	}
	
	 @Test
	public void case13() {
	  btngrey("13765456789", "123456");
	  name.printResult();
	}
	 @Test
	public void case14() {
	  errorPhonenum("1376545678", "123456");
	  name.printResult();
	}
	 @Test
	public void case15() {
	  errorPhonenum("1374544d234", "123456");
	  name.printResult();
	}
	 @Test
	public void case16() {
	  errorPhonenum("23765456789", "123456");
	  name.printResult();
	}
	 @Test
	public void case17() {
	  errorPhonenum("11122233344", "123456");
	  name.printResult();
	}
	 @Test
	public void case18() { 
	 errorpw("17700000004","688888");	 
	 name.printResult(); 	 
	 } 
	 @Test
	public void case19() { 
	  inputmore("17700000004","11111111122222222223");
	  name.printResult(); 
	 }	
	 @Test
	public void case21(){
	  seeornosee("17700000004","111111");
	  name.printResult(); 
	 }	 
	 @Test
    public void case22(){
		 noseelogin("13711111111","688577"); 
		 name.printResult(); 
	 }
	 @Test
	public void case23(){
		 seelogin("13711111111","688577"); 
		 name.printResult();  
	 }
	 @Test
	public void case24(){
		 unreg(phoneNum(),"手机号尚未注册");
		 name.printResult();  
		 }
	 @Test
	public void case25(){
		 unreg("13722222222","获取短信验证码成功"); 
		 name.printResult();  
		 }
	 @Test
	public void case26(){
		 changepw();
		name.printResult();  
		 }	 
	 @Test
	public void case27(){
		loginchange("13722222222","688577"); 
		name.printResult();  
	}	 
	 @Test
	public void case28(){
		 oldacc("13711111111");
		name.printResult();  
	}
	 @Test
	public void case29(){
		 newacc(phoneNum(),"获取短信验证码成功");
		name.printResult();  
		}
	 @Test
	public void case30(){
		 regeist();
		name.printResult();  
		}
	 @Test
	public void case31(){
		 newlogin();
	    name.printResult();  
	}


}
	 
	 
	 

