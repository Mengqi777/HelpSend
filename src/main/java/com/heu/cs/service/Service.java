package com.heu.cs.service;


import com.heu.cs.dao.ReceiveOrderDao;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.heu.cs.dao.CreateOrderDao;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by memgq on 2017/5/14.
 */
@Path("/")
public class Service {

    private String status="";

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

    /**
     * 往数据库插入订单信息，发布订单
     * @param orderInfoStr
     * @return
     */
    @POST
    @Path("/putorder/")
    @Produces(MediaType.TEXT_PLAIN)
    public String createOrderURL(@FormParam("orderinfo") String orderInfoStr){
        CreateOrderDao createOrderDao =new CreateOrderDao();
        status= createOrderDao.insertOrder(orderInfoStr);
        return status;
    }

    @POST
    @Path("/receiveorder")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveOrderURL(@FormParam("orderId") String orderId,
                               @FormParam("orderReceiverId") String orderReceiverId){
        ReceiveOrderDao receiveOrderDao=new ReceiveOrderDao();
        status=receiveOrderDao.receiveOrder(orderId,orderReceiverId);
        return status;
    }
}
