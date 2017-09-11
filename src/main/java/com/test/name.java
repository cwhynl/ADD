package com.test;

import java.util.HashMap;
import java.util.Map;

public class name extends Base{
	
	public static int i=0;
	
	
	/**
	 * 测试用例
	 * @return
	 */
    public static Map<String, String> getdata(){
    	Map<String,String> map=new HashMap<String, String>();
    	//认证用例
    	map.put("case1", "随机输入手机号码正常注册登录");
    	map.put("case2", "新账号求职者四步正常认证");
    	map.put("case3", "新账号猎头认证两部");
    	map.put("case4", "随机输入手机号码正常注册登录");
    	//帐号密码登录
    	map.put("case11", "输入手机号码不输入密码，验证登录按钮正常置灰");
    	map.put("case12", "输入手机号码输入密码小于6位，验证登录按钮正常置灰");
    	map.put("case13", "输入手机号码输入密码大于6位，验证登录按钮正常置灰");
    	map.put("case14", "输入手机号码输入小于11位和密码，验证点击登录提示手机号格式不正确");
    	map.put("case15", "输入手机号码输入11位带字母、特殊字符和密码，验证点击登录提示手机号格式不正确");
    	map.put("case16", "输入手机号码输入11位非1开头和密码，验证点击登录提示手机号格式不正确");
    	map.put("case17", "输入手机号码输入11位1开头不符合正则和密码，验证点击登录提示手机号格式不正确");
    	map.put("case18", "输入正常的手机号码，错误的密码点击登录");
    	map.put("case19", "输入正确的手机号码，长度为21位的密码，验证不能超过20位");
    	map.put("case21", "输入密码后点击眼睛能看见密码，验证再次点击不能看见");
    	map.put("case22", "不能看见密码的情况下输入正确的帐号密码点击登录，验证正常登录");
    	map.put("case23", "能看见密码的情况下输入密码点击登录，验证正常登录");
    	//找回密码
    	map.put("case24", "输入手机号码未注册点击获取验证码验证弹出提示手机号码未注册");
    	map.put("case25", "输入手机号码已注册点击获取验证码验证弹出提示获取成功");
    	map.put("case26", "验证正常输入进行重置密码");
    	map.put("case27", "重置密码后用重置的密码进行一次的登录");
    	//注册帐号
    	map.put("case28", "输入手机号码已注册点击获取验证码");
    	map.put("case29", "输入手机号码未注册点击注册提示获取成功");
    	map.put("case30", "输入正常的帐号密码进行注册");
    	map.put("case31", "注册后用该帐号密码进行登录");
    	//验证码登录
    	map.put("case32", "输入为空的手机号码点击获取验证码提示手机号还没有填写");
    	map.put("case33", "输入手机号码不足11位点击获取验证码提示手机号格式不正确");
    	map.put("case34", "输入手机号为非1开头的11位手机号提示手机号格式不正确");
    	map.put("case35", "输入手机号为1开头11位非法号码提示手机号格式不正确");
    	map.put("case36", "输入12位手机号码，验证只能输入11位");
    	map.put("case37", "验证正常输入手机号登录按钮置灰");
    	map.put("case38", "输入手机号与验证码后登录按钮点亮");
    	map.put("case39", "输入正常的手机号码，不获取验证码点击登录");
    	map.put("case40", "正常输入手机号码点击获取验证码提示获取短信验证码成功");
    	map.put("case41", "输入正常的手机号码获取验证码，输入不正确的验证码点击登录提示验证码不正确");
    	map.put("case42", "输入已经注册的号码进行登录");
    	map.put("case44", "");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return map;
    }
    
    
    
    public static void printResult(){
    	i++;
    	String s = Thread.currentThread().getStackTrace()[2].getMethodName();
    	System.out.println(s);
    	String d=getdata().get(s).toString();
    	print("执行用例："+d+"--->执行成功");
    	
    }
	
   
    
    

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
