package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class User {
	@Id
	private long uid;
	private String uname;
	private String password;

	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

}
