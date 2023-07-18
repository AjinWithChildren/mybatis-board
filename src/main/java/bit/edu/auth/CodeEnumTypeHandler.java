package bit.edu.auth;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> implements TypeHandler<CodeEnum> {

    private final Class<E> type;
    private final E[] enumConstants;

    public CodeEnumTypeHandler(Class<E> type) {
        if (Objects.isNull(type)) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.enumConstants = type.getEnumConstants();

        if (!type.isInterface() && Objects.isNull(enumConstants)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return getCodeEnum(rs.getString(columnName));
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getCodeEnum(cs.getString(columnIndex));
    }

    public CodeEnum getCodeEnum(String code) {
        return Arrays.stream(enumConstants)
            .filter(e -> e.getValue().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
