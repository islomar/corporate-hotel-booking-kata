package com.kata;

public interface BookingRepository {
	Booking findById(BookingId bookingId);

	void save(Booking booking);
}
