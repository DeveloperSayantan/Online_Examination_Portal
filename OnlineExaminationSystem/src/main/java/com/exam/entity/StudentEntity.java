package com.exam.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "Enter your name")
	@NotBlank(message = "Please Enter your name")
	@Column(length = 50)
	private String name;
	
	@NotNull(message = "Enter your class")
	@NotBlank(message = "PLease Enter your class")
	private String cls;
	
	@NotNull(message = "Enter your email")
	@NotBlank(message = "PLease Enter your email")
	private String email;
	
	@NotNull(message = "Enter your phone no.")
	private Long phone;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "school_id", referencedColumnName = "sId")
	private SchoolEntity school_id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "board_id", referencedColumnName = "bId")
	private BoardEntity board_id;
	
//	@NotNull(message = "Enter your password")
//	@NotBlank(message = "Please Set your Password")
	private String password;
}
