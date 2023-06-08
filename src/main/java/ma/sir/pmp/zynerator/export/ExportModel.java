package ma.sir.pmp.zynerator.export;

import java.io.Serializable;
import java.util.List;

public class ExportModel implements Serializable {

    private String title;

    private List<ColumnModel> columnModels;

    private List<?> list;

    // PDF or XLS
    private String fileType = "pdf";

    public List<ColumnModel> getColumnModels() {
        return columnModels;
    }

    public void setColumnModels(List<ColumnModel> columnModels) {
        this.columnModels = columnModels;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
