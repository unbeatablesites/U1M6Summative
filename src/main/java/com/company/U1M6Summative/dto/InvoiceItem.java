package com.company.U1M6Summative.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    @NotNull
    private int id;
    @NotNull
    private int invoiceId;
    @NotNull
    private int itemId;
    @NotNull
    private int quantity;
    @NotNull
    private BigDecimal unitRate;
    @NotNull
    private BigDecimal discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return getId() == that.getId() &&
                getInvoiceId() == that.getInvoiceId() &&
                getItemId() == that.getItemId() &&
                getQuantity() == that.getQuantity() &&
                getUnitRate().equals(that.getUnitRate()) &&
                getDiscount().equals(that.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInvoiceId(), getItemId(), getQuantity(), getUnitRate(), getDiscount());
    }
}
