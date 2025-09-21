package thiennn.pro.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "Thien";
		req.setAttribute("name", name); //Truyền dữ liệu ra cho tham số views
		RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");//goit views home.jsp hiển thị
		rd.forward(req, resp);//chuyển tham số ra home.jsp
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("ten");
		String lstName = req.getParameter("holot");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("Hello " + lstName + " " + name);
		out.close();
	}

}
