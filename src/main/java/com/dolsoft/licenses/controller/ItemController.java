package com.dolsoft.licenses.controller;

import com.dolsoft.licenses.model.Item;
import com.dolsoft.licenses.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(value="/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(@PathVariable("itemId") String itemId) {
        Item item = itemService.getItem(itemId);
        item.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).getItem(item.getItemId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).createItem(item)).withRel("createItem"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).updateItem(item)).withRel("updateItem"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemController.class).deleteItem(item.getItemId())).withRel("deleteItem"));
        return ResponseEntity.ok(item);
    }
    @PutMapping
    public ResponseEntity<String> updateItem(@RequestBody Item request) {
        return ResponseEntity.ok(itemService.updateItem(request));
    }
    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item request) {
        return ResponseEntity.ok(itemService.createItem(request));
    }
    @DeleteMapping(value="/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") String itemId) {
        return ResponseEntity.ok(itemService.deleteItem(itemId));
    }
}

