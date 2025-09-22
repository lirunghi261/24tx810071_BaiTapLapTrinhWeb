package thiennn.pro.daos;

import java.util.List;

import thiennn.pro.models.CategoryModel;

public interface CategoryDao {
	
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	List<CategoryModel> search(String keyword);

}
