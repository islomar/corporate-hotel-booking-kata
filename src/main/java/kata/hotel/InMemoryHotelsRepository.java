/* (C)2025 */
package kata.hotel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kata.hotel.domain.Hotel;
import kata.hotel.domain.HotelId;
import kata.hotel.domain.HotelsRepository;

public class InMemoryHotelsRepository implements HotelsRepository {
  private final Map<HotelId, Hotel> hotels = new ConcurrentHashMap<>();

  @Override
  public List<Hotel> findAll() {
    return this.hotels.values().stream().toList();
  }

  @Override
  public Hotel findHotelById(HotelId hotelId) {
    return null;
  }

  @Override
  public void save(Hotel hotel) {
    hotels.put(hotel.id(), hotel);
  }

  @Override
  public boolean existsByName(String name) {
    return hotels.values().stream().anyMatch(hotel -> hotel.name().equals(name));
  }

  @Override
  public void clear() {
    hotels.clear();
  }
}
