package jp.erostagramu.api.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultDto {
	
	private String message;
	private List<String> errorKey;
}
