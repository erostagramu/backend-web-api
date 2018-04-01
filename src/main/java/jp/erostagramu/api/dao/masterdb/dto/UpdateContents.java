package jp.erostagramu.api.dao.masterdb.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UpdateContents {
	
	private String thumbnailUrl;

	private String title;

	private Integer categoryId01;

	private Integer categoryId02;

	private Integer categoryId03;

	private Integer categoryId04;

	private Integer categoryId05;

	private Integer resourceId;

	private Date sysCreateDate;

	private Date sysUpdateDate;

}
