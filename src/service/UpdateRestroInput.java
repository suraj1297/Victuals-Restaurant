package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Restaurant;

public class UpdateRestroInput {

	public Restaurant update() throws IOException{
		
		Restaurant restro = new Restaurant();
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nLeave field empty if you dont wanna update any particular field.");
		
		System.out.println("\nEnter new Name: ");
		String name = reader.readLine();
		restro.setName(name);
		
		System.out.println("\nEnter Location: ");
		String location = reader.readLine();
		restro.setLocation(location);
		
		System.out.println("\nEnter Ratings: ");
		String ratings = reader.readLine();
		restro.setRatings(ratings);
		
		System.out.println("\nEnter Cuisines: ");
		String cuisines = reader.readLine();
		restro.setCuisines(cuisines);
		
		System.out.println("\nEnter Type (Veg, Non Veg, Street Food, Desserts etc): ");
		String type = reader.readLine();
		restro.setType(type);
		
		System.out.println("\nEnter Special Dishes: ");
		restro.setSpecial_dishes(reader.readLine());
		
		System.out.println("\nEnter Average Price for Two (use 'k' for Thousand): ");
		restro.setAverage_price(reader.readLine());
		
		System.out.println("\nEnter Meals (Brunch, Lunch, Dinner etc): ");
		restro.setMeals(reader.readLine());
		
		System.out.println("\nEnter Regional Dish: ");
		restro.setRegional_dish(reader.readLine());
		
		return restro;
				
	}
}
