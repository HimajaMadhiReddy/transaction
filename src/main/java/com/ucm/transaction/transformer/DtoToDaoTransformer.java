package com.ucm.transaction.transformer;

import com.ucm.transaction.model.Dao.Transaction;

public class DtoToDaoTransformer {

    public static Transaction DtoToDao(com.ucm.transaction.model.Dto.Transaction transaction){

        Transaction transactionDao = new Transaction();


        transactionDao.setNetAmount(String.valueOf(Integer.parseInt(transaction.getPricePerDay())* Integer.parseInt(transaction.getNumberOfDays())));
        transactionDao.setNumberOfDays(transaction.getNumberOfDays());
        transactionDao.setPersonResourceId(transaction.getPersonResourceId());
        transactionDao.setCarResourceId(transaction.getCarResourceId());
        transactionDao.setTax( String.valueOf(Double.parseDouble(transactionDao.getNetAmount())*0.08));
        transactionDao.setTotalAmount(String.valueOf(Integer.parseInt(transactionDao.getNetAmount()) + Integer.parseInt(transactionDao.getTax())));
        transactionDao.setResourceId(transaction.getResourceId());
        transactionDao.setPricePerDay(transaction.getPricePerDay());
        transactionDao.setReservationResourceId(transaction.getReservationResourceId());

        return transactionDao;

    }
}
