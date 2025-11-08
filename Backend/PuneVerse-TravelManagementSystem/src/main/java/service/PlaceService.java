package service;



import java.util.List;

import dto.PlaceDto;


public interface PlaceService {
    PlaceDto addPlace(PlaceDto dto);
    PlaceDto updatePlace(Integer id, PlaceDto dto);
    void deletePlace(Integer id);
    PlaceDto getPlaceById(Integer id);
    List<PlaceDto> getAllPlaces();
}

