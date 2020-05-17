package com.kata.domain;

import java.util.List;

public interface BookingRepository {
	Booking findById(BookingId bookingId);

	void save(Booking booking);

	List<Booking> findAll();
}
