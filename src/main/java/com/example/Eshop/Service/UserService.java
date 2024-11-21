package com.example.Eshop.Service;

import com.example.Eshop.Dto.PersonalData;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void savePersonalData(PersonalData personalData);

}
