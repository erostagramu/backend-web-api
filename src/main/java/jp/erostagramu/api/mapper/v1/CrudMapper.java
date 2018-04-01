package jp.erostagramu.api.mapper.v1;

import org.apache.ibatis.annotations.Mapper;

import jp.erostagramu.api.dao.masterdb.dto.MovieDto;
import jp.erostagramu.api.dao.masterdb.dto.UpdateDto;

@Mapper
public interface CrudMapper {
	
	void insert(MovieDto insertDto);
	void update(UpdateDto updateDto);
	
}
