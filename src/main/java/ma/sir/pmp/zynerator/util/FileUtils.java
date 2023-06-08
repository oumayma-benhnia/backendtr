package ma.sir.pmp.zynerator.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileUtils {


    public static boolean isFileExist(String filepath, String fileName) {

        File file = new File(filepath + fileName);
        return file.exists();

    }

    public static File getFileExistInTempDir(String filepath, String fileName) {

        File file = new File(filepath + fileName);
        if (file.exists()) {
            return file;
        } else {
            file = new File(filepath + fileName + ".ok");
            if (file.exists())
                return file;
        }

        return null;

    }

    public static String saveFile(String tempDir, String dataDir, String fileName, String filepath, String prefix) throws Exception {
        File old = getFileExistInTempDir(tempDir, fileName);
        if (old != null) {
            String newName = prefix + "_" + DateUtil.dateFormatFichier() + randomId() + getExtension(old.getName());
            filepath = filepath + "/" + newName;
            File file = new File(dataDir + filepath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            copyFile(old, file);
            renameTempFile(tempDir, old.getName());
            return filepath;
        }
        return null;
    }

    public static void renameTempFile(String temp, String fileName) throws Exception {
        File file = new File(temp + fileName);
        if (file.exists() && !file.getName().toLowerCase().endsWith(".ok")) {
            File newFile = new File(temp + fileName + ".ok");
            file.renameTo(newFile);
        }
    }

    public static byte[] fileToByte(File file) throws Exception {
        return null;
        //return org.apache.commons.io.FileUtils.readFileToByteArray(file);
    }

    public static String getExtension(String fileName) {

        String extention = "";
        if (fileName.toLowerCase().endsWith(".ok"))
            fileName = fileName.replace(".ok", "");
        extention = fileName.substring(fileName.lastIndexOf("."));

        return extention;
    }

    public static String getFileName(String fileName) {

        String name = fileName;
        name = fileName.substring(0, fileName.indexOf("."));

        return name;
    }

    private static String randomId() {
        String uid = String.valueOf(UniqueID.get());

        return uid.substring(uid.length() - 4);
    }

    private static void copyFile(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}