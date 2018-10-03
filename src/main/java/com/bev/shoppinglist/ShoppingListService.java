package com.bev.shoppinglist;

import com.bev.shoppinglist.model.ShoppingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class ShoppingListService {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListService.class);

    private final Set<ShoppingItem> shoppingList = new HashSet<>();
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACd6489b7fcf8f81ad194583ad2d22215a";
    public static final String AUTH_TOKEN = "f4788ad61988fa74d17cbf9ed247c8b6";

    @PostConstruct
    public void init() {
        log.info("Adding sample shopping itmems.");

        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Coffee", 1));
        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Milk", 1));
        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Sugar", 1));
    }

    /**
     * Return the shopping list for the family.
     *
     * @return
     */
    public Set<ShoppingItem> getShoppingList() {
        return shoppingList;
    }

    /**
     * Adds an items to the shopping list.
     *
     * @param item
     */
    public void addShoppingItem(Optional<ShoppingItem> item) {
        if (item.isPresent()) {
            this.shoppingList.add(item.get());
        }
    }

    /**
     * Removes an item by name from the shopping list.
     *
     * @param itemName
     */
    public void removeItemByName(Optional<String> itemName) {
        if (itemName.isPresent()) {
            this.shoppingList.remove(new ShoppingItem(itemName.get()));
        }
    }

    /**
     * Notifies family that you are at a store and if they want anything.
     */
    public void notifyFamily(Optional<String> message) {
        if (message.isPresent()) {
            log.debug(message.get());
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message smsMessage = Message
                    .creator(new PhoneNumber("+18479625894"), new PhoneNumber("+12243103355"),
                            message.get()).create();

            log.debug(smsMessage.getSid());
        }
    }
}
