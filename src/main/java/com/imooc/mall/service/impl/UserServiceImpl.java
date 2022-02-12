package com.imooc.mall.service.impl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.imooc.mall.enums.ResponseEnum.*;

/**
 * Created by 廖师兄
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 注册
	 *
	 * @param user
	 */
	@Override
	public ResponseVo<User> register(User user) {
//		error();

		//username不能重复
		int countByUsername = userMapper.countByUsername(user.getUsername());
		if (countByUsername > 0) {
			return ResponseVo.error(USERNAME_EXIST);
		}

		//email不能重复
		int countByEmail = userMapper.countByEmail(user.getEmail());
		if (countByEmail > 0) {
			return ResponseVo.error(EMAIL_EXIST);
		}

		user.setRole(RoleEnum.CUSTOMER.getCode());
		//MD5摘要算法(Spring自带)
		user.setPassword(DigestUtils.md5DigestAsHex(
				user.getPassword().getBytes(StandardCharsets.UTF_8)
		));

		//写入数据库
		int resultCount = userMapper.insertSelective(user);
		if (resultCount == 0) {
			return ResponseVo.error(ERROR);
		}

		return ResponseVo.success();
	}

	@Override
	public ResponseVo<User> login(String username, String password) {
		User user = userMapper.selectByUsername(username);
		if (user == null) {
			//用户不存在（返回：用户名或密码错误 ）
			return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
		}

		if (!user.getPassword().equalsIgnoreCase(
				DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
			//密码错误(返回：用户名或密码错误 )
			return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
		}

		user.setPassword("");
		return ResponseVo.success(user);
	}

	private void error() {
		throw new RuntimeException("意外错误");
	}
}
