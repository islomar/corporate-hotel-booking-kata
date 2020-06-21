package com.kata.infrastructure;

import com.kata.domain.hotel.Hotel;
import com.kata.domain.hotel.HotelRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryHotelRepository implements HotelRepository {
    private Map<String, Hotel> hotels;

    public InMemoryHotelRepository() {
        this.hotels = new HashMap<>();
    }

    @Override
    public Optional<Hotel> findById(String hotelId) {
        return Optional.ofNullable(this.hotels.get(hotelId));
//		if (hotelId.equalsIgnoreCase("anyHotelId")) {
//			return Optional.of(new Hotel());
//		}
//		return Optional.empty();
    }

    @Override
    public void addHotel(String hotelId, String hotelName) {
        this.hotels.put(hotelId, new Hotel(hotelId, hotelName));
    }

    @Override
    public void save(Hotel hotel) {
        this.hotels.put(hotel.getHotelId(), hotel);
    }
}
