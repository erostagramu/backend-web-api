package jp.erostagramu.api.facade.v1.crud.model;

import jp.erostagramu.api.dao.masterdb.dto.UpdateDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdatePutFacadeRequest {

	private UpdateDto requestBody;
	
}
