package com.heu.cs.pojo;

import com.google.gson.JsonObject;

import javax.validation.constraints.Null;

/**
 * Created by memgq on 2017/5/17.
 */
public class OrderPojo {
private String orderId="";
    private EndLocationPojo endLocation;
    private StartLocationPojo startLocation;
    private    String sender="";
    private    String receiver="";
    private   String senderTel="";
    private   String receiverTel="";
    private   String goodsName="";

    private    String remark="";

    private    String sendTime="";//期望配送员取物品时间
    private    String receiveTime="";//期望物品送达时间


    private   String putOrderTime="";//下单时间
    private   String receiveOrderTime="";//接单时间
    private  String deliveryTime="";//真正送达时间

    private String enclosurePath="";
    private  String status="";
    public EndLocationPojo getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(EndLocationPojo endLocation) {
        this.endLocation = endLocation;
    }

    public StartLocationPojo getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(StartLocationPojo startLocation) {
        this.startLocation = startLocation;
    }


    public String getPutOrderTime() {
        return putOrderTime;
    }

    public void setPutOrderTime(String putOrderTime) {
        this.putOrderTime = putOrderTime;
    }

    public String getReceiveOrderTime() {
        return receiveOrderTime;
    }

    public void setReceiveOrderTime(String receiveOrderTime) {
        this.receiveOrderTime = receiveOrderTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }




    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEnclosurePath() {
        return enclosurePath;
    }

    public void setEnclosurePath(String enclosurePath) {
        this.enclosurePath = enclosurePath;
    }
}
