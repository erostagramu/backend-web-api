package jp.erostagramu.api.facade.v1.write.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePostResponse {
	
	private String errorKey;
	private String message;
	
}
