/* (C)2025 */
package kata.hotel.use_cases;

import java.util.List;
import java.util.stream.Collectors;
import kata.hotel.domain.Hotel;
import kata.hotel.domain.HotelsRepository;

public class FindAllHotels {
  private final HotelsRepository hotelsRepository;

  public FindAllHotels(HotelsRepository hotelsRepository) {
    this.hotelsRepository = hotelsRepository;
  }

  public FindAllHotelsResponse execute() {
    List<Hotel> allHotels = this.hotelsRepository.findAll();

    List<HotelQueryResponse> allHotelsResponse =
        allHotels.stream()
            .map(hotel -> new HotelQueryResponse(hotel.id().value(), hotel.name()))
            .collect(Collectors.toList());
    return new FindAllHotelsResponse(allHotelsResponse);
  }
}
