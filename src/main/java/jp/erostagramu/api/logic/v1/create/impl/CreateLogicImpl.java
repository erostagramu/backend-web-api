package jp.erostagramu.api.logic.v1.create.impl;

import org.apache.ibatis.exceptions.PersistenceException;
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
	private ResultDto result;
	private HttpStatus status;
	private String message;

	@Override
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) {

		try {
			createDao.create(createPostFacadeRequest);
			message = "成功";
			status = HttpStatus.OK;

		} catch (PersistenceException e) {
			message = "'id'または'categoryId'が重複しています";
			status = HttpStatus.CONFLICT;
			
		} catch (Exception e) {
			message = "不明なエラー";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}

		result = ResultDto.builder().message(message).build();
		return CreatePostFacadeResponse.builder().responseBody(result).status(status).build();

	}

}
