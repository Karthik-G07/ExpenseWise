package com.expensewise.responsedto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExpenseResponseDTO {

	private Long expenseId;
	
	private String expenseName;
	
	private Double amount ;
	
	private String optionalDescription;
		
	private LocalDate date;
	private LocalDateTime createdAt;
	
	private  LocalDateTime updatedAt;
}
