package controller;


import dto.CategoryDto;
import service.CategoryService;
import utils.ResponseUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseUtil addCategory(@RequestBody CategoryDto dto) {
        return ResponseUtil.success("Category added", service.addCategory(dto));
    }

    @GetMapping
    public ResponseUtil getAll() {
        List<CategoryDto> list = service.getAllCategories();
        return ResponseUtil.success("All categories", list);
    }

    @GetMapping("/{id}")
    public ResponseUtil getById(@PathVariable Integer id) {
        return ResponseUtil.success("Category found", service.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseUtil update(@PathVariable Integer id, @RequestBody CategoryDto dto) {
        return ResponseUtil.success("Category updated", service.updateCategory(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseUtil delete(@PathVariable Integer id) {
        service.deleteCategory(id);
        return ResponseUtil.success("Category deleted", null);
    }
}
