package jp.erostagramu.api.exception;

import org.springframework.web.context.request.WebRequest;

import jp.erostagramu.api.dto.ExceptionDto;

public interface ErrorCodeWriter {

	public ExceptionDto writeErrorCode(Exception ex, WebRequest req);

}
