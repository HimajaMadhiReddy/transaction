package com.ucm.transaction.transformer;

import com.ucm.transaction.model.Dto.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DaoToDtoTransformer {

    public static Transaction DaoToDto(com.ucm.transaction.model.Dao.Transaction transaction){

        Transaction transactionDto = new Transaction();
        transactionDto.setNumberOfDays(transaction.getNumberOfDays());
        transactionDto.setCarResourceId(transaction.getCarResourceId());
        transactionDto.setPersonResourceId(transaction.getPersonResourceId());
        transactionDto.setResourceId(transaction.getResourceId());
        transactionDto.setPricePerDay(transaction.getPricePerDay());
        transactionDto.setReservationResourceId(transaction.getReservationResourceId());


        return transactionDto;
    }

    public static List<Transaction> DaoListToDtoList(List<com.ucm.transaction.model.Dao.Transaction> transactions){

        List<Transaction>  transactionsDto =new ArrayList<>();

        for (com.ucm.transaction.model.Dao.Transaction transaction:transactions){

            transactionsDto.add(DaoToDto(transaction));

        }

        return transactionsDto;

    }
}
