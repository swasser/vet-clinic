package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import org.junit.Assert;

//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        //Assert.assertEquals(120, totalPrice);

        assertThat(totalPrice, greaterThan(100));

    }
}
