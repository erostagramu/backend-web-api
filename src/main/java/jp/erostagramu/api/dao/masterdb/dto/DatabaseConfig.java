package jp.erostagramu.api.dao.masterdb.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="spring.datasource")
public class DatabaseConfig {
	
	private String url;
	
	private String username;
	
	private String password;
	
	private String driverClassName;
	
}
