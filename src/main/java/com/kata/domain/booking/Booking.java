package com.kata.domain.booking;

public final class Booking {
    private final BookingId id;

    public Booking(BookingId id) {
        this.id = id;
    }

    public BookingId getId() {
        return id;
    }
}
