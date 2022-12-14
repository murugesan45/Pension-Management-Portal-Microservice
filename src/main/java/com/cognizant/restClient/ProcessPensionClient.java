package com.cognizant.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;

@FeignClient(name = "ProcessPensionService", url="http://3.108.239.52:9084")
public interface ProcessPensionClient {
	
	@PostMapping("/processPension")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token, @RequestBody PensionerInput pensionerInput);

	@GetMapping("/details")
	public List<PensionerDetail> allDetail();
	
	@PostMapping("/pensionerDetail")
	public PensionerDetail getPensionerDetail(@RequestBody PensionerInput pensionerInput);
}
