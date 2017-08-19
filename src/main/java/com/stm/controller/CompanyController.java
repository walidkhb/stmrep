package com.stm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stm.form.CompanyForm;
import com.stm.form.SignupForm;
import com.stm.form.validator.SignupFormValidator;
import com.stm.util.MyUtil;
import com.stm.data.entity.Company;
import com.stm.data.entity.User;
import com.stm.service.CompanyService;
import com.stm.service.UserService;
@Controller
public class CompanyController {
	
	private final Log log = LogFactory.getLog(CompanyController.class);
	

	private CompanyService companyService;

	
	@Autowired
	public CompanyController(CompanyService companyService
			
			) {
		this.companyService = companyService;
	
	
	}
	

	

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String company(Model model, WebRequest request) {
		
		CompanyForm companyForm=new CompanyForm();
		companyForm.setId(15515654);
		companyForm.setTempC(new Company());
		companyForm.setCompanyList(companyService.getAll());
		System.out.println(companyForm.getCompanyList().size());
companyForm.getTempC().setName("walid");
		model.addAttribute(companyForm);
		System.out.println("/company");
		return "companyUI/company";
		
}
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public String edit(@RequestParam(required=true) Company company,@ModelAttribute("companyForm") @Valid CompanyForm companyForm,
			BindingResult result, WebRequest request) {
		System.out.println(companyForm.getId());
		System.out.println(company.getName()+"###");
		 companyForm.setTempC(company);
	 System.out.println("hi");
		//System.out.println(companyForm.getCompanyList().size());

	
		return "companyUI/company";
		
}

}
