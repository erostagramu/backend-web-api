package jp.erostagramu.api.logic.exception;

import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dto.ExceptionDto;

public interface ErrorResponseLogic {

	public ExceptionDto writeErrorCode(Exception ex, WebRequest req);

}
