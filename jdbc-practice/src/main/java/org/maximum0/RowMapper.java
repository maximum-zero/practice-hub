package org.maximum0;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapper(ResultSet resultSet) throws SQLException;
}
