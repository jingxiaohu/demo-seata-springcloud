package com.sly.seata.storage.service.hystrix;

import com.sly.seata.common.model.storage.Storage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage熔断
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class StorageServiceHystrixImpl  {

	/**
	 * 新增失败熔断返回
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	public Map<String, Object> insert(Storage storage) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 400);
		result.put("message", "调用仓储新增服务失败！");
		return result;
	}

}
