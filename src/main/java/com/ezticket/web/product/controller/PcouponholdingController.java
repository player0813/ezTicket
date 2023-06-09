package com.ezticket.web.product.controller;

import com.ezticket.web.product.dto.PcouponholdingDTO;
import com.ezticket.web.product.pojo.PcouponholdingPK;
import com.ezticket.web.product.service.PcouponholdingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pcouponholding")
public class PcouponholdingController {

    @Autowired private PcouponholdingService pcouponholdingService;

    @GetMapping("/list")
    public List<PcouponholdingDTO> getAllPcouponholding(){
        return pcouponholdingService.getAllPcouponHolding();
    }

    @GetMapping
    public PcouponholdingDTO getPcouponHoldingByID(@RequestParam PcouponholdingPK pcouponholdingPK){
        return pcouponholdingService.getPcouponHoldingByID(pcouponholdingPK);
    }

    @GetMapping("/byMemberno")
    public List<PcouponholdingDTO> getPcouponHoldingByMemberno(@RequestParam Integer memberno){
        return pcouponholdingService.getPcouponHoldingByMemberno(memberno);
    }
    @GetMapping("/take")
    public boolean takeCoupon(@RequestParam Integer memberno,@RequestParam Integer pcouponno){
        return pcouponholdingService.takePcoupon(memberno,pcouponno);
    }
    @GetMapping("/takeAll")
    public boolean takeCouponForMember(@RequestParam Integer pcouponno){
        return pcouponholdingService.takePcouponAllMember(pcouponno);
    }

}
