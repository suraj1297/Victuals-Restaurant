package service;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import model.User;

public class Registration{

	public void registration(User user, MongoCollection<Document> collection, String role) {
		
		Document query = new Document("username", user.getUserName())
				.append("password", user.getPassword())
				.append("role", role);
		
		collection.insertOne(query);
		
		System.out.println("\nRegistration Successfull!\n");
		
	}
}
