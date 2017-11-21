package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.*;

public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

        /*Assert.assertEquals("Fido",appointment.getPetName());
        Assert.assertEquals("Fred",appointment.getOwner());
        Assert.assertEquals(TODAY_AT_2_PM,appointment.getAppointmentTime());*/

        /*Step 5*/

        Assert.assertThat(appointment.getPetName(),is(equalTo("Fido")));
        Assert.assertThat(appointment.getOwner(),is(equalTo("Fred")));
        Assert.assertThat(appointment.getAppointmentTime(),is(equalTo(TODAY_AT_2_PM)));
    }

    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        /*Assert.assertEquals(true,appointment.getReason().isPresent());
        Assert.assertEquals("He is sick",appointment.getReason().get());*/

        /*Step 5*/

        Assert.assertThat(appointment.getReason().isPresent(), notNullValue());
        Assert.assertThat(appointment.getReason().isPresent(), is(equalTo(true)));
        Assert.assertThat(appointment.getReason().get(), containsString("He is sick"));
    }

    @Test
    public void appointment_time_before_calculation() throws Exception {
        Appointment appointment = Appointment
                .forPetCalled("Fido")
                .ownedBy("Fred")
                .because("He is sick")
                .at(LocalDateTime
                .of(2017,11,20,19,0,0));

        Assert.assertThat(appointment.isBefore(LocalDateTime.now()),is(equalTo(true)));
        Assert.assertThat(appointment.isBefore(LocalDateTime.of(2017,11,20,18,59,59)),is(equalTo(false)));
        // this is interesting = the equal time case
        Assert.assertThat(appointment.isBefore(LocalDateTime.of(2017,11,20,19,0,0)),is(equalTo(false)));
    }

    @Test
    public void appointment_time_after_calculation() throws Exception {
        Appointment appointment = Appointment
                .forPetCalled("Fido")
                .ownedBy("Fred")
                .because("He is sick")
                .at(LocalDateTime
                        .of(2017,11,20,19,0,0));

        Assert.assertThat(appointment.isAfter(LocalDateTime.now()),is(equalTo(false)));
        Assert.assertThat(appointment.isAfter(LocalDateTime.of(2017,11,20,19,0,01)),is(equalTo(false)));
        // this is interesting = the equal time case
        Assert.assertThat(appointment.isAfter(LocalDateTime.of(2017,11,20,19,0,0)),is(equalTo(false)));
    }
}
