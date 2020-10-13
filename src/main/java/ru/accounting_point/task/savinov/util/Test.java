package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<Long, ObjRow> listObjRow = new LinkedHashMap<>();

        listObjRow.put(4L, new ObjRow(4L, "UID4", 1, new JsonData("Alex", 32), 0L, 10, "4"));
        listObjRow.put(2L, new ObjRow(2L, "UID2", 2, new JsonData("Misha", 32), 4L, 10, "4 -> 2"));
        listObjRow.put(5L, new ObjRow(5L, "UID5", 2, new JsonData("Misha2", 32), 4L, 10, "4 -> 5"));
        listObjRow.put(1L, new ObjRow(1L, "UID1", 2, new JsonData("Masha", 32), 5L, 10, "4 -> 5 -> 1"));
        listObjRow.put(3L, new ObjRow(3L, "UID3", 3, new JsonData(32), 5L, 10, "4 -> 5 -> 3"));
        listObjRow.put(6L, new ObjRow(6L, "UID6", 1, new JsonData("Nastya", 32), 2L, 10, "4 -> 2 -> 6"));
        listObjRow.put(7L, new ObjRow(7L, "UID7", 3, new JsonData(32), 5L, 10, "4 -> 5 -> 7"));
        listObjRow.put(9L, new ObjRow(9L, "UID9", 1, new JsonData("Petya", 32), 2L, 10, "4 -> 2 -> 9"));
        listObjRow.put(8L, new ObjRow(8L, "UID8", 1, new JsonData("Petya", 32), 9L, 10, "4 -> 2 -> 9 -> 8"));

        Painter painter = new Painter();

        painter.paintTree(listObjRow);
        System.out.println(painter.getStatisticsOnTypeNode(listObjRow));

    }
}
