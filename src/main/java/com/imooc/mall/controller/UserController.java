package com.imooc.mall.controller;

import com.imooc.mall.consts.MallConst;
<<<<<<< HEAD
import com.imooc.mall.enums.ResponseEnum;
=======
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Objects;

import static com.imooc.mall.enums.ResponseEnum.PARAM_ERROR;

=======
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by 廖师兄
 */
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
@RestController
@Slf4j
public class UserController {

<<<<<<< HEAD
    @Autowired
    private IUserService userService;

    @PostMapping("/uer/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userForm,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的参数有误，{} {}",
                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        //dto
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  BindingResult bindingResult,
                                  HttpSession session){
        if (bindingResult.hasErrors()){
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置session
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login seesonId={}", session.getId());

        return userResponseVo;
    }

    //  session保存在内存里，如果项目重启的话就会丢失。可以用token+redis的方式来改良
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    //TODO 判断登录状态, 拦截器
    @PostMapping("/user/logout")
    /**
     * {@link TomcatServletWebServerFactory}
     */
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
=======
	@Autowired
	private IUserService userService;

	@PostMapping("/user/register")
	public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		//dto
		return userService.register(user);
	}

	@PostMapping("/user/login")
	public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
								  HttpSession session) {
		ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

		//设置Session
		session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());
		log.info("/login sessionId={}", session.getId());

		return userResponseVo;
	}

	//session保存在内存里，改进版：token+redis
	@GetMapping("/user")
	public ResponseVo<User> userInfo(HttpSession session) {
		log.info("/user sessionId={}", session.getId());
		User user = (User) session.getAttribute(MallConst.CURRENT_USER);
		return ResponseVo.success(user);
	}

	/**
	 * {@link TomcatServletWebServerFactory} getSessionTimeoutInMinutes
	 */
	@PostMapping("/user/logout")
	public ResponseVo logout(HttpSession session) {
		log.info("/user/logout sessionId={}", session.getId());
		session.removeAttribute(MallConst.CURRENT_USER);
		return ResponseVo.success();
	}
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
