package com.example.Eshop.Controller;

import Request.PersonalDocumentRequest;
import com.example.Eshop.Dto.PersonalDocuments;
import com.example.Eshop.Service.PersonalDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class PersonalDocumentsController {

    private final PersonalDocumentsService personalDocumentsService;

    @Autowired
    public PersonalDocumentsController(PersonalDocumentsService personalDocumentsService) {
        this.personalDocumentsService = personalDocumentsService;
    }

    @PostMapping("/newDocument")
    public void savePersonalDocuments(@RequestBody PersonalDocumentRequest personalDocuments) {
        personalDocumentsService.savePersonalDocuments(personalDocuments);
    }
}