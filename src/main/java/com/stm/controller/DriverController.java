package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.Driver;

import com.stm.service.CompanyService;
import com.stm.service.DriverService;

/**
 * Driver controller.
 */
@Controller
@RequestMapping("/admin")
public class DriverController {

    private DriverService driverService;



    @Autowired
    CompanyService companyService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     * List all drivers.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("drivers", driverService.listAllDrivers()); ***usar en el caso de prescindir del paginador**
        Page<Driver> driverPage = driverService.findAll(pageable);
        PageWrapper<Driver> page = new PageWrapper<Driver>(driverPage, "admin/drivers");
        model.addAttribute("drivers", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning drivers:");
        return "driver/drivers";
    }

    /**
     * View a specific driver by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("driver/{id}")
    public String showDriver(@PathVariable Long id, Model model) {
        model.addAttribute("driver", driverService.getDriverById(id));
        return "driver/drivershow";
    }

    // Afficher le formulaire de modification du Driver
    @RequestMapping("driver/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("driver", driverService.getDriverById(id));
        model.addAttribute("companies", companyService.listAllCompanies());
        return "driver/driverform";
    }

    /**
     * New driver.
     *
     * @param model
     * @return
     */
    @RequestMapping("driver/new")
    public String newDriver(Model model) {
        model.addAttribute("driver", new Driver());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "driver/driverform";
    }

    /**
     * Save driver to database.
     *
     * @param driver
     * @return
     */
    @RequestMapping(value = "driver", method = RequestMethod.POST)
    public String saveDriver(Driver driver) {
        System.out.println(driver);
        
        driverService.saveDriver(driver);
        return "redirect:/admin/driver/" + driver.getId();
    }

    /**
     * Delete driver by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("driver/delete/{id}")
    public String delete(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return "redirect:/admin/drivers";
    }

   

}
