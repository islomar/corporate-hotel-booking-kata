package com.kata.domain;

import com.kata.domain.booking.BookingDatesRange;
import com.kata.domain.booking.InvalidDateRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingDatesRangeShould {

    private static final LocalDate TOMORROW = LocalDate.of(2019, 1, 2);
    private static final LocalDate TODAY = LocalDate.of(2019, 1, 1);

    @ParameterizedTest(name = "\"{0}\" should be before {1}")
    @MethodSource("provideInvalidDateRanges")
    public void throw_exception_when_checkout_date_is_prior_to_the_checkin_date(LocalDate checkIn, LocalDate checkOut) {
        assertThrows(InvalidDateRangeException.class, () -> new BookingDatesRange(checkIn, checkOut));
    }

    private static Stream<Arguments> provideInvalidDateRanges() {
        return Stream.of(
                Arguments.of(TOMORROW, TODAY, "CheckIn is before Checkout"),
                Arguments.of(TODAY, TODAY, "CheckIn is the same day than Checkout")
        );
    }

    @Test
    public void create_an_object_if_checkOut_is_at_least_one_day_after_checkIn() {
        assertDoesNotThrow(() -> new BookingDatesRange(TODAY, TOMORROW));
    }
}