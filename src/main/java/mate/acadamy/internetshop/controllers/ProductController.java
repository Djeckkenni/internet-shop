package mate.acadamy.internetshop.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.service.ProductService;

public class ProductController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate.acadamy.internetshop");
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/products/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String value = req.getParameter("price");
        BigDecimal bigDecimal = new BigDecimal(value.replaceAll(",", ""));
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(bigDecimal);
        productService.create(product);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
