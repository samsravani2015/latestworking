package com.example.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the porfol_info database table.
 * 
 */
@Entity
@Table(name="porfol_info")
@NamedQuery(name="PorfolInfo.findAll", query="SELECT p FROM PorfolInfo p")
public class PorfolInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PORFOL_ID")
	private int porfolId;

	@Column(name="PORFOL_NM")
	private String porfolNm;

	@Embedded
	@JsonIgnore
	@JsonValue
	private CommonEntity commonEntity;
	
	@ManyToMany(mappedBy = "porfolInfo")
    private Set<AcctInfo> acctInfo = new HashSet<AcctInfo>();
	
	/*//bi-directional many-to-one association to PorfolPrgmAssc
	@JsonIgnore
	@OneToMany(mappedBy="porfolInfo")
	private List<PorfolPrgmAssc> porfolPrgmAsscs;
	
	
*/
	public PorfolInfo() {
	}

	public int getPorfolId() {
		return porfolId;
	}

	public void setPorfolId(int porfolId) {
		this.porfolId = porfolId;
	}

	public String getPorfolNm() {
		return porfolNm;
	}

	public void setPorfolNm(String porfolNm) {
		this.porfolNm = porfolNm;
	}

	public CommonEntity getCommonEntity() {
		return commonEntity;
	}

	public void setCommonEntity(CommonEntity commonEntity) {
		this.commonEntity = commonEntity;
	}

	public Set<AcctInfo> getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(Set<AcctInfo> acctInfo) {
		this.acctInfo = acctInfo;
	}
	

}