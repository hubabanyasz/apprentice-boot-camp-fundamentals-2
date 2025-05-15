package billing;

import customer.Customer;

public class BillingRun {
    public int generateBill(Customer customer) {
        return customer.getAdverts() * customer.getPriceForAdverts() + customer.getProducts() * customer.getPriceForProducts();
    }
}
