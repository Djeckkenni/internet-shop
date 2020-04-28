package mate.acadamy.internetshop.controllers;

import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User bob = new User();
        bob.setUserName("Bob");
        User alisa = new User();
        alisa.setUserName("Alisa");
      //  userService.create(bob);
        userService.create(alisa);
        resp.sendRedirect("/");
    }
}
