package billing;

import customer.PrivateCustomer;
import customer.Retailer;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BillingRunTest {

    @Test
    public void givenRetailer_whenHasProductsAndAdverts_thenCalculateBill() {

        // given
        Retailer retailer = new Retailer(2, List.of(Products.HUNDRED_IMAGES));

        // when
        BillingRun billingRun = new BillingRun();
        int bill = billingRun.generateBill(retailer);

        // then
        assertThat(bill).isEqualTo(110);
    }

    @Test
    public void givenPrivateCustomer_whenHasProductsAndAdverts_thenCalculateBill() {

        // given
        PrivateCustomer privateCustomer = new PrivateCustomer(2, List.of(Products.ADVERT_PROMOTION, Products.FINANCE_VALUATIONS));

        // when
        BillingRun billingRun = new BillingRun();
        int bill = billingRun.generateBill(privateCustomer);

        // then
        assertThat(bill).isEqualTo(60);
    }

}
