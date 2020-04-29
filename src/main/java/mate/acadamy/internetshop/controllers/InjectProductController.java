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

public class InjectProductController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private final ProductService productService = (ProductService) INJECTOR
            .getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Product boots = new Product();
        boots.setProductName("Ecco");
        boots.setProductPrice(new BigDecimal(1000));
        Product jeans = new Product();
        jeans.setProductPrice(new BigDecimal(500));
        jeans.setProductName("Diesel");
        productService.create(boots);
        productService.create(jeans);
        req.getRequestDispatcher("/WEB-INF/views/injectProduct.jsp").forward(req, resp);
    }
}
