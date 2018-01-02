package jp.erostagramu.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.erostagramu.api.dto.MovieDto;

@Controller
@EnableAutoConfiguration
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public List<String> top() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		MovieDto md = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			md = session.selectOne("jp.erostagramu.api.mybatis.mapper.TestMapper.selectTest", 1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		list.add(md.getTitle());
		return list;
	}
}
