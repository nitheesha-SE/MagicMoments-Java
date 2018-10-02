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

@Service
public class ShoppingListService {

    private static final Logger log = LoggerFactory.getLogger(ShoppingListService.class);

    final private Set<ShoppingItem> shoppingList = new HashSet<>();

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
}
