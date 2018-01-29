package jp.erostagramu.api.logic.v1.create.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreatePostDao;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeRequest;
import jp.erostagramu.api.facade.v1.crud.model.CreatePostFacadeResponse;
import jp.erostagramu.api.logic.v1.create.CreateLogic;

@Service
public class CreateLogicImpl implements CreateLogic {

	@Autowired
	private CreatePostDao createDao;
	private Integer insertCount;
	private ResultDto result;
	private HttpStatus status;
	private String message;
	
	@Override
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) {

		insertCount = createDao.create(createPostFacadeRequest);
		
		// nullの場合、0を設定する
		insertCount = Optional.ofNullable(insertCount).orElse(0);
		
		if (insertCount == 1) {
			message = "成功";
			status = HttpStatus.OK;
		} else if (insertCount == 0) {
			message = "'id'または'categoryId'が重複しています";
			status = HttpStatus.CONFLICT;
		}
		
		result = ResultDto.builder().message(message).build();
		return CreatePostFacadeResponse.builder().responseBody(result).status(status).build();

	}

}
