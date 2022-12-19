package vn.iotstar.service;

import vn.iotstar.model.Transaction;
import java.util.List;

public interface transactionService {
	List<Transaction> findAll();
}
