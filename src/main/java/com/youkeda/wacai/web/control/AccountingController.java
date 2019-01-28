package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.Accounting;
import com.youkeda.wacai.web.model.AccountingRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountingController {
    @RequestMapping(path = "/accounting")
    public Accounting accounting(Accounting accounting) {
        int result = accounting.getCash()+accounting.getIncome()-accounting.getRent()-accounting.getCharges()-accounting.getEat()-accounting.getTreat()-accounting.getKtv();
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
    public String search(@RequestParam("amount") int amount){
        List<AccountingRecord> flitered = records.stream().filter(str->str.getAmount()>amount).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(AccountingRecord temp:flitered){
            sb.append(temp);
        }
        return ""+sb;
    }
}
