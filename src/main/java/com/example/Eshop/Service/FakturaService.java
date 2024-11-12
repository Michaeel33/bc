package com.example.Eshop.Service;

import com.example.Eshop.Dto.FakturaDto;
import org.springframework.stereotype.Service;

@Service
public interface FakturaService {

    FakturaDto getFakturaHistory(long perId);

}
