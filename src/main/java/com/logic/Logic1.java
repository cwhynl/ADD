package com.logic;

import static org.testng.Assert.assertTrue;

import com.test.Base;
import com.test.Xml;
/**
 * 密码登录，修改密码，注册帐号
 * @author Administrator
 *
 */
public class Logic1 extends Base {
	public static String pn=null;
	/**
	 * 判断登录提示框存不存在
	 */
	public static void logintips(){
		if(isPlay(Xml.read("logintips"))){
			 click(findById(Xml.read("negetive")));
			 assertTrue(true);
			}else{
				 assertTrue(false);	
			}
	}
	/**
	 * 登录之后的判断和操作
	 */
	public static void afterlogin(){
		if(isPlay(Xml.read("elite"))){
			 click(findById(Xml.read("logout"))); // 点击退出登录
			 click(findById(Xml.read("comfig")));
			 assertTrue(true);
			}else{
				 assertTrue(false);	
			}
	}
	/**
	 * 登录按钮是否置灰
	 * @param args
	 */
	public static boolean isGrey(){
		return findById(Xml.read("loginbtn")).isEnabled();
	}
   /**
    * 获取提示语,然后跟预期的提示与进行对比
    * @param args预期出现的提示语
    */
	public static boolean tips(String s){
		String ss=findById(Xml.read("snb_t")).getText();
		return s.contentEquals(ss);
	}
	/**
	 * 进入应用到输入帐号密码操作过程
	 */
	public static void stepToInput(String phonenum,String pw){
		if(isPlayById(Xml.read("welcome"))){		
		click(findById(Xml.read("welcome")));// 点击立即进入
		}
		if(isPlayById(Xml.read("pw_login"))){
		click(findById(Xml.read("pw_login")));   //点击帐号登录
		}
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), phonenum); // 输入帐号
		findById(Xml.read("pw_edt")).clear();
		Input(findById(Xml.read("pw_edt")), pw); // 输入密码
	}
   /**
    * 进入到修改密码
    */
	public static void steptopw(){
		if(isPlayById(Xml.read("elite"))){
			 click(findById(Xml.read("logout"))); // 点击退出登录
			 click(findById(Xml.read("comfig")));
		}
		if(isPlayById(Xml.read("welcome"))){
		click(findById(Xml.read("welcome")));// 点击立即进入
		}
		if(isPlayById(Xml.read("pw_login"))){
		click(findById(Xml.read("pw_login")));   //点击帐号登录
		}
		if(isPlayById(Xml.read("forgetpw"))){
		click(findById(Xml.read("forgetpw")));}
	}
	/**
	 * 进入到注册帐号中
	 */
	public static void steptoreg(){
		if(isPlayById(Xml.read("elite"))){
			 click(findById(Xml.read("logout"))); // 点击退出登录
			 click(findById(Xml.read("comfig")));
		}
		if(isPlayById(Xml.read("welcome"))){
		click(findById(Xml.read("welcome")));// 点击立即进入
		}
		if(isPlayById(Xml.read("acc_reg"))){
		click(findById(Xml.read("acc_reg")));// 点击立即进入
		}
	}
	
	/**
	 *验证登录按钮是否置灰的测试
	 * @param args
	 */
	public static void btngrey(String phonenum,String pw){
		stepToInput(phonenum,pw);
		int i=pw.trim().length();
		if(i>=6){
			 assertTrue(isGrey(), "输入密码大于6位登录按钮没有点亮");
		}else{
			 assertTrue(!isGrey(), "输入密码小于6位登录按钮没有置灰");
		}}
		/**
		 * 验证错误的帐号输入提示手机号码不正确
		 */
	public static void errorPhonenum(String phonenum,String pw){
		stepToInput(phonenum,pw);
		click(findById(Xml.read("loginbtn"))); //点击登录
		assertTrue(tips("手机号格式不正确"),"不是提示手机号码不正确");
	}
	/**
	 * 验证密码错误的提示	
	 * @param args
	 */
	public static void errorpw(String phonenum,String pw){
		stepToInput(phonenum,pw);
		click(findById(Xml.read("loginbtn"))); //点击登录
		assertTrue(tips("密码错误"),"不是提示密码错误");
	}
	
	/**
	 * 验证不能输入21位密码
	 * @param args
	 */
	public static void inputmore(String phonenum,String pw){
		stepToInput(phonenum,pw);
		click(findById(Xml.read("pw_iv")));
		int i=findById(Xml.read("pw_edt")).getText().trim().length();
		assertTrue(i==20,"输入21位个数不是20个，而是"+i+"个");
	}
	
	/**
	 * 密码看见与看不见
	 * @param args
	 */
	public static void seeornosee(String phonenum,String pw){
		stepToInput(phonenum,pw);
		String i=findById(Xml.read("pw_edt")).getText();
		assertTrue(i.contentEquals(pw),"密码不能看见："+i+"和"+pw);
		click(findById(Xml.read("pw_iv")));
		String i1=findById(Xml.read("pw_edt")).getText();
		assertTrue(i1.contentEquals(""),"密码不为空能看见"+i1);
	}
	/**
	 * 密码不可见的时候正常登录
	 * @param args
	 */
	public static void noseelogin(String phonenum,String pw){
		if(findById(Xml.read("pw_edt")).getText()!=""){
		stepToInput(phonenum,pw);}
		else{
			click(findById(Xml.read("pw_iv")));	
			stepToInput(phonenum,pw);
		}
		click(findById(Xml.read("loginbtn"))); // 点击登录
		afterlogin();
	}
	/**
	 * 密码可见的时候正常登录
	 * @param args
	 */
	public static void seelogin(String phonenum,String pw){
		stepToInput(phonenum,pw);
		click(findById(Xml.read("pw_iv")));	
		click(findById(Xml.read("loginbtn"))); // 点击登录
		afterlogin();
	}
	/**
	 * 输入手机号点击获取验证码
	 * @param args
	 */
	public static void unreg(String phonenum,String tips){
		steptopw();
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), phonenum); // 输入帐号
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		 assertTrue(tips(tips),"提示语不正确");	
	}
	/**
	 * 获取短信验证码之后修改密码
	 * @param args
	 */
	public static void changepw(){
		Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
		Input(findById(Xml.read("pw_edt")), "688577"); // 输入密码
		click(findById(Xml.read("resetpw"))); // 点击重置密码
		assertTrue(isPlayById(Xml.read("p_edt")),"重置后没有跳转");	
	}
	/**
	 * 改密码后进行登录
	 * @param args
	 */
	public static void loginchange(String phonenum,String pw){
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), phonenum); // 输入帐号
		findById(Xml.read("pw_edt")).clear();
		Input(findById(Xml.read("pw_edt")), pw); // 输入密码
		click(findById(Xml.read("loginbtn"))); // 点击登录
		afterlogin();
	}
	/**
	 * 注册提示语
	 * @param args
	 */
	public static void oldacc(String phonenum){
		steptoreg();
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), phonenum); // 输入帐号
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		if (isPlay(Xml.read("vericodebtn"))) {
			back();
			Input(findById(Xml.read("p_edt")), "15811111111");
			click(findById(Xml.read("sms_btn")));
		}
		logintips();
	}
	/**
	 * 注册提示语
	 * @param args
	 */
	public static void newacc(String phonenum,String tips){
		steptoreg();
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), phonenum); // 输入帐号
		pn=phonenum;
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		 assertTrue(tips(tips),"提示语不正确");	
	}
	/**
	 * 输入帐号密码进行注册
	 * @param args
	 */
	public static void regeist(){
		Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
		Input(findById(Xml.read("pw_edt")), "688577"); // 输入密码	
		click(findById(Xml.read("acc_reg"))); // 点击注册
		afterlogin();
	}
	/**
	 * 新注册的帐号进行登录
	 * @param args
	 */
	public static void newlogin(){
		stepToInput(pn,"688577");
		click(findById(Xml.read("loginbtn"))); // 点击登录
		afterlogin();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
