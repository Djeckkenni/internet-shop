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
        User testAdmin = new User();
        testAdmin.setUserName("testAdmin");
        testAdmin.setUserLogin("testAdmin");
        testAdmin.setUserPassword("1");
        testAdmin.setRoles(Set.of(Role.of("ADMIN")));
        testAdmin.setSalts(new byte[]{3, 4});
        userService.create(testAdmin);
        req.getRequestDispatcher("/WEB-INF/views/injectUser.jsp").forward(req, resp);
    }
}
