package jp.erostagramu.api.facade.v1.write.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePostFacadeResponse {
	
	private CreatePostResponse challengeFreeOutlineResponse;
	private HttpStatus status;
	
}
