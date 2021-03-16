package com.springrest.springrest.sevices.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entitities.Course;
import com.springrest.springrest.sevices.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
//	List<Course> list;
	
	public CourseServiceImpl() {
		// TODO Auto-generated constructor stub
		
//		list = new ArrayList<>();
//		list.add(new Course(100, "JAVA core","This is core java course"));
//		list.add(new Course(101, "Spring java","This is spring java course"));
	}
	@Override
	public List<Course> getCourses(){
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course c = null;
//		
//		for(Course course:list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		//list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		for(Course c:list) {
//			if(c.getId() == course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				break;
//			}
//		}
		courseDao.save(course); //update exisiting if already exisits
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		//list = this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
		
		Course entity = courseDao.getOne(parseLong); // getting entity to be deleted by id
		
		courseDao.delete(entity); // delete method takes entity
	}
	
}
