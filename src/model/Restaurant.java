package model;

public class Restaurant {
	
	private String name;
	private String location;
	private String ratings;
	private String cuisines;
	private String type;
	private String special_dishes;
	private String average_price;
	private String meals;
	private String regional_dish;
	
	
//	public Restaurant(String name,String location, String ratings, String cuisines, String type,
//			String special_dishes, String average_price, String meals, String regional_dish) {
//		
//		this.name = name;
//		this.location = location;
//		this.ratings = ratings;
//		this.cuisines = cuisines;
//		this.type = type;
//		this.special_dishes = special_dishes;
//		this.average_price = average_price;
//		this.meals = meals;
//		this.regional_dish = regional_dish;
//		
//		
//	}
//	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getCuisines() {
		return cuisines;
	}
	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecial_dishes() {
		return special_dishes;
	}
	public void setSpecial_dishes(String special_dishes) {
		this.special_dishes = special_dishes;
	}
	public String getAverage_price() {
		return average_price;
	}
	public void setAverage_price(String average_price) {
		this.average_price = average_price;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getRegional_dish() {
		return regional_dish;
	}
	public void setRegional_dish(String regional_dish) {
		this.regional_dish = regional_dish;
	}
	

}
