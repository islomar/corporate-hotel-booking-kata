/* (C)2025 */
package kata.hotel.use_cases;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kata.hotel.domain.HotelsRepository;

public class FindAllHotels {
  private final HotelsRepository hotelsRepository;

  public FindAllHotels(HotelsRepository hotelsRepository) {
    this.hotelsRepository = hotelsRepository;
  }

  public FindAllHotelsResponse execute() {
    Map<String, String> allHotels = this.hotelsRepository.findAll();

    List<HotelQueryResponse> allHotelsResponse =
        allHotels.entrySet().stream()
            .map(hotel -> new HotelQueryResponse(hotel.getKey(), hotel.getValue()))
            .collect(Collectors.toList());
    return new FindAllHotelsResponse(allHotelsResponse);
  }
}
