package dto;

public class PlaceDto {

    private Integer placeId;
    private String name;
    private String location;
    private Double price;
    private String description;
    private Integer categoryId;

    // Getters and Setters
    public Integer getPlaceId() { return placeId; }
    public void setPlaceId(Integer placeId) { this.placeId = placeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}
