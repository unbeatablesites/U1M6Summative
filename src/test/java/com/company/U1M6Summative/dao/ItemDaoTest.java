package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDaoTest {

    @Test
    public void addItem() {
    }

    @Test
    public void getItem() {
    }

    @Test
    public void getAllItems() {
    }

    @Test
    public void updateItem() {
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void addGetUpdateDeleteItem(){

        Item item = new Item();
        item.setDailyRate();  //big decimal data type format???? wth
        item.setDescription("Movie");
        item.setName("Bad Boys");

    }


}