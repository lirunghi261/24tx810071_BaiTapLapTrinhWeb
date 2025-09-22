package thiennn.pro.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletDiskFileUpload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thiennn.pro.models.CategoryModel;
import thiennn.pro.services.CategoryService;
import thiennn.pro.services.impl.CategoryServiceImpl;
import thiennn.pro.utils.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();

	    DiskFileItemFactory diskFileItemFactory = DiskFileItemFactory.builder()
	        .setBufferSize(4096)
	        .get();

	    JakartaServletDiskFileUpload servletFileUpload = new JakartaServletDiskFileUpload(diskFileItemFactory);

	    try {
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("UTF-8");
	        req.setCharacterEncoding("UTF-8");

	        List<DiskFileItem> items = servletFileUpload.parseRequest(req);

	        for (DiskFileItem item : items) {
	            if ("catename".equals(item.getFieldName())) {
	                category.setCatename(item.getString(StandardCharsets.UTF_8));
	            } else if ("icon".equals(item.getFieldName())) {
	                String originalFileName = item.getName();
	                int index = originalFileName.lastIndexOf(".");
	                String ext = originalFileName.substring(index + 1);
	                String fileName = System.currentTimeMillis() + "." + ext;
	                File file = new File(Constant.UPLOAD_DIRECTORY + "/category/" + fileName);
	                item.write(file.toPath());
	                category.setIcon("category/" + fileName);
	            }
	        }

	        cateService.insert(category);

	        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}

}
