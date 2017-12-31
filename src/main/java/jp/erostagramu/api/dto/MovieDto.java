package jp.erostagramu.api.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "i_movies")
public class MovieDto {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "no")
	private Integer no;

	@Column(name = "thumbnail_url")
	private String thumbnailUrl;

	@Column(name = "category_id_01")
	private Integer categoryId01;

	@Column(name = "category_id_02")
	private Integer categoryId02;

	@Column(name = "category_id_03")
	private Integer categoryId03;

	@Column(name = "category_id_04")
	private Integer categoryId04;

	@Column(name = "category_id_05")
	private Integer categoryId05;

	@Column(name = "resource_id")
	private Integer resourceId;

	@Column(name = "sys_create_date")
	private Date sysCreateDate;

	@Column(name = "sys_update_date")
	private Date sysUpdateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public Integer getCategoryId01() {
		return categoryId01;
	}

	public void setCategoryId01(Integer categoryId01) {
		this.categoryId01 = categoryId01;
	}

	public Integer getCategoryId02() {
		return categoryId02;
	}

	public void setCategoryId02(Integer categoryId02) {
		this.categoryId02 = categoryId02;
	}

	public Integer getCategoryId03() {
		return categoryId03;
	}

	public void setCategoryId03(Integer categoryId03) {
		this.categoryId03 = categoryId03;
	}

	public Integer getCategoryId04() {
		return categoryId04;
	}

	public void setCategoryId04(Integer categoryId04) {
		this.categoryId04 = categoryId04;
	}

	public Integer getCategoryId05() {
		return categoryId05;
	}

	public void setCategoryId05(Integer categoryId05) {
		this.categoryId05 = categoryId05;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Date getSysCreateDate() {
		return sysCreateDate;
	}

	public void setSysCreateDate(Date sysCreateDate) {
		this.sysCreateDate = sysCreateDate;
	}

	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}

	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}

}
