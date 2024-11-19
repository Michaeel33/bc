package com.example.Eshop.Service.impl;

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

    public FakturaDto getFakturaHistoryByCustomerName(String firstName, String lastName) {

        List<PersonalData> personalDataList = personalDataDao.getPersonalDataByName(firstName, lastName);

        if (personalDataList.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with name: " + firstName + " " + lastName);
        }
        long perId = personalDataList.get(0).getPerId();

        return getFakturaHistory(perId);
    }

    public FakturaDto getFakturaHistoryByCustomerId(String customerId) {
        Long perId = personalDocumentsDao.getPerIdByCustomerId(customerId);

        return getFakturaHistory(perId);
    }
}
