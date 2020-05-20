package com.kata.application;

import com.kata.domain.*;

import java.time.LocalDate;
import java.util.Optional;

public final class BookingService {
	private final BookingRepository bookingRepository;
	private final HotelRepository hotelRepository;

	public BookingService(BookingRepository bookingRepository, HotelRepository hotelRepository) {

		this.bookingRepository = bookingRepository;
		this.hotelRepository = hotelRepository;
	}

	public Booking book(String employeeId, String hotelId, String roomType, LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException, HotelNotFoundException {
		Optional<Hotel> hotel = this.hotelRepository.findById(hotelId);
		hotel.orElseThrow(HotelNotFoundException::new);
		new BookingDatesRange(checkIn, checkOut);
		Booking booking = new Booking(new BookingId());
		this.bookingRepository.save(booking);
		return booking;
	}
}
