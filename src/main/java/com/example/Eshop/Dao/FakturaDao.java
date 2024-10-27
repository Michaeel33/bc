package com.example.Eshop.Dao;

import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Dto.PersonalData;
import com.example.Eshop.Dto.PersonalDocuments;

public interface FakturaDao {

    PersonalData getPersonalData(long perId);

    FakturaDto getFaktura(long perId);
}
