package com.expensewise.Requestdto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ExpenseRequestDTO {

	@NotBlank(message = "expense is required")
	private String expenseName;
	
	 @NotNull(message = "Amount is required")
@Positive(message = "Amount must be greater than 0")
	private Double amount;
	
	private String optionalDescription;
	
	private LocalDate date;
	
}
