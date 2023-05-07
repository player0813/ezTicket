package com.ezticket.web.activity.dto;

import com.ezticket.web.activity.pojo.Aimgt;
import com.ezticket.web.activity.pojo.BlockPrice;
import com.ezticket.web.activity.pojo.Session;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class ActivityBackDashboardDto {
    private Integer activityNo;
    private String aName;

    @JsonFormat(pattern = "yyyy/MM/dd kk:mm", timezone = "GMT+8")
    private Date aSDate;
    @JsonFormat(pattern = "yyyy/MM/dd kk:mm", timezone = "GMT+8")
    private Date aEDate;
    private Integer aStatus;
    private String aPlace;
    private String aPlaceAdress;
    private List<Session> session;

}
