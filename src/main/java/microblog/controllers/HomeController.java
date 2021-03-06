package microblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import microblog.services.PostService;
import microblog.models.Post;

import java.util.List;
import java.util.stream.Collectors;

//Spring MVC Controller instance
@Controller
public class HomeController
{
    @Autowired
    private PostService postService;
    @RequestMapping("/")
    public String index(Model model)
    {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        List<Post> lastPost = latest5Posts.stream().limit(1).collect(Collectors.toList());
        model.addAttribute("lastPost",lastPost);
        return "index";
    }
}