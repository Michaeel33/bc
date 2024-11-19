package com.example.Eshop.Service.impl;

import Request.SearchRequestDto;
import com.example.Eshop.Dao.ItemsDao;
import com.example.Eshop.Dao.OrdersDao;
import com.example.Eshop.Dao.PersonalDataDao;
import com.example.Eshop.Dao.PersonalDocumentsDao;
import com.example.Eshop.Dto.*;
import com.example.Eshop.Exception.CustomerNotFoundException;
import com.example.Eshop.Service.FakturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FakturaServiceImpl  implements FakturaService {

    @Autowired
    private final PersonalDataDao personalDataDao;
    @Autowired
    private final PersonalDocumentsDao personalDocumentsDao;
    @Autowired
    private final OrdersDao ordersDao;
    @Autowired
    private final ItemsDao itemsDao;

    @Override
    public FakturaDto getFakturaHistory(long perId) {
        FakturaDto fakturaDto = new FakturaDto();
        PersonalData personalDataDto = personalDataDao.getPersonalData(perId);
        PersonalDocuments personalDocuments = personalDocumentsDao.getPersonalDoc(perId);
        List<Orders> ordersList = ordersDao.getOrdersForPerId(perId);

        for (Orders order : ordersList) {
            List<Items> itemList = itemsDao.getItemsForOrder(order.getOrderNumber());
            order.setOrderedItems(itemList);
        }

        fakturaDto.setPersId(perId);
        fakturaDto.setPersonalData(personalDataDto);
        fakturaDto.setPersonalDocuments(personalDocuments);
        fakturaDto.setOrdersList(ordersList);

        return fakturaDto;
    }

    @Override
    public List<FakturaDto> searchFaktura(SearchRequestDto searchRequest) {
        String paramForSearch = searchRequest.getParamForSearch();
        String value = searchRequest.getValue();

        if ("name".equalsIgnoreCase(paramForSearch)) {
            String[] names = value.split(" ");
            if (names.length == 2) {
                return getFakturaHistoryByCustomerName(names[0], names[1]);
            } else {
                throw new IllegalArgumentException("Invalid name format. Expected 'firstName lastName'.");
            }
        } else if ("customerId".equalsIgnoreCase(paramForSearch)) {
            List<FakturaDto> result = new ArrayList<>();
            result.add(getFakturaHistoryByCustomerId(value));
            return result;
        } else {
            throw new IllegalArgumentException("Invalid paramForSearch. Expected 'name' or 'customerId'.");
        }
    }


    @Override
    public List<FakturaDto> getFakturaHistoryByCustomerName(String firstName, String lastName) {
        List<PersonalData> personalDataList = personalDataDao.getPersonalDataByName(firstName, lastName);

        if (personalDataList.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with name: " + firstName + " " + lastName);
        }

        List<FakturaDto> fakturaDtoList = new ArrayList<>();
        for (PersonalData personalData : personalDataList) {
            long perId = personalData.getPerId();
            fakturaDtoList.add(getFakturaHistory(perId));
        }

        return fakturaDtoList;
    }

    @Override
    public FakturaDto getFakturaHistoryByCustomerId(String customerId) {
        Long perId = personalDocumentsDao.getPerIdByCustomerId(customerId);

        return getFakturaHistory(perId);
    }
}
