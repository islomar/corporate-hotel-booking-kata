package com.kata.application;

import com.kata.domain.Hotel;
import com.kata.domain.HotelNotFoundException;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HotelServiceShould {

	@Test
	public void create_a_new_hotel() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());

		hotelService.addHotel("anyHotelId", "anyHotelName");
	}

	@Test
	public void set_a_room() throws HotelNotFoundException {
		InMemoryHotelRepository hotelRepository = new InMemoryHotelRepository();
		HotelService hotelService = new HotelService(hotelRepository);
		hotelService.addHotel("anyHotelId", "anyHotelName");

		hotelService.setRoom("anyHotelId", "anyRoomNumber", "anyRoomType");

		Hotel hotel = hotelRepository.findById("anyHotelId").get();
		assertTrue(hotel.hasRoomType("anyRoomType"));
	}

	@Test
	public void throw_an_exception_when_hotel_already_exists() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());
		hotelService.addHotel("anyHotelId", "anyHotelName");

		assertThrows(HotelNotFoundException.class, () -> hotelService.addHotel("anyHotelId", "anyHotelName"));
	}

}