package com.kata.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingDatesRangeShould {

	private static final LocalDate TOMORROW = LocalDate.of(2019, 1, 2);
	private static final LocalDate TODAY = LocalDate.of(2019, 1, 1);

	@ParameterizedTest
	@MethodSource("provideInvalidDateRanges")
	public void throw_exception_when_checkout_date_is_prior_to_the_checkin_date(LocalDate checkIn, LocalDate checkOut) {
		assertThrows(InvalidDateRangeException.class, () -> {
			new BookingDatesRange(checkIn, checkOut);
		});
	}

	private static Stream<Arguments> provideInvalidDateRanges() {
		return Stream.of(
				Arguments.of(TOMORROW, TODAY, "ChekIn is before Checkout"),
				Arguments.of(TODAY, TODAY, "ChekIn is the same day than Checkout")
		);
	}
}