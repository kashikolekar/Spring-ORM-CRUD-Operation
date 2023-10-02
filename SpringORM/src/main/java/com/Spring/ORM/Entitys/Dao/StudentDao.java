package com.Spring.ORM.Entitys.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.ORM.Entitys.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	//insert
	@Transactional("TM")
	public int insert(Student student)
	{
		
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return 1;
	}

	//get the single data(obj)
	
	public Student getStudent(int id)
	{
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
		
	}
	
	
	public List<Student> getAllStudent()
	{
		List<Student> all = this.hibernateTemplate.loadAll(Student.class);
		return all;
	}
	
	@Transactional("TM")
	public void deleteStudent(int id)
	{
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional("TM")
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
