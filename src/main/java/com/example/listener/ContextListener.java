package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class ContextListener implements ServletContextListener {
    /* ContextListener should:
    be placed in com.example.filter package.
    set "servletTimeInit" attribute in the context,
    "servletTimeInit" is a LocalDateTime object showing when the context was initialized.*/
    @Override
    public void contextInitialized(ServletContextEvent event) {
        LocalDateTime servletTimeInit = LocalDateTime.now();
        ServletContext context = event.getServletContext();
        context.setAttribute("servletTimeInit", servletTimeInit);
    }
    }
