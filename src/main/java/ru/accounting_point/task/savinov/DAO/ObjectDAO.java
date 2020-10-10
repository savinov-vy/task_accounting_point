package ru.accounting_point.task.savinov.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Converter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ObjectDAO {

    private JdbcTemplate jdbcTemplate;


    public ObjectDAO(JdbcTemplate jdbcTemplate) throws SQLException {
        this.jdbcTemplate = jdbcTemplate;
    }


    public LinkedHashMap<Long, ObjRow> getMapObjRow() {
        return jdbcTemplate.query("                                                                                                       " +
                        " WITH RECURSIVE rec AS(" +
                        " SELECT id, uid, object_type, data, parent_object_id, 1 AS level, CAST(id AS TEXT) AS path                         \n" +
                        " FROM objects WHERE parent_object_id = 0                                                                           \n" +
                        " UNION ALL                                                                                                         \n" +
                        " SELECT o.id, o.uid, o.object_type, o.data, o.parent_object_id, r.level + 1, r.path || ' -> ' || CAST(o.id AS TEXT)\n" +
                        " FROM rec r, objects o                                                                                             \n" +
                        " WHERE o.parent_object_id = r.id)                                                                                  \n" +
                        " SELECT * FROM rec;",
                (ResultSetExtractor<LinkedHashMap>) rs -> {
                    LinkedHashMap<Long, ObjRow> answ = new LinkedHashMap<>();

                    while (rs.next()) {
                        try {
                            answ.put(rs.getLong(1), new ObjRow(
                                    rs.getLong(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    Converter.toJavaObject(rs.getString(4)),
                                    rs.getLong(5),
                                    rs.getInt(6),
                                    rs.getString(7)


                            ));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    return answ;
                });

    }


}


       /*             ObjRow objRow = new ObjRow();
            objRow.setId(rs.getLong(1));
            objRow.setUid(rs.getString(2));
            objRow.setObject_type(rs.getInt(3));
            try {
                objRow.setJsonData(Converter.toJavaObject(rs.getString(4)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            objRow.setParent_object_id(rs.getLong(5));
            objRow.setLevel(rs.getInt(6));
            objRow.setPath(rs.getString(7));

            return objRow;
        });

        jdbcTemplate.query("select string1,string2 from table where x=1", new ResultSetExtractor<Map>(){
            @Override
            public Map extractData(ResultSet rs) throws SQLException,DataAccessException {
                HashMap<String,String> mapRet= new HashMap<String,String>();
                while(rs.next()){
                    mapRet.put(rs.getString("string1"),rs.getString("string2"));
                }
                return mapRet;
            }*/

