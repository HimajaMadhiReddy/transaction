package com.ucm.transaction.repository;

import com.ucm.transaction.model.Dao.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository  extends MongoRepository<Transaction,String> {

Transaction findByResourceId(UUID resourceId);
List<Transaction> findByCarResourceId(String carResourceId);
List<Transaction> findByPersonResourceId(String personResourceId);
List<Transaction> findByReservationResourceId(String reservationResourceId);
List<Transaction> findByCarResourceIdAndPersonResourceId(String carResourceId, String personResourceId);
List<Transaction> findByPersonResourceIdAndReservationResourceId(String personResourceId, String reservationResourceId);
List<Transaction> findByReservationResourceIdAndCarResourceId(String reservationResourceId, String carResourceId);
List<Transaction> findByPersonResourceIdAndCarResourceIdAndReservationResourceId(String personResourceId,String carResourceId, String reservationResourceId);

}
