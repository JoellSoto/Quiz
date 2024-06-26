package com.Tech.quiz.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SwaggerUiRedirectController {
    @GetMapping("/swagger-ui/")
    public String forward() {
        return "forward:/swagger-ui/index.html";
    }
    @GetMapping("/swagger-ui")
    public RedirectView redirect() {
        return new RedirectView("/swagger-ui/");
    }

    @GetMapping("/swagger")
    public RedirectView redirect2() {
        return new RedirectView("/swagger-ui/");
    }

}
