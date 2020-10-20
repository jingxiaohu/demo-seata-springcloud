package com.sly.seata.business.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sly.seata.service.BusinessService;


/**
 * 业务controller
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
	@Autowired
	private BusinessService businessServiceImpl;

	/**
	 * 购买
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@ResponseBody
	@RequestMapping("/purchase")
	public Object purchase(HttpServletRequest request, HttpServletResponse response) {
		String accountId = "1";
		String orderId = "2";
		String storageId = "3";
		Map<String, Object> result = null;
		try {
			result = businessServiceImpl.purchase(accountId, orderId, storageId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isEmpty(result)){
			result = new HashMap<>(16);
			result.put("status", 400);
			result.put("message", "调用business服务失败！");
			return result;
		}
		return result;
	}
}
