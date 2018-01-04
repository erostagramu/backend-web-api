package jp.erostagramu.api.facade;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.ResultDto;

public interface CreateFecade {
	
	public ResultDto create(MovieDto movieDto);
	
}
