package jp.erostagramu.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController extends ResponseEntityExceptionHandler{

	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	public CrudController() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResultDto create(@RequestBody MovieDto dto) throws IOException {
		Integer insertCnt = session.insert("jp.erostagramu.api.mapper.ApiMapper.create", dto);
		session.commit();
		if (insertCnt != 1) {
			return ResultDto.builder().message("動画の作成に失敗しました").build();
		}
		return null;
	}

	// 一時的な動作確認用です。IDからTitleを検索して表示します。
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String readTitleById(@PathVariable Integer id) throws IOException {
		MovieDto dto = session.selectOne("jp.erostagramu.api.mapper.ApiMapper.readTitleById", id);
		return dto.getTitle();
	}

	// 主キー重複または外部キー違反が発生した時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> 
	handleRuntimeException(SQLIntegrityConstraintViolationException ex,WebRequest req) {
		String errorMessage = "[重複する動画ID]または[存在しないカテゴリID・連携元動画種別ID]が指定されました";
		ResultDto errorBody = ResultDto.builder().message(errorMessage).build();
		return handleExceptionInternal
		(ex, errorBody, new HttpHeaders(), HttpStatus.CONFLICT, req);
        // (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}
		
	// <!動きません！>JSONに誤ったデータ型が記載されていた時のレスポンス
	@ExceptionHandler
	public ResponseEntity<Object> 
	handleRuntimeException(InvalidFormatException ex,WebRequest req) {
		String errorMessage = "JSONのデータ型が間違っています";
		ResultDto errorBody = ResultDto.builder().message(errorMessage).build();
		return handleExceptionInternal
		(ex,errorBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
        // (例外,レスポンスボディ,レスポンスヘッダー,レスポンスステータス,リクエスト)
	}
}
