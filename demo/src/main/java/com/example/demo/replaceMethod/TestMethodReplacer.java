package com.example.demo.replaceMethod;

import java.lang.reflect.Method;

public class TestMethodReplacer {
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("我替换了原有的方法");
		return null;
	}
}
