package com.example.Eshop.Dao;

import Request.PersonalDocumentRequest;
import com.example.Eshop.Dto.PersonalDocuments;

public interface PersonalDocumentsDao {
    PersonalDocuments getPersonalDoc(long perId);

    Long getPerIdByCustomerId(String customerId);
    void savePersonalDocuments(PersonalDocumentRequest personalDocuments);
}