package com.hy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.mapper.StudentMapper;
import com.hy.model.Student;
import com.hy.service.StudentService;

/**
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月12日
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
	private StudentMapper studentMapper;
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List getList(){
    	return studentMapper.getAllStudent();
        /*String sql = "select id,name,score,avg ,count ,sum FROM t_student";
        return (List) jdbcTemplate.query(sql, new RowMapper(){
 
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setCount(rs.getInt("count"));
                stu.setName(rs.getString("name"));
                stu.setScore(rs.getString("score"));
                stu.setAvg(rs.getString("avg"));
                stu.setSum(rs.getString("sum"));
                return stu;
            }
 
        });*/
    }

	@Override
	public void update(Student user) {
		studentMapper.update(user);		
	}

	@Override
	public void add(Student user) {
		studentMapper.add(user);	
		
	}

	@Override
	public void delete(Student user) {
		studentMapper.delete(user);	
		
	}
}
