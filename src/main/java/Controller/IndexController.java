package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shaohao on 2018/9/30.
 */
@Controller
@RequestMapping("/home")
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "/index.jsp";
    }
}
