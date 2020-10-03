package ru.accounting_point.task.savinov.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.accounting_point.task.savinov.entities.JsonData;
import ru.accounting_point.task.savinov.entities.ObjRow;

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

    public List<ObjRow> getListObjRow() {
       List<ObjRow> objRow = new ArrayList<>();
       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjaak", 25), 22L));
       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjkk", 22), 23L));
       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjnjnk", 27), 24L));
       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjbbhk", 25), 25L));
       objRow.add(new ObjRow(1L, "15L", 11,new JsonData("kjk", 25), 25L));
            return objRow;
        }

//    public List<ObjRow> getListObjRow() {
//        return jdbcTemplate.query("select * from objects",(rs, rowNum) -> {
//            ObjRow objRow = new ObjRow();
//            ObjectMapper objectMapper = new ObjectMapper();
//            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//            objRow.setId(rs.getLong(1));
//            objRow.setUid(rs.getString(2));
//            objRow.setObject_type(rs.getInt(3));
//            String jsonString = rs.getString(4);
//            objRow.setJsonData(objectMapper.convertValue(jsonString));
//            objRow.setParent_object_id(rs.getLong(4));
//            System.out.println(objRow);
//            return objRow;
//        });


//    }
}
