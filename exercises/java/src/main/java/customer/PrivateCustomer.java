package customer;

import billing.Products;

import java.util.List;

public class PrivateCustomer extends Customer {

    public PrivateCustomer(int adverts, List<Products> products) {
        super(adverts, products);
    }

    public int getPriceForAdverts() {
        return 20;
    }
}
