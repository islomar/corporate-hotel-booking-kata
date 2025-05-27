package kata.hotel;

public class Hotel {
    private final String id;
    private final String name;
    private final String location;

    // Default constructor for JSON deserialization
    public Hotel() {
        this(null, null, null);
    }

    public Hotel(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
