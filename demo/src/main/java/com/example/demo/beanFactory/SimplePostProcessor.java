package com.example.demo.beanFactory;

import java.util.Locale;

public class SimplePostProcessor {

	private String connectionString;

	private String password;

	private String username;

	Locale locale1 = new Locale("zh", "CN");

	Locale locale2 = new Locale("zh");

	Locale locale3 = Locale.CHINA;

	Locale locale4 = Locale.CHINESE;

	Locale locale5 = Locale.getDefault();

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SimplePostProcessor{" +
				"connectionString='" + connectionString + '\'' +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
