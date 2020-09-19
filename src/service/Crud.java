package service;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import model.Restaurant;
import utilities.CrudAbstract;

public class Crud extends CrudAbstract{

	@Override
	public void add(MongoCollection<Document> collection, Restaurant restro) {
		// TODO Auto-generated method stub
		
		Document doc = new Document("name",restro.getName())
				.append("location", restro.getLocation())
				.append("ratings",restro.getRatings())
				.append("cuisines", restro.getCuisines())
				.append("type", restro.getType())
				.append("special_dishes", restro.getSpecial_dishes())
				.append("average_price", restro.getAverage_price())
				.append("meals", restro.getMeals())
				.append("regional_dish", restro.getRegional_dish());
		
		collection.insertOne(doc);
		
		System.out.println("\nAdded new Restaurant successfully.\n");
		
	}

	@Override
	public void delete(MongoCollection<Document> collection, String name, String location) {
		// TODO Auto-generated method stub
			Document doc = new GetRestro().get(collection, name, location);
			if(doc != null) {
				BasicDBObject delQuery = new BasicDBObject();
				delQuery.put("_id", doc.getObjectId("_id"));
		
				collection.deleteOne(delQuery);
				System.out.println("\nDeleted Successfully !\n");
			}
		else{
			System.out.println("No such restaurant found :(");
		}
		
	}


	@Override
	public void update(Document document, MongoCollection<Document> collection) throws IOException {
		// TODO Auto-generated method stub
		
		Restaurant restro = new UpdateRestroInput().update();
		
		BasicDBObject newDocument = new BasicDBObject();
		
		if(!restro.getName().equalsIgnoreCase("n") && !restro.getName().isEmpty())
			newDocument.append("name",restro.getName());
		
		if(!restro.getLocation().equalsIgnoreCase("n") && !restro.getLocation().isEmpty())
			newDocument.append("location",restro.getLocation());
		
		if(!restro.getRatings().equalsIgnoreCase("n")  && !restro.getRatings().isEmpty())
			newDocument.append("ratings",restro.getRatings());
		
		if(!restro.getCuisines().equalsIgnoreCase("n")  && !restro.getCuisines().isEmpty())
			newDocument.append("cuisines",restro.getCuisines());
		
		if(!restro.getType().equalsIgnoreCase("n")  && !restro.getType().isEmpty())
			newDocument.append("type",restro.getType());
		
		if(!restro.getSpecial_dishes().equalsIgnoreCase("n") && !restro.getSpecial_dishes().isEmpty())
			newDocument.append("special_dishes",restro.getSpecial_dishes());
		
		if(!restro.getAverage_price().equalsIgnoreCase("n") && !restro.getAverage_price().isEmpty())
			newDocument.append("average_price",restro.getAverage_price());
		
		if(!restro.getMeals().equalsIgnoreCase("n")  && !restro.getMeals().isEmpty())
			newDocument.append("meals",restro.getMeals());
		
		if(!restro.getRegional_dish().equalsIgnoreCase("n") && !restro.getRegional_dish().isEmpty())
			newDocument.append("regional_dish",restro.getRegional_dish());
			
		
		if(newDocument.isEmpty()) {
			System.out.println("There was nothing to update.");
		}
		else {
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.put("$set",newDocument);
		
		
		BasicDBObject query = new BasicDBObject();
		query.put("_id",document.getObjectId("_id"));
		
		
		collection.updateOne(query, setQuery);
		
		System.out.println("\nUpdated Successfully");
		
		}
		
	}

}
