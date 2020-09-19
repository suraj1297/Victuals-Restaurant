package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import utilities.AddRestroAbstract;

public class UserRestaurantService extends AddRestroAbstract{

	private int count = 0;
	

	@Override
	public void BestRestro(MongoCollection<Document> collection, String location) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Document> newDoc = getData(collection, location);
		
		// sorting list as per ratings
		newDoc.sort((Document d1, Document d2) -> d2.getString("ratings").compareTo(d1.getString("ratings")));
		
		
		System.out.println("\nHere are some restaurants that you may like!\n");
		
	
		newDoc.forEach((docc)-> {
			count++;
			printData(docc);
			System.out.println();
		});
		
		count = 0;
	}

	@Override
	public void BestBars(MongoCollection<Document> collection, String location) {
		// TODO Auto-generated method stub
		
		ArrayList<Document> newDoc = getData(collection, location);
		
		// sorting list as per ratings
		newDoc.sort((Document d1, Document d2) -> d2.getString("ratings").compareTo(d1.getString("ratings")));
		
		Iterator<Document> itr = newDoc.iterator();
		
		System.out.println("\nHere are some restaurants that you may like!\n");
		while(itr.hasNext()) {
			Document d = itr.next();
			if(d.getString("type").contains("Bar")) {
				count++;
				printData(d);
				System.out.println();
			}
				
		}
		
		count = 0;
		
		
	}

	

	@Override
	public void Explore(MongoCollection<Document> collection,String location) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nWe are going to ask you few questions, if you dont want to answer any specific question just type 'n'");
		System.out.println("\nWhat kind of cuisine are you looking for?");
		String cuisine = sc.next();
		sc.nextLine();
		System.out.println("\nDo you prefer Veg or Non-Veg?");
		String type = sc.next();
		sc.nextLine();
		System.out.println("\nAny specific special dish?");
		String dish = sc.next();
		sc.nextLine();
		System.out.println("\nAny budget restrains(use k for thousands)?");
		String budget = sc.next();

		
		
		// getting data
		ArrayList<Document> newDoc = getData(collection, location);
		
		// sorting list as per ratings
		newDoc.sort((Document d1, Document d2) -> d2.getString("ratings").compareTo(d1.getString("ratings")));
		
		Iterator<Document> itr = newDoc.iterator();
		
		System.out.println("\nHere are some restaurants that you may like!\n");
		while(itr.hasNext()) {
			Document d = itr.next();
			if(d.getString("type").toLowerCase().contains(type.contentEquals("n")? "0":type.toLowerCase()) 
			|| d.getString("cuisines").toLowerCase().contains(cuisine.contentEquals("n") ? "0":cuisine.toLowerCase())
			|| d.getString("special_dishes").toLowerCase().contains(dish.contentEquals("n")? "0":dish.toLowerCase())
			|| d.getString("average_price").toLowerCase().contains(budget.contentEquals("n")? "o":budget.toLowerCase())
			|| d.getString("regional_dish").toLowerCase().contains(dish.contentEquals("n")? "0":dish.toLowerCase())
					) {
				count++;
				printData(d);
				System.out.println();
			}
				
		}
		
		count = 0;
		
	}
	
	@Override
	public void Regional(MongoCollection<Document> collection, String location) {
		// TODO Auto-generated method stub
		// getting data
		ArrayList<Document> newDoc = getData(collection, location);
				
		// sorting list as per ratings
		newDoc.sort((Document d1, Document d2) -> d2.getString("ratings").compareTo(d1.getString("ratings")));
				
		Iterator<Document> itr = newDoc.iterator();
				
		System.out.println("\nHere are some restaurants that you may like!\n");
		while(itr.hasNext()) {
			Document d = itr.next();
			if(!d.getString("regional_dish").contains("None")) {
				count++;
				printData(d);
				System.out.println("\tRegional Dish:    "+"'"+d.get("regional_dish")+"'");
				System.out.println();
			}
				
		}
		count = 0;
		
		
	}
	
	
	public ArrayList<Document> getData(MongoCollection<Document> collection, String location){
		
		FindIterable<Document> doc = collection.find();
		
		Iterator<Document> itr = doc.iterator();
		
		ArrayList<Document> newDoc = new ArrayList<Document>();
		
		while(itr.hasNext()) {
			Document d = itr.next();
			if(d.getString("location").toLowerCase().contentEquals(location.toLowerCase()))
				newDoc.add(d);
		}
		
		return newDoc;
	}
	
	public void printData(Document docc) {
		
		System.out.println("  "+count+". "+docc.get("name"));
		System.out.println("\tLocation:        "+"'"+docc.get("location")+"'");
		System.out.println("\tCuisine:         "+"'"+docc.get("cuisines")+"'");
		System.out.println("\tType:            "+"'"+docc.get("type")+"'");
		System.out.println("\tSpecial Dishes:  "+"'"+docc.get("special_dishes")+"'");
		System.out.println("\tMeals:           "+"'"+docc.get("meals")+"'");
		System.out.println("\tAverage Price/2:  "+"'"+docc.get("average_price")+" INR"+"'");
		System.out.println("\tRatings:          "+"'"+docc.get("ratings")+"'");
		
		
	}


}
