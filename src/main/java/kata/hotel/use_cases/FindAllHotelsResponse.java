/* (C)2025 */
package kata.hotel.use_cases;

import java.util.List;

public record FindAllHotelsResponse(List<HotelQueryResponse> allExistingHotels) {}
