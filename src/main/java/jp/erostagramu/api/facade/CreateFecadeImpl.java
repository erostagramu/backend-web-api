package jp.erostagramu.api.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.erostagramu.api.dao.masterdb.write.impl.CreateDaoImpl;
import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

@Component
public class CreateFecadeImpl implements CreateFecade{
	
	@Autowired
	private CreateDaoImpl createDaoImpl;
	
	@Override
	public ResultDto create(MovieDto movieDto) {
		return createDaoImpl.create(movieDto);
	}

}
