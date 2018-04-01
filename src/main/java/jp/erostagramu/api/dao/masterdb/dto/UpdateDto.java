package jp.erostagramu.api.dao.masterdb.dto;

import lombok.Data;

@Data
public class UpdateDto {
	
	private Integer movieId;
	
	private UpdateContents updateContents;
	
}
