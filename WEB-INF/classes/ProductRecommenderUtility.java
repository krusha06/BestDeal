import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.util.*;

public class ProductRecommenderUtility
{
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal","root","Amb!vert6");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/* Connection con = null;
    static String message;
	
	public boolean connect()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal","root","Amb!vert6");
			if(con.isClosed() || con==null){
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
	} */

	//fetching products from product table
	public Products getProductByName(String s)
	{
		//List<Products> productList = new ArrayList<Products>();
		Products product=null;
		String query;
		try
		{
			/* if(category.equalsIgnoreCase(""))
			{
				query = "SELECT * FROM ProductDetail order by productName ASC;";
				pst = con.prepareStatement(query);
			}
			else
			{
				query = "SELECT * FROM ProductDetail where category = ? order by productName ASC ;";
				pst = con.prepareStatement(query);
				pst.setString(1,category);
			} */
			
			query = "SELECT * FROM ProductDetail where productName = (?)";
			pst = con.prepareStatement(query);
			//System.out.println("string = " + s);
			pst.setString(1,s);
			//System.out.println("Query is "+pst);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				//System.out.println("Rs is " + rs);
				//System.out.println("Product name "+ rs.getString("productName"));
				//List<String> accessoryList = new ArrayList<String>();
				product = new Products();
				product.setName(rs.getString("productName"));
				product.setPrice(rs.getString("productPrice"));
				product.setImage(rs.getString("productImage"));
				product.setManufacturer(rs.getString("productManufacturer"));
				product.setCondition(rs.getString("productCondition"));
				product.setDiscount(rs.getString("productDiscount"));
				product.setQuantity(rs.getString("productQuantity"));
				product.setManufacturerRebate(rs.getString("manufacturerRebate"));
				
				//accessory list conversion.
				/* String s[] = (rs.getString("productAccessoryList")).split(",");
				for(String s1:s)
					accessoryList.add(s1);
				product.setAccessoryList(accessoryList);
				
				productList.add(product); */
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return product;
	}
	
	/* public Item getProductByName(String pName)
	{
		Item item = null;
		try
		{	
			PreparedStatement ps =  con.prepareStatement("select * from products where pname=?");
			ps.setString(1,pName);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				item = new Item();
				item.setPrice((float)rs.getDouble("pprice"));
				item.setName(rs.getString("pname"));
				item.setRetailer(rs.getString("rname"));
				item.setCompany(rs.getString("pcompany"));
				item.setColor(rs.getString("pcolor"));
				item.setCondition(rs.getString("pcondition"));
				item.setId(rs.getInt("pid")+"");
				item.setDescription(rs.getString("pdescription"));
				item.setImage(rs.getString("pimage"));
				item.setCategory(rs.getString("pcategory"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return item;
	} */
	
	public HashMap readCSVFile(){

		String f = "";
		//String dir = System.getenv("ANT_HOME");
        BufferedReader reader = null;
        String seperator = ",";
		HashMap<String,String> prodMap = new HashMap<String,String>();
		try {

            reader = new BufferedReader(new FileReader(new File("C:\\tomcat\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\Assignment_5\\output.csv")));
            while ((f = reader.readLine()) != null) {
                String[] recommendItem = f.split(seperator,2);
				prodMap.put(recommendItem[0],recommendItem[1]);
            }
			
		} catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		
		return prodMap;
	}
}