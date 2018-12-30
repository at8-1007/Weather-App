/**
 * 
 * @author athom126 (Ashley Thomas)
 * Created on: 10/20/18
 * 
 */
package com.weatherapp;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


@WebServlet(name="WeatherApp", urlPatterns="/WeatherApp")
public class Weather extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
						throws ServletException, IOException {
		
		/* Get selected city */
		String rawSelection = request.getParameter("selection");
		if(rawSelection == "") {
			PrintWriter out = response.getWriter();
			out.println("Valid city was not selected");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/weather.jsp");
	        dispatcher.forward(request, response);
		}
		else {
			int selection = Integer.parseInt(rawSelection) - 1;
			/* Parse XML doc to create Node tree */
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = dbf.newDocumentBuilder();				
				Document doc = builder.parse(new File("Weather.xml"));
				
				doc.getDocumentElement().normalize();
				
				// store each element of XML file into a node list
				NodeList cities = doc.getElementsByTagName("CITY");
				NodeList highs = doc.getElementsByTagName("HI");
				NodeList lows = doc.getElementsByTagName("LOW");
				NodeList descriptions = doc.getElementsByTagName("DESCRIPTION");
				NodeList icons = doc.getElementsByTagName("ICON");
				
				// initialize variables to store extracted data
				String city = "";
				int high = 0;
				int low = 0;
				String description = "";
				String imgSrc = "";
				
				// extract attribute value of city element for selected city
				Node cityNode = cities.item(selection); 
				if(cityNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cityName = (Element) cityNode;
					city = cityName.getAttribute("NAME");
					//System.out.println("City: " + city);
				}
			
				// extract high for the day for selected city
				high = Integer.parseInt(highs.item(selection).getTextContent());
				//System.out.println("High: " + high);
				
				// extract low for the day for selected city
				low = Integer.parseInt(lows.item(selection).getTextContent());
				//System.out.println("Low: " + low);
				
				// extract description for the day for selected city
				description = descriptions.item(selection).getTextContent();
				//System.out.println("Description: " + description);
				
				// extract attribute value of icon element for selected city
				Node imageNode = icons.item(selection);
				if(imageNode.getNodeType() == Node.ELEMENT_NODE) {
					Element imageFile = (Element) imageNode;
					imgSrc = imageFile.getAttribute("VALUE").toLowerCase();
					//System.out.println("Image: " + imgSrc);
				}
				
				/* Construct response */
				response.setContentType("text/html;charset=UTF-8");	
				// create weather bean for selected city and display the results
				WeatherBean weather = new WeatherBean(high, low, description, imgSrc, city);
		        request.setAttribute("weather", weather);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
		        dispatcher.forward(request, response);
			} catch (ParserConfigurationException | SAXException e) {
				e.printStackTrace();
			}
		}	
	}
}