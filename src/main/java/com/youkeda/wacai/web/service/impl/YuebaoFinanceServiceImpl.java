package com.youkeda.wacai.web.service.impl;

import java.util.Date;

import com.youkeda.wacai.web.model.FinanceInfo;
import com.youkeda.wacai.web.service.FinanceService;

public class YuebaoFinanceServiceImpl implements FinanceService {

    @Override
    public FinanceInfo invest(double amount, int days) {
        FinanceInfo financeInfo = new FinanceInfo();
        double income = amount * 0.0292 / 365 * days;
        financeInfo.setIncome(income);
        financeInfo.setStartTime(new Date());
        financeInfo.setAmount(amount);
        financeInfo.setDays(days);
        return financeInfo;
    }
}
