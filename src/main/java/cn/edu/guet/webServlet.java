package cn.edu.guet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class webServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("第一个后端程序");
        String citykey = request.getParameter("citykey");
        String password = request.getParameter("password");
        System.out.println(citykey);
        System.out.println(password);
    //浏览器输入url
    //http://localhost:8080/Web_war/web.html?citykey=123456&password=123

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
