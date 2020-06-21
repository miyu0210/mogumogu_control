package sample.dto;

public class Keisan {

    private Integer m_total;
    private Integer d_total;
    private Integer m_budget;
    
    public Keisan(Integer m_total, Integer d_total, Integer m_budget) {
        this.m_total = m_total;
        this.d_total = d_total;
        this.m_budget = m_budget;
    }
    
    public Integer getM_budget() {
        return m_budget;
    }

    public void setM_budget(Integer m_budget) {
        this.m_budget = m_budget;
    }

    public Keisan() {}

    public Integer getM_total() {
        return m_total;
    }

    public void setM_total(Integer m_total) {
        this.m_total = m_total;
    }

    public Integer getD_total() {
        return d_total;
    }

    public void setD_total(Integer d_total) {
        this.d_total = d_total;
    }
}
