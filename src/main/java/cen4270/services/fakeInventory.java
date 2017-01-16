package cen4270.services;
import cen4270.models.Item;

/**
 * Created by Caciano on 9/28/2016.
 */
public class fakeInventory implements InventoryInterface
{
    private Item item;

    public Item getItem(String itemID)
    {
        item = new Item("foo", "bar", 10, 5);
        if(itemID.equals("foo"))
            return item;

        return null;
    }
}
