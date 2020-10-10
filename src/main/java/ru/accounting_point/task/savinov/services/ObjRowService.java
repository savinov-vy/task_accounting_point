package ru.accounting_point.task.savinov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounting_point.task.savinov.DAO.ObjectDAO;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Painter;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjRowService {


    private ObjectDAO objectDAO;

    @Autowired
    public ObjRowService(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    public List<StringBuilder> getListObjRow() {
        Painter painter = new Painter();

        StringBuilder stringBuilder = new StringBuilder();
        List<StringBuilder> stringBuilders = new ArrayList<>();
      //  return painter.paintTree(objectDAO.getMapObjRow());
        return stringBuilders;
    }

}