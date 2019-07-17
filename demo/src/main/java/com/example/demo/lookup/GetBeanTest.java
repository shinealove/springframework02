package com.example.demo.lookup;

public abstract class GetBeanTest {
	public GetBeanTest() {
	}

	public void showMe() {
		this.getBean().showMe();
		this.getBean().testShow();
	}

	public abstract User getBean();
}
