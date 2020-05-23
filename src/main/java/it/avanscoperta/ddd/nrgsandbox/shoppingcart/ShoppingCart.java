package it.avanscoperta.ddd.nrgsandbox.shoppingcart;

import org.javamoney.moneta.Money;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<LineItem> lineItems = new ArrayList<>();
    Money subTotal = Money.of(0, "EUR");

    public static ShoppingCart createEmpty() {
        return new ShoppingCart();
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
        updateSubtotal();
    }

    private void updateSubtotal() {
        subTotal = Money.of(0, "EUR");
        lineItems.forEach((LineItem item) -> {
            subTotal = subTotal.add(item.getUnitPrice());
        } );
    }
}
