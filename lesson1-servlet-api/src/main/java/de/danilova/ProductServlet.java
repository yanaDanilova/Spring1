package de.danilova;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product_servlet")
public class ProductServlet extends HttpServlet {

    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig config) throws ServletException {
      this.servletConfig = servletConfig;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 1; i < 11; i++) {
            Product product = new Product(i,"product"+i, 100+i);
            resp.getWriter().printf(String.valueOf(product));
            resp.getWriter().printf("<br>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();

    }
}
