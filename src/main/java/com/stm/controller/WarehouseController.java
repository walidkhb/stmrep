package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.Warehouse;

import com.stm.service.CompanyService;
import com.stm.service.WarehouseService;

/**
 * Warehouse controller.
 */
@Controller
@RequestMapping("/admin")
public class WarehouseController {

    private WarehouseService warehouseService;



    @Autowired
    CompanyService companyService;

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    /**
     * List all warehouses.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/warehouses", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("warehouses", warehouseService.listAllWarehouses()); ***usar en el caso de prescindir del paginador**
        Page<Warehouse> warehousePage = warehouseService.findAll(pageable);
        PageWrapper<Warehouse> page = new PageWrapper<Warehouse>(warehousePage, "admin/warehouses");
        model.addAttribute("warehouses", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning warehouses:");
        return "warehouse/warehouses";
    }

    /**
     * View a specific warehouse by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("warehouse/{id}")
    public String showWarehouse(@PathVariable Long id, Model model) {
        model.addAttribute("warehouse", warehouseService.getWarehouseById(id));
        return "warehouse/warehouseshow";
    }

    // Afficher le formulaire de modification du Warehouse
    @RequestMapping("warehouse/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("warehouse", warehouseService.getWarehouseById(id));
        model.addAttribute("companies", companyService.listAllCompanies());
        return "warehouse/warehouseform";
    }

    /**
     * New warehouse.
     *
     * @param model
     * @return
     */
    @RequestMapping("warehouse/new")
    public String newWarehouse(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "warehouse/warehouseform";
    }

    /**
     * Save warehouse to database.
     *
     * @param warehouse
     * @return
     */
    @RequestMapping(value = "warehouse", method = RequestMethod.POST)
    public String saveWarehouse(Warehouse warehouse) {
        System.out.println(warehouse);
        
        warehouseService.addWarehouse(warehouse);
        return "redirect:/admin/warehouse/" + warehouse.getId();
    }

    /**
     * Delete warehouse by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("warehouse/delete/{id}")
    public String delete(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return "redirect:/admin/warehouses";
    }

   

}
