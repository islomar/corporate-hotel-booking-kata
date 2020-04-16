package com.kata;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookingServiceShould {

	@Test
	public void book_a_room() {
		CompanyService companyService = new CompanyService(new InMemoryCompanyRepository());
		companyService.addEmployee("anyCompanyId", "anyEmployeeId");
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());
		hotelService.addHotel("anyHotelId", "anyHotelName");
		hotelService.setRoom("anyHotelId", "anyRoomNumber", "anyRoomType");
		BookingRepository bookingRepository = new InMemoryBookingRepository();
		BookingService bookingService = new BookingService(bookingRepository);
		Date checkIn = new Date();
		Date checkOut = new Date();

		Booking booking = bookingService.book("anyEmployeeId", "anyHotelId", "anyRoomType", checkIn, checkOut);

		Booking foundBooking = bookingRepository.findById(booking.getId());
		assertThat(foundBooking, is(booking));
	}

	@Test
	public void please_give_me_a_good_name() {

	}

	/**
	 * Test cases
	 * No availability in these dates for a room type
	 * Non existing employeeId
	 * Non existing hotelId
	 * Non existing roomType
	 */
}