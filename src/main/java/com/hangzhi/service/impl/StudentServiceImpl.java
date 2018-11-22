package com.hangzhi.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangzhi.bean.Student;
import com.hangzhi.bean.StudentExample;
import com.hangzhi.dao.StudentMapper;
import com.hangzhi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	StudentMapper studentMapper;

	@Override
	public Student getStudentById(int id) {
		Student student = studentMapper.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public Student getStudentByAccount(String account) {
		StudentExample studentExample = new StudentExample();
		studentExample.createCriteria().andAccountEqualTo(account);
		List<Student> studentList = studentMapper.selectByExample(studentExample);
		if(CollectionUtils.isEmpty(studentList)){
			return null;
		}
		return studentList.get(0);
	}

}
