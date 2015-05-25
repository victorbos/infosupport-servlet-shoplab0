package nl.shop.web.controller;

import nl.shop.domain.Product;
import nl.shop.srv.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Victor on 9-5-2015.
 */
@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    @Inject
    ProductService productService;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Product> products=productService.listProducts();
        PrintWriter printWriter=httpServletResponse.getWriter();
        printWriter.println("<html>");
        printWriter.print("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/screen.css\" ></head>");
        printWriter.print("<body><table class=\"dataTable\">");
        for (int i=0; i< products.size(); i++){
            if (i%3==0) {
                printWriter.print("<tr>");
            }
            Product product=products.get(i);
            printWriter.print("<th>"+product.getName()+"</th>");
            printWriter.print("<td><br><img src=\"img/" + product.getImage() + "\"></td>");
            printWriter.print("<td><br>" + product.getPrice()+"</td>");
            if ((i+1)%3==0) {
                printWriter.print("</tr>");
            }
        }
        printWriter.println("</table></body></html>");
    }
}
