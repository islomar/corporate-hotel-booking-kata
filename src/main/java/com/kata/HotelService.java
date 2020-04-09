package com.kata;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomRepository roomRepository;

	public void addHotel(String hotelId, String hotelName) {
		hotelRepository.addHotel(hotelId, hotelName);
	}

	public void setRoom(String hotelId, String number, String roomType) {
		roomRepository.addRoom(hotelId, number, roomType);
	}
}