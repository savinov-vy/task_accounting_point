package ru.accounting_point.task.savinov.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Converter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ObjectDAO(JdbcTemplate jdbcTemplate) throws SQLException {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<ObjRow> getListObjRow() {
//       List<ObjRow> objRow = new ArrayList<>();
//       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjaak", 25), 22L));
//       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjkk", 22), 23L));
//       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjnjnk", 27), 24L));
//       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjbbhk", 25), 25L));
//       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjk", 25), 25L));
//            return objRow;
//        }

    public List<ObjRow> getListObjRow() {
        return jdbcTemplate.query("WITH RECURSIVE r AS (                                                \n" +
                "SELECT id, uid, object_type, data, parent_object_id                                        \n" +
                "FROM objects WHERE parent_object_id = 0                                                    \n" +
                "UNION                                                                                      \n" +
                "SELECT objects.id, objects.uid, objects.object_type, objects.data, objects.parent_object_id\n" +
                "FROM objects JOIN r ON r.id = objects.parent_object_id                                     \n" +
                ")                                                                                          \n" +
                "                                                                                           \n" +
                "SELECT r.id, r.uid, r.object_type, r.data, r.parent_object_id FROM r ORDER BY r.parent_object_id;",
                (rs, rowNum) -> {
            ObjRow objRow = new ObjRow();
            objRow.setId(rs.getLong(1));
            objRow.setUid(rs.getString(2));
            objRow.setObject_type(rs.getInt(3));
            try {
                objRow.setJsonData(Converter.toJavaObject(rs.getString(4)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            objRow.setParent_object_id(rs.getLong(5));
            System.out.println(objRow);
            return objRow;
        });


    }
}
