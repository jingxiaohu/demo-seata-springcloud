package com.sly.seata.service;

import com.sly.seata.common.model.order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sly.seata.service.hystrix.OrderServiceHystrixImpl;

import java.util.Map;

/**
 * Order feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-order", fallback = OrderServiceHystrixImpl.class)
public interface OrderService {

	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@RequestMapping(value = "/order/insert", method = RequestMethod.POST)
	Map<String, Object> insert(@RequestBody Order order);

}
