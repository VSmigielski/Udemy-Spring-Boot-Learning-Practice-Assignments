package academy.learnprogramming.config;

import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")

public class WebConfig implements WebMvcConfigurer {
    // Constants
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    // Create bean method
    @Bean
    public ViewResolver viewResolver() {
        // internal resource view resolver
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        // Set prefix
        viewResolver.setPrefix(RESOLVER_PREFIX);
        // Set suffix
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        // viewResolver returned
        return viewResolver;
    }

    // Used to configure easy non-dynamic pages
    // For us, this is the home view
    // Eliminates creating more things in TodoItemController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // This will direct us to the home page
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
