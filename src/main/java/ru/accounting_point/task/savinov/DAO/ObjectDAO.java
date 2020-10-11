package ru.accounting_point.task.savinov.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Converter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

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


