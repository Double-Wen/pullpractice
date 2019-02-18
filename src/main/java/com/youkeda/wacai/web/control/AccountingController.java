package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountingController {
    @RequestMapping(path = "/accounting")
    public Accounting accounting(Accounting accounting) {
        int result = accounting.getCash() + accounting.getIncome() - accounting.getRent() - accounting.getCharges() - accounting.getEat() - accounting.getTreat() - accounting.getKtv();
        accounting.setBalance(result);
        return accounting;
    }

    List<AccountingRecord> records = new ArrayList<>();

    @RequestMapping(path = "/record")
    public String record(AccountingRecord record) {
        Date time = new Date();
        record.setTime(time);
        String result = "";
        records.add(record);
        for (AccountingRecord temp : records) {
            result = result + "记录:" +
                    "  发生时间:" + temp.getCreateTime() +
                    "  金额:" + temp.getAmount() +
                    "  类别:" + temp.getType() +
                    "  科目:" + temp.getCategory() +
                    "  记账时间:" + temp.getTime();
            result = result + "<br>";

        }
        return result;
    }

    @RequestMapping(path = "/search")
    public String search(@RequestParam("amount") int amount) {
        List<AccountingRecord> flitered = records.stream().filter(str -> str.getAmount() > amount).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (AccountingRecord temp : flitered) {
            sb.append("记录" + "金额" + temp.getAmount());
            sb.append("记账时间" + temp.getTime());
            sb.append("发生时间" + temp.getCreateTime());
            sb.append("类型" + temp.getType());
            sb.append("项目" + temp.getCategory());
        }
        return sb.toString();
    }

    public static final List<Payinfo> payinfos = new ArrayList<>();

    @PostConstruct
    public void init() {
        //初始化白条数据
        Payinfo baitiao = new Payinfo();
        baitiao.setPayType(PayType.baitiao);
        baitiao.setBillingDate(10);
        baitiao.setDueDate(20);
        payinfos.add(baitiao);
        //初始化花呗数据
        Payinfo huabei = new Payinfo();
        huabei.setPayType(PayType.huabei);
        huabei.setBillingDate(20);
        huabei.setDueDate(10);
        payinfos.add(huabei);
        //初始化信用卡数据
        CreditCard creditCard = new CreditCard();
        creditCard.setPayType(PayType.creditCard);
        creditCard.setBillingDate(5);
        creditCard.setDueDate(25);
        creditCard.setName("招商银行信用卡");
        creditCard.setCardNumber("111111111111");
        payinfos.add(creditCard);
    }

    @RequestMapping(path = "/pay")
    public Payinfo pay(@RequestParam("amount") double amount, @RequestParam("payType") PayType payType, @RequestParam("stagesCount") int stagesCount) {
        List<Payinfo> payinfoList = payinfos.stream().filter(payinformation -> payinformation.getPayType().equals(payType)).collect(Collectors.toList());
        if (payType.equals(PayType.creditCard)) {
            CreditCard creditCard = (CreditCard) payinfoList.get(0);
            //返回数据
            CreditCard result = new CreditCard();
            result.setBillingDate(creditCard.getBillingDate());
            result.setDueDate(creditCard.getDueDate());
            result.setPayType(PayType.creditCard);
            result.setAmount(amount);
            result.setStagesCount(stagesCount);
            result.setName(creditCard.getName());
            result.setCardNumber(creditCard.getCardNumber());
            return result;
        } else {
            Payinfo payinfo = payinfoList.get(0);
            //返回数据
            Payinfo result = new Payinfo();
            result.setBillingDate(payinfo.getBillingDate());
            result.setDueDate(payinfo.getDueDate());
            result.setPayType(payType);
            result.setAmount(amount);
            result.setStagesCount(stagesCount);
            return result;
        }
    }
}
