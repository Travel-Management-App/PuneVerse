package utils;

import dto.CategoryDto;
import dto.PlaceDto;
import entity.Category;
import entity.Place;

public class MapperUtil {

    public static Category toEntity(CategoryDto dto) {
        Category c = new Category();
        c.setCategoryId(dto.getCategoryId());
        c.setName(dto.getName());
        c.setDescription(dto.getDescription());
        return c;
    }

    public static CategoryDto toDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
 // --- For Place Mapping ---
    public static Place toEntity(PlaceDto dto) {
        Place p = new Place();
        p.setPlaceId(dto.getPlaceId());
        p.setName(dto.getName());
        p.setLocation(dto.getLocation());
        p.setPrice(dto.getPrice());
        p.setDescription(dto.getDescription());
        return p;
    }

    public static PlaceDto toDto(Place entity) {
        PlaceDto dto = new PlaceDto();
        dto.setPlaceId(entity.getPlaceId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getCategoryId());
        }
        return dto;
    }

}

