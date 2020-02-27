import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class SAXParserDataStore extends DefaultHandler
{
	String currentCategorytemp;
	//PrintWriter out = null; 
	static HashMap<String,List<Products>> productMap = new HashMap<String,List<Products>>();
	List<Products> fitnessWatchList = new ArrayList<Products>();
	List<Products> soundSystemsList = new ArrayList<Products>();
	List<Products> tvList = new ArrayList<Products>();
	List<Products> voiceAssistantList = new ArrayList<Products>();
	List<Products> smartWatchList = new ArrayList<Products>();
	List<Products> phoneList = new ArrayList<Products>();
	List<Products> laptopList = new ArrayList<Products>();
	List<Products> wirelessPlanList = new ArrayList<Products>();
	List<Products> headphoneList = new ArrayList<Products>();
	
	List<Products> accessoriesList = new ArrayList<Products>();
	Products product = null;
	List<String> accessoryList = null;
	
	String elementValueHead;
	boolean nameFlag = false, priceFlag=false,imageFlag=false, manufacturerFlag=false, conditionFlag=false, discountFlag=false, accessoriesFlag=false;
	
	//This method is used to test using PrintWriter's object.
	/* void parse(String fileName, PrintWriter out)
	{
		this.out=out;
		//out.println(fileName);
		DefaultHandler handler = this;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try 
		{
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(fileName), handler);
        } 
		catch (Exception ex) 
		{
			out.println(ex.getMessage());
		}
    } */
	
	void parse(String fileName)
	{
		//this.out=out;
		//out.println(fileName);
		DefaultHandler handler = this;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try 
		{
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(fileName), handler);
        } 
		catch (Exception ex) 
		{
			ex.getMessage();
		}
    }
	
	public void startElement(String str1, String str2, String elementName, Attributes attrs) throws SAXException 
    {
		String currentCategory=null;
        try
		{
			if(elementName.equalsIgnoreCase("TV"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("FitnessWatch"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("VoiceAssistant"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("WirelessPlan"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("SmartWatch"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			} 
			else if(elementName.equalsIgnoreCase("Phone"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			} 
			else if(elementName.equalsIgnoreCase("Laptop"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("Headphone"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("SoundSystems"))
			{
				currentCategory = attrs.getValue("id");
				product = new Products();	
				accessoryList = new ArrayList<String>();
			}
			else if(elementName.equalsIgnoreCase("AccessoriesCatalog"))
			{
				currentCategory = attrs.getValue("id");
				currentCategorytemp = currentCategory;
				if(currentCategory.equalsIgnoreCase("accessory"))
				{
					product = new Products();
				}
			} 
			else if(elementName.equalsIgnoreCase("name"))
			{
				nameFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("price"))
			{
				priceFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("image"))
			{
				imageFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("manufacturer"))
			{
				manufacturerFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("condition"))
			{
				conditionFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("discount"))
			{
				discountFlag = true;	
			}
			else if(elementName.equalsIgnoreCase("accessory"))
			{
				accessoriesFlag=true;	
			}
			
			if(elementName.equalsIgnoreCase("accessory") && currentCategory.equalsIgnoreCase("speakers"))
			{
				
			} 
        }
        catch(Exception e){}
    }
	
	public void endElement(String namespaceURI, String localName, String elementName)
    throws SAXException 
    {
		if(elementName.equalsIgnoreCase("SoundSystems"))
		{
			//out.println("P: "+product);
			soundSystemsList.add(product);
			productMap.put("soundSystemsList",soundSystemsList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("TV"))
		{
			//out.println("P: "+product);
			tvList.add(product);
			productMap.put("tvList",tvList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("SmartWatch"))
		{
			//out.println("P: "+product);
			smartWatchList.add(product);
			productMap.put("smartWatchList",smartWatchList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("Phone"))
		{
			//out.println("P: "+product);
			phoneList.add(product);
			productMap.put("phoneList",phoneList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("Laptop"))
		{
			//out.println("P: "+product);
			laptopList.add(product);
			productMap.put("laptopList",laptopList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("FitnessWatch"))
		{
			//out.println("P: "+product);
			fitnessWatchList.add(product);
			productMap.put("fitnessWatchList",fitnessWatchList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("Headphone"))
		{
			//out.println("P: "+product);
			headphoneList.add(product);
			productMap.put("headphoneList",headphoneList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("VoiceAssistant"))
		{
			//out.println("P: "+product);
			voiceAssistantList.add(product);
			productMap.put("voiceAssistantList",voiceAssistantList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("WirelessPlan"))
		{
			//out.println("P: "+product);
			wirelessPlanList.add(product);
			productMap.put("wirelessPlanList",wirelessPlanList);
			//out.println(productMap);
		} 
		else if(elementName.equalsIgnoreCase("AccessoriesCatalog"))
		{
			//out.println("P: "+product);
			accessoriesList.add(product);
			productMap.put("accessoriesList",accessoriesList);
			//out.println("\naccessoriesList: "+accessoriesList);
		}  
    }

    public void characters(char buf[], int offset, int len)
    throws SAXException
    {
         try{
            String elementValueHead = new String(buf, offset, len);
            
			if(nameFlag)
			{
				product.setName(elementValueHead);
				//out.println(elementValueHead);
				nameFlag=false;
			}
			else if(priceFlag)
			{
				product.setPrice(elementValueHead);
				//out.println(elementValueHead);
				priceFlag=false;
			}
			else if(imageFlag)
			{
				product.setImage(elementValueHead);
				//out.println(elementValueHead);
				imageFlag=false;
			}
			else if(manufacturerFlag)
			{
				product.setManufacturer(elementValueHead);
				//out.println(elementValueHead);
				manufacturerFlag=false;
			}
			else if(conditionFlag)
			{
				product.setCondition(elementValueHead);
				//out.println(elementValueHead);
				conditionFlag=false;
			}
			else if(discountFlag)
			{
				product.setDiscount(elementValueHead);
				//out.println(elementValueHead);
				discountFlag=false;
			}
			else if(accessoriesFlag)
			{
				accessoryList.add(elementValueHead);
				product.setAccessoryList(accessoryList);
				//out.println(elementValueHead);
				accessoriesFlag=false;
			}
				
			//out.println("Test here 35");
			//out.println(elementValueHead);
            }
        
        catch(Exception e){} 
    } 

	public Map<String,List<Products>> getProductMap()
	{
		return productMap;
	}
	
	public List<Products> getsoundSystemsList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		soundSystemsList = dbObj.getProductList("SoundSystems");
		return soundSystemsList;
		//return (productMap.get("soundSystemsList"));
	}
	
	public List<Products> getSmartWatchList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		smartWatchList = dbObj.getProductList("SmartWatch");
		return smartWatchList;
		//return (productMap.get("smartWatchList"));
	}
	
	public List<Products> getHeadphoneList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		headphoneList = dbObj.getProductList("HeadPhones");
		return headphoneList;
		//return (productMap.get("headphoneList"));
	}
	
	public List<Products> getPhoneList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		phoneList = dbObj.getProductList("Phone");
		return phoneList;
		//return (productMap.get("phoneList"));
	}
	
	public List<Products> getLaptopList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		laptopList = dbObj.getProductList("Laptops");
		return laptopList;
		//return (productMap.get("laptopList"));
	}
	
	public List<Products> gettvList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		tvList = dbObj.getProductList("TV");
		return tvList;
		//return (productMap.get("tvList"));
	}
	
	public List<Products> getfitnessWatchList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		fitnessWatchList = dbObj.getProductList("FitnessWatch");
		return fitnessWatchList;
		//return (productMap.get("fitnessWatchList"));
	}
	
	public List<Products> getvoiceAssistantList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		voiceAssistantList = dbObj.getProductList("VoiceAssistant");
		return voiceAssistantList;
		//return (productMap.get("voiceAssistantList"));
	}
	
	public List<Products> getwirelessPlanList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		wirelessPlanList = dbObj.getProductList("WirelessPlan");
		return wirelessPlanList;
		//return (productMap.get("wirelessPlanList"));
	}
	
	public List<Products> getAccessoriesList()
	{
		MySQLDataStoreUtilities dbObj = new MySQLDataStoreUtilities();
		accessoriesList = dbObj.getProductList("AccessoriesList");
		return accessoriesList;
		//return (productMap.get("accessoriesList"));
	}
}
