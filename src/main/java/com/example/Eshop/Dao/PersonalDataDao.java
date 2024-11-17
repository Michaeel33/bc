package com.example.Eshop.Dao;

import com.example.Eshop.Dto.PersonalData;

import java.util.List;


public interface PersonalDataDao {
    PersonalData getPersonalData(long perId);

    List<PersonalData> getPersonalDataByName(String firstName, String lastName);
}