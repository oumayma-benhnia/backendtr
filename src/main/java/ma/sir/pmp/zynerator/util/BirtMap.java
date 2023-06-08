package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.enumeration.PRAMAMETRE_TYPE;

import java.io.Serializable;

public class BirtMap implements Serializable {
    private String key;
    private Object value;
    private PRAMAMETRE_TYPE type = PRAMAMETRE_TYPE.STRING;

    public BirtMap(String key, Object value, PRAMAMETRE_TYPE type) {

        this.key = key;
        this.value = value;
        this.type = type;
    }

    public BirtMap(String key, Object value) {

        this.key = key;
        this.value = value;
    }

    public BirtMap() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public PRAMAMETRE_TYPE getType() {
        return type;
    }

    public void setType(PRAMAMETRE_TYPE type) {
        this.type = type;
    }
}
