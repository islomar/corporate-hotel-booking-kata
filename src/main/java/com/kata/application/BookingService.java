package com.kata.application;

import com.kata.domain.*;

import java.time.LocalDate;

public final class BookingService {
	private final BookingRepository bookingRepository;

	public BookingService(BookingRepository bookingRepository) {

		this.bookingRepository = bookingRepository;
	}

	public Booking book(String employeeId, String hotelId, String roomType, LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
		new BookingDatesRange(checkIn, checkOut);
		Booking booking = new Booking(new BookingId());
		this.bookingRepository.save(booking);
		return booking;
	}
}
