package ru.accounting_point.task.savinov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounting_point.task.savinov.DAO.ObjectDAO;
import ru.accounting_point.task.savinov.entities.ObjRow;

import java.util.List;

@Service
public class ObjRowService {


    private ObjectDAO objectDAO;

    @Autowired
    public ObjRowService(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    public List<ObjRow> getListObjRow() {
        return objectDAO.getListObjRow();
    }

}