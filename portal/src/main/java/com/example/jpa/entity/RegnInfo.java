package com.example.jpa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the regn_info database table.
 * 
 */
@Entity
@Table(name="regn_info")
@NamedQuery(name="RegnInfo.findAll", query="SELECT r FROM RegnInfo r")
public class RegnInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REGN_ID")
	private int regnId;

	@Column(name="REGN_NM")
	private String regnNm;

	@Embedded
	@JsonIgnore
	private CommonEntity commonEntity;
	

	//bi-directional many-to-one association to RegnAcctAssc
	//@OneToMany(mappedBy="regnInfo")
	//private List<RegnAcctAssc> regnAcctAsscs;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "regn_acct_assc",
        joinColumns = @JoinColumn(name = "REGN_ID", referencedColumnName = "REGN_ID"),
        inverseJoinColumns = @JoinColumn(name = "ACCT_ID", referencedColumnName = "ACCT_ID"))
    private Set<AcctInfo> accountInfo;


	public int getRegnId() {
		return regnId;
	}


	public void setRegnId(int regnId) {
		this.regnId = regnId;
	}


	public String getRegnNm() {
		return regnNm;
	}


	public void setRegnNm(String regnNm) {
		this.regnNm = regnNm;
	}


	public CommonEntity getCommonEntity() {
		return commonEntity;
	}


	public void setCommonEntity(CommonEntity commonEntity) {
		this.commonEntity = commonEntity;
	}


	public Set<AcctInfo> getAccountInfo() {
		return accountInfo;
	}


	public void setAccountInfo(Set<AcctInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
}