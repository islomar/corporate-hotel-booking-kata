package kata.hotel.acceptance.api;

import kata.hotel.api.CorporateHotelBookingController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@WebMvcTest(CorporateHotelBookingController.class)
@ContextConfiguration(classes = CorporateHotelBookingController.class) // Needed because the package doesn't match exactly
public class CorporateHotelBookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnEmptyListOfHotels() throws Exception {
        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void shouldAddNewHotel() throws Exception {
        String hotelJson = "{\"name\":\"Hilton\"}";

        mockMvc.perform(post("/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(hotelJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.name", is("Hilton")));

        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Hilton"));
    }

    @Disabled
    public void shouldGetHotelById() throws Exception {
        String hotelJson = "{\"name\":\"Marriott\",\"location\":\"New York\"}";

        MvcResult result = mockMvc.perform(post("/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(hotelJson))
                .andExpect(status().isCreated())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String hotelId = responseContent.split("\"id\":\"")[1].split("\"")[0];

        mockMvc.perform(get("/hotels/" + hotelId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(hotelId)))
                .andExpect(jsonPath("$.name", is("Marriott")))
                .andExpect(jsonPath("$.location", is("New York")));
    }
}
