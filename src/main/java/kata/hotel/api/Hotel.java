package kata.hotel.api;

public class Hotel {
    private final String id;
    private final String name;

    public Hotel(String id, String name) {
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
