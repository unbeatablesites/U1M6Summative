package com.company.U1M6Summative.Controller;

import com.company.U1M6Summative.dto.Item;
import com.company.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemViewModelController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody @Valid Item itemViewModel){
        return serviceLayer.saveItem(itemViewModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Item getItem(@PathVariable("id") int itemId){
        return serviceLayer.findItem(itemId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@RequestBody @Valid Item item ,@PathVariable("id") int itemId){
        item.setId(itemId);
        serviceLayer.updateItem(item);
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllItems(){
        return serviceLayer.findAllItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("id") int itemId){
        serviceLayer.removeItem(itemId);
    }

}
