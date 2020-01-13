package com.example.demo.domain;

import com.example.demo.enums.Status;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class Account {

	@Id
	private String id;
	private String loginId;
	private String password;
	private Status status;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
	@JoinColumn(name = "user_id")
	private User user;
}
