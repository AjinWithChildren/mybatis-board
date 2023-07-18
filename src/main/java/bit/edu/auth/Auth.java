package bit.edu.auth;

import org.apache.ibatis.type.MappedTypes;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public enum Auth implements CodeEnum{

    ADMIN(1, "ADMIN"),
    USER(2, "USER"),
    ;

    private final Integer key;

    private final String value;

    Auth(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }
    @Override
    public String getValue() {
        return value;
    }

    @MappedTypes(Auth.class)
    public static class TypeHandler extends CodeEnumTypeHandler<Auth> {
        public TypeHandler() {
            super(Auth.class);
        }
    }

}
