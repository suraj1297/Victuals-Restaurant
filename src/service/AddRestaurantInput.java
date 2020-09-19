package service;

import java.util.Scanner;

import model.Restaurant;

public class AddRestaurantInput {
	
	Scanner sc = new Scanner(System.in);
	
	public void addName(Restaurant restro) {
			
			System.out.println("\nName of restaurant: ");
			String name = sc.nextLine();
			
			if(name.isEmpty()) {
				addName(restro);
			}else {
				restro.setName(name);
			}
		}
	
	public void addLocation(Restaurant restro) {
		
		System.out.println("\nLocation: ");
		String location = sc.nextLine();

		
		if(location.isEmpty()) {
			addLocation(restro);
		}else {
			restro.setLocation(location);
		}
	}
	
	
	public void addRatings(Restaurant restro) {
		
		System.out.println("\nRatings: ");
		String ratings = sc.nextLine();
		
		if(ratings.isEmpty()) {
			addRatings(restro);
		}
		else{
			restro.setRatings(ratings);
		}
	}
	
	public void addCuisines(Restaurant restro) {
		
		System.out.println("\nCuisines: ");
		String cuisines = sc.nextLine();
		
		if(cuisines.isEmpty()) {
			addCuisines(restro);
		}else {
			restro.setCuisines(cuisines);
		}
	}
	
	public void addType(Restaurant restro) {
		
		System.out.println("\nType(Veg, Non Veg, Snacks, Dessert etc): ");
		String type = sc.nextLine();
		
		
		if(type.isEmpty()) {
			addType(restro);
		}
		else {
			restro.setType(type);
		}		
	}
	
	
	public void addSpecialDishes(Restaurant restro) {
		
		System.out.println("\nSpecial Dishes: ");
		String special_dishes = sc.nextLine();
		
		
		if(special_dishes.isEmpty()) {
			addSpecialDishes(restro);
		}
		else {
			restro.setSpecial_dishes(special_dishes);
		}
	}
	

	public void addAveragePrice(Restaurant restro) {
		
		System.out.println("\nAverage Price for Two (Use 'K' for Thousands): ");
		String average_price = sc.nextLine();

		
		if(average_price.isEmpty()) {
			addAveragePrice(restro);
		}
		else {
			restro.setAverage_price(average_price);
		}
	}
	
	
	public void addMeals(Restaurant restro) {
		
		System.out.println("\nMeals (Luch, Dinner, Breakfast, Brunch): ");
		String meals = sc.nextLine();

		
		if(meals.isEmpty()) {
			addMeals(restro);
		}
		else {
			restro.setMeals(meals);
		}
	}
	
	
	public void addRegionalDish(Restaurant restro) {
		
		System.out.println("\nRegional Dishes: ");
		String regional_dish = sc.nextLine();
		
		
		if(regional_dish.isEmpty()) {
			addRegionalDish(restro);
		}
		else {
			restro.setRegional_dish(regional_dish);
		}
	}
}
