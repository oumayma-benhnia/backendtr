package ma.sir.pmp.zynerator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ma.sir.pmp.zynerator.bean.BaseEnum;

/**
 * ENUM_STATUT_PROTOCOLEINCLUSION
 *
 * @author JAF
 * @version 1.2
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum STATUT_PROTOCOLEINCLUSION implements BaseEnum {

    PRESCRIPTION("PRESCRIPTION"),
    DEMARRE("DEMARRE"),
    TERMINE("TERMINE"),
    INTERROMPU("INTERROMPU"),
    ANNULE("ANNULE");

    private final String label;

    STATUT_PROTOCOLEINCLUSION(String label) {
        this.label = label;
    }

    @JsonCreator
    public static STATUT_PROTOCOLEINCLUSION forValue(@JsonProperty("name") String value) {
        for (STATUT_PROTOCOLEINCLUSION o : STATUT_PROTOCOLEINCLUSION.values()) {
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