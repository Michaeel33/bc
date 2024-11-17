package com.example.Eshop.Dao;

import com.example.Eshop.Dto.PersonalDocuments;

public interface PersonalDocumentsDao {
    PersonalDocuments getPersonalDoc(long perId);

    Long getPerIdByCustomerId(String customerId);
}