package com.techcanopy.camelpoc;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamelpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelpocApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean1() {
		ServletRegistrationBean<CamelHttpTransportServlet> registration = new ServletRegistrationBean<>(new CamelHttpTransportServlet(), "/services/*");
		registration.setName("CamelServlet");
		return registration;
	}

}
