package serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.PlaceDto;
import entity.Category;
import entity.Place;
import exception.ResourceNotFoundException;
import repo.CategoryRepository;
import repo.PlaceRepository;
import service.PlaceService;
import utils.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public PlaceDto addPlace(PlaceDto dto) {
        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + dto.getCategoryId()));

        Place place = MapperUtil.toEntity(dto);
        place.setCategory(category);

        return MapperUtil.toDto(placeRepo.save(place));
    }

    @Override
    public PlaceDto updatePlace(Integer id, PlaceDto dto) {
        Place place = placeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found with id " + id));

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + dto.getCategoryId()));

        place.setName(dto.getName());
        place.setLocation(dto.getLocation());
        place.setPrice(dto.getPrice());
        place.setDescription(dto.getDescription());
        place.setCategory(category);

        return MapperUtil.toDto(placeRepo.save(place));
    }

    @Override
    public void deletePlace(Integer id) {
        placeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Place not found with id " + id));
        placeRepo.deleteById(id);
    }

    @Override
    public PlaceDto getPlaceById(Integer id) {
        Place place = placeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found with id " + id));
        return MapperUtil.toDto(place);
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        return placeRepo.findAll().stream().map(MapperUtil::toDto).collect(Collectors.toList());
    }
}
