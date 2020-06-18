package uy.meli.interfaces.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MeliRestConfig {

	@Bean
	public RestOperations createRestTemplOperations(final ClientHttpRequestFactory clientHttpRequestFactory) {
		return new RestTemplate(clientHttpRequestFactory);
		
	}

	@Bean
	public ClientHttpRequestFactory createClientHttpRequestFactory(	@Value("${connect.timeout}") final int connectTimeout,
			@Value("${read.timeout}") final int readTimeout) {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(readTimeout);
		return httpComponentsClientHttpRequestFactory;
	} 

}
