package com.youkeda.wacai.web.control;

import com.youkeda.wacai.web.model.Accounting;
import com.youkeda.wacai.web.model.AccountingRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AccountingController {

    List<AccountingRecord> records = new ArrayList<>();
    @RequestMapping(path = "/record")
    public String record(AccountingRecord record) {
        Date time = new Date();
        record.setTime(time);
        String str = "";
        for (int index=0;index<records.size();index++){
            AccountingRecord item = records.get(index);
            String temp1 = item.getCreateTime();
            Date temp2 = item.getTime();
            int temp3 = item.getAmount();
            String temp4 = item.getType();
            String temp5 = item.getCategory();
            str += temp1;
            str += "\n";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            str += sdf.format(temp2);
            str += "\n";
            str += String.valueOf(temp3);
            str += "\n";
            str += temp4;
            str += "\n";
            str += temp5;
            str += "\n";
        }
        return str;
    }

    @RequestMapping(path = "/accounting")
    public Accounting accounting(Accounting accounting) {
        int result = accounting.getCash()+accounting.getIncome()-accounting.getRent()-accounting.getCharges()-accounting.getEat()-accounting.getTreat()-accounting.getKtv();
        accounting.setBalance(result);
        return accounting;
    }
}
