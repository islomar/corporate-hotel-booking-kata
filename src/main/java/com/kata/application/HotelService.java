package com.kata.application;

import com.kata.domain.Hotel;
import com.kata.domain.HotelNotFoundException;
import com.kata.domain.HotelRepository;

import java.util.Optional;

public final class HotelService {
	private final HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public void addHotel(String hotelId, String hotelName) throws HotelNotFoundException {
		//TODO do the same refactor than in BookingService
		Optional<Hotel> hotel = this.hotelRepository.findById(hotelId);
		if (hotel.isPresent()) {
			throw new HotelNotFoundException();
		}
		this.hotelRepository.addHotel(hotelId, hotelName);
	}

	public void setRoom(String hotelId, String roomNumber, String roomType) {

	}
}
