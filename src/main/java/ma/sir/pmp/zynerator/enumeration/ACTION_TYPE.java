package ma.sir.pmp.zynerator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ma.sir.pmp.zynerator.bean.BaseEnum;

/**
 * ENUM_ACTION_TYPE
 *
 * @author JAF
 * @version 1.2
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ACTION_TYPE implements BaseEnum {

    ADD("Ajout"),
    UPDATE("Modification"),
    DELETE("Suppression");

    private final String label;

    ACTION_TYPE(String label) {
        this.label = label;
    }

    @JsonCreator
    public static ACTION_TYPE forValue(@JsonProperty("name") String value) {
        for (ACTION_TYPE o : ACTION_TYPE.values()) {
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