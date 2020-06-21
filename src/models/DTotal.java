package models;

public class DTotal {
    
    
    private String day;
    private Long sum;
    
    public DTotal(String day,  Long sum) {
        this.day = day;
        this.sum = sum;
    }

    public String getReceipt_date() {
        return day;
    }

    public void setReceipt_date(String day) {
        this.day = day;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

   

    
}