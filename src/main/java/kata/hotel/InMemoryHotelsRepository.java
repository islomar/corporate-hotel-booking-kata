/* (C)2025 */
package kata.hotel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kata.hotel.domain.Hotel;
import kata.hotel.domain.HotelsRepository;

public class InMemoryHotelsRepository implements HotelsRepository {
  private final Map<String, Hotel> hotels = new ConcurrentHashMap<>();

  @Override
  public List<Hotel> findAll() {
    return this.hotels.entrySet().stream()
        .map(hotel -> new Hotel(hotel.getKey(), hotel.getValue().name()))
        .toList();
  }

  @Override
  public Hotel findHotelById(String hotelId) {
    return null;
  }

  @Override
  public void save(Hotel hotel) {
    hotels.put(hotel.id(), hotel);
  }
}
