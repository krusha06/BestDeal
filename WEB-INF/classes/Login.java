import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.*;



public class Login extends HttpServlet {
	
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
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
	}
	else
	{
		out.println("<li class='selected'><a href='managestore'>Add Products</a></li>");
		out.println("<li class=''><a href='modifyproduct'>Delete Product</a></li>");
		out.println("<li class=''><a href='dataanalytics'>Data Analytics</a></li>");
		out.println("<li class=''><a href='inventory'>Inventory</a></li>");
		out.println("<li class=''><a href='salesreport'>Sales Report</a></li>");
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
	out.println("<li  class=''><a href='home'>Home</a></li>");
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

	out.println("<form method='Post' action='login'>");
	out.println("<table>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Login as&nbsp&nbsp");
	out.println("<input type='radio' name='usertype' value='customer' checked='checked'>&nbspCustomer&nbsp&nbsp&nbsp <input type='radio' name='usertype' value='storemanager'>&nbspStore Manager&nbsp&nbsp&nbsp <input type='radio' name='usertype' value='salesmanager'>&nbspSales Manager ");
	out.println("</td>");
	out.println("</tr>");
	out.println("<td>");
	out.println("User Id &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :");
	out.println("<input type='text' name='userid' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Password&nbsp&nbsp&nbsp:");
	out.println("<input type='password' name='password' required/></td>");
	out.println("</tr>");
	out.println("<tr><td ><input type='submit' value='Login'></td></tr>");
	out.println("</table/>");
	out.println("</form>");
	
	
}


  public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
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
	}
	else
	{
		out.println("<li class='selected'><a href='managestore'>Add Products</a></li>");
		out.println("<li class=''><a href='modifyproduct'>Delete Product</a></li>");
		out.println("<li class=''><a href='dataanalytics'>Data Analytics</a></li>");
		out.println("<li class=''><a href='inventory'>Inventory</a></li>");
		out.println("<li class=''><a href='salesreport'>Sales Report</a></li>");
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
	out.println("<li  class=''><a href='home'>Home</a></li>");
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
	
	String customertype = request.getParameter("usertype");
	String userid1 = request.getParameter("userid");
	String password1 = request.getParameter("password");
	
	
	if(customertype.equals("storemanager") && userid1.equals("admin") && password1.equals("admin"))
	{
		session.setAttribute("fname","StoreMngr");
		session.setAttribute("userid","StoreMngr");
		RequestDispatcher rd = request.getRequestDispatcher("managestore");
		rd.forward(request,response);
	}
	else if(customertype.equalsIgnoreCase("salesmanager") && userid1.equals("admin") && password1.equals("admin"))
	{
		session.setAttribute("fname","SalesMngr");
		session.setAttribute("userid","SalesMngr");
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);
	}
	
	else
	{
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		HashMap<String,User> userHashMap = new HashMap<String,User>();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		
	//SQL code to validate user details from table
	MySQLDataStoreUtilities dbObject = new MySQLDataStoreUtilities();
	if(dbObject.checkUserExist(userId))
	{
		if(dbObject.validateUser(userId,password))
		{
			session.setAttribute("fname",userId);
			session.setAttribute("userid",userId);
			RequestDispatcher rd = request.getRequestDispatcher("home");
			rd.forward(request,response);
		}
		else
		{
			out.println("<h3>Password is Incorrect / Please select appropriate User Type and try again  <h3>");
		}	
	}
	else
		out.println("<h1>User Id does not exist </h1>");
	}
}


}
