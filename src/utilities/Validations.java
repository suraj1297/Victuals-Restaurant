package utilities;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import model.User;

public class Validations {
	
	public boolean validation(int type, User user, MongoCollection<Document> collection) {
		
		String role = type == 1 ? "user":"admin";
			
		BasicDBObject andQuery = new BasicDBObject();
		
		ArrayList<Document> newDocument = new ArrayList<Document>();
		newDocument.add(new Document("username",user.getUserName()));
		newDocument.add(new Document("password",user.getPassword()));
		newDocument.add(new Document("role",role));
		
		andQuery.put("$and",newDocument);
		
		Document doc = null;
		doc = collection.find(andQuery).first();
		
		if(doc == null) {
			return false;
		}
		
		return true;
			
	}

}
