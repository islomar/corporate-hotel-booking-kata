package com.kata.domain.hotel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Hotel {
    private final String hotelId;
    private final String hotelName;
    private Map<String, Set<String>> rooms;

    public Hotel(String hotelId, String hotelName) {

        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = new HashMap<>();
    }

    public boolean hasRoomType(String roomType) {
        return this.rooms.containsKey(roomType);
    }

    public void addRoom(String roomType, String roomNumber) {
        //TODO: refactor to use a better data structure
        Set<String> roomNumbers = this.rooms.get(roomType);
        if (roomNumbers == null) {
            roomNumbers = new HashSet<>();
        }
        roomNumbers.add(roomNumber);
        this.rooms.put(roomType, roomNumbers);
    }

    public String getHotelId() {
        return hotelId;
    }

    public Map<String, Set<String>> getRooms() {
        return this.rooms;
    }
}
