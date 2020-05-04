package mate.acadamy.internetshop.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.service.UserService;

public class AuthenticationFilter implements Filter {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private static final UserService userService = (UserService) INJECTOR
            .getInstance(UserService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getServletPath();
        if (url.equals("/users/login") || url.equals("/registration")) {
            filterChain.doFilter(req, resp);
            return;
        }
        Long userId = (Long) req.getSession().getAttribute(USER_ID);

        if (userId == null || userService.get(userId) == null) {
            resp.sendRedirect("/users/login");
            return;
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
