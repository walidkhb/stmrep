package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.PriceList;

import com.stm.service.CompanyService;
import com.stm.service.PriceListService;

/**
 * PriceList controller.
 */
@Controller
@RequestMapping("/admin")
public class PriceListController {

    private PriceListService pricelistService;



    @Autowired
    CompanyService companyService;

    @Autowired
    public void setPriceListService(PriceListService pricelistService) {
        this.pricelistService = pricelistService;
    }

    /**
     * List all pricelists.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/pricelists", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("pricelists", pricelistService.listAllPriceLists()); ***usar en el caso de prescindir del paginador**
        Page<PriceList> pricelistPage = pricelistService.findAll(pageable);
        PageWrapper<PriceList> page = new PageWrapper<PriceList>(pricelistPage, "admin/pricelists");
        model.addAttribute("pricelists", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning pricelists:");
        return "pricelist/pricelists";
    }

    /**
     * View a specific pricelist by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("pricelist/{id}")
    public String showPriceList(@PathVariable Long id, Model model) {
        model.addAttribute("pricelist", pricelistService.getPriceListById(id));
        return "pricelist/pricelistshow";
    }

    // Afficher le formulaire de modification du PriceList
    @RequestMapping("pricelist/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pricelist", pricelistService.getPriceListById(id));
        model.addAttribute("companies", companyService.listAllCompanies());
        return "pricelist/pricelistform";
    }

    /**
     * New pricelist.
     *
     * @param model
     * @return
     */
    @RequestMapping("pricelist/new")
    public String newPriceList(Model model) {
        model.addAttribute("pricelist", new PriceList());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "pricelist/pricelistform";
    }

    /**
     * Save pricelist to database.
     *
     * @param pricelist
     * @return
     */
    @RequestMapping(value = "pricelist", method = RequestMethod.POST)
    public String savePriceList(PriceList pricelist) {
        System.out.println(pricelist);
        
        pricelistService.addPriceList(pricelist);
        return "redirect:/admin/pricelist/" + pricelist.getId();
    }

    /**
     * Delete pricelist by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("pricelist/delete/{id}")
    public String delete(@PathVariable Long id) {
        pricelistService.deletePriceList(id);
        return "redirect:/admin/pricelists";
    }

   

}
