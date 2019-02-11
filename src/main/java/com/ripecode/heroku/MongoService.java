package com.ripecode.heroku;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoService {
    private static  MongoClient mongoClient;

    static {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://tutorial-user:tutorial-user@cluster0-shard-00-00-2lbue.mongodb.net:27017,cluster0-shard-00-01-2lbue.mongodb.net:27017,cluster0-shard-00-02-2lbue.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin"));
    }

    public static String getMessage() {
        MongoDatabase database = mongoClient.getDatabase("tutorial");
        MongoCollection<Document> collection = database.getCollection("messages");


        Document query = new Document("_id", new ObjectId("5c60b282f066fe5f423c76b6"));
        Document result = collection.find(query).iterator().next();


        return result.getString("message");
    }
}