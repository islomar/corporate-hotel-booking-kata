package com.kata.infrastructure;

import com.kata.domain.Hotel;
import com.kata.domain.HotelRepository;

import java.util.Optional;

public final class InMemoryHotelRepository implements HotelRepository {
	@Override
	public Optional<Hotel> findById(String hotelId) {
		if (hotelId.equalsIgnoreCase("anyHotelId")) {
			return Optional.of(new Hotel());
		}
		return Optional.empty();
	}
}
