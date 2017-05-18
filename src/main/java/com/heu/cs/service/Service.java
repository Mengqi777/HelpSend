package com.heu.cs.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.heu.cs.dao.InsertOrderDao;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by memgq on 2017/5/14.
 */
@Path("/")
public class Service {


        @GET
        @Produces({"text/html"})
        public String index(){
            return "OK";
        }

        @GET
        @Path("/mongodb")
        @Produces(MediaType.TEXT_HTML)
        public String mongodb(){
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("bbddb");
            MongoCollection<Document> collection = mongoDatabase.getCollection("users");
            Document document = new Document("title", "MongoDB");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
            return document.toString();
        }

        @GET
        @Path("/insertorder/{order}")
        @Produces(MediaType.TEXT_PLAIN)
        public String insertorder(@PathParam("order") String orderStr){
            InsertOrderDao insertOrderDao=new InsertOrderDao();
            String status=insertOrderDao.insertOrder(orderStr);
            return status;
        }
}
