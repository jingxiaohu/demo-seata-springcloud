package com.sly.seata.storage.service.impl;

import com.sly.seata.common.model.storage.Storage;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 仓储service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class StorageServiceImpl {


	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	public Map<String, Object> insert(@RequestBody Storage storage) {
		System.out.println(RootContext.getXID());
		//int a = 10/0;
		insertT( storage);
		
		
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

	public void  insertT(Storage storage){
		/*String sql = "INSERT INTO `BUSINESS_STORAGE`(storageId,storageName,storageCount,logicDel,remark)" +
				" VALUES(#{storageId},#{storageName},#{storageCount},#{logicDel},#{remark})";*/
		String sql = "INSERT INTO `BUSINESS_STORAGE`(storageId,storageName,storageCount,logicDel,remark) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,storage.getStorageId(),storage.getStorageName(),storage.getStorageCount(),storage.getLogicDel()
				,storage.getRemark());
	}
}
