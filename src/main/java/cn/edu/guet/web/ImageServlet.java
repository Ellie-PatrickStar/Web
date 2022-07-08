package cn.edu.guet.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //respond返回jpg给网页
        response.setContentType("image/jpeg");

        InputStream in = null;
        try {
            in = Class.forName("cn.edu.guet.web.ImageServlet").getResourceAsStream("/candy.jpg");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int size = in.available();
        byte by[] = new byte[1024];
        int a = 0;
        ServletOutputStream os = response.getOutputStream();
        while((a = in.read(by))!= -1){
            os.write(by,0,a);
        }
        os.flush();
        os.close();
        in.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
