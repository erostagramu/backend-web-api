package jp.erostagramu.api.facade.v1.write;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;

public interface CreateFacade {
	
	public ResultDto create(MovieDto movieDto);
	
}
