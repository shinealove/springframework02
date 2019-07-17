package com.example.demo.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class getBeanClass(Element element) {
		return User.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String userName = element.getAttribute("username");
		String email = element.getAttribute("email");
		if (StringUtils.hasText(userName)) {
			bean.addPropertyValue("username", userName);
		}

		if (StringUtils.hasText(email)) {
			bean.addPropertyValue("email", email);
		}

	}
}
