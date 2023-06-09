package com.ezticket.web.product.pojo;
import com.ezticket.web.users.pojo.Member;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.*;

import java.sql.Timestamp;

@Entity
@Table(name ="PCOMMENT")
public class Pcomment implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pcommentno;
	private Integer productno;

	@NotEmpty(message = "評論內容不可為空")
	private String pcommentcont;

	@NotNull(message = "評論數不可為空")
	@Min(value =1,message ="評星數不能小於{value}")
	@Max(value =5,message ="評星數不能大於{value}")
	private Integer prate;
	private Timestamp pcommentdate;
	private Integer memberno;
	private Integer pcommentstatus;
	private Integer plike;


	@ManyToOne
	@JoinColumn(name ="memberno",insertable = false,updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name ="productno",insertable = false,updatable = false)
	private Product product;
	
	public Pcomment() {}
	
	public Integer getPcommentno() {
		return pcommentno;
	}
	public void setPcommentno(Integer pcommentno) {
		this.pcommentno = pcommentno;
	}
	public Integer getProductno() {
		return productno;
	}
	public void setProductno(Integer productno) {
		this.productno = productno;
	}

	public String getPcommentcont() {
		return pcommentcont;
	}
	public void setPcommentcont(String pcommentcont) {
		this.pcommentcont = pcommentcont;
	}
	public Integer getPrate() {
		return prate;
	}
	public void setPrate(Integer prate) {
		this.prate = prate;
	}
	public Timestamp getPcommentdate() {
		return pcommentdate;
	}
	public void setPcommentdate(Timestamp pcommentdate) {
		this.pcommentdate = pcommentdate;
	}
	public Integer getMemberno() {
		return memberno;
	}
	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}
	public Integer getPcommentstatus() {
		return pcommentstatus;
	}
	public void setPcommentstatus(Integer pcommentstatus) {
		this.pcommentstatus = pcommentstatus;
	}
	public Integer getPlike() {
		return plike;
	}
	public void setPlike(Integer plike) {
		this.plike = plike;
	}
	
	

}
