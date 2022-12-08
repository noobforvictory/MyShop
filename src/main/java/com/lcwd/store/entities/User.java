package com.lcwd.store.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity //important
@Table(name = "jpa_users") //optional

public class User {
	
	@Id //important (specifies primary key)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id") //optional (it takes parameter name as column by default if name not provided)
	private String id;
	
	@Column(name = "user_name",length = 100,nullable = false)
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	private String gender;
	
	private Date dob;
	

}
