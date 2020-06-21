package com.kata.application;

import com.kata.domain.booking.*;
import com.kata.domain.hotel.Hotel;
import com.kata.domain.hotel.HotelNotFoundException;
import com.kata.domain.hotel.HotelRepository;
import com.kata.domain.hotel.NonExistingRoomTypeException;

import java.time.LocalDate;

public final class BookingService {
    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;

    public BookingService(BookingRepository bookingRepository, HotelRepository hotelRepository) {

        this.bookingRepository = bookingRepository;
        this.hotelRepository = hotelRepository;
    }

    public Booking book(String employeeId, String hotelId, String roomType, LocalDate checkIn, LocalDate checkOut) throws InvalidDateRangeException, HotelNotFoundException, NonExistingRoomTypeException {
        Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        if (!hotel.hasRoomType(roomType)) {
            throw new NonExistingRoomTypeException();
        }
        new BookingDatesRange(checkIn, checkOut);
        Booking booking = new Booking(new BookingId());
        this.bookingRepository.save(booking);
        return booking;
    }
}
