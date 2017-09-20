package com.logic;

import static org.testng.Assert.assertTrue;

import com.test.Base;
import com.test.Xml;

public class Logic extends Base {

	/**
	 * 正常新手帐号登录逻辑,到选择猎头那一步
	 */
	public void login(String phone1, String phone2) {
		click(findById(Xml.read("welcome"))); // 点击立即进入
		Input(findById(Xml.read("p_edt")), phone1); // 输入帐号
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		if (isPlay(Xml.read("vericodebtn"))) {
			back();
			Input(findById(Xml.read("p_edt")), phone2);
			click(findById(Xml.read("sms_btn")));
		}
		Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
		click(findById(Xml.read("loginbtn"))); // 点击登录
		 assertTrue(isPlay(Xml.read("elite")), "找不到控件:"+Xml.read("elite"));
		// //判断
	}

	/**
	 * 求职者走正常流程进入主页
	 * 
	 * @param args
	 */
	public void seeker_auth(String s1, String s2) {
		// login(s1,s2);
		step1();
		step2();
		step3();
		step4();
		assertTrue(isPlay(Xml.read("chance")), "找不到控件:" + Xml.read("chance")); // 判断
	}

	/**
	 * 求职认证第一步
	 */
	public static void step1() {
		click(findById(Xml.read("elite")));// 点击求职者
		sleep(1000);
		click(findById(Xml.read("head"))); // 点击头像
		click(findById(Xml.read("photo")));// 选择第一个头像
		print("输入姓名");
		Input(findById(Xml.read("nameedt")), "james"); // 输入姓名cwh
		print("输入姓名");
		click(findById(Xml.read("birthday"))); // 选择生日
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("next"))); // 点击下一步
	}

	/**
	 * 求职认证第二步
	 */
	public static void step2() {
		click(findById(Xml.read("edu"))); // 选择学历
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("work"))); // 选择参加工作年份
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("city"))); // 选择所在城市
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("skill"))); // 选择技能标签
		click(findByXpath(Xml.read("Java"))); // 选择UI
		click(findByXpath(Xml.read("PHP")));// 选择UE
		click(findByXpath(Xml.read(".NET")));// 选择GUI
		click(findById(Xml.read("con_tv"))); // 按确定
		click(findById(Xml.read("next"))); // 点击下一步
	}

	/**
	 * 求职认证第三步
	 */
	public static void step3() {
		print("输入公司名");
		Input(findById(Xml.read("comedt")), "laohucom");
		print("输入工作名");
		Input(findByXpath(Xml.read("jobedt")), "product");
		click(findById(Xml.read("start_time")));// 起始工作时间
		// click(findById(Xml.read("minyear")));//起始工作时间选择2016
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("end_time")));// 结束工作时间
		// click(findById(Xml.read("lastyear")));//结束时间选择2017
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("jobdute")));// 点击工作内容
		print("输入工作内容");
		Input(findById(Xml.read("content")), "doingproducttesting");// 输入工作内容
		click(findById(Xml.read("save")));// 点击保存
		click(findById(Xml.read("next"))); // 点击下一步
	}

	/**
	 * 求职认证第四步
	 */
	public static void step4() {
		click(findById(Xml.read("expected_job")));// 点击期望职位
		click(findById(Xml.read("jishu")));// 点击技术
		click(findByXpath(Xml.read("java")));// 点击java
		click(findById(Xml.read("industy")));// 点击行业
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("expected_city"))); // 选择默认的按确定
		click(findByXpath(Xml.read("beijin")));// 点击北京
		click(findById(Xml.read("city_com"))); // 按确定
		click(findById(Xml.read("salary"))); // 选择目标年薪
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read("finish"))); // 选择默认的按确定
		back();
	}

	/**
	 * 猎头认证
	 */
	public static void hunter_auth() {
		// 判断是不是在职位首页，如果不是返回到身份选择页
		while (true) {
			if (isPlay(Xml.read("chance"))) {
				click(findById(Xml.read2("mine"))); // 点击我的
				click(findById(Xml.read2("acc_set"))); // 点击账号设置
				click(findById(Xml.read2("idt_set"))); // 点击切换身份
				break;
			} else {
				backToCho();
				break;
			}
		}
		click(findById(Xml.read2("hunter"))); // 点击我是猎头
		firstStep();
		secondStep();

	}

	/**
	 * 按返回回到求职和猎头选择界面
	 */
	public static void backToCho() {
		while (true) {
			if (isPlay(Xml.read2("hunter"))) {
				break;
			}
			back();
		}
	}

	/**
	 * 猎头认证第一步
	 */
	public static void firstStep() {
		sleep(1000);
		print(findById(Xml.read("nameedt")).getText());
		if (findById(Xml.read("nameedt")).getText() == "点击填写") {
			click(findById(Xml.read("head"))); // 点击头像
			click(findById(Xml.read("photo")));// 选择第一个头像
			Input(findById(Xml.read("nameedt")), "jim"); // 输入姓名cwh
		}
		click(findById(Xml.read("city"))); // 选择所在城市
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read2("worktime"))); // 点击从业时间
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read2("exp_area"))); // 点击擅长行业领域
		click(findById(Xml.read("conf"))); // 选择默认的按确定
		click(findById(Xml.read2("exp_job"))); // 点击擅长职位类型
		click(findByXpath(Xml.read2("java"))); // 点击java
		click(findByXpath(Xml.read2("C++"))); // 点击C++
		click(findById(Xml.read("con_tv"))); // 按确定
		click(findById(Xml.read("next"))); // 点击下一步
	}

	/**
	 * 猎头认证第二步
	 */
	public static void secondStep() {
		print("猎头公司名");
		Input(findById(Xml.read("comedt")), "aaaa");
		print("猎头职位");
		Input(findByXpath(Xml.read2("jobedt")), "tester");
		print("猎头邮箱");
		Input(findByXpath(Xml.read2("mailedt")), "23456@qq.com");
		click(findById(Xml.read2("filephoto"))); // 点击上传认证
		click(findById(Xml.read2("photo"))); // 点击相册
		click(findByXpath(Xml.read2("pic"))); // 点击一张照片
		click(findById(Xml.read("finish"))); // 选择默认的按确定
		assertTrue(isPlay(Xml.read2("rem")), "找不到控件:" + Xml.read2("rem")); // 判断
	}

}