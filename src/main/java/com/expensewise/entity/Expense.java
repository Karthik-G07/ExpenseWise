package com.expensewise.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenseId;
	
	private String expenseName;
	
	private Double amount ;
	
	private String optionalDescription;
		
	private LocalDate date=LocalDate.now();
	
	@Column(name="created_at",updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at",nullable = false)
	private  LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@PrePersist
	public void oncreated()
	{
		this.createdAt=LocalDateTime.now();
		
		if(this.date==null)
		{
			this.date=LocalDate.now();
		}
		
		
	}
	@PreUpdate
	public void onupdate()
	{
		this.updatedAt=LocalDateTime.now();
	}
}
