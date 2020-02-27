import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.List.*;



public class DataAnalytics extends HttpServlet {
	
	  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
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
	out.println("<li  class=''><a href='managestore'>Add Products</a></li>");
	out.println("<li class=''><a href='modifyproduct'>Delete Product</a></li>");
	out.println("<li class='selected'><a href='dataanalytics'>Data Analytics</a></li>");
	out.println("<li class=''><a href='inventory'>Inventory</a></li>");
	out.println("<li class=''><a href='salesreport'>Sales Report</a></li>");
	
	HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");
	if (fname == null)
	{
	out.println("<li class='' ><a href='login'>Sign in</a></li>");
	}
	else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='signout'>Sign Out</a></li>");
	}
	
	out.println("</ul>");
	out.println("</nav>");
	out.println("<h1>Data Analytics on Customer Reviews</h1>");
	out.println("<form  method='Post' action='dataanalytics'>");
	out.println("<table>"+
	"<tr><td><input type='checkbox' name='cb_category' value='productCategory'> Product Category</td>"+
	"<td><select name='category'><option value='allCategories' >All Categories</option><option value='SoundSystems'>SoundSystems</option></option><option value='SmartWatch'>SmartWatch</option><option value='HeadPhones'>HeadPhones</option><option value='TV'>TV</option><option value='VoiceAssistant'>Voice Assistant</option><option value='FitnessWatch'>Fitness Watch</option><option value='Phones'>Phones</option><option value='Laptops'>Laptops</option><option value='WirelessPlan'>WirelessPlan</option></select></td>"+
	"<td></td><td></td><td></td></tr>"+
	
	"<tr><td><input type='checkbox' name='cb_pprice' value='productPrice'> Product Price</td>"+
	"<td><input type='text' name='pprice' /></td>"+
	"<td><input type='radio' name='rb_pprice' value='equals'>Equals<br>"+
	"<input type='radio' name='rb_pprice' value='greaterThan'>Greater than<br>"+
	"<input type='radio' name='rb_pprice' value='lessThan'>Less than<br>"+
	"</td><td></td><td></td></tr>"+
	
	"<tr><td><input type='checkbox' name='cb_reviewrating' value='reviewRating'> Review Rating</td>"+
	"<td><select name='reviewrating'>"
					 +" <option value='1' >1(Very Bad)</option> "
					 +" <option value='2' >2</option> "
					 +" <option value='3' >3</option> "
					 +" <option value='4' >4</option> "
					 +" <option value='5' >5(Very Good)</option> "
					 +" </select></td>"+
	"<td><input type='radio' name='rb_reviewrating' value='equals'>Equals<br>"+
	"<input type='radio' name='rb_reviewrating' value='greaterThan'>Greater than<br>"+
	"</td><td></td><td></td></tr>"+
	
	"<tr><td><input type='checkbox' name='cb_city' value='reviewRating'> Retailer City</td>"+
	"<td><input type='text' name='city' /></td>"+
	"<td></td><td></td><td></td></tr>"+
	
	"<tr><td><input type='checkbox' name='cb_groupby' value='groupBy'> Group By</td>"+
	"<td><select name='groupby'>"
					 +" <option value='city' >City</option> "
					 +" <option value='zipCode' >Zip Code</option> "
					 +" </select></td>"+
	"<td><input type='radio' name='rb_groupby' value='count'>Count<br>"+
	"<input type='radio' name='rb_groupby' value='details'>Details<br>"+
	"<td></td><td></td></tr>"+
	
	"</table> <input type='submit' value='Find Data'>");
	out.println("</form>");
	
	out.println("</body>");
    out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
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
	out.println("<li  class='selected'><a href='managestore'>Add Products</a></li>");
	out.println("<li class=''><a href='modifyproduct'>Delete Product</a></li>");
	out.println("<li class=''><a href='dataanalytics'>Data Analytics</a></li>");
	out.println("<li class=''><a href='inventory'>Inventory</a></li>");
	out.println("<li class=''><a href='salesreport'>Sales Report</a></li>");
	
	HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");
	if (fname == null)
	{
	out.println("<li class='' ><a href='login'>Sign in</a></li>");
	}
	else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='signout'>Sign Out</a></li>");
	}
	
	out.println("</ul>");
	out.println("</nav>");
	out.println("<h1>Data Analytics on Customer Reviews</h1>");
	
	String productCategory = request.getParameter("category");
	String cbpprice = request.getParameter("cb_pprice");
	String cbrr = request.getParameter("cb_reviewrating");
	String cbcity = request.getParameter("cb_city");
	String cbgroupby = request.getParameter("cb_groupby");
	
	MongoDBDataStoreUtilities mongoObj = new MongoDBDataStoreUtilities();
	
	List<ProductReview> reviewList;

	if(productCategory.equalsIgnoreCase("allCategories"))
		 reviewList = mongoObj.getReviewList("","");
	else
		reviewList = mongoObj.getReviewList("productCategory",productCategory);
	
	
	if(reviewList!=null){
		out.println("<table border='2'>"+
				"<tr><th width='20%'>Product Name </th><th width='20%'>Product Price</th><th width='20%'>Product Category</th><th width='20%'>Review Rating</th></tr>");
			for(int i=0;i<reviewList.size();i++)
			{
				ProductReview p = reviewList.get(i);
				out.println("<tr><td>" +p.getProductModelName()+ " </td><td>" +p.getProductPrice()+ "</td><td>" +p.getProductCategory()+ " </td><td>" +p.getReviewRating()+ " </td></tr>");
			}
			out.println("</table>");
	}
	else{
		out.println("No Customer Reviews to show !!!");		
	}
	
	out.println("</body>");
    out.println("</html>");
	}

}


