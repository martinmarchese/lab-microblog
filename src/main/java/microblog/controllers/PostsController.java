package microblog.controllers;

import microblog.forms.PostForm;
import microblog.models.Post;
import microblog.models.User;
import microblog.services.NotificationService;
import microblog.services.PostService;
import microblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController
{
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;


    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model)
    {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts")
    public String list(Model model)
    {
        List<Post> posts = postService.findAll();
        model.addAttribute("allPosts",posts);
        return "posts/index";
    }

    @RequestMapping("/posts/new")
    public String post(PostForm postForm)
    {
        return "posts/new";
    }

    @RequestMapping(value = "/posts/new", method = RequestMethod.POST)
    public String postPage(@Valid PostForm postForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "posts/new";
        }

        User user = userService.findById(1L);

        Post post = new Post(postForm.getTitle(),postForm.getBody(),user);

        postService.create(post);

        return "redirect:/posts";
    }
}
