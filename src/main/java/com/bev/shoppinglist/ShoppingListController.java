package com.bev.shoppinglist;

import com.bev.shoppinglist.model.ShoppingItem;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping("/notifyFamily")
    @ResponseBody
    public ResponseEntity notifyFamily(@RequestBody Map<String, Object> request) {
        shoppingListService.notifyFamily(Optional.ofNullable((String) request.get("message")));
        return new ResponseEntity(Void.class, HttpStatus.OK);
    }

    @RequestMapping(path = "/sms", method = RequestMethod.POST, produces = {MediaType.TEXT_XML_VALUE}, consumes =
            MediaType.ALL_VALUE)
    @ResponseBody
    public String receiveSMSFromTwilio(@RequestBody String request) {
        log.debug(request);
        shoppingListService.addShoppingItem(Optional.of(new ShoppingItem(request.substring(request.indexOf("&Body")+6,
                request.indexOf(
                "&FromCountry")))));
        Body body = new Body
                .Builder("Your item has been added to the shopping list!")
                .build();
        Message sms = new Message
                .Builder()
                .body(body)
                .build();
        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();
        return twiml.toXml();
    }
}
