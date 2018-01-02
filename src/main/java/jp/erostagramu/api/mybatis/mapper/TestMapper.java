package jp.erostagramu.api.mybatis.mapper;

import jp.erostagramu.api.dto.MovieDto;

public interface TestMapper {
	
	MovieDto selectTest(Integer id);
	void create(MovieDto dto);
	
}
