package com.stm.controller;

import com.stm.data.entity.Centro;
import com.stm.service.CentroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Centro controller.
 */
@Controller
public class CentroController {

    private CentroService centroService;

    @Autowired
    public void setCentroService(CentroService centroService) {
        this.centroService = centroService;
    }

    /**
     * List all centros.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/centros", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("centros", centroService.listAllCentros()); ***usar en el caso de prescindir del paginador**
        Page<Centro> centroPage = centroService.findAll(pageable);
        PageWrapper<Centro> page = new PageWrapper<Centro>(centroPage, "/centros");
        model.addAttribute("centros", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning centros:");
        return "centro/centros";
    }

    /**
     * View a specific centro by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("centro/{id}")
    public String showCentro(@PathVariable Integer id, Model model) {
        model.addAttribute("centro", centroService.getCentroById(id));
        return "centro/centroshow";
    }

    // Afficher le formulaire de modification du Centro
    @RequestMapping("centro/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("centro", centroService.getCentroById(id));
        return "centro/centroform";
    }

    /**
     * New centro.
     *
     * @param model
     * @return
     */
    @RequestMapping("centro/new")
    public String newCentro(Model model) {
        model.addAttribute("centro", new Centro());
        return "centro/centroform";
    }

    /**
     * Save centro to database.
     *
     * @param centro
     * @return
     */
    @RequestMapping(value = "centro", method = RequestMethod.POST)
    public String saveCentro(Centro centro) {
        centroService.saveCentro(centro);
        return "redirect:/centro/" + centro.getId();
    }

    /**
     * Delete centro by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("centro/delete/{id}")
    public String delete(@PathVariable Integer id) {
        centroService.deleteCentro(id);
        return "redirect:/centros";
    }

}
