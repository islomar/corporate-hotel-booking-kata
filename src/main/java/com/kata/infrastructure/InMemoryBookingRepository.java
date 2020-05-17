package com.kata.infrastructure;

import com.kata.domain.Booking;
import com.kata.domain.BookingId;
import com.kata.domain.BookingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class InMemoryBookingRepository implements BookingRepository {
	Map<BookingId, Booking> bookings;

	public InMemoryBookingRepository() {
		this.bookings = new HashMap<>();
	}

	@Override
	public Booking findById(BookingId bookingId) {
		return bookings.get(bookingId);
	}

	@Override
	public void save(Booking booking) {
		bookings.put(booking.getId(), booking);
	}

	public List<Booking> findAll() {
		return this.bookings.values().stream().collect(Collectors.toList());
	}
}
