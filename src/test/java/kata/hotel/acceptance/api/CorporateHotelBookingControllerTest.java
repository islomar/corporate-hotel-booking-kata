/* (C)2025 */
package kata.hotel.acceptance.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kata.hotel.api.CorporateHotelBookingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CorporateHotelBookingController.class)
@ContextConfiguration(classes = CorporateHotelBookingController.class)
// Needed because the package doesn't match exactly
public class CorporateHotelBookingControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void shouldReturnEmptyListOfHotels() throws Exception {
    mockMvc.perform(get("/hotels")).andExpect(status().isOk()).andExpect(content().string("[]"));
  }

  @Test
  public void shouldAddNewHotel() throws Exception {
    String hotelJson = "{\"name\":\"Hilton\"}";

    mockMvc
        .perform(post("/hotels").contentType(MediaType.APPLICATION_JSON).content(hotelJson))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", notNullValue()))
        .andExpect(jsonPath("$.name", is("Hilton")));

    mockMvc
        .perform(get("/hotels"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name").value("Hilton"));
  }
}
