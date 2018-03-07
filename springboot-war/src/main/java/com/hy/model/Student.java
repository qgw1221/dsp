package com.hy.model;
 
import java.io.Serializable;
 
/**
 * 学生实体
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月12日
 */
public class Student implements Serializable{
 
    private static final long serialVersionUID = 2120869894112984147L;
 
    private int id;
    private String name;
    private String sum;
    private String score;
    
    public Student(String name, String sum, String score, String avg, int count) {
		super();
		this.name = name;
		this.sum = sum;
		this.score = score;
		this.avg = avg;
		this.count = count;
	}
    public Student() {
    	super();
    }

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	private String avg;
    private int count;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sum=" + sum
				+ ", avg=" + avg + ", count=" + count + "]";
	}
    
}