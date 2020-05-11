package com.example.demo.usersystem.domain;

import com.example.demo.usersystem.enums.Status;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class Account extends BaseDomainObject {

	private String loginId;
	private Status status;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "user_id")
	private User user;
}
