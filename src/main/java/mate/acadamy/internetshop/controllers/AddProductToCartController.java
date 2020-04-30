package mate.acadamy.internetshop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.acadamy.internetshop.inject.Injector;
import mate.acadamy.internetshop.model.Product;
import mate.acadamy.internetshop.model.ShoppingCart;
import mate.acadamy.internetshop.service.ProductService;
import mate.acadamy.internetshop.service.ShoppingCartService;

public class AddProductToCartController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector INJECTOR = Injector.getInstance("mate.acadamy.internetshop");
    private ProductService productService = (ProductService) INJECTOR
            .getInstance(ProductService.class);
    private ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR
            .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productId = req.getParameter("id");
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(USER_ID);
        Product product = productService.get(Long.parseLong(productId));
        shoppingCartService.addProduct(shoppingCart, product);
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
