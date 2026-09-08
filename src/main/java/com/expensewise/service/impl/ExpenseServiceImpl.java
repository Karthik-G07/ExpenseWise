package com.expensewise.service.impl;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.expensewise.Requestdto.ExpenseRequestDTO;
import com.expensewise.entity.Expense;
import com.expensewise.entity.User;
import com.expensewise.repository.ExpenseRepository;
import com.expensewise.repository.UserRepository;
import com.expensewise.responsedto.ExpenseResponseDTO;
import com.expensewise.service.ExpenseService;


@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository exprepo;
	 
	@Autowired
	private  ModelMapper mapper;
	
	@Autowired
	private UserRepository urepo;

	@Override
	public ExpenseResponseDTO addExpense(ExpenseRequestDTO req) {
		// TODO Auto-generated method stub
		
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		
		User user =(User)authentication.getPrincipal();
		
		Expense expense=mapper.map(req,Expense.class);
		
		expense.setUser(user);
		
	Expense savedExpense=exprepo.save(expense);
		
		return mapper.map(savedExpense,ExpenseResponseDTO.class);
	}

	@Override
	public List<ExpenseResponseDTO> allExpense() {
		// TODO Auto-generated method stub
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		User user=(User)auth.getPrincipal();
		
		List<ExpenseResponseDTO> allexp=new ArrayList<>();
		
	List<Expense> expenses=	exprepo.findByUser(user);
	
		
	for(Expense expense:expenses)	
	{
		ExpenseResponseDTO res=	mapper.map(expense, ExpenseResponseDTO.class);
		allexp.add(res);
	}
	
		return allexp;
	}

	@Override
	public ExpenseResponseDTO getExpenseById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteExpenseById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO req) {
		// TODO Auto-generated method stub
		return null;
	}
	
}