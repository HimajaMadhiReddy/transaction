package com.ucm.transaction.controller;


import com.ucm.transaction.exceptions.InvalidRequestException;
import com.ucm.transaction.exceptions.ResourceNotFoundException;
import com.ucm.transaction.model.Dto.Transaction;
import com.ucm.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransactionController {

@Autowired
    TransactionService transactionService;
@ResponseBody
@RequestMapping(method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
public Transaction createService(@RequestBody Transaction transaction) throws InvalidRequestException {

    return transactionService.validateCreateRequest(transaction);

}
@ResponseBody
@RequestMapping(value = "/{resourceId}",produces = "application/json")
Transaction getByResourceId(@PathVariable String resourceId) throws InvalidRequestException, ResourceNotFoundException {
    return transactionService.getByResourceId(resourceId);

}

@ResponseBody
@RequestMapping(produces = "application/json")
List<Transaction> searchTransaction (@RequestParam(required = false) String personResourceId,
                                     @RequestParam(required = false) String carResourceId,
                                     @RequestParam(required = false) String  reservationResourceId){


    return transactionService.validateSearchRequest(carResourceId,personResourceId,reservationResourceId);


}

}
