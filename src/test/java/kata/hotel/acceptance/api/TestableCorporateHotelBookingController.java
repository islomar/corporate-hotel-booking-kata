/* (C)2025 */
package kata.hotel.acceptance.api;

import kata.hotel.InMemoryHotelsRepository;
import kata.hotel.api.CorporateHotelBookingController;

/**
 * Extension of CorporateHotelBookingController that provides test-specific functionality. This
 * class should not be used in production code.
 */
public class TestableCorporateHotelBookingController extends CorporateHotelBookingController {
  private final InMemoryHotelsRepository repository;

  public TestableCorporateHotelBookingController() {
    super(new InMemoryHotelsRepository());
    this.repository = (InMemoryHotelsRepository) getHotelsRepository();
  }

  /** Clears all hotels from the repository. This method is intended for testing purposes only. */
  public void clearRepository() {
    this.repository.clear();
  }
}
