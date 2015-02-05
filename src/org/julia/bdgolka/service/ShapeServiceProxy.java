package org.julia.bdgolka.service;

import org.julia.bdgolka.aspect.LogginAspect;
import org.julia.bdgolka.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	@Override
	public Circle getCircle() {
		new LogginAspect().logginAdvice();
		return super.getCircle();
	}
}
