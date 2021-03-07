package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Add a logger
@Slf4j
// Web Controller
@Controller
public class DemoController {

    // Fields
    private final DemoService demoService;

    // Constructor initializes the demoService
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // Request methods
    // http://localhost:8080/ToDoListProject/hello
    // This returns the body of the request which in this case is hello
    @ResponseBody
    // To set up the html URL
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/ToDoListProject/welcome
    // When using parameters, then the above link will give Error 400
    // http://localhost:8080/ToDoListProject/welcome?user=Veronica
    // Two parameters URL: http://localhost:8080/ToDoListProject/welcome?user=Veronica&age=25
    // The previous directory and after directory will auto complete
    @GetMapping("welcome")
    // You can request more parameters
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
        // When using attribute in jsp file use this syntax
        // ${modelattributename} -> ${user}
        // model.addAttribute("user", "Veronica");
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        // Log this model
        log.info("model = {}", model);
        // prefix + name + suffix
        // /WEB-INF/view/welcome/welcome.jsp
        return "welcome";
    }

    // Model attributes
    // Another way to create model attributes
    // This type creates the attribute before the one above
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        // Add a log entry
        log.info("welcomeMessage() called");
        // Return string
        return demoService.getWelcomeMessage();
    }

}
