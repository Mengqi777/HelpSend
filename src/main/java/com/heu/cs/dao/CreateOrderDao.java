package com.heu.cs.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoCollection;
import com.heu.cs.conndb.ConnMongoDB;
import org.bson.Document;


/**
 * Created by memgq on 2017/5/17.
 */
public class CreateOrderDao {
    private String operateSuccess="1";
    private String operateFailure="0";
    public CreateOrderDao() {
    }

    /**
     *
     * @param orderStr json格式的字符串
     * @return 返回操作状态，成功或失败
     */
    public String insertOrder(String orderStr){

        try{
            /**
             * 先转成jsonObject ,然后格式化看有没有漏掉的字段，有的话加上
             */
            JsonObject obj = new JsonParser().parse(orderStr).getAsJsonObject();
            FormatOrderData formatOrderData=new FormatOrderData();
            obj=formatOrderData.format(obj);

            Gson gson = new Gson();
            orderStr=gson.toJson(obj);

            ConnMongoDB connMongoDB=new ConnMongoDB();
            MongoCollection collection=connMongoDB.getCollection("bbddb","normalorder");

            Document document = Document.parse(orderStr);
            collection.insertOne(document);
            connMongoDB.getMongoClient().close();
            return operateSuccess;
        }catch (Exception exception){
            exception.printStackTrace();
            return operateFailure;
        }
    }
}
