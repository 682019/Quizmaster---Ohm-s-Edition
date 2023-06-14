package controllers;

import org.springframework.stereotype.Controller; //addthis
import org.springframework.ui.Model; //add this
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping; // add this
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam; //add this
import org.springframework.web.servlet.ModelAndView;

import com.example.servingwebcontent.entities.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("userHome", "employee", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user")User user,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("username", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("id", user.getId());
        return "userView";
    }
    //@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    // public String submit(@Valid @ModelAttribute("user")User user,
    //                      BindingResult result,  ModelMap model) {
    //     if (result.hasErrors()) {
    //         return "error";
    //     }

    //     //Do Something
    //     return "employeeView";
    // }
}