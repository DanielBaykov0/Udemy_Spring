package baykov.daniel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // http://localhost:8080/ToDoList/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/ToDoList/welcome
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("user", "Daniel");
        log.info("model= {}", model);

        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return "Welcome to this Demo application.";
    }
}