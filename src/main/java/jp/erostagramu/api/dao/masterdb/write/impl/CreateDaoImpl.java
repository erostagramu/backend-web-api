package jp.erostagramu.api.dao.masterdb.write.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;
import jp.erostagramu.api.dao.masterdb.write.CreateDao;

@Service
public class CreateDaoImpl implements CreateDao{

	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;

	public CreateDaoImpl() throws IOException {
		inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	
	@Override
	public ResultDto create(MovieDto movieDto) {
		Integer insertCnt = session.insert("jp.erostagramu.api.mapper.ApiMapper.create", movieDto);
		session.commit();
		if (insertCnt != 1) {
			return ResultDto.builder().message("動画の作成に失敗しました").build();
		}
		return null;
	}

}
