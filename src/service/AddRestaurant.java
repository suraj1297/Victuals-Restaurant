package service;

import model.Restaurant;

public class AddRestaurant {
	
	AddRestaurantInput ri = new AddRestaurantInput(); 
	
	public AddRestaurant(Restaurant restro) {
		
		ri.addName(restro);
		ri.addLocation(restro);
		ri.addRatings(restro);
		ri.addCuisines(restro);
		ri.addType(restro);
		ri.addSpecialDishes(restro);
		ri.addAveragePrice(restro);
		ri.addMeals(restro);
		ri.addRegionalDish(restro);
	}

}
