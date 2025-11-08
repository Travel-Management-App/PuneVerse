package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dto.PlaceDto;
import service.PlaceService;
import utils.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin
public class PlaceController {

    @Autowired
    private PlaceService service;

    @PostMapping
    public ResponseUtil addPlace(@RequestBody PlaceDto dto) {
        return ResponseUtil.success("Place added successfully", service.addPlace(dto));
    }

    @GetMapping
    public ResponseUtil getAll() {
        List<PlaceDto> list = service.getAllPlaces();
        return ResponseUtil.success("All places fetched", list);
    }

    @GetMapping("/{id}")
    public ResponseUtil getById(@PathVariable Integer id) {
        return ResponseUtil.success("Place found", service.getPlaceById(id));
    }

    @PutMapping("/{id}")
    public ResponseUtil update(@PathVariable Integer id, @RequestBody PlaceDto dto) {
        return ResponseUtil.success("Place updated", service.updatePlace(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseUtil delete(@PathVariable Integer id) {
        service.deletePlace(id);
        return ResponseUtil.success("Place deleted", null);
    }
}
