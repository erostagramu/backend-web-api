package jp.erostagramu.api.dao.masterdb.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultDto {
	
	private HttpStatus statusCode;
	private String message;
	private String errorKey;
}
