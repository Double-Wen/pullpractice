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
        for (AccountingRecord record1 : records) {
            result = result + "记录:" +
                    "  发生时间:" + record1.getCreateTime() +
                    "  金额:" + record1.getAmount() +
                    "  类别:" + record1.getType() +
                    "  科目:" + record1.getCategory() +
                    "  记账时间:" + record1.getTime();
            result = result + "<br>";

        }
        return result;
    }

}
