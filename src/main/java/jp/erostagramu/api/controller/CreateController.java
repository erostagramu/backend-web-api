package jp.erostagramu.api.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.erostagramu.api.dto.MovieDto;

@Transactional(timeout = 15)
@RestController
@RequestMapping(value = "api/v1/movie")
public class CreateController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void createMovie() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			MovieDto dto = new MovieDto();
			dto.setId(999);
			dto.setThumbnailUrl("http://test01.com");
			dto.setTitle("動画あ");
			dto.setCategoryId01(10);
			dto.setCategoryId02(20);
			dto.setCategoryId03(10);
			dto.setCategoryId04(20);
			dto.setCategoryId05(10);
			dto.setResourceId(1);
			session.insert("jp.erostagramu.api.mybatis.mapper.TestMapper.create", dto);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
