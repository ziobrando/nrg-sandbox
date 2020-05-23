package it.avanscoperta.ddd.nrgsandbox.shoppingcart;

import org.javamoney.moneta.Money;

/**
 * LineItem is a potential Value Object in our Aggregate,
 * with a few tricks we can make it read only.
 */
public class LineItem {

    private final String description;
    private final Money unitPrice;
    private final String itemId;
    private final int quantity;

    public LineItem(String description, Money unitPrice, String itemId, int quantity) {
        this.description = description;
        this.unitPrice = unitPrice;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
