package com.sly.seata.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.sly.seata.service.hystrix.BusinessServiceHystrixImpl;

/**
 * Business feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
public interface BusinessService {

	/**
	 * 购买
	 * 
	 * @param accountId
	 * @param orderId
	 * @param storageId
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	Map<String, Object> purchase( String accountId,  String orderId, String storageId);

}
