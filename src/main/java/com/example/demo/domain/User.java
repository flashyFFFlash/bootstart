package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author gxj
 *
 */

@Document(value = "us.user")
public class User implements Serializable {
	private static final long serialVersionUID = 7758266006644687283L;


	private String id;
	private String name;
	private String password;
	private String avatar;
	private Status status;
	private List<Account> accounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	class Account {
		private String id;
		private String name;
		private Date date;
		private Status status;
	}

	enum Status {
		/**
		 * 正常.
		 */
		AVAILABLE,
		/**
		 * 禁用.
		 */
		DISABLE
	}

}
