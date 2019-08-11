package com.example.demo.httpInvoker;

public class HttpInvokertestImpl implements HttpInvokerTestI {
	@Override
	public String getTestPo(String desp) {
		return "getTestPo " + desp;
	}
}
