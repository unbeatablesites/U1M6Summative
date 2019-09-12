package com.company.U1M6Summative.dto;

import jdk.vm.ci.meta.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private int id;
    private int customerId;
    private LocalDate orderDate;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private BigDecimal returnFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getReturnFee() {
        return returnFee;
    }

    public void setReturnFee(BigDecimal returnFee) {
        this.returnFee = returnFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getId() == invoice.getId() &&
                getCustomerId() == invoice.getCustomerId() &&
                getOrderDate().equals(invoice.getOrderDate()) &&
                getPickUpDate().equals(invoice.getPickUpDate()) &&
                getReturnDate().equals(invoice.getReturnDate()) &&
                getReturnFee().equals(invoice.getReturnFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getOrderDate(), getPickUpDate(), getReturnDate(), getReturnFee());
    }
}
