/* (C)2025 */
package kata.hotel.api;

public class AddHotelRequest {
  private final String id;
  private final String name;

  public AddHotelRequest(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
