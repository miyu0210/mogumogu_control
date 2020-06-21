package models;

public class MTotal {
    
    
    private String month;
    private Long sumM;
    
    public MTotal(String month,  Long sumM) {
        this.month = month;
        this.sumM = sumM;
    }

    public String getReceipt_date() {
        return month;
    }

    public void setReceipt_date(String month) {
        this.month = month;
    }

    public Long getSumM() {
        return sumM;
    }

    public void setSumM(Long sumM) {
        this.sumM = sumM;
    }

    
}