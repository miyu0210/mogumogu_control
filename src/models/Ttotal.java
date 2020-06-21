package models;

public class Ttotal {

    private String receipt_date;
    private Integer totalamount;
    private Integer id;
    private String payment;
    
    public Ttotal(String receipt_date,  Integer totalamount, Integer id, String payment) {
        this.receipt_date = receipt_date;
        this.totalamount = totalamount;
        this.id = id;
        this.payment = payment;
    }
    
    public String getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(String receipt_date) {
        this.receipt_date = receipt_date;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    

}
