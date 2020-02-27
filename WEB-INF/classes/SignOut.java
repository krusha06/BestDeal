import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;



public class SignOut extends HttpServlet {
	
	
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
	out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	out.println("<title>BestDeal</title>");
	out.println("<link rel='shortcut icon' href='images/Best-Deals.png'/>");
	out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='container'>");
	out.println("<header>");
	out.println("<h1><a href='home'><span>Best Deal</span></a></h1>");
	out.println("</header>");
	out.println("<nav>");
	out.println("<ul>");
	out.println("<div align='right'>");
	HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");
	
	if (fname == null)
	{
	out.println("<li class=''><a href='register'>Register</a></li>");
	out.println("<li class='' ><a href='login'>Sign in</a></li>");
	}
	else if(fname.equals("SalesMngr"))
	{
		  out.println("<li class=''><a href='register'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");  
		  out.println("<li class='' ><a href='signout'>Sign Out</a></li>");
	}
	else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='signout'>Sign Out</a></li>");
	}
	
	out.println("<li class='' ><a href='vieworders'>View Orders</a></li>");
	out.println("<form action='viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/red-cart.png' width = '40px' height = '40px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</ul>");
	out.println("</nav>");
	
	out.println("<nav>");
	out.println("<ul>");
	out.println("<li class=''><a href='home'>Home</a></li>");
	out.println("<li class=''><a href='tv'>TV</a></li>");	
	out.println("<li class=''><a href='soundsystems'>Sound Systems</a></li>");	
	out.println("<li class=''><a href='phones'>Phones</a></li>");
	out.println("<li class=''><a href='laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='voiceassistant'>Voice Assistant</a></li>");
	out.println("<li class=''><a href='smartwatches'>Smart Watches</a></li>");
	out.println("<li class=''><a href='fitnesswatches'>Fitness Watches</a></li>");	
	out.println("<li class=''><a href='headphones'>Headphones</a></li>");
	out.println("<li class=''><a href='wirelessplan'>Wireless Plan</a></li>");
	out.println("</ul>");
	out.println("</nav>");
	
	if(session!=null)
	session.invalidate();
		out.println("<br><br><h2>Please click <a href='login'>  here</a> to Login. <h2><br><br>");

}

}