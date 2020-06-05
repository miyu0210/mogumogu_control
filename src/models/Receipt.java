package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "receipt")
@NamedQueries({
    @NamedQuery(
            name = "getAllReceipt",
            query = "SELECT r FROM Receipt AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getReceiptCount",
            query = "SELECT COUNT(r) FROM Receipt AS r"
            ),
    @NamedQuery(
            name = "getReceiptTotal",
            query = "SELECT SUM(r.totalamount) FROM Receipt r"
            ),
})
@Entity
public class Receipt {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "receipt_date", nullable = false)
    private Date receipt_date;
    
    @Column(name = "totalamount", nullable = false)
    private Integer totalamount;
    
    @Column(name = "payment", nullable = false)
    private String payment;
    
    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;
    
    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(Date receipt_date) {
        this.receipt_date = receipt_date;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }
    
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    
    
}