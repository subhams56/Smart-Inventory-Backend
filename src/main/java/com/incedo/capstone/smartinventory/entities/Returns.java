package com.incedo.capstone.smartinventory.entities;


import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

    @Entity
    public class Returns {

        @Id
        private int returnid;

        public int getReturnid() {
            return returnid;
        }

        public void setReturnid(int returnid) {
            this.returnid = returnid;
        }

        @Column
        private int Godownid;

        @Column
        private String ItemName;

        @Column
        @Temporal(TemporalType.DATE)
        private String DeliveryDate;

        @Column
        @Temporal(TemporalType.DATE)
        private String ReturnDate;

        @Column
        private int Quatity;

        @Column
        private String InvoiceNumber;

        @Column
        private float BillValue;

        @Column
        private String BillCheckedby;

        public int getGodownid() {
            return Godownid;
        }
        public void setGodownid(int godownid) {
            Godownid = godownid;
        }
        public String getItemName() {
            return ItemName;
        }
        public void setItemName(String itemName) {
            ItemName = itemName;
        }
        public String getDeliveryDate() {
            return DeliveryDate;
        }
        public void setDeliveryDate(String deliveryDate) {
            DeliveryDate = deliveryDate;
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
        @Override
        public String toString() {
            return "Returns [Godownid=" + Godownid + ", ItemName=" + ItemName + ", DeliveryDate=" + DeliveryDate
                    + ", ReturnDate=" + ReturnDate + ", Quatity=" + Quatity + ", InvoiceNumber=" + InvoiceNumber
                    + ", BillValue=" + BillValue + ", BillCheckedby=" + BillCheckedby + "]";
        }
}
