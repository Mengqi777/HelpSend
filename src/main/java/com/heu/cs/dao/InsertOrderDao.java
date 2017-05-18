package com.heu.cs.dao;

import com.mongodb.client.MongoCollection;
import com.heu.cs.conndb.ConnMongoDB;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by memgq on 2017/5/17.
 */
public class InsertOrderDao {
    public InsertOrderDao() {
    }

    public String insertOrder(String orderStr){

        try{
            ConnMongoDB connMongoDB=new ConnMongoDB();
            MongoCollection collection=connMongoDB.getCollection("bbddb","order");
            //JsonObject obj = new JsonParser().parse(orderStr).getAsJsonObject();
            //Document document = new Document(obj.get("id").toString(), obj.get("name"));
            Document document = new Document("title", orderStr);
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            connMongoDB.getMongoClient().close();
            return "1";
        }catch (Exception exception){
            exception.printStackTrace();
            return "0";
        }
    }
}
