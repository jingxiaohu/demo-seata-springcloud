package com.sly.seata.account.service.impl;

import com.sly.seata.common.model.account.Account;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class AccountServiceImpl  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertAccount(Account account) {
		jdbcTemplate.update("INSERT INTO `business_account`(accountId,amount,accountName,logicDel,remark)" +
				" VALUES(?,?,?,?,?)", new Object[] {account.getAccountId(), account.getAmount(),account.getAccountName(),account.getLogicDel(),account.getRemark()});
	}
	/**
	 * 新增
	 * 
	 * @param account
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
//	@GlobalTransactional
	public Map<String, Object> insert(Account account) {
		System.out.println(RootContext.getXID());
		insertAccount(account);
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

}
