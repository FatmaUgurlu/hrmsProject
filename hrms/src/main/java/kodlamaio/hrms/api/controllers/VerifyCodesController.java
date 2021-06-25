package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.results.Result;

@RestController
@RequestMapping("/api/verifyCodes")
public class VerifyCodesController {

	private VerifyCodeService verifyCodeService;

	@Autowired
	public VerifyCodesController(VerifyCodeService verifyCodeService) {
		super();
		this.verifyCodeService = verifyCodeService;
	}
	
	@PutMapping("/{verifyCode}")
	public Result updatedVerifyCode(@PathVariable("verifyCode") String verifyCode) {
		return verifyCodeService.verifyUser(verifyCode);
	}
	
}
