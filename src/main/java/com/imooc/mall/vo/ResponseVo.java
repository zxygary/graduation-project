package com.imooc.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
<<<<<<< HEAD
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
=======
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
import com.imooc.mall.enums.ResponseEnum;
import lombok.Data;
import org.springframework.validation.BindingResult;

<<<<<<< HEAD
=======
import java.util.Objects;

/**
 * Created by 廖师兄
 */
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

<<<<<<< HEAD
    private Integer status;

    private String msg;

    private T data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T>ResponseVo<T> successByMsg(String msg){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T>ResponseVo<T> success(T data){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), data);
    }


    public static <T>ResponseVo<T> success(){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static <T>ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<T>(responseEnum.getCode(), responseEnum.getDesc());
    }

    public static <T>ResponseVo<T> error(ResponseEnum responseEnum, String msg){
        return new ResponseVo<T>(responseEnum.getCode(), msg);
    }

    public static <T>ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult){
        return new ResponseVo<T>(responseEnum.getCode(),
                bindingResult.getFieldError().getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }
=======
	private Integer status;

	private String msg;

	private T data;

	private ResponseVo(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	private ResponseVo(Integer status, T data) {
		this.status = status;
		this.data = data;
	}

	public static <T> ResponseVo<T> successByMsg(String msg) {
		return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), msg);
	}

	public static <T> ResponseVo<T> success(T data) {
		return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), data);
	}

	public static <T> ResponseVo<T> success() {
		return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
	}

	public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
		return new ResponseVo<>(responseEnum.getCode(), responseEnum.getDesc());
	}

	public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg) {
		return new ResponseVo<>(responseEnum.getCode(), msg);
	}

	public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult) {
		return new ResponseVo<>(responseEnum.getCode(),
				Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
	}
>>>>>>> ca76460b9e005cb8b9c256e8058f1a03483ca668
}
