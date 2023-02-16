package com.market.domain;

public class PurchaseItem {
    private int productId;
    private int quiantity;
    private double total;
    private boolean active;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuiantity() {
        return quiantity;
    }

    public void setQuiantity(int quiantity) {
        this.quiantity = quiantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
