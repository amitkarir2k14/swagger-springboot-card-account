package io.swagger.api;

import io.swagger.model.CardDetails;

import io.swagger.annotations.*;

import io.swagger.model.CardRepository;
import org.ektorp.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-01T18:09:28.587+05:30")

@Controller
public class FetchCardDetailsApiController implements FetchCardDetailsApi {

    private static Class<FetchCardDetailsApiController> applicationClass = FetchCardDetailsApiController.class;

   /* public static void main(String[] args)
    {
        SpringApplication.run(FetchCardDetailsApiController.class, args);
    }*/

    @Autowired
    private CardRepository repository;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> fetchCardsDetailsById(@PathVariable String cardNumber) {
        CardDetails cardDetails = null;
        try {
            cardDetails = repository.get(cardNumber);
        } catch (DocumentNotFoundException ex) {
            return new ResponseEntity<ApplicationError>(
                    new ApplicationError(HttpStatus.NOT_FOUND.value(), "specified ID does not exist"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CardDetails>(cardDetails, HttpStatus.OK);
    }


}
