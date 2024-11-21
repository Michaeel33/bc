package com.example.Eshop.Service.impl;

import com.example.Eshop.Dao.PersonalDataDao;
import com.example.Eshop.Dto.PersonalData;
import com.example.Eshop.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final PersonalDataDao personalDataDao;

    @Override
    public void savePersonalData(PersonalData personalData) {
        personalDataDao.savePersonalData(personalData);
    }


}
