package mate.acadamy.internetshop.controllers;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Role;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.UserService;

public class InjectUserController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private final UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User bob = new User();
        bob.setUserName("Bob");
        bob.setUserLogin("Bob");
        bob.setUserPassword("1");
        bob.setRoles(Set.of(Role.of("USER")));
        userService.create(bob);

        User alisa = new User();
        alisa.setUserName("Alisa");
        alisa.setUserLogin("Alisa");
        alisa.setUserPassword("1");
        alisa.setRoles(Set.of(Role.of("USER")));
        userService.create(alisa);

        User admin = new User();
        admin.setUserName("admin");
        admin.setUserLogin("admin");
        admin.setUserPassword("1");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);

        req.getRequestDispatcher("/WEB-INF/views/injectUser.jsp").forward(req, resp);
    }
}
