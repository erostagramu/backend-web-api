package jp.erostagramu.api.logic.write.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.write.model.CreatePostFacadeResponse;
import jp.erostagramu.api.facade.v1.write.model.CreatePostResponse;
import jp.erostagramu.api.logic.write.LogicCreate;

@Service
public class LogicCreateImpl implements LogicCreate {

	@Autowired
	private CreatePostDao createDao;

	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) {
		
		ResultDto result = createDao.create(createPostFacadeRequest);
		
		CreatePostResponse createPostResponse = CreatePostResponse.builder().
				errorKey(result.getErrorKey()).
				message(result.getMessage()).
				build();
		
		return CreatePostFacadeResponse.builder().
				challengeFreeOutlineResponse(createPostResponse).
				status(result.getStatusCode()).
				build();

	}
}