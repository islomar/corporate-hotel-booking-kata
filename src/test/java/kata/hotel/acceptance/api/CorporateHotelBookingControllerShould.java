/* (C)2025 */
package kata.hotel.acceptance.api;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TestableCorporateHotelBookingController.class)
@ContextConfiguration(classes = TestableCorporateHotelBookingController.class)
// Needed because the package doesn't match exactly
public class CorporateHotelBookingControllerShould {

  @Autowired private MockMvc mockMvc;
  @Autowired private TestableCorporateHotelBookingController controller;

  @BeforeEach
  public void setUp() {
    controller.clearRepository();
  }

  @Test
  public void returnEmptyListOfHotels() throws Exception {
    mockMvc.perform(get("/hotels")).andExpect(status().isOk()).andExpect(content().string("[]"));
  }

  @Test
  public void addNewHotel() throws Exception {
    UUID anyHotelId = UUID.randomUUID();
    String anyHotelName = "Any hotel name";
    String hotelJson = "{\"id\":\"" + anyHotelId + "\",\"name\":\"" + anyHotelName + "\"}";

    mockMvc
        .perform(post("/hotels").contentType(MediaType.APPLICATION_JSON).content(hotelJson))
        .andExpect(status().isCreated());

    mockMvc
        .perform(get("/hotels"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(anyHotelId.toString()))
        .andExpect(jsonPath("$[0].name").value(anyHotelName));
  }

  @Test
  public void doNotCreateTwoHotelsWithSameName() throws Exception {
    UUID anyHotelId1 = UUID.randomUUID();
    UUID anyHotelId2 = UUID.randomUUID();
    String anyHotelName = "Any hotel name";
    String hotelJson1 = "{\"id\":\"" + anyHotelId1 + "\",\"name\":\"" + anyHotelName + "\"}";
    String hotelJson2 = "{\"id\":\"" + anyHotelId2 + "\",\"name\":\"" + anyHotelName + "\"}";

    mockMvc
        .perform(post("/hotels").contentType(MediaType.APPLICATION_JSON).content(hotelJson1))
        .andExpect(status().isCreated());

    mockMvc
        .perform(post("/hotels").contentType(MediaType.APPLICATION_JSON).content(hotelJson2))
        .andExpect(status().isConflict());
  }
}
