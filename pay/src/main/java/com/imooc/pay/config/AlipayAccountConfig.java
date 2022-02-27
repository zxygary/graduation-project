package com.imooc.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 */
@Component
@ConfigurationProperties(prefix = "alipay")
@Data
public class AlipayAccountConfig {

	private String appId;

	private String privateKey;

	private String publicKey;

	private String notifyUrl;

	private String returnUrl;
}
