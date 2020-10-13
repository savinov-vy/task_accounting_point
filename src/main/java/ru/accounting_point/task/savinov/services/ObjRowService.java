package ru.accounting_point.task.savinov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounting_point.task.savinov.DAO.ObjectDAO;
import ru.accounting_point.task.savinov.util.Painter;
import java.util.List;

@Service
public class ObjRowService {

    private ObjectDAO objectDAO;

    @Autowired
    public ObjRowService(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    public List<String> getListObjRow() {
        Painter painter = new Painter();
        return painter.paintTree(objectDAO.getMapObjRow());
    }

}