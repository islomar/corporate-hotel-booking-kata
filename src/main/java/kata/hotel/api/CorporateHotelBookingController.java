package kata.hotel.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CorporateHotelBookingController {

    private final Map<String, Hotel> hotels = new ConcurrentHashMap<>();

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return new ArrayList<>(hotels.values());
    }

    @PostMapping("/hotels")
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel addHotel(@RequestBody Hotel hotelRequest) {
        String id = UUID.randomUUID().toString();
        Hotel hotel = new Hotel(id, hotelRequest.getName(), hotelRequest.getLocation());
        hotels.put(id, hotel);
        return hotel;
    }
}
