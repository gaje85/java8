package com.training.annotation;

import java.lang.reflect.Method;

public class AnnotationExample {

	public AnnotationExample(){
		
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@TrainingAnno(desc="sample",id=200)
	public void setUp(){
		
	}
	
	public static void main(String[] args) {
		try {
			Class classObj = Class.forName("com.training.annotation.AnnotationExample");
			
			Method methods[] = classObj.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
				if(method.getName().indexOf("setUp") != -1){
					TrainingAnno trainingAnno = method.getAnnotation(TrainingAnno.class);
					System.out.println(trainingAnno.id());
					System.out.println(trainingAnno.desc());
				}
			}
		} catch (Exception e) {
			
		}
	}
}
