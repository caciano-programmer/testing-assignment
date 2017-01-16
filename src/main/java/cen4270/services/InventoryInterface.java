package cen4270.services;
import cen4270.models.Item;

/**
 * Created by Caciano on 9/28/2016.
 */
public interface InventoryInterface
{
    public Item getItem(String itemID);
}
