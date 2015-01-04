package sample.data.jpa.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_DOG")
@NamedQueries({
		@NamedQuery(name="Dog.findAllForUser", query="select d from Dog d where ?1 MEMBER OF d.owners"),
		@NamedQuery(name="Dog.findOneForUser", query="select d from Dog d where ?1 MEMBER OF d.owners and d.id = ?2")
})
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Size(min = 1, max = 50)
	@Column(name = "description", length = 50)
	private String name;


	@OrderBy
	@JoinTable(
			name = "T_DOG_OWNER",
			joinColumns = {@JoinColumn(name = "dog_id", referencedColumnName = "id")},
			inverseJoinColumns = {
					@JoinColumn(name = "username", referencedColumnName = "username")})
	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<User> owners = new ArrayList<User>();

	public Dog() {
	}

	public Dog(String name, List<User> owners) {
		this.name = name;
		this.owners = owners;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Dog named " + name + " with owners " + owners.toString();
	}
}
