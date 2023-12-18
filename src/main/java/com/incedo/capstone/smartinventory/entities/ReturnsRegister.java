package com.incedo.capstone.smartinventory.entities;


import jakarta.persistence.*;

@Entity(name="returns_register")
public class ReturnsRegister {

    @Id
    private int returnid;
    private String ItemName;
    @Temporal(TemporalType.DATE)
    private String DeliveryDate;
    @Temporal(TemporalType.DATE)
    private String ReturnDate;
    private int Quatity;
    private String InvoiceNumber;
    private float BillValue;
    private String BillCheckedby;

    @ManyToOne(optional = false)
    @JoinColumn(name="godown_id")
    private Godowns godowns;

    public int getReturnid() {
        return returnid;
    }

    public void setReturnid(int returnid) {
        this.returnid = returnid;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public int getQuatity() {
        return Quatity;
    }

    public void setQuatity(int quatity) {
        Quatity = quatity;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public float getBillValue() {
        return BillValue;
    }

    public void setBillValue(float billValue) {
        BillValue = billValue;
    }

    public String getBillCheckedby() {
        return BillCheckedby;
    }

    public void setBillCheckedby(String billCheckedby) {
        BillCheckedby = billCheckedby;
    }

    public Godowns getGodowns() {
        return godowns;
    }

    public void setGodowns(Godowns godowns) {
        this.godowns = godowns;
    }

    @Override
    public String toString() {
        return "ReturnsRegister{" +
                "returnid=" + returnid +
                ", ItemName='" + ItemName + '\'' +
                ", DeliveryDate='" + DeliveryDate + '\'' +
                ", ReturnDate='" + ReturnDate + '\'' +
                ", Quatity=" + Quatity +
                ", InvoiceNumber='" + InvoiceNumber + '\'' +
                ", BillValue=" + BillValue +
                ", BillCheckedby='" + BillCheckedby + '\'' +
                ", godowns=" + godowns +
                '}';
    }
}
