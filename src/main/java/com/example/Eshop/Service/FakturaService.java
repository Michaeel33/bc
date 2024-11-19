package com.example.Eshop.Service;

import Request.SearchRequestDto;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Dto.PersonalData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FakturaService {

    FakturaDto getFakturaHistory(long perId);
    List<FakturaDto> searchFaktura(SearchRequestDto searchRequest);
    List<FakturaDto> getFakturaHistoryByCustomerName(String firstName, String lastName);
    FakturaDto getFakturaHistoryByCustomerId(String customerId);

}
