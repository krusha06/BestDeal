import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Laptops extends HttpServlet 
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {  
	SAXParserDataStore fetchProductList = new SAXParserDataStore();
	List<Products> laptopList = fetchProductList.getLaptopList();
	
	
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
	out.println("<li class='selected'><a href='laptops'>Laptops</a></li>");
	out.println("<li class=''><a href='voiceassistant'>Voice Assistant</a></li>");
	out.println("<li class=''><a href='smartwatches'>Smart Watches</a></li>");
	out.println("<li class=''><a href='fitnesswatches'>Fitness Watches</a></li>");	
	out.println("<li class=''><a href='headphones'>Headphones</a></li>");
	out.println("<li class=''><a href='wirelessplan'>Wireless Plan</a></li>");
	out.println("</ul>");
	out.println("</nav>");
	
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Laptops</h2>" +
				"<table>");
	
	Products p,p2;
	 for(int i = 0;i<laptopList.size();i++)
	{
		p = laptopList.get(i);
		session.setAttribute("addtocart",p);
		//out.println("p name: "+p.getName());
		out.println("<tr class='card'>"+
					"	<td><b>" + p.getName() + "</b>  </td>" +
					"	<td><img class='product-image' src='" +p.getImage()+ "'></td>" +
					"	<td>$" + p.getPrice() + "</td>" +
					"<form class = 'submit-button' method = 'get' action = 'addtocart'>" +
					"<td><input class = 'submit-button' type = 'submit' value='Buy Now'></td>" +
					"<input type='hidden' name='product' value='"+p+"'>" +
					"</form>" +
					//Write Review form
					"<form class = 'submit-button' method = 'get' action = 'writereview'>" +
					"<td><input class = 'submit-button' type = 'submit' value='Write Review'></td>" +
					"<input type='hidden' name='product' value='"+p+"'>" +
					"<input type='hidden' name='productCategory' value='Laptops'>" +
					"</form>" +
					
					//View Review form
					"<form class = 'submit-button' method = 'get' action = 'viewreview'>" +
					"<td><input class = 'submit-button' type = 'submit' value='View Review'></td>" +
					"<input type='hidden' name='product' value='"+p+"'>" +
					"</form>" +
					"</tr>");
	} 
	
	out.println("</table>");
	out.println("</article>");
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='soundsystems'>Sound Systems</a></li>");	
	out.println("<li><a href='tv'>TV</a></li>");	
	out.println("<li><a href='phones'>Phones</a></li>");
	out.println("<li><a href='laptops'>Laptops</a></li>");
	out.println("<li><a href='voiceassistant'>Voice Assistant</a></li>");
	out.println("<li><a href='smartwatches'>Smart Watches</a></li>");
	out.println("<li><a href='fitnesswatches'>Fitness Watches</a></li>");	
	out.println("<li><a href='headphones'>Headphones</a></li>");
	out.println("<li><a href='wirelessplan'>Wireless Plan</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");	
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Best Deal - Serves the Best </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
	out.println("</body>");	
	out.println("</html>");	

	}
}
