package com.logic;
import static org.testng.Assert.assertTrue;
import com.test.Xml;
/**
 * 验证码登录
 * @author Administrator
 *
 */
public class login_Logic extends Logic1 {
      /**
       * 在各种界面进入验证登录输入帐号过程
       */
	public static void veriInput(String pn){
		if(isPlayById(Xml.read("welcome"))){	
		click(findById(Xml.read("welcome")));// 点击立即进入
		}
		if(isPlayById(Xml.read("pw_iv"))){
		click(findById(Xml.read("veri_login")));   //如果在密码登录点击验证码登录
		}
		if(isPlay(Xml.read("elite"))){
		click(findById(Xml.read("logout")));  // 如果已经登录点击退出登录
		click(findById(Xml.read("comfig")));
		click(findById(Xml.read("veri_login")));
		}
		findById(Xml.read("p_edt")).clear();
		Input(findById(Xml.read("p_edt")), pn); // 输入帐号
	}
	
	/**
	 * 获取验证码查看提示语
	 */
	public static void getvericode(String pn){
	    veriInput(pn);
	    click(findById(Xml.read("sms_btn"))); // 点击获取验证码
	    if(pn==""){
	    	assertTrue(tips("手机号还没填写"),"提示语不正确");
	    }else{
	    	assertTrue(tips("手机号格式不正确"),"提示语不正确");
	    }   
    }
	/**
	 * 输入12位手机号码
	 */
	public static void longinput(String pn){
		veriInput(pn);
		int i=findById(Xml.read("p_edt")).getText().trim().length();
		assertTrue(i==11,"输入12位手机号不是显示11位，而是"+i+"个");
	}
	/**
	 * 验证登录按钮置灰与点亮
	 */
	public static void isbtngrey(String pn,String sns){
		veriInput(pn);
		if(sns==""){
			assertTrue(!isGrey(),"不输入验证码没有置灰");
		}else{
			Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
			assertTrue(isGrey(),"输入验证码没有点亮");
		}
	}
	/**
	 * 正确短信验证码提示语
	 */
	public static void correctInput(String pn){
		veriInput(pn);
	    click(findById(Xml.read("sms_btn"))); // 点击获取验证码
	    if(pn==""){
	    	assertTrue(tips("手机号还没填写"),"提示语不正确");
	    }else{
	    	assertTrue(tips("获取短信验证码成功"),"提示语不正确");
	    }   
	}
	/**
	 * 获取与不获取验证码进行登录
	 *
	 */
	public static void snslogin(String pn1,int i){
     if(i==0){
			veriInput(pn1);
			pn=pn1;
			veriCode();
			click(findById(Xml.read("loginbtn"))); // 点击登录
			assertTrue(tips("请先获取验证码"),"提示语不正确");
        }else if(i==1){
        	veriCode();
    			click(findById(Xml.read("loginbtn"))); // 点击登录
			afterlogin();
        }
		}
	
	/**
	 * 输入已经注册的号码进行登录
	 */
	public static void oldlogin(String pn){
		veriInput(pn);
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		if (isPlay(Xml.read("vericodebtn"))) {
			back();
			Input(findById(Xml.read("p_edt")), "17700000004");
			click(findById(Xml.read("sms_btn")));
		}
		findById(Xml.read("code_edt")).clear();
		Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
		click(findById(Xml.read("loginbtn"))); // 点击登录
		assertTrue(isPlay(Xml.read("chance")), "找不到控件:" + Xml.read("chance")); // 判断
	}
	/**
	 * 验证码框内字符为1111就不输入，否则输入
	 */
	public static void veriCode(){
		String s1=findById(Xml.read("code_edt")).getText();
    	if(s1!="1111"){
			findById(Xml.read("code_edt")).clear();
			Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
			}
	}
}
