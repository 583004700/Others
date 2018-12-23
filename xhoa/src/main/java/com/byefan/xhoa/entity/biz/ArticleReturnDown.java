package com.byefan.xhoa.entity.biz;

import com.byefan.xhoa.entity.media.MediaType;
import org.apache.ibatis.type.Alias;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_biz_article_return_down")
public class ArticleReturnDown implements Serializable {
    @Id
    private Integer id;

    private Integer orderId;

    private Integer mediaId;

    private String mediaName;

    private Integer supplierId;

    private String supplierName;

    private Integer mediaUserId;

    private String mediaUserName;

    private String brand;

    private Date issuedDate;

    private String title;

    private String link;

    private Double saleAmount;

    private Double incomeAmount;

    private Double taxes;

    private String priceColumn;

    private String priceType;

    private Double payAmount;

    private Double outgoAmount;

    private Date promiseDate;

    private Date incomeDate;

    private Double otherPay;

    private Double refundAmount;

    private String remarks;

    private Double commission;

    private Date commissionDate;

    private Integer outgoStates;

    private Integer commissionStates;

    private Integer invoiceStates;

    private Integer incomeStates;

    private Integer issueStates;
//    @Transient
//    private Media media;
    @Transient
    private MediaType mediaType;

    private Integer num;

    private String filePath;

    private Integer refundStates ;
    /**
     * 驳回时间
     */
    private Date returnDownDate;
    /**
     * 驳回人
     */
    private Integer returnDownUser;

    public Integer getRefundStates() {
        return refundStates;
    }

    public void setRefundStates(Integer refundStates) {
        this.refundStates = refundStates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public Integer getMediaUserId() {
        return mediaUserId;
    }

    public void setMediaUserId(Integer mediaUserId) {
        this.mediaUserId = mediaUserId;
    }

    public String getMediaUserName() {
        return mediaUserName;
    }

    public void setMediaUserName(String mediaUserName) {
        this.mediaUserName = mediaUserName == null ? null : mediaUserName.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public String getPriceColumn() {
        return priceColumn;
    }

    public void setPriceColumn(String priceColumn) {
        this.priceColumn = priceColumn == null ? null : priceColumn.trim();
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType == null ? null : priceType.trim();
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getOutgoAmount() {
        return outgoAmount;
    }

    public void setOutgoAmount(Double outgoAmount) {
        this.outgoAmount = outgoAmount;
    }

    public Date getPromiseDate() {
        return promiseDate;
    }

    public void setPromiseDate(Date promiseDate) {
        this.promiseDate = promiseDate;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Double getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(Double otherPay) {
        this.otherPay = otherPay;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Date getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(Date commissionDate) {
        this.commissionDate = commissionDate;
    }

    public Integer getOutgoStates() {
        return outgoStates;
    }

    public void setOutgoStates(Integer outgoStates) {
        this.outgoStates = outgoStates;
    }

    public Integer getCommissionStates() {
        return commissionStates;
    }

    public void setCommissionStates(Integer commissionStates) {
        this.commissionStates = commissionStates;
    }

    public Integer getInvoiceStates() {
        return invoiceStates;
    }

    public void setInvoiceStates(Integer invoiceStates) {
        this.invoiceStates = invoiceStates;
    }

    public Integer getIncomeStates() {
        return incomeStates;
    }

    public void setIncomeStates(Integer incomeStates) {
        this.incomeStates = incomeStates;
    }

    public Integer getIssueStates() {
        return issueStates;
    }

    public void setIssueStates(Integer issueStates) {
        this.issueStates = issueStates;
    }

    //
//    public Media getMedia() {
//        return media;
//    }
//
//    public void setMedia(Media media) {
//        this.media = media;
//    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getReturnDownDate() {
        return returnDownDate;
    }

    public void setReturnDownDate(Date returnDownDate) {
        this.returnDownDate = returnDownDate;
    }

    public Integer getReturnDownUser() {
        return returnDownUser;
    }

    public void setReturnDownUser(Integer returnDownUser) {
        this.returnDownUser = returnDownUser;
    }
}