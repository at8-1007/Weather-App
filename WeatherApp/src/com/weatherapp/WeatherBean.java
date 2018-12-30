/**
 * @author athom126 (Ashley Thomas)
 * Created on: 10/20/18
 * 
 */
package com.weatherapp;

public class WeatherBean {
	
	private int high;
	private int low;
	private String description;
	private String imgSrc;
	private String city;
	
	/**
	 * Default empty constructor
	 */
	public WeatherBean() {}
	
	/**
	 * 
	 * @param hi
	 * @param lo
	 * @param desc
	 * @param img
	 */
	public WeatherBean(int hi, int lo, String desc, String img, String city) {
		this.setHigh(hi);
		this.setLow(lo);
		this.setDescription(desc);
		this.setImgSrc(img);
		this.setCity(city);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHigh() {
		return high;
	}
	
	/**
	 * 
	 * @param high
	 */
	public void setHigh(int high) {
		this.high = high;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLow() {
		return low;
	}
	
	/**
	 * 
	 * @param low
	 */
	public void setLow(int low) {
		this.low = low;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getImgSrc() {
		return imgSrc;
	}
	
	/**
	 * 
	 * @param imgSrc
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = "images/"+imgSrc+".gif";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param city
	 * @return 
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
