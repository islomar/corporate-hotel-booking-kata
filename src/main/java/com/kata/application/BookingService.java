package com.kata.application;

import com.kata.domain.Booking;
import com.kata.domain.BookingId;
import com.kata.domain.BookingRepository;
import com.kata.domain.InvalidDateRangeException;

import java.time.LocalDate;

public final class BookingService {
	private final BookingRepository bookingRepository;

	public BookingService(BookingRepository bookingRepository) {

		this.bookingRepository = bookingRepository;
	}

	public Booking book(String employeeId, String hotelId, String roomType, LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
		if (checkIn.isAfter(checkOut)) {
			throw new InvalidDateRangeException();
		}
		Booking booking = new Booking(new BookingId());
		this.bookingRepository.save(booking);
		return booking;
	}
}
