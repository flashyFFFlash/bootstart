package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 7758266006644687283L;

	@Id
	private String id;
	private String name;
	private String password;
	private String avatar;
	private Status status;
//	private List<Account> accounts;

	@Data
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

