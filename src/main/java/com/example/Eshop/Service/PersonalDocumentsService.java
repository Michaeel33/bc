package com.example.Eshop.Service;

import Request.PersonalDocumentRequest;
import com.example.Eshop.Dto.PersonalDocuments;
import org.springframework.stereotype.Service;

@Service
public interface PersonalDocumentsService {
    void savePersonalDocuments(PersonalDocumentRequest personalDocuments);
}