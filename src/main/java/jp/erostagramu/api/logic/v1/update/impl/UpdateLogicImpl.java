package jp.erostagramu.api.logic.v1.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.constants.MessageConstants;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.read.CountByIdGetDao;
import jp.erostagramu.api.dao.masterdb.write.UpdatePutDao;
import jp.erostagramu.api.facade.v1.crud.model.FacadeResponse;
import jp.erostagramu.api.facade.v1.crud.model.UpdatePutFacadeRequest;
import jp.erostagramu.api.logic.v1.update.UpdateLogic;

@Service
public class UpdateLogicImpl implements UpdateLogic {

	@Autowired
	private UpdatePutDao updateDao;
	@Autowired
	private CountByIdGetDao countDao;
	private ResultDto result;
	private String message;
	private HttpStatus status;

	@Override
	public FacadeResponse update(UpdatePutFacadeRequest updatePutFacadeRequest) {

		try {
			// 更新対象のデータが存在するかを確認
			Integer count = countDao.countById(updatePutFacadeRequest.getRequestBody().getMovieId());

			if (count == 1) {
				updateDao.update(updatePutFacadeRequest);

				// リクエスト成功時
				message = MessageConstants.SUCCESS;
				status = HttpStatus.OK;
			
			} else {
				// 更新対象のデータが存在しなかった時
				message = MessageConstants.MOVIE_ID_INTEGRITY;
				status = HttpStatus.NOT_FOUND;
			}

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
		return FacadeResponse.builder().responseBody(result).status(status).build();
	}

}
