package com.example.demo.circleDependence;

public class TestC {

	private TestA testA;

	public void c(){
		testA.a();
	}

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
