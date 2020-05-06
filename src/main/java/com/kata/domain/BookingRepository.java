package com.kata.domain;

public interface BookingRepository {
	Booking findById(BookingId bookingId);

	void save(Booking booking);
}
