package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import org.junit.Assert;

import static org.hamcrest.Matchers.*;

public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        //Assert.assertEquals(120, totalPrice);

        /* Step 1 */
        //Assert.assertThat(totalPrice, is(equalTo(120)));

        /* Step 2 */
        Assert.assertThat(totalPrice, greaterThan(119));
    }
}
