package utilities;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;



public class ValidateLocation {
	
	public boolean validateLocation(String location, MongoCollection<Document> collection) {
		
		FindIterable<Document> doc = collection.find();
		
		Iterator<Document> itr = doc.iterator();
		
		while(itr.hasNext()) {
			
			String docloc = itr.next().getString("location");
			if(docloc.toLowerCase().contentEquals(location.toLowerCase()))
				return true;
		}
		
		return false;
	}

}
