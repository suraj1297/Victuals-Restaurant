package utilities;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public abstract class AddRestroAbstract {
	
	public abstract void BestRestro(MongoCollection<Document> collection, String location);
	public abstract void BestBars(MongoCollection<Document> collection, String location);
	public abstract void Explore(MongoCollection<Document> collection,String location);
	public abstract void Regional(MongoCollection<Document> collection,String location);

}
