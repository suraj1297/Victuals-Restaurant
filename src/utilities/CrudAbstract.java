package utilities;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import model.Restaurant;

public abstract class CrudAbstract {

	public abstract void add(MongoCollection<Document> collection, Restaurant restro);
	public abstract void delete(MongoCollection<Document> collection, String name, String location);
	public abstract void update(Document document, MongoCollection<Document> collection) throws IOException;
	
}
