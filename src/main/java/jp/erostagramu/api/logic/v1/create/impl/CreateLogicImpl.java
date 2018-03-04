package jp.erostagramu.api.logic.v1.create.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.constants.MessageConstants;
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
	private String message;
	private HttpStatus status;

	@Override
	public CreatePostFacadeResponse create(CreatePostFacadeRequest createPostFacadeRequest) {

		try {
			createDao.create(createPostFacadeRequest);

			// リクエスト成功時
			message = MessageConstants.SUCCESS;
			status = HttpStatus.OK;

		} catch (DuplicateKeyException e) {
			// 既に存在するIDを指定した時
			message = MessageConstants.ID_DUPLICATION;
			status = HttpStatus.CONFLICT;

		} catch (DataIntegrityViolationException e) {
			// 存在しないcategoryIDを指定した時
			message = MessageConstants.CATEGORY_ID_INTEGRITY;
			status = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {
			// その他の問題が生じた時
			message = MessageConstants.OTHER;
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}

		result = ResultDto.builder().message(message).build();
		return CreatePostFacadeResponse.builder().responseBody(result).status(status).build();

	}

}
