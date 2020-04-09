package com.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceShould {

	@Mock
	HotelRepository hotelRepository;

	@Mock
	RoomRepository roomRepository;

	@InjectMocks
	HotelService hotelService;

	@Test
	public void add_a_hotel() {
		hotelService.addHotel("hotelId", "hotelName");

		verify(hotelRepository, times(1)).addHotel("hotelId", "hotelName");
	}

	@Test
	public void set_a_room() {
		hotelService.setRoom("hotelId", "42", "roomType");

		verify(roomRepository, times(1)).addRoom("hotelId", "42", "roomType");

	}
}