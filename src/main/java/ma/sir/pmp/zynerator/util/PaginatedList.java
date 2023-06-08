package ma.sir.pmp.zynerator.util;

import java.io.Serializable;
import java.util.List;

public class PaginatedList implements Serializable {

    private List<?> list;

    private int dataSize = 0;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

}
