package jp.erostagramu.api.facade.v1.crud.model;

import org.springframework.http.HttpStatus;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePostFacadeResponse {
	
	private ResultDto responseBody;
	private HttpStatus status;
	
}
