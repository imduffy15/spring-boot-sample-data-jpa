package sample.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
public class User {

	@Id
	private String username;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}
}
