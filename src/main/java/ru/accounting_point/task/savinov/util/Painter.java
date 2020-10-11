package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.ObjRow;
import java.util.*;
import java.util.stream.Collectors;

public class Painter {


    public Painter() {
    }


    public ArrayList<String> paintTree(Map<Long, ObjRow> objRows) {

        ArrayList<ArrayList<String>> arrayListsTree = new ArrayList<>();

        for (Map.Entry<Long, ObjRow> entry : objRows.entrySet()) {
            ArrayList<String> arrayList = new ArrayList<>(2000);

            String[] forBild = entry.getValue().getPath().split(" -> ");
            ArrayList<Integer> nodeTree = new ArrayList<>(convertMasStringToMasInt(forBild));
            String str = new String();
            for (Integer integer : nodeTree) {
                Long num = (long) integer;
                String name = objRows.get(num).getJsonData().getName();

                if (name != null) str = name;
                else str = objRows.get(num).getUid();
                arrayList.add(str);
            }
            arrayListsTree.add(arrayList);
        }

        return convertArrListMasstoArrListString(arrayListsTree);
    }

    public List<Integer> convertMasStringToMasInt(String[] args) {
        List<Integer> array = Arrays.asList(args).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        return array;
    }


    public ArrayList<String> convertArrListMasstoArrListString(ArrayList<ArrayList<String>> listInList) {
        ArrayList<String> listString = new ArrayList<>();
        for (ArrayList<String> list : listInList) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (list.size() - 1 > i) stringBuilder.append(" -> ");
            }
            String string = new String(stringBuilder);
            listString.add(string);
        }
        return listString;
    }


}





