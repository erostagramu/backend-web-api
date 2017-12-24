package jp.erostagramu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/health_check")
public class HealthCheckController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HealthCheckInfoDto get() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public HealthCheckInfoDto post() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public HealthCheckInfoDto put() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public HealthCheckInfoDto delete() {
		HealthCheckInfoDto dto = new HealthCheckInfoDto();
		dto.setStatus("success");
		return dto;
	}
}
