package ma.sir.pmp.zynerator.dto;


import java.util.Objects;

public class FileTempDto {

    private String checksumValue;
    private String originalFileName;
    private String fileName;
    private String name;
    private String id;


    public String getChecksumValue() {
        return checksumValue;
    }

    public void setChecksumValue(String checksumValue) {
        this.checksumValue = checksumValue;
    }

    public String getName() {
        return this.originalFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(checksumValue, fileName, id, name, originalFileName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileTempDto other = (FileTempDto) obj;
        return Objects.equals(checksumValue, other.checksumValue) && Objects.equals(fileName, other.fileName)
        && Objects.equals(id, other.id) && Objects.equals(name, other.name)
        && Objects.equals(originalFileName, other.originalFileName);
    }
}