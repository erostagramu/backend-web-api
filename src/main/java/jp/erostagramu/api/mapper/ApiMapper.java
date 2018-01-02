package jp.erostagramu.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import jp.erostagramu.api.dto.MovieDto;
import jp.erostagramu.api.dto.ResultDto;

@Service
@Mapper
public interface ApiMapper {
	
	ResultDto create(MovieDto dto);
	
}
