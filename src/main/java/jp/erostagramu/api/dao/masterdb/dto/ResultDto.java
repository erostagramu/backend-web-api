package jp.erostagramu.api.dao.masterdb.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultDto {
	
	private String message;
	private String errorKey;
}
