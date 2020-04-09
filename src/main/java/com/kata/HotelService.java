package com.kata;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	public void addHotel(String hotelId, String hotelName) {
		hotelRepository.addHotel(hotelId, hotelName);
	}
}