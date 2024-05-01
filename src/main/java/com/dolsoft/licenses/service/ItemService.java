package com.dolsoft.licenses.service;

import com.dolsoft.licenses.model.Item;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ItemService {
    public Item getItem(String itemId) {
        Item item = new Item();
        item.setId(new Random().nextInt(1000));
        item.setItemId(itemId);
        item.setName("Some Item");
        item.setSize("Some size");
        item.setWeight("Some weight");
        return item;
    }
    public String createItem(Item item) {
        String responseMessage = null;
        if(item != null) {
            responseMessage = String.format("This is the post and the object is: %s", item.toString());
        }
        return responseMessage;
    }
    public String updateItem(Item item) {
        String responseMessage = null;
        if (item != null) {
            responseMessage = String.format("This is the put and the object is: %s", item.toString());
        }
        return responseMessage;
    }
    public String deleteItem(String itemId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting item with id %s", itemId);
        return responseMessage;
    }
}

