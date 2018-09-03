package com.insurance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Email_Service")
public class EmailServiceModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Basic(optional = false)
	@Column(columnDefinition = "date", nullable = false, name = "date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(columnDefinition = "sublect", name = "subject")
	private String subject;

	@Column(columnDefinition = "message", name = "message")
	private String messgae;

	@Column(columnDefinition = "phoneNo", name = "phoneNo")
	private int phoneNo;

	@Column(columnDefinition = "mail", name = "mail")
	private String mailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "EmailServiceModel [id=" + id + ", date=" + date + ", subject=" + subject + ", messgae=" + messgae
				+ ", phoneNo=" + phoneNo + ", mailId=" + mailId + "]";
	}

}
