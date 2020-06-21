package com.kata.domain.booking;

import java.time.LocalDate;

public final class BookingDatesRange {
    public BookingDatesRange(LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
        validate(checkIn, checkOut);
    }

    private void validate(LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
        if (checkOutIsNotAtLeastOneDayAfterCheckin(checkIn, checkOut)) {
            throw new InvalidDateRangeException();
        }
    }

    private boolean checkOutIsNotAtLeastOneDayAfterCheckin(LocalDate checkIn, LocalDate checkOut) {
        return !checkOut.isAfter(checkIn);
    }
}
