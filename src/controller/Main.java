package controller;


import java.io.IOException;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import dao.Connection;
import model.Location;
import model.Restaurant;
import model.User;
import service.AddRestaurant;
import service.Crud;
import service.GetRestro;
import service.Registration;
import service.UserRestaurantService;
import utilities.CrudAbstract;
import utilities.AddRestroAbstract;
import utilities.ValidateLocation;
import utilities.Validations;

public class Main {
	static Scanner sc = new Scanner(System.in);
	private static String askLocation = null;
	
	static Location location = null;
	
	
	public static void  greetings(MongoCollection<Document> collection) throws NumberFormatException, IOException {
		System.out.println("How would you like to login?");
		System.out.println("1. User\n"+"2. Admin\n3. User Registration");
		System.out.println("Enter 1/2/3: ");
		String choice = sc.next();
		sc.nextLine();

		
		if(choice.contentEquals("1") || choice.contentEquals("2")) {
			System.out.println("Username: ");
			
			String userName = sc.nextLine();
			
			System.out.println("Password: ");
			String password =  sc.nextLine();
			
			User user = new User(userName, password);
			
			Validations valid = new Validations();
			if(!valid.validation(Integer.parseInt(choice) , user, new Connection().connectUser())) {
				System.out.println("Sorry! You might have entered wrong credentials. \n");
				greetings(collection);
			}
			
			System.out.println("Logged in successfully!\n");
			
		}
		else if(choice.contentEquals("3")) {
			System.out.print("Enter Username: ");
			String userName = sc.nextLine();
			
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			
			User user = new User(userName, password);
			
			new Registration().registration(user, new Connection().connectUser(), "user");
			greetings(collection);
			
		}
		else {
			System.out.println("\nPlease enter appropirate choice number");
			greetings(collection);
		}
		
		path(collection, Integer.parseInt(choice));
	}
	
	public static void userService(MongoCollection<Document> collection) throws NumberFormatException, IOException {
		
		System.out.println("\nWhat are you looking for ?");
		System.out.println("1. Explore Restaurants");
		System.out.println("2. Explore Bars");
		System.out.println("3. Filter/Guide");
		System.out.println("4. Regional Dishes");
		System.out.println("5. Logout");
		
		String choice = sc.next();
		
		if(!"12345".contains(choice)) {
			System.out.println("Please enter appropriate choice");
			userService(collection);
		}
		
		
		// Creating instance of Restaurant Details
		AddRestroAbstract restro = new UserRestaurantService();
		
		switch(Integer.parseInt(choice)) {
		case 1: 
			restro.BestRestro(collection,location.getLocation());
			break;
		case 2:
			restro.BestBars(collection,location.getLocation());
			break;
		case 3:
			restro.Explore(collection,location.getLocation());
			break;
		case 4:
			restro.Regional(collection,location.getLocation());
			break;
		
		case 5:
			System.out.println();
			greetings(collection);
			break;
		}
		
		userService(collection);
				
		
	}
	
	
	public static void adminService(MongoCollection<Document> collection) throws IOException {
		
		System.out.println("\nWelcome Admin !");
		System.out.println("1. Add new restaurant");
		System.out.println("2. Delete resaurant");
		System.out.println("3. Update restaurant");
		System.out.println("4. View Restaurants");
		System.out.println("5. Register new admin");
		System.out.println("6. Logout");
		
		String choice = sc.next();
		
		if(!"123456".contains(choice)) {
			System.out.println("Please enter appropriate choice");
			adminService(collection);
		}
		
		CrudAbstract crud = new Crud();
		 
		
		switch(Integer.parseInt(choice)) {
			
		case 1: 
			System.out.println("\nEnter 'none' if some field doesn't apply.");
			Restaurant restro = new Restaurant();
			new AddRestaurant(restro);
			crud.add(collection, restro);
			break;
			
		case 2:
			System.out.println("\nEnter the name and location of restaurant you want to delete.");
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Location: ");
			String location = sc.nextLine();
			System.out.println("Are you sure you want to delete "+name+"\nEnter (Y/N)");
			String yn = sc.nextLine();
			if(yn.equalsIgnoreCase("y")) {
				crud.delete(collection, name, location);
			}else {
				System.out.println("\nAborted! Data was not deleted\n");
			}
			break;
			
		case 3:
			System.out.println("\nPlease Enter the name of Restaurant:");
			sc.nextLine();
			String name1 = sc.nextLine();
			System.out.println("Location: ");
			String location1 = sc.nextLine();
			
			Document doc = new GetRestro().get(collection, name1, location1);
			if(doc == null) {
				System.out.println("No such Restaurant Found. You might have misstyped something");
			}else {
				crud.update(doc, collection);
			}
			break;
			
		case 4:
			sc.nextLine();
			System.out.println("Location: ");
			String location3 = sc.nextLine();
			
			boolean valid = false;
			ValidateLocation validLoc = new ValidateLocation();
			valid = validLoc.validateLocation(location3, collection);
			
			if(valid) {
				AddRestroAbstract restroo = new UserRestaurantService();
				restroo.BestRestro(collection, location3);
			}else {
				System.out.println("Sorry! But we don't have restaurants in that loction :(\n");
			}
			break;
			
		case 5:
			sc.nextLine();
			System.out.print("Enter Username: ");
			String userName = sc.nextLine();
			
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			
			User user = new User(userName, password);
			
			new Registration().registration(user, new Connection().connectUser(), "admin");
			break;
			
		case 6:
			System.out.println();
			greetings(collection);
			break;
			
		default:
			adminService(collection);
			break;
		}
		
		adminService(collection);
		
	}
	
	
	public static void path(MongoCollection<Document> collection, int choice) throws IOException {
		
		
		if(choice == 1) {
		
			//Asking for location
			boolean valid = false;
			do {
			System.out.println("Please tell us your location");
			askLocation = sc.next();
			ValidateLocation validLoc = new ValidateLocation();
			valid = validLoc.validateLocation(askLocation, collection);
			
			if(valid) {
				location = new Location(askLocation);
			}else {
				System.out.println("Sorry! But we don't operate in your location :( \nWanna try different location ?\n");
			}
	
			}while(askLocation.isEmpty() || !valid);
			
			
			// Asking for Preference
			userService(collection);
			
		}
		else if(choice == 2) {
			
			adminService(collection);
			
		}
	
	}
	
	
	 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Connecting to DataBase
		MongoCollection<Document> collection = new Connection().connect();
		
		
		//Greeting
		System.out.println("Greetings ! Welcome to Victuals\n");
		greetings(collection);
		
		sc.close();
		
	}

}

