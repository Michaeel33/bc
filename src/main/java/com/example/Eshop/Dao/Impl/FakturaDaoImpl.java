package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.FakturaDao;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Dto.Orders;
import com.example.Eshop.Dto.PersonalData;
import com.example.Eshop.Dto.PersonalDocuments;
import com.example.Eshop.Dto.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class FakturaDaoImpl implements FakturaDao {

    private final PersonalDataDaoImpl personalDataDao;
    private final PersonalDocumentsDaoImpl personalDocumentsDao;
    private final OrdersDaoImpl ordersDao;
    private final ItemsDaoImpl itemsDao;

    @Autowired
    public FakturaDaoImpl(PersonalDataDaoImpl personalDataDao, PersonalDocumentsDaoImpl personalDocumentsDao, OrdersDaoImpl ordersDao, ItemsDaoImpl itemsDao) {
        this.personalDataDao = personalDataDao;
        this.personalDocumentsDao = personalDocumentsDao;
        this.ordersDao = ordersDao;
        this.itemsDao = itemsDao;
    }

    @Override
    public FakturaDto getFaktura(long perId) {
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