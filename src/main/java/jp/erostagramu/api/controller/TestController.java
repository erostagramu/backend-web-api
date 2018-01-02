package jp.erostagramu.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.erostagramu.api.dto.MovieDto;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/test")
public class TestController {
	
	private InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
	public TestController() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	
	
	@RequestMapping("/{id}")
	public String searchById(@PathVariable Integer id) throws IOException {
		MovieDto dto = session.selectOne("jp.erostagramu.api.mapper.TestMapper.selectTest",id);
		return dto.getTitle();
	}
	
	@RequestMapping("/")
	public Integer create() throws IOException {
		MovieDto dto = new MovieDto();
		dto.setId(9999);
		dto.setThumbnailUrl("http://hoge");
		dto.setTitle("動画E");
		dto.setCategoryId01(10);
		dto.setCategoryId02(20);
		dto.setCategoryId03(10);
		dto.setCategoryId04(20);
		dto.setCategoryId05(10);
		dto.setResourceId(1);
		Integer insertCnt = session.insert("jp.erostagramu.api.mapper.TestMapper.create",dto);
		session.commit();
		return insertCnt;
	}
}
