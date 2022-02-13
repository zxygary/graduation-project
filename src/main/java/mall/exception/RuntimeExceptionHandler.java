package mall.exception;

import mall.enums.ResponseEnum;
import mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static mall.enums.ResponseEnum.ERROR;

/**
 * Created by 廖师兄
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
//	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseVo handle(RuntimeException e) {
		return ResponseVo.error(ERROR, e.getMessage());
	}

	@ExceptionHandler(UserLoginException.class)
	@ResponseBody
	public ResponseVo userLoginHandle() {
		return ResponseVo.error(ResponseEnum.NEED_LOGIN);
	}
}
