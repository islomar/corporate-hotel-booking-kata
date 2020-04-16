package com.kata;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookingServiceShould {

	@Test
	public void book_a_room() {
		BookingRepository bookingRepository = new InMemoryBookingRepository();
		BookingService bookingService = new BookingService(bookingRepository);

		Booking booking = bookingService.book("anyEmployeeId", "anyHotelId", "anyRoomType", new Date(), new Date());

		Booking foundBooking = bookingRepository.findById(booking.getId());
		assertThat(foundBooking.getId(), is(booking.getId()));

	}
}