package customer;

import billing.Products;

import java.util.List;

public abstract class Customer {

    private final int adverts;
    private final List<Products> products;

    Customer(int adverts, List<Products> products) {
        this.adverts = adverts;
        this.products = products;
    }

    public int getAdverts() {
        return adverts;
    }

    public int getProducts() {
        return products.size();
    }

    public int getPriceForProducts() {
        return 10;
    }

    public abstract int getPriceForAdverts();
}

