package com.epam.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.model.Account;

@RestController
public class Api {

    private List<Account> accounts;

    protected Logger logger = Logger.getLogger(Api.class.getName());

    public Api() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, 1, "111111"));
        accounts.add(new Account(2, 2, "222222"));
        accounts.add(new Account(3, 3, "333333"));
        accounts.add(new Account(4, 4, "444444"));
        accounts.add(new Account(5, 1, "555555"));
        accounts.add(new Account(6, 2, "666666"));
        accounts.add(new Account(7, 2, "777777"));
    }

    @RequestMapping("/accounts/{number}")
    public Account findByNumber(@PathVariable("number") String number) {
        logger.info(String.format("Account.findByNumber(%s)", number));
        return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
    }


    @RequestMapping("/accounts")
    public List<Account> findAll() {
        logger.info("Account.findAll()");
        return accounts;
    }

}
