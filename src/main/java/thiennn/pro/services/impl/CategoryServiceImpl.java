package thiennn.pro.services.impl;

import java.io.File;
import java.util.List;

import thiennn.pro.daos.CategoryDao;
import thiennn.pro.daos.impl.CategoryDaoImpl;
import thiennn.pro.models.CategoryModel;
import thiennn.pro.services.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	CategoryDao categoryDao = new CategoryDaoImpl();


	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);

		
	}

	@Override
	public void edit(CategoryModel category) {
		CategoryModel oldCategory = categoryDao.get(category.getCateid());
		oldCategory.setCatename(category.getCatename());
		if (category.getIcon() != null) {
		// XOA ANH CU DI
		String fileName = oldCategory.getIcon();
		final String dir = "D:\\upload";
		File file = new File(dir + "/category" + fileName);
		if (file.exists()) {
		file.delete();
		}
		oldCategory.setIcon(category.getIcon());
		}
		categoryDao.edit(oldCategory);

		
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);

		
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);

	}

	@Override
	public CategoryModel get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<CategoryModel> search(String keyword) {
		return categoryDao.search(keyword);
	}

}
