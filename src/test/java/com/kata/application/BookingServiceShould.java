package com.kata.application;


import com.kata.domain.Booking;
import com.kata.domain.BookingRepository;
import com.kata.domain.InvalidDateRangeException;
import com.kata.infrastructure.InMemoryBookingRepository;
import com.kata.infrastructure.InMemoryCompanyRepository;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingServiceShould {

	@Test
	public void book_a_room() throws InvalidDateRangeException {
		CompanyService companyService = new CompanyService(new InMemoryCompanyRepository());
		companyService.addEmployee("anyCompanyId", "anyEmployeeId");
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());
		hotelService.addHotel("anyHotelId", "anyHotelName");
		hotelService.setRoom("anyHotelId", "anyRoomNumber", "anyRoomType");
		BookingRepository bookingRepository = new InMemoryBookingRepository();
		BookingService bookingService = new BookingService(bookingRepository);
		LocalDate checkIn = LocalDate.of(2019, 1, 1);
		LocalDate checkOut = LocalDate.of(2019, 1, 2);

		Booking booking = bookingService.book("anyEmployeeId", "anyHotelId", "anyRoomType", checkIn, checkOut);

		Booking foundBooking = bookingRepository.findById(booking.getId());
		assertThat(foundBooking, is(booking));
	}

	@Test
	public void not_proceed_with_the_booking_if_checkout_date_is_at_least_one_day_after_checkin_date() {
		BookingRepository bookingRepository = new InMemoryBookingRepository();
		BookingService bookingService = new BookingService(bookingRepository);
		LocalDate checkIn = LocalDate.of(2019, 1, 2);
		LocalDate checkOut = LocalDate.of(2019, 1, 1);

		assertThrows(InvalidDateRangeException.class, () -> {
			bookingService.book("anyEmployeeId", "anyHotelId", "anyRoomType", checkIn, checkOut);
		});
		//check an exception is thrown
		//check the booking was not done
	}

	/**
	 * TEST CASES: which is the most simple failing test which would help us to move on?
	 * No availability in these dates for a room type
	 * Non existing employeeId
	 * Non existing hotelId
	 * Non existing roomType
	 */

	/**
	 * PENDING
	 * Fix package structure
	 * Create VO for all Ids
	 * Dates: use natural language, e.g. "today", "tomorrow".
	 */
}