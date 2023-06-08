package ma.sir.pmp.zynerator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ma.sir.pmp.zynerator.bean.BaseEnum;

/**
 * ENUM_PRAMAMETRE_TYPE
 *
 * @author JAF
 * @version 1.2
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PRAMAMETRE_TYPE implements BaseEnum {

    STRING("String"),
    DATE("Date"),
    DATETIME("DateTime"),
    INTEGER("Integer"),
    DOUBLE("Double"),
    BOOLEAN("Boolean");

    private final String label;

    PRAMAMETRE_TYPE(String label) {
        this.label = label;
    }

    @JsonCreator
    public static PRAMAMETRE_TYPE forValue(@JsonProperty("name") String value) {
        for (PRAMAMETRE_TYPE o : PRAMAMETRE_TYPE.values()) {
            if (o.name().equals(value)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String getDisplayText() {
        return this.label;
    }

    @Override
    public String toString() {

        return getName();
    }
}