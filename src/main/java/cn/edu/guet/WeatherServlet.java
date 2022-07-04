package cn.edu.guet;

import okhttp3.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("获取天气");
        //根据citykey返回不同城市的天气
        String citykey = request.getParameter("citykey");
        System.out.println(citykey);

        //postman复制粘贴后发现报红
        //需要 添加依赖 百度搜索 maven okhttp
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
        //重复了，有冲突
        Request okRequest = new Request.Builder()
                .url("http://wthrcdn.etouch.cn/weather_mini?citykey="+citykey)
                //修改url不能写死
//                .url("http://wthrcdn.etouch.cn/weather_mini?citykey=101270101")
//                .method("GET", body)
                .build();
        Response okResponse = client.newCall(okRequest).execute();
        String str = okResponse.body().string();
        System.out.println(str);

        //响应:天气接口返回json数据到前端
        response.setContentType("application/json;charset=UTF-8");
        //此处是写的内容类型取决于tomcat中的配置的类型
        PrintWriter out = response.getWriter();
        out.print(str);
        out.flush();
        out.close();

    }







    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
