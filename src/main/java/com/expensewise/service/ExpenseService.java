package com.expensewise.service;

import java.util.List;

import com.expensewise.Requestdto.ExpenseRequestDTO;
import com.expensewise.responsedto.ExpenseResponseDTO;


public interface ExpenseService {

	public ExpenseResponseDTO addExpense( ExpenseRequestDTO req);
	
	public List<ExpenseResponseDTO> allExpense();
	
	public ExpenseResponseDTO getExpenseById(Long id);
	
	public void deleteExpenseById(Long id);
	
	public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO req);
}
