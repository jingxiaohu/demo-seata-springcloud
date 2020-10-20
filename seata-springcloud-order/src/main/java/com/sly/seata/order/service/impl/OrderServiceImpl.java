package com.sly.seata.order.service.impl;

import com.sly.seata.common.model.order.Order;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class OrderServiceImpl  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertOrder(Order order) {
		jdbcTemplate.update("INSERT INTO `BUSINESS_ORDER`(orderId,orderNo,orderDetail,createTime,logicDel,remark)" +
				" VALUES(?,?,?,?,?,?)", new Object[] {order.getOrderId(), order.getOrderNo(),order.getOrderDetail(),order.getCreateTime(),order.getLogicDel(),order.getRemark()});
	}
/*	@Autowired
	private OrderMapper orderMapper;*/

	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	public Map<String, Object> insert(@RequestBody Order order) {
		System.out.println(RootContext.getXID());

		insertOrder(order);
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

}
