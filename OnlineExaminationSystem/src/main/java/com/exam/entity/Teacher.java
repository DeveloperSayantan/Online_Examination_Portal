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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;

	@NotNull(message = "Enter your name")
	@NotBlank(message = "Please Enter your name")
	@Column(length = 50)
    private String name;
	
	private String subject;

    @NotNull(message = "Enter your email")
	@NotBlank(message = "PLease Enter your email")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Enter your phone no.")
    private Long phone;

    @NotNull(message = "Enter your password")
    @NotBlank(message = "Password cannot be blank")
    private String password;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "school_id", referencedColumnName = "sId", nullable= false)
	private SchoolEntity school_id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "board_id", referencedColumnName = "bId", nullable = false)
	private BoardEntity board_id;
}
