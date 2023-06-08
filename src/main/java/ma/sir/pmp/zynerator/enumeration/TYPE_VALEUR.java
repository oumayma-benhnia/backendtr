package ma.sir.pmp.zynerator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ma.sir.pmp.zynerator.bean.BaseEnum;

/**
 * ENUM_TYPE_VALEUR
 *
 * @author JAF
 * @version 1.2
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TYPE_VALEUR implements BaseEnum {

    TEXT("Texte"),
    BOOLEAN("Boolean (OUI/NON)");

    private final String label;

    TYPE_VALEUR(String label) {
        this.label = label;
    }

    @JsonCreator
    public static TYPE_VALEUR forValue(@JsonProperty("name") String value) {
        for (TYPE_VALEUR o : TYPE_VALEUR.values()) {
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