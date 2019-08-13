package org.test.app;


import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.Region_2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void insert() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = (DaoImpl) context.getBean("daoImpl", DaoImpl.class);
			dao.insert(new Region_2( 11, "EmmaWatson"));
		} catch (Exception e) {
			System.out.println("Exception insert=" + e.getMessage());
			
		}

	}
	public static void update() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = (DaoImpl) context.getBean("daoImpl", DaoImpl.class);
			dao.update(new Region_2("putoEmmaboxer", 2));
		} catch (Exception e) {
			System.out.println("Exception update=" + e.getMessage());
			
		}

	}
	public static void delete() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = (DaoImpl) context.getBean("daoImpl", DaoImpl.class);
			dao.delete(new Region_2(2));
		} catch (Exception e) {
			System.out.println("Exception delete=" + e.getMessage());
			
		}

	}
	
	
	public static void selectAll() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
			List<Region_2> lista = dao.selectAll();
			for(Region_2 x : lista)
			{
				System.out.println(x.getId()+","+ x.getNombre());
			}
		} catch (Exception e) {
			System.out.println("Exception SelectAll=" + e.getMessage());
			
		}

	}
	public static void selectById() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
			Region_2 region = dao.selectById(1);
			
				System.out.println(region.getId()+","+ region.getNombre());
			
		} catch (Exception e) {
			System.out.println("Exception selectById=" + e.getMessage());
			
		}
	}
	public static void createTable() 
	{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
			dao.createTableNota();
			
				
			
		} catch (Exception e) {
			System.out.println("Exception selectById=" + e.getMessage());
			
		}
	}
	
	public static void main(String[] args) {
		//insert();
		//update();
		//delete();
		//selectById();
		//selectAll();
		createTable();
	}

}
