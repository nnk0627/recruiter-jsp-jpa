package com.recruitment.team.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Recruiter
 *
 */
@Entity
@NamedQuery(name="Recruiter.getAll",query="select r from Recruiter r")
public class Recruiter implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	public Recruiter() {
		super();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
   
}
