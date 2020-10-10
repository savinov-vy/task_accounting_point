package ru.accounting_point.task.savinov.util;

import ru.accounting_point.task.savinov.entities.ObjRow;

import java.util.*;

public class Painter {


    public Painter() {
    }


    public void paintTree(Map<Long, ObjRow> objRows) {
        String string = new String();

        ArrayList<String> arrayList = new ArrayList<>(30000);


        for (Map.Entry<Long, ObjRow> entry : objRows.entrySet()) {
            String[] forBild = entry.getValue().getPath().split(" -> ");


 /*           for (Long str : Long.parseLong(forBild)) {
                string += str;

            }*/
      //      System.out.println(string);
       string += "-";
            arrayList.add(string);
            string = "";

        }
        System.out.println(arrayList);


        //       return rowTree;

    }
    public int[] convertMasStringToMasInt(String[] args){
        int[] array = Arrays.asList(args).stream().mapToInt(Integer::parseInt).toArray();
        return array;
        }
    }

//            pathOnTree.append(objRow.getPath());return Arrays.stream(unsorted)
//             .map(BigSorting2::convertFromStringToBigInteger)
//             .toArray(BigInteger[]::new);


//            rowTree.add(pathOnTree);
//            pathOnTree.delete(0, objRow.getPath().length());


//            String[] pathOnTreeMas = objRow.getPath().split(" -> ");
//
//            for (String idObjRowStr : pathOnTreeMas) {
//                idObjRow += idObjRow;

    //   Long idObjRowNum = Long.parseLong(idObjRowStr);
    //  pathOnTree.append(objRows.get(idObjRowNum).getJsonData().getName() != null ? objRows.get(idObjRowNum).getJsonData().getName() : objRows.get(idObjRowNum).getUid());
    //   pathOnTree.append(" -> ");
//
//            }
//
//            rowTree.add(pathOnTree);
//
//            pathOnTree.substring(0);





