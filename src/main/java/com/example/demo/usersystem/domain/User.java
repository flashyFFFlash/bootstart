package com.example.demo.usersystem.domain;

import com.example.demo.usersystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "user")
public class User extends BaseDomainObject {
	private static final long serialVersionUID = 7758266006644687283L;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@NotEmpty(message = "姓名不能为空")
	@Size(min = 2, max = 20)
	@Column(nullable = false, length = 20)
	private String username;
	private String nickname;
	@JsonIgnore
	private String password;
	private String avatar;
	private Status status;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Account> accounts;
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;


}

