package com.hangzhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hangzhi.bean.Parent;
import com.hangzhi.bean.Student;
import com.hangzhi.bean.Teacher;
import com.hangzhi.common.UserToken;
import com.hangzhi.service.ParentService;
import com.hangzhi.service.StudentService;
import com.hangzhi.service.TeacherService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	TeacherService teacherService;
	

	/**
	 * @Author Adam
	 * @Description  学生登陆
	 * @Date 23:01 2018/9/1
	 * @Param [request, map, school]
	 * @return boolean
	 */
	@RequestMapping("/studentLogin")
	public Student studentLogin(@RequestParam(value = "account") String account,
								@RequestParam(value = "password") String password, 
								HttpServletRequest request,
								HttpServletResponse response) {

		System.out.println("\n学生登陆");
		Student student = null;
		//设置永不过期
		SecurityUtils.getSubject().getSession().setTimeout(-1000L);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 调用安全认证框架的登录方法
			subject.login(new UserToken(account, password, "Student"));
			student = studentService.getStudentByAccount(account);
		} catch (AuthenticationException ex) {
			System.out.println("登陆失败: " + ex.getMessage());
		}
		return student;

	}
	
	/**
	 * @Author Adam
	 * @Description  家长登陆
	 * @Date 23:01 2018/9/1
	 * @Param [request, map, school]
	 * @return boolean
	 */
	@RequestMapping("/parentLogin")
	public Parent parentLogin(@RequestParam(value = "account") String account,
								@RequestParam(value = "password") String password, 
								HttpServletRequest request,
								HttpServletResponse response) {

		System.out.println("\n家长登陆");
		Parent parent = null;
		//设置永不过期
		SecurityUtils.getSubject().getSession().setTimeout(-1000L);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 调用安全认证框架的登录方法
			subject.login(new UserToken(account, password, "Parent"));
			parent = parentService.getParentByAccount(account);
		} catch (AuthenticationException ex) {
			System.out.println("登陆失败: " + ex.getMessage());
		}
		return parent;

	}
	
	/**
	 * @Author Adam
	 * @Description  老师登陆
	 * @Date 23:01 2018/9/1
	 * @Param [request, map, school]
	 * @return boolean
	 */
	@RequestMapping("/teacherLogin")
	public Teacher teacherLogin(@RequestParam(value = "account") String account,
								@RequestParam(value = "password") String password, 
								HttpServletRequest request,
								HttpServletResponse response) {

		System.out.println("\n老师登陆");
		Teacher teacher = null;
		//设置永不过期
		SecurityUtils.getSubject().getSession().setTimeout(-1000L);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 调用安全认证框架的登录方法
			subject.login(new UserToken(account, password, "Teacher"));
			teacher = teacherService.getTeacherByAccount(account);
		} catch (AuthenticationException ex) {
			System.out.println("登陆失败: " + ex.getMessage());
		}
		return teacher;

	}
}
