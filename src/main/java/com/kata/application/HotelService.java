package com.kata.application;

import com.kata.domain.HotelRepository;

public final class HotelService {
	private final HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	public void addHotel(String hotelId, String hotelName) {

	}

	public void setRoom(String hotelId, String roomNumber, String roomType) {

	}
}