package vn.iotstar.service.impl;

import vn.iotstar.dao.TransactionDao;
import vn.iotstar.dao.impl.TransactionDaoImpl;
import vn.iotstar.model.Transaction;
import vn.iotstar.service.transactionService;

import java.util.List;

public class transactionServiceImpl implements transactionService {
	TransactionDao transactionDAO = new TransactionDaoImpl();

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }
}
