package it.avanscoperta.ddd.nrgsandbox.shoppingcart;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestShoppingCart {

    @Test
    public void can_create_empty_cart() {
        ShoppingCart shoppingCart = ShoppingCart.createEmpty();
        assertNotNull(shoppingCart);
    }

    @Test
    public void subtotal_is_zero_on_creation() {
        ShoppingCart shoppingCart = ShoppingCart.createEmpty();
        assertEquals(shoppingCart.getSubTotal(), 0 );
    }

    @Test
    public void can_add_one_item() {
        ShoppingCart shoppingCart = ShoppingCart.createEmpty();
        String description = "The item description";
        Money unitPrice = Money.of(29.5, "EUR");
        String itemId = UUID.randomUUID().toString();
        LineItem lineItem = new LineItem(description, unitPrice, itemId, 1);

        shoppingCart.addItem(lineItem);

        assertEquals(shoppingCart.getSubTotal(), lineItem.getUnitPrice());
    }

}
