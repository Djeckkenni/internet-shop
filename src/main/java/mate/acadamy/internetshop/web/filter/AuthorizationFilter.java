package mate.acadamy.internetshop.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Role;
import mate.acadamy.internetshop.model.User;
import mate.acadamy.internetshop.service.UserService;
import org.apache.log4j.Logger;

public class AuthorizationFilter implements Filter {
    private static final Logger LOGGER
            = Logger.getLogger(AuthorizationFilter.class);
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private static final UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);
    private Map<String, Set<Role.RoleName>> protectedUrls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrls.put("/users/all", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/orders/all", Set.of(Role.RoleName.USER));
        protectedUrls.put("/products/add", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/products/admin", Set.of(Role.RoleName.ADMIN));
        protectedUrls.put("/shoppingCart/all", Set.of(Role.RoleName.USER));
        protectedUrls.put("/injectProduct", Set.of(Role.RoleName.ADMIN));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestedUrl = req.getServletPath();

        if (protectedUrls.get(requestedUrl) == null) {
            filterChain.doFilter(req, resp);
            return;
        }
        Long userId = (Long) req.getSession().getAttribute("user_id");

        if (userId == null || userService.get(userId) == null) {
            resp.sendRedirect("/users/login");
            return;
        }
        User user = userService.get(userId);
        if (isAuthorized(user, protectedUrls.get(requestedUrl))) {
            filterChain.doFilter(req, resp);
        } else {
            LOGGER.warn("User " + user.getUserName() + " with id "
                    + user.getUserId() + " go to " + requestedUrl);
            req.getRequestDispatcher("/WEB-INF/views/users/accessDenied.jsp").forward(req, resp);
        }
        return;
    }

    @Override
    public void destroy() {

    }

    private boolean isAuthorized(User user, Set<Role.RoleName> authorizedRoles) {
        for (Role.RoleName authorizedRole : authorizedRoles) {
            for (Role userRole : user.getRoles()) {
                if (authorizedRole.equals(userRole.getRoleName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
