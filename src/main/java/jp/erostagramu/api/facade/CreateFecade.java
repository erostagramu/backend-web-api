package jp.erostagramu.api.facade;

import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

public interface CreateFecade {
	
	public ResultDto create(MovieDto movieDto);
	
}
