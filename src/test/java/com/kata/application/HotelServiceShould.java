package com.kata.application;

import com.kata.domain.Hotel;
import com.kata.domain.HotelNotFoundException;
import com.kata.domain.HotelRepository;
import com.kata.infrastructure.InMemoryHotelRepository;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.kata.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HotelServiceShould {

    @Test
    public void create_a_new_hotel() throws HotelNotFoundException {
        HotelService hotelService = new HotelService(new InMemoryHotelRepository());

        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);
    }

    @Test
    public void throw_an_exception_when_hotel_already_exists() throws HotelNotFoundException {
        HotelService hotelService = new HotelService(new InMemoryHotelRepository());
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);

        assertThrows(HotelNotFoundException.class, () -> hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME));
    }

    @Test
    public void set_a_room() throws HotelNotFoundException {
        HotelRepository hotelRepository = new InMemoryHotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);

        hotelService.setRoom(ANY_HOTEL_ID, ANY_ROOM_NUMBER, ANY_ROOM_TYPE);

        Hotel hotel = hotelRepository.findById(ANY_HOTEL_ID).get();
        Set<String> roomNumbers = hotel.getRooms().get(ANY_ROOM_TYPE);
        assertThat(roomNumbers, hasItem(ANY_ROOM_NUMBER));
    }

    @Test
    public void throw_an_exception_when_setting_a_room_for_a_non_existing_hotel() throws HotelNotFoundException {
        HotelService hotelService = new HotelService(new InMemoryHotelRepository());
        hotelService.addHotel(ANY_HOTEL_ID, ANY_HOTEL_NAME);

        assertThrows(HotelNotFoundException.class, () -> hotelService.setRoom("aNonExistingHotelId", ANY_ROOM_NUMBER, ANY_ROOM_TYPE));
    }

}