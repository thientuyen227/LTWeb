package vn.iotstar.dao;


import vn.iotstar.model.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> findAll();

}