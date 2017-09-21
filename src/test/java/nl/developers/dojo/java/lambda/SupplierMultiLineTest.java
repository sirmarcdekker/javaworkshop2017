package nl.developers.dojo.java.lambda;

import static nl.developers.dojo.java.model.Fixtures.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.Fixtures.GroupFactory.aGroup;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.function.Supplier;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Group;
import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class SupplierMultiLineTest {

    @Test
    public void singleGuestTest() {
        String name = "Dojo group";
        String contact = "Myself";
        Exhibit location = aExhibit().build();
        Group group = aGroup().withName(name)
                              .withContact(contact)
                              .withTourLevel(10)
                              .withCurrentlyAt(location)
                              .build();

        Supplier<Guest> groupMemberCreator = SupplierBasics.createGroupGuestSupplier(group);

        assertThat(groupMemberCreator, notNullValue());
        Guest guest01 = groupMemberCreator.get();
        assertThat(guest01, notNullValue());
        assertThat(guest01.getName().isPresent(), equalTo(false));
        assertThat(guest01.getTourLevel().isPresent(), equalTo(true));
        assertThat(guest01.getTourLevel().get(), equalTo(10));
        assertThat(guest01.getCurrentlyAt().isPresent(), equalTo(true));
        assertThat(guest01.getCurrentlyAt().get(), equalTo(location));
        assertThat(group.getGroupMembers(), contains(guest01));
    }

    @Test
    public void doubleGuestTest() {
        String name = "Dojo group";
        String contact = "Myself";
        Exhibit location = aExhibit().build();
        Group group = aGroup().withName(name)
                              .withContact(contact)
                              .withTourLevel(10)
                              .withCurrentlyAt(location)
                              .build();

        Supplier<Guest> groupMemberCreator = SupplierBasics.createGroupGuestSupplier(group);

        assertThat(groupMemberCreator, notNullValue());
        Guest guest01 = groupMemberCreator.get();
        assertThat(guest01, notNullValue());
        assertThat(guest01.getName().isPresent(), equalTo(false));
        assertThat(guest01.getTourLevel().isPresent(), equalTo(true));
        assertThat(guest01.getTourLevel().get(), equalTo(10));
        assertThat(guest01.getCurrentlyAt().isPresent(), equalTo(true));
        assertThat(guest01.getCurrentlyAt().get(), equalTo(location));
        Guest guest02 = groupMemberCreator.get();
        assertThat(guest02, notNullValue());
        assertThat(guest02.getName().isPresent(), equalTo(false));
        assertThat(guest02.getTourLevel().isPresent(), equalTo(true));
        assertThat(guest02.getTourLevel().get(), equalTo(10));
        assertThat(guest02.getCurrentlyAt().isPresent(), equalTo(true));
        assertThat(guest02.getCurrentlyAt().get(), equalTo(location));

        assertThat(guest01.getVisitorNumber(), not(guest02.getVisitorNumber()));
        assertThat(group.getGroupMembers(), hasSize(2));
        assertThat(group.getGroupMembers(), containsInAnyOrder(guest01, guest02));
    }

    @Test
    public void largeGroupTest() {
        String name = "Dojo group";
        String contact = "Myself";
        Exhibit location = aExhibit().build();
        Group group = aGroup().withName(name)
                              .withContact(contact)
                              .withTourLevel(10)
                              .withCurrentlyAt(location)
                              .build();

        Supplier<Guest> groupMemberCreator = SupplierBasics.createGroupGuestSupplier(group);

        assertThat(groupMemberCreator, notNullValue());
        for(int i=0; i< 20; i++) {
            groupMemberCreator.get();
        }
        assertThat(group.getGroupMembers(), hasSize(20));
        assertThat(group.getGroupMembers().stream().map(Guest::getVisitorNumber).distinct().count(), equalTo(20L));
        assertThat(group.getGroupMembers().stream().map(g -> g.getTourLevel().get()).distinct().count(), equalTo(1L));
        assertThat(group.getGroupMembers().stream().map(g -> g.getCurrentlyAt().get()).distinct().count(), equalTo(1L));
    }
}
