package zwb.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","haha");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("11111111111111111");
        req.getRequestDispatcher("/page/index.jsp").forward(req,resp);
    }
}
