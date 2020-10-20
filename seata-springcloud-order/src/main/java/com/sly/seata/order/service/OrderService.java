package com.sly.seata.order.service;

import com.sly.seata.common.model.order.Order;
import com.sly.seata.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Order feign客户端
 *
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class OrderService {
    @Autowired
    OrderServiceImpl orderServiceImpl;

    /**
     * 新增
     *
     * @param order
     * @return
     * @author sly
     * @time 2019年6月12日
     */
    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    Map<String, Object> insert(@RequestBody Order order) {
        return orderServiceImpl.insert(order);
    }

}
