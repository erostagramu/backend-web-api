package jp.erostagramu.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CrudController {

	private InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	public CrudController() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	// 一時的な動作確認用です。IDからTitleを検索して表示します。
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String searchById(@PathVariable Integer id) throws IOException {
		MovieDto dto = session.selectOne("jp.erostagramu.api.mapper.ApiMapper.readTitleById", id);
		return dto.getTitle();
	}

	// 動画登録API
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResultDto create(@RequestBody MovieDto dto) throws IOException {
		Integer insertCnt = session.insert("jp.erostagramu.api.mapper.ApiMapper.create", dto);
		session.commit();
		if (insertCnt != 1) {
			return ResultDto.builder().message("動画の作成に失敗しました").build();
		}
		return ResultDto.builder().message("動画作成OK!!").build();
	}
}
