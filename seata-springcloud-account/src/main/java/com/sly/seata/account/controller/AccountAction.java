package com.sly.seata.account.controller;

import com.sly.seata.account.service.impl.AccountServiceImpl;
import com.sly.seata.common.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Copyright (C),2020
 * Author: jingxiaohu
 * Date: 2020/10/20 14:18
 * Description:
 */
@RestController
public class AccountAction {
    @Autowired
    AccountServiceImpl accountServiceImpl;
    /**
     * 新增
     *
     * @param account
     * @return
     * @author sly
     * @time 2019年6月12日
     */
    @RequestMapping(value = "/account/insert", method = RequestMethod.POST)
    Map<String, Object> insert(@RequestBody Account account){
        return  accountServiceImpl.insert(account);
    }
}
