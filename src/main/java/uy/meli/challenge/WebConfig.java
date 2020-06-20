package uy.meli.challenge;

import java.util.concurrent.Executor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import uy.meli.challenge.service.impl.ItemService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "uy.meli")
public class WebConfig {

	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("ItemCache-");
		executor.initialize();
		return executor;
	}
	
	@Bean
	public FilterRegistrationBean<AppFilter> appFilter(ItemService itemService){
	    FilterRegistrationBean<AppFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new AppFilter(itemService));
	    registrationBean.addUrlPatterns("/items/*");
	         
	    return registrationBean;    
	}

}
