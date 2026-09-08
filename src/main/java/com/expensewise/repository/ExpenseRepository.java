package com.expensewise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensewise.entity.Expense;
import com.expensewise.entity.User;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

	List<Expense> findByUser(User user);
}
