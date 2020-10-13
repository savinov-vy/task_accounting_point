package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.ObjRow;

import java.util.*;
import java.util.stream.Collectors;

public class Painter {

    public Painter() {
    }

    public List<String> paintTree(Map<Long, ObjRow> objRows) {

        List<List<String>> listWithInnerList = new ArrayList<>();

        for (Map.Entry<Long, ObjRow> entry : objRows.entrySet()) {
            List<String> arrayList = new ArrayList<>(2000);

            String[] forBild = entry.getValue().getPath().split(" -> ");
            List<Integer> nodeTree = new ArrayList<>(convertMasStringToListInt(forBild));
            String str = null;
            for (Integer integer : nodeTree) {
                Long num = Long.valueOf(integer);
                String name = objRows.get(num).getJsonData().getName();
                str = name != null ? name : objRows.get(num).getUid();
                arrayList.add(str);
            }
            listWithInnerList.add(arrayList);
        }
        return convertListInsideListBrancheToArrListStringBranche(listWithInnerList);
    }

    public Map<Integer, Long>  getStatisticsOnTypeNode(Map<Long, ObjRow> objRowMap){
        return objRowMap.values().stream().collect(Collectors.groupingBy(ObjRow::getObject_type, Collectors.counting()));

    }

    private List<Integer> convertMasStringToListInt(String[] args) {
        List<Integer> idEachUserInTreeBranch = Arrays.asList(args).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return idEachUserInTreeBranch;
    }

    private List<String> convertListInsideListBrancheToArrListStringBranche(List<List<String>> listInList) {
        return listInList.stream().map(v -> v.stream().collect(Collectors.joining(" -> "))).collect(Collectors.toList());
    }
}





