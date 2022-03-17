package com.imooc.pay.controller;

import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.impl.PayServiceImpl;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 廖师兄
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

	@Autowired
	private PayServiceImpl payService;

	@Autowired
	private WxPayConfig wxPayConfig;

	@GetMapping("/create")
	public ModelAndView create(@RequestParam("orderId") String orderId,
							   @RequestParam("amount") BigDecimal amount,
							   @RequestParam("payType") BestPayTypeEnum bestPayTypeEnum
							   ) {
		PayResponse response = payService.create(orderId, amount, bestPayTypeEnum);

		//支付方式不同，渲染就不同, WXPAY_NATIVE使用codeUrl,  ALIPAY_PC使用body
		Map<String, String> map = new HashMap<>();
		if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE) {
			map.put("codeUrl", response.getCodeUrl());
			map.put("orderId", orderId);
			map.put("returnUrl", wxPayConfig.getReturnUrl());
			return new ModelAndView("createForWxNative", map);
		}else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC) {
			map.put("body", response.getBody());
			return new ModelAndView("createForAlipayPc", map);
		}

		throw new RuntimeException("暂不支持的支付类型");
	}

	@PostMapping("/notify")
	@ResponseBody
	public String asyncNotify(@RequestBody String notifyData) {
		return payService.asyncNotify(notifyData);
	}

	@GetMapping("/queryByOrderId")
	@ResponseBody
	public PayInfo queryByOrderId(@RequestParam String orderId) {
		log.info("查询支付记录...");
		return payService.queryByOrderId(orderId);
	}
}
