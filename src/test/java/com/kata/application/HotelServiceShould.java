package com.kata.application;

import com.kata.domain.Hotel;
import com.kata.domain.HotelNotFoundException;
import com.kata.domain.HotelRepository;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HotelServiceShould {

	@Test
	public void create_a_new_hotel() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());

		hotelService.addHotel("anyHotelId", "anyHotelName");
	}

	@Test
	public void set_a_room() throws HotelNotFoundException {
		HotelRepository hotelRepository = new InMemoryHotelRepository();
		HotelService hotelService = new HotelService(hotelRepository);
		hotelService.addHotel("anyHotelId", "anyHotelName");

		hotelService.setRoom("anyHotelId", "anyRoomNumber", "anyRoomType");

		Hotel hotel = hotelRepository.findById("anyHotelId").get();
		Set<String> roomNumbers = hotel.getRooms().get("anyRoomType");
		assertThat(roomNumbers, hasItem("anyRoomNumber"));
	}

	@Test
	public void throw_an_exception_when_hotel_already_exists() throws HotelNotFoundException {
		HotelService hotelService = new HotelService(new InMemoryHotelRepository());
		hotelService.addHotel("anyHotelId", "anyHotelName");

		assertThrows(HotelNotFoundException.class, () -> hotelService.addHotel("anyHotelId", "anyHotelName"));
	}

}