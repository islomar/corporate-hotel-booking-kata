package com.kata.domain;

import java.util.Optional;

public interface HotelRepository {
	Optional<Hotel> findById(String hotelId);

	void addHotel(String hotelId, String hotelName);
}
