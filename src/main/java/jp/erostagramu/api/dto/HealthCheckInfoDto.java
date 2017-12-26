package jp.erostagramu.api.dto;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class HealthCheckInfoDto {

	private String status;

}
