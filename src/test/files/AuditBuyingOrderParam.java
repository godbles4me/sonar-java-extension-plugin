package com.df.aizhuan.trade.api.params;

public class AuditBuyingOrderParam {

    private String buyingOrderNo;
    private String auditor;
    private Boolean pass;
    private String remark;

    public String getBuyingOrderNo() {
        return buyingOrderNo;
    }

    public void setBuyingOrderNo(String buyingOrderNo) {
        this.buyingOrderNo = buyingOrderNo;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
