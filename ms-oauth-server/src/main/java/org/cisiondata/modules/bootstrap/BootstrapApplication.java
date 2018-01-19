package org.cisiondata.modules.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.cisiondata.modules.bootstrap.filter.OAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"org.cisiondata"})
public class BootstrapApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(BootstrapApplication.class);

	@Bean()
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return objectMapper;
	}
	
	@Bean
	public FilterRegistrationBean oauthFilter(){
		OAuthFilter oauthFilter = new OAuthFilter();
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(oauthFilter);
		filterRegistrationBean.setName("oauthFilter");
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");//拦截路径，可以添加多个
		filterRegistrationBean.setUrlPatterns(urlPatterns);
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
		LOG.info("OAuth Server Bootstrap");
	}
}
