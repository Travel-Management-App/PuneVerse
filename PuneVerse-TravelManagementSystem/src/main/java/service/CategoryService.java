package service;



import java.util.List;

import dto.CategoryDto;


public interface CategoryService {
    CategoryDto addCategory(CategoryDto dto);
    CategoryDto updateCategory(Integer id, CategoryDto dto);
    void deleteCategory(Integer id);
    CategoryDto getCategoryById(Integer id);
    List<CategoryDto> getAllCategories();
}
