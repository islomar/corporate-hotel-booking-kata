/* (C)2025 */
package kata.hotel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kata.hotel.domain.HotelsRepository;

public class InMemoryHotelsRepository implements HotelsRepository {
  private final Map<String, String> hotels = new ConcurrentHashMap<>();

  @Override
  public Map<String, String> findAll() {
    return this.hotels;
  }

  @Override
  public void save(String hotelId, String hotelName) {
    hotels.put(hotelId, hotelName);
  }
}
