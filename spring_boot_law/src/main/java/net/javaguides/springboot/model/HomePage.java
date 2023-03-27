package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "user_queries")
public class HomePage {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "query_text")
	private String queryText;
	
	@Column(name = "query_doc_uri")
	private String queryDocUri;
	
	public HomePage() {
		
	}
	
	public HomePage(String firstName, String lastName, String email, String queryText, String queryDocUri) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.queryText = queryText;
		this.queryDocUri = queryDocUri;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public String getQueryDocUri() {
		return queryDocUri;
	}
	public void setQueryDocUri(String queryDocUri) {
		this.queryDocUri = queryDocUri;
	}


}
