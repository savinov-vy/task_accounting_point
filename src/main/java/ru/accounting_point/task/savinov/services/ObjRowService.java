package ru.accounting_point.task.savinov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounting_point.task.savinov.DAO.ObjectDAO;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Painter;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ObjRowService {
    Painter painter = new Painter();
    private ObjectDAO objectDAO;
    private LinkedHashMap<BigInteger, ObjRow> objRowMap;

    @Autowired
    public ObjRowService(ObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }
    public List<String> getListObjRow() {
        objRowMap = objectDAO.getMapObjRow();
        return painter.paintTree(objRowMap);
    }

    public Map<Integer, Long> getMapStatiscsTypeObjRow(){
        return painter.getStatisticsOnTypeNode(objRowMap);
    }
}