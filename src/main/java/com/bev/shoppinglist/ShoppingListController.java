package com.bev.shoppinglist;

import com.bev.shoppinglist.model.ShoppingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoppingList")
public class ShoppingListController {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListController.class);

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity getShoppingList() {
        Map body = new HashMap<String, Object>();
        body.put("data", this.shoppingListService.getShoppingList());

        return new ResponseEntity(body, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity addShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        shoppingListService.addShoppingItem(Optional.of(shoppingItem));
        return new ResponseEntity(Void.class, HttpStatus.OK);
    }

    @DeleteMapping("")
    @ResponseBody
    public ResponseEntity deleteShoppingItem(@RequestBody Optional<ShoppingItem> shoppingItem) {
        if (shoppingItem.isPresent()) {
            shoppingListService.removeItemByName(Optional.of(shoppingItem.get().getText()));
        }
        return new ResponseEntity(Void.class, HttpStatus.OK);
    }
}
