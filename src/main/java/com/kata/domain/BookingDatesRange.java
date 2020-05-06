package com.kata.domain;

import java.time.LocalDate;

public final class BookingDatesRange {
	public BookingDatesRange(LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
		validate(checkIn, checkOut);
	}

	private void validate(LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException {
		if (checkIn.isAfter(checkOut)) {
			throw new InvalidDateRangeException();
		}
	}
}
