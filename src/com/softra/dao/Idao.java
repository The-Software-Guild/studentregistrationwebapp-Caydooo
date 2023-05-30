package com.softra.dao;

import javax.servlet.ServletContext;

import com.mysql.jdbc.Connection;

public interface Idao {
	
	void persistStudent(ServletContext context);

}
