package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }



// public class CalculatorServlet implements Servlet // (1)
//    private ServletConfig servletConfig;

//    @Override
//    public void init(ServletConfig config) throws ServletException { // Sublet 컨테이너가 Sublet 생성 후 초기화 작업 호출하는 메소드 - 1번만 호출
//        log.info("init");
//        this.servletConfig = servletConfig;
//    }

     /*public class CalculatorServlet extends GenericServlet // (2)
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }*/

//    @Override
//    public void destroy() { // 자원 해제시 사용
//        // resourse release
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return this.servletConfig;
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "";
//    }
}
