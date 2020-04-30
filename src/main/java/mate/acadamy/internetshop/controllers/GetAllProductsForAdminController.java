package mate.acadamy.internetshop.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ProductService;

public class GetAllProductsForAdminController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> products = productService.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/products/admin.jsp").forward(req, resp);
    }
}
