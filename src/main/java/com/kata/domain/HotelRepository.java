package com.kata.domain;

import java.util.Optional;

public interface HotelRepository {
	Optional<Hotel> findById(String hotelId);
}
