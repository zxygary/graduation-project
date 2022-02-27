package mall.service;

import mall.pojo.User;
import mall.vo.ResponseVo;

public interface IUserService {

	/**
	 * 注册
	 */
	ResponseVo<User> register(User user);

	/**
	 * 登录
	 */
	ResponseVo<User> login(String username, String password);
}
