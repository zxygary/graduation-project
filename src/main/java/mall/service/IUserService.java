package mall.service;

import mall.pojo.User;
import mall.vo.ResponseVo;

/**
 * Created by 廖师兄
 */
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
