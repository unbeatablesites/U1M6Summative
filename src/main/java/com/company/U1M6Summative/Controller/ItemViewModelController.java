//package com.company.U1M6Summative.Controller;
//
//import com.company.U1M6Summative.dto.Item;
//import com.company.U1M6Summative.service.ServiceLayer;
//import com.company.U1M6Summative.viewmodel.ItemViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/item")
//public class ItemViewModelController {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//
//    @RequestMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Item createItem(@RequestBody @Valid Item itemViewModel){
//        return serviceLayer.saveItem(itemViewModel);
//    }
//
//    @RequestMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Item getItem(@PathVariable("id") int itemId){
//        return serviceLayer.findItem(itemId);
//    }
//
//    @RequestMapping("/update/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateItem(@RequestBody @Valid Item item ,@PathVariable("id") int itemId){
//        item.setItemId(itemId);
//        serviceLayer.updateItem(item);
//    }
//
//    @RequestMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Item> getAllItems(){
//        return serviceLayer.findAllItems();
//    }
//
//    @RequestMapping("/delete/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteItem(@PathVariable("id") int itemId){
//        serviceLayer.removeItem(itemId);
//    }
//
//}
