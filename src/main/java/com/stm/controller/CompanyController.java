package com.stm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.stm.data.entity.Company;
import com.stm.data.entity.User;
import com.stm.service.CompanyService;
import com.stm.service.CompanyService;
import com.stm.service.UserService;
@Controller
@RequestMapping("/admin")


public class CompanyController {
	
	
	    private CompanyService copmanyService;



	    @Autowired
	    CompanyService companyService;

	    @Autowired
	    public void setCompanyService(CompanyService copmanyService) {
	        this.copmanyService = copmanyService;
	    }

	    /**
	     * List all copmanys.
	     *
	     * @param model
	     * @return
	     */
	    @RequestMapping(value = "/copmanys", method = RequestMethod.GET)
	    public String list(Model model, Pageable pageable) {
	        //model.addAttribute("copmanys", copmanyService.listAllCompanys()); ***usar en el caso de prescindir del paginador**
	        Page<Company> copmanyPage = copmanyService.findAll(pageable);
	        PageWrapper<Company> page = new PageWrapper<Company>(copmanyPage, "admin/copmanys");
	        model.addAttribute("copmanys", page.getContent());
	        model.addAttribute("page", page);
	        System.out.println("Returning copmanys:");
	        return "copmany/copmanys";
	    }

	    /**
	     * View a specific copmany by its id.
	     *
	     * @param id
	     * @param model
	     * @return
	     */
	    @RequestMapping("copmany/{id}")
	    public String showCompany(@PathVariable Long id, Model model) {
	        model.addAttribute("copmany", copmanyService.getCompanyById(id));
	        return "copmany/copmanyshow";
	    }

	    // Afficher le formulaire de modification du Company
	    @RequestMapping("copmany/edit/{id}")
	    public String edit(@PathVariable Long id, Model model) {
	        model.addAttribute("copmany", copmanyService.getCompanyById(id));
	        
	        return "copmany/copmanyform";
	    }

	    /**
	     * New copmany.
	     *
	     * @param model
	     * @return
	     */
	    @RequestMapping("copmany/new")
	    public String newCompany(Model model) {
	        model.addAttribute("copmany", new Company());
	       
	        return "copmany/copmanyform";
	    }

	    /**
	     * Save copmany to database.
	     *
	     * @param copmany
	     * @return
	     */
	    @RequestMapping(value = "copmany", method = RequestMethod.POST)
	    public String saveCompany(Company copmany) {
	        System.out.println(copmany);
	        
	        copmanyService.addCompany(copmany);
	        return "redirect:/admin/copmany/" + copmany.getId();
	    }

	    /**
	     * Delete copmany by its id.
	     *
	     * @param id
	     * @return
	     */
	    @RequestMapping("copmany/delete/{id}")
	    public String delete(@PathVariable Long id) {
	        copmanyService.deleteCompany(id);
	        return "redirect:/admin/copmanys";
	    }

	   

	}

