package uz.yasmintour.yasmintour.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.yasmintour.yasmintour.dto.MessageDto;
import uz.yasmintour.yasmintour.service.EmailService;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @CrossOrigin(value = "*")
    @PostMapping("/send-email")
    public ResponseEntity<Map> sendMail(@RequestBody MessageDto details) {
        System.out.println(details);
        return ResponseEntity.ok(Map.of("message",emailService.sendSimpleMail(details)));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
