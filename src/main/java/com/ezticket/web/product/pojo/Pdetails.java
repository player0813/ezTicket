package com.ezticket.web.product.pojo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity
public class Pdetails {
    @EmbeddedId
    private PdetailsPK pdetailsNo;

    private Integer porderqty;

    private Integer pprice;

    private Integer pcommentstatus;

}