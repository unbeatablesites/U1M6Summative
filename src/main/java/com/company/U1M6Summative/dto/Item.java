package com.company.U1M6Summative.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private int id;

    @NotEmpty(message = "Name can't be empty")
    @Size(max = 50, message = "Can't be more than 50 characters long")
    private String name;

    @Size(max = 255, message = "Can't be more than 255 characters long")
    private String description;
    @NotNull(message = "Daily rate can't be null")
    @Digits(integer = 2, fraction = 2)
    private BigDecimal dailyRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                getName().equals(item.getName()) &&
                Objects.equals(getDescription(), item.getDescription()) &&
                getDailyRate().equals(item.getDailyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getDailyRate());
    }
}
