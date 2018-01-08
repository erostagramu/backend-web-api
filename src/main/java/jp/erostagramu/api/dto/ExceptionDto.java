package jp.erostagramu.api.dto;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class ExceptionDto {

	Object body;
	HttpStatus status;
	
}
