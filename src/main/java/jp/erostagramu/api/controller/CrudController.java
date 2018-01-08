package jp.erostagramu.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.facade.CreateFecade;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController extends ResponseEntityExceptionHandler {

	@Autowired
	private CreateFecade createFecade;

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResultDto create(@RequestBody MovieDto movieDto) {
		return createFecade.create(movieDto);
	}

	// 主キー重複または外部キー違反が発生した時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> handleRuntimeException(SQLIntegrityConstraintViolationException ex, WebRequest req) {
		String errorMessage = "[重複する動画ID]または[存在しないカテゴリID・連携元動画種別ID]が指定されました";
		ResultDto errorBody = ResultDto.builder().message(errorMessage).build();
		return handleExceptionInternal(ex, errorBody, new HttpHeaders(), HttpStatus.CONFLICT, req);
		// (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}

	// <!動きません！>JSONに誤ったデータ型が記載されていた時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> handleRuntimeException(InvalidFormatException ex, WebRequest req) {
		String errorMessage = "JSONのデータ型が間違っています";
		ResultDto errorBody = ResultDto.builder().message(errorMessage).build();
		return handleExceptionInternal(ex, errorBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
		// (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}
}
