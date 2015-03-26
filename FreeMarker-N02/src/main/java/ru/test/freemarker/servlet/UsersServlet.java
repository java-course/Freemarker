package ru.test.freemarker.servlet;


import ru.test.freemarker.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Georgy Gobozov
 * @created : 25.04.13
 */
public class UsersServlet extends HttpServlet {

    public static List<User> users;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        users = new ArrayList<User>();
        users.add(new User("Vova", "Ivanov", "ivanov@gmail.com", 20));
        users.add(new User("Petr", "Petrov", "ptrov@gmail.com", 21));
        users.add(new User("Sidr", "Sidorov", "sidr@gmail.com", 23));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("delete") != null){

            String name = request.getParameter("delete");
            User user = findUserByName(name);
            if (user != null)
                users.remove(user);

            response.sendRedirect("/users");
            return;
        }

        request.setAttribute("users", users);
        request.setAttribute("message", "Message to demonstrate include");


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/templates/users.ftl");
        dispatcher.forward(request, response);




    }


    private User findUserByName(String name){
        for (User user : users) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }



}
