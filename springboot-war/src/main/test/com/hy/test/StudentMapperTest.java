package com.hy.test;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hy.Application;
import com.hy.model.Student;
import com.hy.service.StudentService;

//@RunWith(SpringJUnit4ClassRunner.class)  
//@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "server.port=8080",
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//重新加载 Spring 上下文 每个测试自动重启springboot
//@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)  
//@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
//@WebAppConfiguration
public class StudentMapperTest {
	@Autowired
	private StudentService stuService;

	@Before
    public void setUp() {
        // 每个测试开始前的操作
		System.out.println("==setup====");
    }
	@After
    public void tearDown() {
        // 每个测试执行后的操作
		System.out.println("==down====");
    }
	@Test
	public void testInsert() throws Exception {
		//stuService.add(new Student("11", "22","33","44",1));
		System.out.println("add");
	}

	@Test
	public void testQuery() throws Exception {
		System.out.println(stuService.getList().size());
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		/*Student s=new Student();
		s.setId(1);
		s.setName("qwer");
		s.setScore("99");
		s.setAvg("88");
		s.setCount(5);
		stuService.update(s);*/
		System.out.println("update");
		System.out.println(UUID.randomUUID());
		//Student user = StudentMapper.getOne(3l);
		//System.out.println(user.toString());
		//user.setNickName("neo");
		//stuMapper.update(user);
		//Assert.assertTrue(("neo".equals(StudentMapper.getOne(3l).getNickName())));
	}
	
	
}