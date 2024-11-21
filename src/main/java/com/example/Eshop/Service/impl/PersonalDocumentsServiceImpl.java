package com.example.Eshop.Service.impl;

import Request.PersonalDocumentRequest;
import com.example.Eshop.Dao.PersonalDocumentsDao;
import com.example.Eshop.Dto.PersonalDocuments;
import com.example.Eshop.Service.PersonalDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonalDocumentsServiceImpl implements PersonalDocumentsService {

    @Autowired
    private final PersonalDocumentsDao personalDocumentsDao;

    @Override
    public void savePersonalDocuments(PersonalDocumentRequest personalDocumentsRequest) {
        PersonalDocumentRequest personalDocuments = new PersonalDocumentRequest();
        personalDocuments.setPerId(personalDocumentsRequest.getPerId());
        personalDocuments.setCustomerId(personalDocumentsRequest.getCustomerId());
        personalDocuments.setCountry(personalDocumentsRequest.getCountry());
        personalDocuments.setVerified(personalDocumentsRequest.getIsVerified());

        personalDocumentsDao.savePersonalDocuments(personalDocuments);
    }
}