package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.ObjRow;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Painter {

    public Painter() {
    }

    public List<String> paintTree(Map<BigInteger, ObjRow> objRows) {

        List<List<String>> listWithInnerList = new ArrayList<>();

        for (Map.Entry<BigInteger, ObjRow> entry : objRows.entrySet()) {
            List<String> arrayList = new ArrayList<>(2000);

            String[] forBild = entry.getValue().getPath().split(" -> ");
            List<BigInteger> nodeTree = new ArrayList<BigInteger>(convertMasStringToListBigInt(forBild));
            String str = null;
            for (BigInteger bigInteger : nodeTree) {
                String name = objRows.get(bigInteger).getJsonData().getName();
                str = name != null ? name : objRows.get(bigInteger).getUid();
                arrayList.add(str);
            }
            listWithInnerList.add(arrayList);
        }
        return convertListInsideListBrancheToArrListStringBranche(listWithInnerList);
    }

    public Map<Integer, Long>  getStatisticsOnTypeNode(Map<BigInteger, ObjRow> objRowMap){
        return objRowMap.values().stream().collect(Collectors.groupingBy(ObjRow::getObject_type, Collectors.counting()));

    }

    private List<BigInteger> convertMasStringToListBigInt(String[] args) {
        List<BigInteger> bigIntegerIdList = Arrays.stream(args).map(BigInteger::new).collect(Collectors.toList());
        return bigIntegerIdList;
    }

    private List<String> convertListInsideListBrancheToArrListStringBranche(List<List<String>> listInList) {
        return listInList.stream().map(v -> v.stream().collect(Collectors.joining(" -> "))).collect(Collectors.toList());
    }
}





