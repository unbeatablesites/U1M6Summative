package com.company.U1M6Summative.Controller;

import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
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
    public ItemViewModel createItem(@RequestBody @Valid ItemViewModel itemViewModel){
        return serviceLayer.saveItem(itemViewModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ItemViewModel getItem(@PathVariable("id") int itemId){
        return serviceLayer.findItem(itemId);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@RequestBody @Valid ItemViewModel item ,@PathVariable("id") int itemId){
        item.setItemId(itemId);
        serviceLayer.updateItem(item);
    }

    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemViewModel> getAllItems(){
        return serviceLayer.findAllItems();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("id") int itemId){
        serviceLayer.removeItem(itemId);
    }

}
