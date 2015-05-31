
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0654437
 */



public class Order {

    private String customerId;
    private String customerName;
    private Date timeReceived;
    private Date timeProcessed;
    private Date timeFulfilled;
    private List<Purchase> listOfPurchases = new ArrayList<>();
    private String notes;

    public Order(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public void addPurchase(Purchase p) {
        listOfPurchases.add(p);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(Date timeReceived) {
        this.timeReceived = timeReceived;
    }

    public Date getTimeProcessed() {
        return timeProcessed;
    }

    public void setTimeProcessed(Date timeProcessed) {
        this.timeProcessed = timeProcessed;
    }

    public Date getTimeFulfilled() {
        return timeFulfilled;
    }

    public void setTimeFulfilled(Date timeFulfilled) {
        this.timeFulfilled = timeFulfilled;
    }

    public List<Purchase> getListOfPurchases() {
        return listOfPurchases;
    }

    public void setListOfPurchases(List<Purchase> listOfPurchases) {
        this.listOfPurchases = listOfPurchases;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("customerId", getCustomerId());
        json.put("customerName", getCustomerName());

        json.put("timeReceived", (getTimeReceived() != null) ? getTimeReceived().toString() : null);
        json.put("timeProcessed", (getTimeProcessed() != null) ? getTimeProcessed().toString() : null);
        json.put("timeFulfilled", (getTimeFulfilled() != null) ? getTimeFulfilled().toString() : null);
        JSONArray pList = new JSONArray();
        for (Purchase p : getListOfPurchases()) {
            JSONObject pObj = new JSONObject();
            pObj.put("productId", p.getProductId());
            pObj.put("quantity", p.getQuantity());
            pList.add(pObj);
        }
        json.put("purchases", pList);
        json.put("notes", getNotes());
        return json;
    }
}

