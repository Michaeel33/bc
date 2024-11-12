package com.example.Eshop.Service.impl;

import com.example.Eshop.Dao.FakturaDao;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Service.FakturaService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FakturaServiceImpl  implements FakturaService {

    @Autowired
    private final FakturaDao fakturaDao;


    @Override
    public FakturaDto getFakturaHistory(long perId) {
        return fakturaDao.getFaktura(perId);
    }
}
