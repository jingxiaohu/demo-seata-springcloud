package com.sly.seata.storage.service;

import com.sly.seata.common.model.storage.Storage;
import com.sly.seata.storage.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Storage feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class StorageService {
@Autowired
StorageServiceImpl storageServiceImpl;
	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@RequestMapping(value = "/storage/insert", method = RequestMethod.POST)
	Map<String, Object> insert(@RequestBody Storage storage){
		return storageServiceImpl.insert(storage);
	}


}
