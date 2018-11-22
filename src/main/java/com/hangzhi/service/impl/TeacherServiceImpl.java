package com.hangzhi.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangzhi.bean.Teacher;
import com.hangzhi.bean.TeacherExample;
import com.hangzhi.dao.TeacherMapper;
import com.hangzhi.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public Teacher getTeacherByAccount(String account) {
		TeacherExample teacherExample = new TeacherExample();
		teacherExample.createCriteria().andAccountEqualTo(account);
		List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
		if(CollectionUtils.isEmpty(teacherList)){
			return null;
		}
		return teacherList.get(0);
	}

}
