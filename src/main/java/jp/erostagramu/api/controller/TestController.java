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
@RequestMapping(value = "api/v1/movie")
public class TestController {
	
	private static final String RESOURCE = "mybatis-config.xml";
	
	@RequestMapping("/test/{id}")
	public String searchById(@PathVariable Integer id) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		MovieDto dto = session.selectOne("jp.erostagramu.api.mapper.TestMapper.selectTest",id);
		return dto.getTitle();
	}
	
	@RequestMapping("/")
	public Integer create() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		MovieDto dto = new MovieDto();
		dto.setId(3000);
		dto.setThumbnailUrl("http://hoge");
		dto.setTitle("動画C");
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
