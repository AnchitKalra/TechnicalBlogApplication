package upgrad;
import model.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")

    public String homeController(Model model) {

       ArrayList<Posts> postsArrayList = new ArrayList<>();

        Posts post1 = new Posts();
        post1.setTitle("Post1");
        post1.setBody("This is Post 1");
        post1.setDate(new Date());
        postsArrayList.add(post1);

        Posts post2 = new Posts();
        post2.setTitle("Post2");
        post2.setBody("This is Post 2");
        post2.setDate(new Date());
        postsArrayList.add(post2);

        Posts post3 = new Posts();
        post3.setTitle("Post3");
        post3.setBody("This is Post 3");
        post3.setDate(new Date());
        postsArrayList.add(post3);

        model.addAttribute("hello", postsArrayList);

        return "index";

    }
}
