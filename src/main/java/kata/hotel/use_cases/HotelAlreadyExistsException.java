/* (C)2025 */
package kata.hotel.use_cases;

public class HotelAlreadyExistsException extends RuntimeException {
  public HotelAlreadyExistsException(String message) {
    super(message);
  }
}
