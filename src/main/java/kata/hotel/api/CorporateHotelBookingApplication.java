/* (C)2025 */
package kata.hotel.api;

import kata.hotel.InMemoryHotelsRepository;
import kata.hotel.domain.HotelsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CorporateHotelBookingApplication {
  public static void main(String[] args) {
    SpringApplication.run(CorporateHotelBookingApplication.class, args);
  }

  @Bean
  public HotelsRepository hotelsRepository() {
    return new InMemoryHotelsRepository();
  }
}
