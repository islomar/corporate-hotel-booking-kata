/* (C)2025 */
package kata.hotel.use_cases;

import kata.hotel.domain.Hotel;
import kata.hotel.domain.HotelId;
import kata.hotel.domain.HotelsRepository;

public class AddHotel {

  private final HotelsRepository hotelsRepository;

  public AddHotel(HotelsRepository hotelsRepository) {
    this.hotelsRepository = hotelsRepository;
  }

  public void execute(String hotelId, String hotelName) {
    hotelsRepository.save(new Hotel(new HotelId(hotelId), hotelName));
  }
}
