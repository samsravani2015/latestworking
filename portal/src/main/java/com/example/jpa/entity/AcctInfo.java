package com.example.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
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
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the acct_info database table.
 * 
 */
@Entity
@Table(name="acct_info")
@NamedQuery(name="AcctInfo.findAll", query="SELECT a FROM AcctInfo a")
public class AcctInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCT_ID")
	private int acctId;
	
	@Column(name="ACCT_NM")
	private String acctNm;

	@Embedded
	@JsonIgnore
	@JsonValue
	private CommonEntity commonEntity;
	
	@ManyToMany(mappedBy = "accountInfo")
    private Set<RegnInfo> regnInfo = new HashSet<RegnInfo>();
	

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "acct_porfol_assc",
        joinColumns = @JoinColumn(name = "ACCT_ID", referencedColumnName = "ACCT_ID"),
        inverseJoinColumns = @JoinColumn(name = "PORFOL_ID", referencedColumnName = "PORFOL_ID"))
    private Set<PorfolInfo> porfolInfo;

	public AcctInfo() {
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getAcctNm() {
		return acctNm;
	}

	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}

	public CommonEntity getCommonEntity() {
		return commonEntity;
	}

	public void setCommonEntity(CommonEntity commonEntity) {
		this.commonEntity = commonEntity;
	}

	public Set<RegnInfo> getRegnInfo() {
		return regnInfo;
	}

	public void setRegnInfo(Set<RegnInfo> regnInfo) {
		this.regnInfo = regnInfo;
	}

	public Set<PorfolInfo> getPorfolInfo() {
		return porfolInfo;
	}

	public void setPorfolInfo(Set<PorfolInfo> porfolInfo) {
		this.porfolInfo = porfolInfo;
	}

}