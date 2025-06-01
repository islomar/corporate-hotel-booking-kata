/* (C)2025 */
package kata.hotel.api;

import java.util.List;
import kata.hotel.InMemoryHotelsRepository;
import kata.hotel.domain.HotelsRepository;
import kata.hotel.use_cases.AddHotel;
import kata.hotel.use_cases.FindAllHotels;
import kata.hotel.use_cases.HotelAlreadyExistsException;
import kata.hotel.use_cases.HotelQueryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CorporateHotelBookingController {
  private final HotelsRepository hotelsRepository;

  public CorporateHotelBookingController() {
    this.hotelsRepository = new InMemoryHotelsRepository();
  }

  public HotelsRepository getHotelsRepository() {
    return hotelsRepository;
  }

  @GetMapping("/hotels")
  public List<HotelQueryResponse> getHotels() {
    FindAllHotels findAllHotels = new FindAllHotels(this.hotelsRepository);
    return findAllHotels.execute().allExistingHotels();
  }

  @PostMapping("/hotels")
  @ResponseStatus(HttpStatus.CREATED)
  public void addHotel(@RequestBody AddHotelRequest addHotelRequest) {
    AddHotel addHotel = new AddHotel(this.hotelsRepository);
    try {
      addHotel.execute(addHotelRequest.id(), addHotelRequest.name());
    } catch (HotelAlreadyExistsException e) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
    }
  }
}
