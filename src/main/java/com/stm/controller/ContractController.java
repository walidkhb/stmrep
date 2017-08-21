package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.Contract;

import com.stm.service.CompanyService;
import com.stm.service.ContractService;

/**
 * Contract controller.
 */
@Controller
@RequestMapping("/admin")
public class ContractController {

    private ContractService contractService;



    @Autowired
    CompanyService companyService;

    @Autowired
    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * List all contracts.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/contracts", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("contracts", contractService.listAllContracts()); ***usar en el caso de prescindir del paginador**
        Page<Contract> contractPage = contractService.findAll(pageable);
        PageWrapper<Contract> page = new PageWrapper<Contract>(contractPage, "admin/contracts");
        model.addAttribute("contracts", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning contracts:");
        return "contract/contracts";
    }

    /**
     * View a specific contract by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("contract/{id}")
    public String showContract(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.getContractById(id));
        return "contract/contractshow";
    }

    // Afficher le formulaire de modification du Contract
    @RequestMapping("contract/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.getContractById(id));
        model.addAttribute("companies", companyService.listAllCompanies());
        return "contract/contractform";
    }

    /**
     * New contract.
     *
     * @param model
     * @return
     */
    @RequestMapping("contract/new")
    public String newContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "contract/contractform";
    }

    /**
     * Save contract to database.
     *
     * @param contract
     * @return
     */
    @RequestMapping(value = "contract", method = RequestMethod.POST)
    public String saveContract(Contract contract) {
        System.out.println(contract);
        
        contractService.addContract(contract);
        return "redirect:/admin/contract/" + contract.getId();
    }

    /**
     * Delete contract by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("contract/delete/{id}")
    public String delete(@PathVariable Long id) {
        contractService.deleteContract(id);
        return "redirect:/admin/contracts";
    }

   

}
