package jp.erostagramu.api.dao.masterdb.write;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;

public interface CreatePostDao {
	
	public ResultDto create(CreatePostFacadeRequest createPostFacadeRequest);
		
}
