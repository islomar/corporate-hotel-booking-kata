package com.kata.application;

import com.kata.domain.HotelNotFoundException;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HotelServiceShould {

	@Test
	public void create_a_new_hotel() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());

		hotelService.addHotel("anyHotelId", "anyHotelName");
	}

	@Test
	public void throw_an_exception_when_hotel_already_exists() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());
		hotelService.addHotel("anyHotelId", "anyHotelName");

		assertThrows(HotelNotFoundException.class, () -> hotelService.addHotel("anyHotelId", "anyHotelName"));
	}

}