package customer;

import billing.Products;

import java.util.List;

public class Retailer extends Customer {

    public Retailer(int adverts, List<Products> products) {
        super(adverts, products);
    }

    public int getPriceForAdverts() {
        return 50;
    }
}
