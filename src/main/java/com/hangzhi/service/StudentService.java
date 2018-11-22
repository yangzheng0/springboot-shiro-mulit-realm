package com.hangzhi.service;

import com.hangzhi.bean.Student;

public interface StudentService {
	Student getStudentById(int id);
	
	Student getStudentByAccount(String account);
}
