package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.CategoryDto;
import entity.Category;
import exception.ResourceNotFoundException;
import repo.CategoryRepository;
import service.CategoryService;
import utils.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Override
    public CategoryDto addCategory(CategoryDto dto) {
        Category category = MapperUtil.toEntity(dto);
        return MapperUtil.toDto(repo.save(category));
    }

    @Override
    public CategoryDto updateCategory(Integer id, CategoryDto dto) {
        Category cat = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
        cat.setName(dto.getName());
        cat.setDescription(dto.getDescription());
        return MapperUtil.toDto(repo.save(cat));
    }

    @Override
    public void deleteCategory(Integer id) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
        repo.deleteById(id);
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        Category cat = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
        return MapperUtil.toDto(cat);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return repo.findAll().stream().map(MapperUtil::toDto).collect(Collectors.toList());
    }
}

