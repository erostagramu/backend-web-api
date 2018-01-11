package jp.erostagramu.api.facade.v1.exception;

import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dto.ExceptionDto;

public interface ErrorResponseFacade {

	public ExceptionDto writeErrorCode(Exception ex, WebRequest req);

}
