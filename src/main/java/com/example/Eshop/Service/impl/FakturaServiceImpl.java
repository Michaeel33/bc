package com.example.Eshop.Service.impl;

import com.example.Eshop.Dao.FakturaDao;
import com.example.Eshop.Dao.Impl.ItemsDao;
import com.example.Eshop.Dao.OrdersDao;
import com.example.Eshop.Dao.PersonalDataDao;
import com.example.Eshop.Dao.PersonalDocumentsDao;
import com.example.Eshop.Dto.*;
import com.example.Eshop.Service.FakturaService;
import jakarta.annotation.PostConstruct;
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
}
