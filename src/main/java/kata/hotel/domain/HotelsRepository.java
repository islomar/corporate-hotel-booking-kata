/* (C)2025 */
package kata.hotel.domain;

import java.util.Map;

public interface HotelsRepository {
  Map<String, String> findAll();

  void save(String hotelId, String hotelName);
}
