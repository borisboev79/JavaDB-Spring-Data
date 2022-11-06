package bookStoreSystem.services.category;

import bookStoreSystem.domain.entities.Category;
import bookStoreSystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categories;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categories) {
        this.categories = categories;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        this.categories.saveAll(categories);
    }

    @Override
    public boolean isDataSeeded() {
        return this.categories.count() > 0;
    }

    @Override
    public Set<Category> getRandomCategories() {
        final long count = this.categories.count();
        if (count != 0) {
            final long randomCategoryId = new Random().nextLong(1L, count) + 1L;
            return Set.of(this.categories.findById(randomCategoryId).orElseThrow(NoSuchElementException::new));

        }
        throw new RuntimeException();
    }
}
