package com.chance.database;

// Generated 2013-7-9 14:38:41 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CUser generated by hbm2java
 */
@Entity
@Table(name = "C_User", catalog = "chance")
public class CUser implements java.io.Serializable {

	private Integer CUserId;
	private String CUserWifiMac;
	private String CUserPwd;
	private String CUserPhone;
	private String CUserEmail;
	private long CUserInsertTime;
	private long CUserUpdateTime;
	private int CUserUserInfoId;
	private long CUserLastLoginTime;
	private String CUserBlueMac;
	private short CUserActive;
	private Long id;
	private Integer CUserInfoSetShareMapAddr;

	public CUser() {
	}

	public CUser(String CUserWifiMac, String CUserPwd, String CUserPhone,
			String CUserEmail, long CUserInsertTime, long CUserUpdateTime,
			int CUserUserInfoId, long CUserLastLoginTime, short CUserActive) {
		this.CUserWifiMac = CUserWifiMac;
		this.CUserPwd = CUserPwd;
		this.CUserPhone = CUserPhone;
		this.CUserEmail = CUserEmail;
		this.CUserInsertTime = CUserInsertTime;
		this.CUserUpdateTime = CUserUpdateTime;
		this.CUserUserInfoId = CUserUserInfoId;
		this.CUserLastLoginTime = CUserLastLoginTime;
		this.CUserActive = CUserActive;
	}

	public CUser(String CUserWifiMac, String CUserPwd, String CUserPhone,
			String CUserEmail, long CUserInsertTime, long CUserUpdateTime,
			int CUserUserInfoId, long CUserLastLoginTime, String CUserBlueMac,
			short CUserActive, Long id, Integer CUserInfoSetShareMapAddr) {
		this.CUserWifiMac = CUserWifiMac;
		this.CUserPwd = CUserPwd;
		this.CUserPhone = CUserPhone;
		this.CUserEmail = CUserEmail;
		this.CUserInsertTime = CUserInsertTime;
		this.CUserUpdateTime = CUserUpdateTime;
		this.CUserUserInfoId = CUserUserInfoId;
		this.CUserLastLoginTime = CUserLastLoginTime;
		this.CUserBlueMac = CUserBlueMac;
		this.CUserActive = CUserActive;
		this.id = id;
		this.CUserInfoSetShareMapAddr = CUserInfoSetShareMapAddr;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "C_User_ID", unique = true, nullable = false)
	public Integer getCUserId() {
		return this.CUserId;
	}

	public void setCUserId(Integer CUserId) {
		this.CUserId = CUserId;
	}

	@Column(name = "C_User_WifiMac", nullable = false, length = 20)
	public String getCUserWifiMac() {
		return this.CUserWifiMac;
	}

	public void setCUserWifiMac(String CUserWifiMac) {
		this.CUserWifiMac = CUserWifiMac;
	}

	@Column(name = "C_User_Pwd", nullable = false, length = 20)
	public String getCUserPwd() {
		return this.CUserPwd;
	}

	public void setCUserPwd(String CUserPwd) {
		this.CUserPwd = CUserPwd;
	}

	@Column(name = "C_User_Phone", nullable = false, length = 20)
	public String getCUserPhone() {
		return this.CUserPhone;
	}

	public void setCUserPhone(String CUserPhone) {
		this.CUserPhone = CUserPhone;
	}

	@Column(name = "C_User_Email", nullable = false, length = 20)
	public String getCUserEmail() {
		return this.CUserEmail;
	}

	public void setCUserEmail(String CUserEmail) {
		this.CUserEmail = CUserEmail;
	}

	@Column(name = "C_User_InsertTime", nullable = false)
	public long getCUserInsertTime() {
		return this.CUserInsertTime;
	}

	public void setCUserInsertTime(long CUserInsertTime) {
		this.CUserInsertTime = CUserInsertTime;
	}

	@Column(name = "C_User_UpdateTime", nullable = false)
	public long getCUserUpdateTime() {
		return this.CUserUpdateTime;
	}

	public void setCUserUpdateTime(long CUserUpdateTime) {
		this.CUserUpdateTime = CUserUpdateTime;
	}

	@Column(name = "C_User_UserInfo_ID", nullable = false)
	public int getCUserUserInfoId() {
		return this.CUserUserInfoId;
	}

	public void setCUserUserInfoId(int CUserUserInfoId) {
		this.CUserUserInfoId = CUserUserInfoId;
	}

	@Column(name = "C_User_LastLoginTime", nullable = false)
	public long getCUserLastLoginTime() {
		return this.CUserLastLoginTime;
	}

	public void setCUserLastLoginTime(long CUserLastLoginTime) {
		this.CUserLastLoginTime = CUserLastLoginTime;
	}

	@Column(name = "C_User_BlueMac", length = 17)
	public String getCUserBlueMac() {
		return this.CUserBlueMac;
	}

	public void setCUserBlueMac(String CUserBlueMac) {
		this.CUserBlueMac = CUserBlueMac;
	}

	@Column(name = "C_User_Active", nullable = false)
	public short getCUserActive() {
		return this.CUserActive;
	}

	public void setCUserActive(short CUserActive) {
		this.CUserActive = CUserActive;
	}

	@Column(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "C_UserInfo_Set_ShareMapAddr")
	public Integer getCUserInfoSetShareMapAddr() {
		return this.CUserInfoSetShareMapAddr;
	}

	public void setCUserInfoSetShareMapAddr(Integer CUserInfoSetShareMapAddr) {
		this.CUserInfoSetShareMapAddr = CUserInfoSetShareMapAddr;
	}

}
