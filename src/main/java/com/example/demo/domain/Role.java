package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Role extends BaseDomainObject {

	private static final long serialVersionUID = 344446440276883516L;
	public static final String ADMIN_ROLE_ID = "628971b6af614f1890fd84d39f726bdf";

	private String name;
	@Column(name = "[desc]")
	private String desc;
	private String code;


}
