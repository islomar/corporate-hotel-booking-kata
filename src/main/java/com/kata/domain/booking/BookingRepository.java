package com.kata.domain.booking;

public interface BookingRepository {
    Booking findById(BookingId bookingId);

    void save(Booking booking);
}
