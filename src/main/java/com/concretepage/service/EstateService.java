package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IEstateDAO;
import com.concretepage.entity.Estate;

@Service
public class EstateService implements IEstateService {

    @Autowired
    private IEstateDAO estateDAO;

    @Override
    public Estate getEstateById(int estateId) {
        Estate obj = estateDAO.getEstateById(estateId);
        return obj;
    }

    @Override
    public List<Estate> getAllEstates() {
        return estateDAO.getAllEstates();
    }

    @Override
    public List<Estate> getAllEstatesPaged(Integer page) {
        return estateDAO.getAllEstatesPaged(page);
    }

    @Override
    public synchronized boolean addEstate(Estate estate) {
            estateDAO.addEstate(estate);
            return true;
    }

    @Override
    public void updateEstate(Estate estate) {
        estateDAO.updateEstate(estate);
    }

    @Override
    public void deleteEstate(int estateId) {
        estateDAO.deleteEstate(estateId);
    }

    @Override
    public List<Estate> searchEstatePaged(Integer page, String place, String startDate, String endDate,String type,Double price,Byte wifi,Byte heating,Byte aircondition,Byte kitchen,Byte parking,Byte elevator){
        return estateDAO.searchEstatePaged(page, place, startDate, endDate, type, price, wifi, heating, aircondition, kitchen, parking, elevator);
    }
    @Override
    public int getCount(){
        return estateDAO.getCount();
    }

    @Override
    public List<String> getEstateTypes(){
        return estateDAO.getEstateTypes();
    }
    @Override
    public List<Estate> getAllByUserID(Integer userId){
        return estateDAO.getAllByUserID(userId);
    }
}
