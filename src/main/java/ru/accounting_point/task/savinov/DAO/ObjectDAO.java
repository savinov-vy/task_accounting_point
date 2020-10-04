package ru.accounting_point.task.savinov.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;
import ru.accounting_point.task.savinov.util.Converter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Component
public class ObjectDAO {

    private JdbcTemplate jdbcTemplate;


    public ObjectDAO(JdbcTemplate jdbcTemplate) throws SQLException {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ObjRow> getListObjRow() {
        return jdbcTemplate.query("" +
                        " WITH RECURSIVE rec AS(" +
                        " SELECT id, uid, object_type, data, parent_object_id, 1 AS level, CAST(id AS TEXT) AS path                         \n" +
                        " FROM objects WHERE parent_object_id = 0                                                                           \n" +
                        " UNION ALL                                                                                                         \n" +
                        " SELECT o.id, o.uid, o.object_type, o.data, o.parent_object_id, r.level + 1, r.path || ' -> ' || CAST(o.id AS TEXT)\n" +
                        " FROM rec r, objects o                                                                                             \n" +
                        " WHERE o.parent_object_id = r.id)                                                                                  \n" +
                        " SELECT * FROM rec;",
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
            objRow.setLevel(rs.getInt(6));
            objRow.setPath(rs.getString(7));

            return objRow;
        });


    }
}
