package com.misury.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author misury
 **/
@RestController
public class CatController {
    @GetMapping("/test")
    public String test(){
       return "hello world CAT!";
    }

    @GetMapping("/gc")
    public String gc(){
        System.gc();
        return "gc success!";
    }
    // DemoController.java

    @GetMapping("/transaction")
    public String transaction() {
        // <1> 创建 Transaction 对象
        Transaction t = Cat.newTransaction("URL", "/demo/transaction");
        try {
            // <2> ... yourBusiness(); 业务逻辑

            // <3> 设置 Transaction 的状态为成功
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // <4> 设置 Transaction 的状态为异常
            t.setStatus(e);
        } finally {
            // <5> 标记 Transaction 结束
            t.complete();
        }
        return "success";
    }
}
