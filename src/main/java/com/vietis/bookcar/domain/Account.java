package com.vietis.bookcar.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private int accountID;
	
	@NotNull(message="Cần nhập username")
	@Column(name = "username")
	private String username;
	
	@NotNull(message="Cần nhập Password")
	@Length(min=5, message="Password cần ít nhất 5 kí tự")
	@Column(name = "password")
	private String password;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String username, String password, String role) {
		super();
		this.accountID = id;
		this.username = username;
		this.password = password;
	}

	

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "account_role_pk", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
