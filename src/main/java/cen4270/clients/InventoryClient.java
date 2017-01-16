package cen4270.clients;

import cen4270.models.Item;
import cen4270.services.InventoryInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * This service is used to retrieve items from the store's inventory
 */
public class InventoryClient implements InventoryInterface{
    /**
     * The following map is used to simulate a database. A real implementation would
     * establish a connection to a database, like MySQL.
     */
    private Map<String, Item> database;

    public InventoryClient() {
        database = new HashMap<String, Item>();

        Item item1 = new Item("1", "Book", 5, 1);
        Item item2 = new Item("2", "Movie", 10, 2);

        database.put(item1.getID(), item1);
        database.put(item2.getID(), item2);
    }

    /**
     * Retrieves an item from the inventory
     * @param itemID The ID of the item
     * @return The item or null, if the item is not found
     */
    public Item getItem(String itemID) {
        System.out.println("Getting item from inventory " + itemID + "...");

        Item item = null;
        try {
            // The following sleep is used to simulate the time taken to retrieve an
            // item from the database. A real implementation would use a connection
            // to a database, but this should be enough for the purpose of this
            // assignment
            Thread.sleep(1000);
            item = database.get(itemID);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("... Retuning item: " + item);

        return item;
    }
}
