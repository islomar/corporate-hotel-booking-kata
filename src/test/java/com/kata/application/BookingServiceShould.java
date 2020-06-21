package com.kata.application;


import com.kata.domain.*;
import com.kata.infrastructure.InMemoryBookingRepository;
import com.kata.infrastructure.InMemoryCompanyRepository;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingServiceShould {

    private static final LocalDate TODAY = LocalDate.of(2019, 1, 1);
    private static final LocalDate TOMORROW = LocalDate.of(2019, 1, 2);
    private static final String ANY_HOTEL_ID = "anyHotelId";
    private static final String ANY_HOTEL_NAME = "anyHotelName";
    private static final String ANY_ROOM_NUMBER = "anyRoomNumber";
    private static final String ANY_ROOM_TYPE = "anyRoomType";
    private static final String ANY_EMPLOYEE_ID = "anyEmployeeId";
    private static final String ANY_COMPANY_ID = "anyCompanyId";
    private HotelService hotelService;
    private BookingService bookingService;
    private BookingRepository bookingRepository;
    private HotelRepository hotelRepository;

    @BeforeEach
    public void setUp() {
        CompanyService companyService = new CompanyService(new InMemoryCompanyRepository());
        companyService.addEmployee(ANY_COMPANY_ID, ANY_EMPLOYEE_ID);
        hotelRepository = new InMemoryHotelRepository();
        hotelService = new HotelService(hotelRepository);
        bookingRepository = new InMemoryBookingRepository();
        bookingService = new BookingService(bookingRepository, hotelRepository);
    }


    @Test
    public void book_a_room() throws InvalidDateRangeException, HotelNotFoundException, NonExistingRoomTypeException {
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);
        hotelService.setRoom(ANY_HOTEL_ID, ANY_ROOM_NUMBER, ANY_ROOM_TYPE);

        Booking booking = bookingService.book(ANY_EMPLOYEE_ID, ANY_HOTEL_ID, ANY_ROOM_TYPE, TODAY, TOMORROW);

        Booking foundBooking = bookingRepository.findById(booking.getId());
        assertThat(foundBooking, is(booking));
    }

    @Test
    public void not_proceed_with_the_booking_if_checkout_date_is_at_least_one_day_after_checkin_date() throws HotelNotFoundException {
        InMemoryBookingRepository bookingRepository = new InMemoryBookingRepository();
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);
        hotelService.setRoom(ANY_HOTEL_ID, ANY_ROOM_NUMBER, ANY_ROOM_TYPE);
        BookingService bookingService = new BookingService(bookingRepository, hotelRepository);

        assertThrows(InvalidDateRangeException.class, () -> bookingService.book(ANY_EMPLOYEE_ID, ANY_HOTEL_ID, ANY_ROOM_TYPE, TOMORROW, TODAY));
        assertThat(bookingRepository.findAll(), is(empty()));
    }

    @Test
    public void not_proceed_with_the_booking_if_hotel_does_not_exist() {
        InMemoryBookingRepository bookingRepository = new InMemoryBookingRepository();
        BookingService bookingService = new BookingService(bookingRepository, hotelRepository);

        assertThrows(HotelNotFoundException.class, () -> bookingService.book(ANY_EMPLOYEE_ID, "aNonExistingHotelId", ANY_ROOM_TYPE, TODAY, TOMORROW));
        assertThat("The booking should not have been done", bookingRepository.findAll(), is(empty()));
    }

    @Test
    public void not_proceed_with_the_booking_if_room_type_does_not_exist() throws HotelNotFoundException {
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);
        hotelService.setRoom(ANY_HOTEL_ID, ANY_ROOM_NUMBER, ANY_ROOM_TYPE);
        InMemoryBookingRepository bookingRepository = new InMemoryBookingRepository();
        BookingService bookingService = new BookingService(bookingRepository, hotelRepository);

        assertThrows(NonExistingRoomTypeException.class, () -> bookingService.book(ANY_EMPLOYEE_ID, ANY_HOTEL_ID, "nonExistingRoomType", TODAY, TOMORROW));
        assertThat("The booking should not have been done", bookingRepository.findAll(), is(empty()));
    }

}