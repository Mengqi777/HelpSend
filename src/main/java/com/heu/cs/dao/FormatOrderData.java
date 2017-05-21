package com.heu.cs.dao;

import com.google.gson.JsonObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by memgq on 2017/5/21.
 */
public class FormatOrderData {
    private String[] prop1={"orderId","orderOwnerId", "orderReceiverId", "sender","receiver",
            "senderTel", "receiverTel","goodsName","putOrderTime","sendTime","receiveTime",
            "receiveOrderTime", "deliveryTime", "remark","enclosurePath","status"};
    private String[] prop2={"startLocation","endLocation",};
    public JsonObject  format(JsonObject obj){
        for(String s:prop1){
            if (obj.has(s)){

            }else {
                obj.addProperty(s,"");
            }
        }
        for(String s:prop2){
            if (obj.has(s)){

            }else {
                JsonObject object=new JsonObject();
                object.addProperty( "description","");
                object.addProperty( "latitude","");
                object.addProperty( "longitude","");
                obj.add(s,object);
            }
        }
        return obj;
    }
}
