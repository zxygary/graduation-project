package mall.enums;

import lombok.Getter;

/**
 * 角色0-管理员,1-普通用户
 */
@Getter
public enum RoleEnum {
	ADMIN(0),

	CUSTOMER(1),

	;

	Integer code;

	RoleEnum(Integer code) {
		this.code = code;
	}
}
