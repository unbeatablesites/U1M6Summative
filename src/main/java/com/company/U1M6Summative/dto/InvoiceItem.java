package com.company.U1M6Summative.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    private int id;
    @NotNull(message = "Invoice id can't be null")
    private int invoiceId;
    @NotNull(message = "Item Id can't be null")
    private int itemId;
    @NotNull(message = "Quantity can't be null")
    private int quantity;
    @NotNull(message = "Unit rate can't be null")
    @Digits(integer = 2, fraction = 2, message = "Incorrect unit rate")
    private BigDecimal unitRate;
    @NotNull(message = "Discount cannot be null")
    @Digits(integer = 2, fraction = 2, message = "Invalid discount")
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

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", unitRate=" + unitRate +
                ", discount=" + discount +
                '}';
    }
}
