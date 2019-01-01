package cn.itcast.purchasing.vo;

public class OrderVo {
    //采购单信息
    private OrderCustom orderCustom;
    //采购单审核信息
    private OrderAuditCustom orderAuditCustom;

    public OrderCustom getOrderCustom() {
        return orderCustom;
    }

    public void setOrderCustom(OrderCustom orderCustom) {
        this.orderCustom = orderCustom;
    }

    public OrderAuditCustom getOrderAuditCustom() {
        return orderAuditCustom;
    }

    public void setOrderAuditCustom(OrderAuditCustom orderAuditCustom) {
        this.orderAuditCustom = orderAuditCustom;
    }
}
