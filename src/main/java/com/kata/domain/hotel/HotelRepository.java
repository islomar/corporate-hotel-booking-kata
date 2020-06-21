package com.kata.domain.hotel;

import java.util.Optional;

public interface HotelRepository {
    Optional<Hotel> findById(String hotelId);

    void addHotel(String hotelId, String hotelName);

    void save(Hotel hotel);
}