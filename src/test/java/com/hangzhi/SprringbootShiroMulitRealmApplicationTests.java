package com.hangzhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hangzhi.bean.Student;
import com.hangzhi.service.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprringbootShiroMulitRealmApplicationTests {
	
	@Autowired
	StudentServiceImpl StudentServiceImpl;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testStudent(){
		Student student = StudentServiceImpl.getStudentById(1);
		System.out.println(student);
	}

}
