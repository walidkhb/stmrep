package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.Track;

import com.stm.service.CompanyService;
import com.stm.service.TrackService;

/**
 * Track controller.
 */
@Controller
@RequestMapping("/admin")
public class TrackController {

    private TrackService trackService;



    @Autowired
    CompanyService companyService;

    @Autowired
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * List all tracks.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("tracks", trackService.listAllTracks()); ***usar en el caso de prescindir del paginador**
        Page<Track> trackPage = trackService.findAll(pageable);
        PageWrapper<Track> page = new PageWrapper<Track>(trackPage, "admin/tracks");
        model.addAttribute("tracks", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning tracks:");
        return "track/tracks";
    }

    /**
     * View a specific track by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("track/{id}")
    public String showTrack(@PathVariable Long id, Model model) {
        model.addAttribute("track", trackService.getTrackById(id));
        return "track/trackshow";
    }

    // Afficher le formulaire de modification du Track
    @RequestMapping("track/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("track", trackService.getTrackById(id));
        model.addAttribute("companies", companyService.listAllCompanies());
        return "track/trackform";
    }

    /**
     * New track.
     *
     * @param model
     * @return
     */
    @RequestMapping("track/new")
    public String newTrack(Model model) {
        model.addAttribute("track", new Track());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "track/trackform";
    }

    /**
     * Save track to database.
     *
     * @param track
     * @return
     */
    @RequestMapping(value = "track", method = RequestMethod.POST)
    public String saveTrack(Track track) {
        System.out.println(track);
        
        trackService.addTrack(track);
        return "redirect:/admin/track/" + track.getId();
    }

    /**
     * Delete track by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("track/delete/{id}")
    public String delete(@PathVariable Long id) {
        trackService.deleteTrack(id);
        return "redirect:/admin/tracks";
    }

   

}
