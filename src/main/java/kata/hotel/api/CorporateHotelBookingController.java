/* (C)2025 */
package kata.hotel.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorporateHotelBookingController {

  private final Map<String, AddHotelRequest> hotels = new ConcurrentHashMap<>();

  @GetMapping("/hotels")
  public List<AddHotelRequest> getHotels() {
    return new ArrayList<>(hotels.values());
  }

  @PostMapping("/hotels")
  @ResponseStatus(HttpStatus.CREATED)
  public AddHotelRequest addHotel(@RequestBody AddHotelRequest addHotelRequest) {
    String id = UUID.randomUUID().toString();
    AddHotelRequest hotel = new AddHotelRequest(id, addHotelRequest.getName());
    hotels.put(id, hotel);
    return hotel;
  }
}
