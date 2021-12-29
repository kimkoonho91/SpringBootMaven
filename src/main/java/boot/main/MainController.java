package boot.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    // 메인화면 접속
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(HttpServletRequest httpServletRequest, Model model) {
        
        System.out.println("메인화면 접속");
        
        return "thymeleaf/main";
    }
}