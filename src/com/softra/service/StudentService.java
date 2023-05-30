package com.softra.service;

import javax.servlet.ServletContext;

import com.softra.dao.Idao;
import com.softra.dao.StudentDao;

public class StudentService implements IService {
	private Idao dao;
	
	public StudentService() {
		dao = new StudentDao();
	}
	
	@Override
	public void saveStudent(ServletContext context) {
		dao.persistStudent(context);
		
	}

}
