package thiennn.pro.services;

import thiennn.pro.models.UserModel;

public interface UserService {

	UserModel login(String username, String password);

	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

}
