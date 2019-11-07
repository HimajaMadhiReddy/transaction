package com.ucm.transaction.service;

import com.ucm.transaction.exceptions.InvalidRequestException;
import com.ucm.transaction.exceptions.ResourceNotFoundException;
import com.ucm.transaction.model.Dto.Transaction;
import com.ucm.transaction.repository.TransactionRepository;
import com.ucm.transaction.transformer.DaoToDtoTransformer;
import com.ucm.transaction.transformer.DtoToDaoTransformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction validateCreateRequest(Transaction transaction) throws InvalidRequestException {


        transaction.setResourceId(UUID.randomUUID());
        if(StringUtils.isBlank(transaction.getPersonResourceId())){
            throw new  InvalidRequestException("Please enter personResourceId");
        }
            try {

                UUID.fromString(transaction.getPersonResourceId());

            }catch (Exception ex){
                throw new InvalidRequestException("please enter valid personResourceId");
            }

            if(StringUtils.isBlank(transaction.getCarResourceId())){
                throw new InvalidRequestException("please enter carResourceId");
            }
            try {
                UUID.fromString(transaction.getCarResourceId());
            }catch (Exception ex){
                throw new InvalidRequestException("please enter valid carResourceId");
            }

            if(StringUtils.isBlank(transaction.getNumberOfDays())){
                throw new InvalidRequestException("please enter numberOfDays");
            }
            try {
                Integer.parseInt(transaction.getNumberOfDays());
            }catch (Exception ex){
                throw new InvalidRequestException("please enter valid integer for numberOfDays");
            }

            if (StringUtils.isBlank(transaction.getPricePerDay())){
                throw new InvalidRequestException("please enter pricePerDay");
            }
            try {
                Double.parseDouble(transaction.getPricePerDay());
            }catch (Exception ex){
                throw  new InvalidRequestException("please enter valid double value for pricePerDay");
            }

        return DaoToDtoTransformer.DaoToDto(transactionRepository.save(DtoToDaoTransformer.DtoToDao(transaction)));

    }

    public Transaction getByResourceId(String resourceId) throws InvalidRequestException, ResourceNotFoundException {

        try {
            UUID.fromString(resourceId);
        }catch (Exception ex){

            throw new InvalidRequestException("please enter valid resourceId"+ resourceId + " entered is Invalid");
        }

        com.ucm.transaction.model.Dao.Transaction transactionDao = transactionRepository.findByResourceId(UUID.fromString(resourceId));

        if (transactionDao == null){
             throw  new ResourceNotFoundException("Transaction with given" + resourceId + " doesn't exist");
        }

        return DaoToDtoTransformer.DaoToDto(transactionDao);

    }

    public List<Transaction> validateSearchRequest(String carResourceId, String personResourceId, String reservationResourceId){

       List<com.ucm.transaction.model.Dao.Transaction> transactions = new ArrayList<>();

       if(!StringUtils.isBlank(carResourceId) && StringUtils.isBlank(personResourceId) && StringUtils.isBlank(reservationResourceId)){

        transactions = transactionRepository.findByCarResourceId(carResourceId);
       }
       if (!StringUtils.isBlank(personResourceId) && StringUtils.isBlank(carResourceId) && StringUtils.isBlank(reservationResourceId)){

           transactions = transactionRepository.findByPersonResourceId(personResourceId);
       }

       if(!StringUtils.isBlank(reservationResourceId) && StringUtils.isBlank(carResourceId) && StringUtils.isBlank(personResourceId)){

           transactions = transactionRepository.findByReservationResourceId(reservationResourceId);
       }
       if(!StringUtils.isBlank(carResourceId) && !StringUtils.isBlank(personResourceId) && StringUtils.isBlank(reservationResourceId)){

           transactions = transactionRepository.findByCarResourceIdAndPersonResourceId(carResourceId, personResourceId);
       }
       if(!StringUtils.isBlank(personResourceId) && !StringUtils.isBlank(reservationResourceId) && StringUtils.isBlank(carResourceId)){

           transactions = transactionRepository.findByPersonResourceIdAndReservationResourceId(personResourceId, reservationResourceId);
       }
       if(!StringUtils.isBlank(reservationResourceId) && !StringUtils.isBlank(carResourceId) && StringUtils.isBlank(personResourceId)){

           transactions = transactionRepository.findByReservationResourceIdAndCarResourceId(reservationResourceId, carResourceId);
       }
       if (!StringUtils.isBlank(personResourceId) && !StringUtils.isBlank(carResourceId) && !StringUtils.isBlank(reservationResourceId)){

           transactions = transactionRepository.findByPersonResourceIdAndCarResourceIdAndReservationResourceId(personResourceId,carResourceId,reservationResourceId);
       }

        return DaoToDtoTransformer.DaoListToDtoList(transactions);

    }
}
