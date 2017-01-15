package microblog.controllers;

import microblog.forms.RegisterForm;
import microblog.models.User;
import microblog.services.NotificationService;
import microblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController
{
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/new")
    public String register(RegisterForm registerForm)
    {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        User user = new User(registerForm.getUsername(),registerForm.getFullName(),registerForm.getPassword());

        userService.create(user);

        return "redirect:/";
    }
}
