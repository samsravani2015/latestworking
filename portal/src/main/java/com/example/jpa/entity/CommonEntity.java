package com.example.jpa.entity;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Embeddable
public class CommonEntity {
	
	@JsonIgnore
	@Column(name="AUD_INSRT_ID")
	private String audInsrtId;
	
	@JsonIgnore
	@Column(name="AUD_INSRT_TMSTP")
	private Timestamp audInsrtTmstp;

	@JsonIgnore
	@Column(name="AUD_UPDT_ID")
	private String audUpdtId;

	@JsonIgnore
	@Column(name="AUD_UPDT_TMSTP")
	private Timestamp audUpdtTmstp;

	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name="REGN_END_DT")
	private Date regnEndDt;

	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name="REGN_START_DT")
	private Date regnStartDt;
	
}