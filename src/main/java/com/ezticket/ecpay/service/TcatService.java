package com.ezticket.ecpay.service;

import com.ezticket.web.product.pojo.Porder;
import com.ezticket.web.product.repository.PorderRepository;
import ecpay.logistics.integration.AllInOne;
import ecpay.logistics.integration.domain.CreateHomeObj;
import ecpay.logistics.integration.domain.PrintTradeDocumentObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TcatService {

    @Autowired
    private PorderRepository porderRepository;
    // 產生黑貓物流訂單
    public String postCreateHomeOrder (Integer porderno) throws UnsupportedEncodingException {
        AllInOne all = new AllInOne("");
        CreateHomeObj obj = new CreateHomeObj();
        Porder porder = porderRepository.getReferenceById(porderno);
        obj.setMerchantTradeNo("ezTicket0200000" + porderno);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String Now = now.format(formatter);
        obj.setMerchantTradeDate(Now);
        obj.setLogisticsSubType("TCAT");
        obj.setGoodsAmount(porder.getPchecktotal().toString());
        obj.setSenderName("ezTicket");
        obj.setSenderCellPhone("0987254088");
        obj.setReceiverName(porder.getRecipient());
        obj.setReceiverCellPhone(porder.getRephone());
        String returnURL = "https://5b45-111-249-14-16.jp.ngrok.io";
        // 設定接收回傳值的Https + Controller路徑
        obj.setServerReplyURL(returnURL + "/ecpay/tcat/return");
        // 擷取地址
        String zipcode = porder.getReaddress().substring(0, 3).toString();
        String address = porder.getReaddress().substring(3).toString();
        // 重新編譯

        String big5Str = new String(address.getBytes("UTF-8"), "Big5");
        String utf8Str = new String(address.getBytes("Big5"), "UTF-8");

        obj.setSenderZipCode("320");
        obj.setSenderAddress("桃園市中壢區復興路46號9樓");
        obj.setReceiverZipCode(zipcode);
        obj.setReceiverAddress(address);
        obj.setTemperature("0001");
        obj.setDistance("00");
        obj.setSpecification("0002");
        obj.setScheduledPickupTime("4");
        obj.setScheduledDeliveryTime("4");
        return all.create(obj);
    }

    public String postPrintTradeDocumentOrder (String allPayLogisticsID){
        AllInOne all = new AllInOne("");
        PrintTradeDocumentObj obj = new PrintTradeDocumentObj();
        obj.setMerchantID("2000132");
        obj.setAllPayLogisticsID(allPayLogisticsID);
        return all.printTradeDocument(obj);
    }
}