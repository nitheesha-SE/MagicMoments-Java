package com.bev.shoppinglist;

import com.bev.shoppinglist.model.ShoppingItem;
import com.bev.shoppinglist.model.walmart.WalmartSearchResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListService.class);

    private final Set<ShoppingItem> shoppingList = new HashSet<>();
    private final Set<ShoppingItem> recentlyAddedItemsList = new HashSet<>();
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACd6489b7fcf8f81ad194583ad2d22215a";
    public static final String AUTH_TOKEN = "f4788ad61988fa74d17cbf9ed247c8b6";
    public static final RestTemplate restTemplate = new RestTemplate();


    @PostConstruct
    public void init() {
        log.info("Adding sample shopping itmems.");

        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Coffee", 1, "Charlie"));
        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Milk", 1, "Charlie"));
        this.shoppingList.add(new ShoppingItem(UUID.randomUUID().toString(), "Sugar", 1, "Addison"));

        this.recentlyAddedItemsList.add(new ShoppingItem(UUID.randomUUID().toString(), "Coffee", 1, "Charlie"));
        this.recentlyAddedItemsList.add(new ShoppingItem(UUID.randomUUID().toString(), "Milk", 1, "Charlie"));
        this.recentlyAddedItemsList.add(new ShoppingItem(UUID.randomUUID().toString(), "Sugar", 1, "Addison"));
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
     * Return recently added items.
     *
     * @return
     */
    public Set<ShoppingItem> getRecentlyAddedItems(Optional<String> query) {
        if (query.isPresent()) {
            return recentlyAddedItemsList.stream()
                    .filter(line -> line.getText().contains(query.get()))
                    .collect(Collectors.toSet());
        } else {
            return recentlyAddedItemsList;
        }
    }

    /**
     * Searches the walmart api to see if the items are available nearby.
     * @param query
     * @return
     */
    public WalmartSearchResponse getNearbyItems(Optional<String> query) {
        if (query.isPresent()) {
            final String walmartAPIURL = "http://api.walmartlabs.com/v1/search?query="+query.get()+"&format=json&facet=on&facet" +
                    ".filter=offerType%3AONLINE_AND_STORE&apiKey=kfr3z4kp7bm4g5bcqetxqrnb";

            WalmartSearchResponse response = restTemplate.getForObject(walmartAPIURL, WalmartSearchResponse.class);

            return response;
        } else {
            return new WalmartSearchResponse();
        }
    }



    /**
     * Adds an items to the shopping list.
     *
     * @param item
     */
    public void addShoppingItem(Optional<ShoppingItem> item) {
        if (item.isPresent()) {
            if(StringUtils.isEmpty(item.get().getKey())){
                item.get().setKey(UUID.randomUUID().toString());
            }
            this.shoppingList.add(item.get());
            this.recentlyAddedItemsList.add(item.get());
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
