package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import com.mongodb.MongoClient; 

public class Connection {
	  
	
	public MongoCollection<Document> connect() {
		// Disabling logging
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
	    mongoLogger.setLevel(Level.SEVERE);
	    
	    
	    //Creating client
	    MongoClient mongo = new MongoClient("localhost", 27017);
	    
	    // Accessing Database
	    MongoDatabase database  = mongo.getDatabase("Restaurant");
		
		// Retrieving a collection
	    MongoCollection<Document> collection = database.getCollection("restaurant"); 
	    

	    return collection;
	    
	    

	}
	
	
	public MongoCollection<Document> connectUser(){
		
		//Creating client
	    MongoClient mongo = new MongoClient("localhost", 27017);
	    
	    // Accessing Database
	    MongoDatabase database  = mongo.getDatabase("Restaurant");
		
		MongoCollection<Document> collection = database.getCollection("user");
		
		return collection;
	}
}
