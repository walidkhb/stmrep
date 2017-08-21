package com.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stm.data.entity.User;
import com.stm.service.GroupService;
import com.stm.service.UserService;

/**
 * User controller.
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    private UserService userService;



    @Autowired
    GroupService groupsService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * List all users.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        //model.addAttribute("users", userService.listAllUsers()); ***usar en el caso de prescindir del paginador**
        Page<User> userPage = userService.findAll(pageable);
        PageWrapper<User> page = new PageWrapper<User>(userPage, "admin/users");
        model.addAttribute("users", page.getContent());
        model.addAttribute("page", page);
        System.out.println("Returning users:");
        return "user/users";
    }

    /**
     * View a specific user by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/usershow";
    }

    // Afficher le formulaire de modification du User
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("groups", groupsService.listAllGroups());
        return "user/userform";
    }

    /**
     * New user.
     *
     * @param model
     * @return
     */
    @RequestMapping("user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("groups", groupsService.listAllGroups());
        return "user/userform";
    }

    /**
     * Save user to database.
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        System.out.println(user);
        
        userService.saveUser(user);
        return "redirect:/admin/user/" + user.getId();
    }

    /**
     * Delete user by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

   

}
