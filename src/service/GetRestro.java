package service;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

public class GetRestro {
	
	public Document get(MongoCollection<Document> collection, String name, String location) {
		
		
		BasicDBObject andQuery = new BasicDBObject();
		ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("name", name));
		obj.add(new BasicDBObject("location", location));
		andQuery.put("$and", obj);
		
		try {
			collection.find(andQuery).first();
		}catch(Exception e){
			return null;
		}
		
		return collection.find(andQuery).first();
	}

}
