/* (C)2025 */
package kata.hotel.domain;

import java.util.List;

public interface HotelsRepository {
  List<Hotel> findAll();

  Hotel findHotelById(HotelId hotelId);

  void save(Hotel hotel);
}
