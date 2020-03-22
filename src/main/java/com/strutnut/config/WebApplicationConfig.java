package com.strutnut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;


@Configuration
public class WebApplicationConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        initSpringConfig(servletContext);
        initWebmvcConfig(servletContext);


    }

    private void initSpringConfig(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.register(SpringConfig.class);
        servletContext.addListener(new ContextLoaderListener(configWebApplicationContext));

    }


    private void initWebmvcConfig(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.register(WebmvcConfig.class);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(configWebApplicationContext));
        springmvc.setLoadOnStartup(1);
        springmvc.addMapping("/*");
    }
}
