package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<BigInteger, ObjRow> listObjRow = new LinkedHashMap<>();
        listObjRow.put(new BigInteger("4"), new ObjRow(new BigInteger("4"), "UID4", 1, new JsonData("Alex", 32), new BigInteger("0"), 10, "4"));
        listObjRow.put(new BigInteger("2"), new ObjRow(new BigInteger("2"), "UID2", 2, new JsonData("Misha", 32), new BigInteger("4"), 10, "4 -> 2"));
        listObjRow.put(new BigInteger("5"), new ObjRow(new BigInteger("5"), "UID5", 2, new JsonData("Misha2", 32), new BigInteger("4"), 10, "4 -> 5"));
        listObjRow.put(new BigInteger("1"), new ObjRow(new BigInteger("1"), "UID1", 2, new JsonData("Masha", 32), new BigInteger("5"), 10, "4 -> 5 -> 1"));
        listObjRow.put(new BigInteger("3"), new ObjRow(new BigInteger("3"), "UID3", 3, new JsonData(32), new BigInteger("5"), 10, "4 -> 5 -> 3"));
        listObjRow.put(new BigInteger("6"), new ObjRow(new BigInteger("6"), "UID6", 1, new JsonData("Nastya", 32), new BigInteger("2"), 10, "4 -> 2 -> 6"));
        listObjRow.put(new BigInteger("7"), new ObjRow(new BigInteger("7"), "UID7", 3, new JsonData(32), new BigInteger("5"), 10, "4 -> 5 -> 7"));
        listObjRow.put(new BigInteger("9"), new ObjRow(new BigInteger("9"), "UID9", 1, new JsonData("Petya", 32), new BigInteger("2"), 10, "4 -> 2 -> 9"));
        listObjRow.put(new BigInteger("8"), new ObjRow(new BigInteger("8"), "UID8", 1, new JsonData("Petya", 32), new BigInteger("9"), 10, "4 -> 2 -> 9 -> 8"));

        Painter painter = new Painter();

        System.out.println(painter.paintTree(listObjRow));
        System.out.println(painter.getStatisticsOnTypeNode(listObjRow));

    }
}
