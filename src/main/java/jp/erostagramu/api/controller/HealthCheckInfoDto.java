package jp.erostagramu.api.controller;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class HealthCheckInfoDto {

	private String status;

}
