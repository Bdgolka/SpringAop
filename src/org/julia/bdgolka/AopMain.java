package org.julia.bdgolka;

import org.julia.bdgolka.service.FactoryService;
import org.julia.bdgolka.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("spring.xml");
		// ShapeService shapeService = ctx.getBean("shapeService",
		// ShapeService.class);

		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService
				.getBean("shapeService");

		shapeService.getCircle();
	}
}
