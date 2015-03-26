package ru.test.freemarker.servlet;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.test.freemarker.bean.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Georgy Gobozov
 * @created : 25.04.13
 */
public class CreateUserServlet extends HttpServlet {

    private Configuration cfg;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Initialize the FreeMarker configuration;
        cfg = new Configuration();
        // - Templates are stoted in the WEB-INF/templates directory of the Web app.
        cfg.setServletContextForTemplateLoading(getServletContext(), "templates");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map data = new HashMap();
        data.put("message", "Welcome to user management application");
        Template t = cfg.getTemplate("newuser.ftl");

        // Prepare the HTTP response:
        // - Use the charset of template for the output
        // - Use text/html MIME-type
        response.setContentType("text/html; charset=" + t.getEncoding());
        Writer out = response.getWriter();
        // Merge the data-model and the template
        try {
            t.process(data, out);
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");

        if (!isEmptyString(name) && !isEmptyString(surname) && !isEmptyString(email) && isDigit(age)){
            UsersServlet.users.add(new User(name, surname, email, Integer.parseInt(age)));

        }

        resp.sendRedirect("/users");

    }

    private boolean isEmptyString(String s){
        return s == null || s.trim().length() == 0;
    }

    private boolean isDigit(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
