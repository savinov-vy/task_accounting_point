package ru.accounting_point.task.savinov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounting_point.task.savinov.DAO.ObjectDAO;
import ru.accounting_point.task.savinov.util.Painter;
import java.util.List;
import java.util.Map;

@Service
public class ObjRowService {
    Painter painter = new Painter();
    private ObjectDAO objectDAO;

    @Autowired
    public ObjRowService(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }

    public List<String> getListObjRow() {
        return painter.paintTree(objectDAO.getMapObjRow());
    }

    public Map<Integer, Long> getMapStatiscsTypeObjRow(){
        return painter.getStatisticsOnTypeNode(objectDAO.getMapObjRow());
    }
}