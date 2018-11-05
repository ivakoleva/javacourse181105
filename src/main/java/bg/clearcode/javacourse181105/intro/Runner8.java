package bg.clearcode.javacourse181105.intro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 05.11.2018,
 * a significant bit of leva.bg project.
 */
public class Runner8 {
    static int i = 1;

    private FileInputStream fileInputStream ;
    private String value = "1";

    {
        try {
            fileInputStream = new FileInputStream("gradlew.bat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        i = 3;
        value = "2";
    }

    static {
        i = 2;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public Runner8() {
        try {
            fileInputStream = new FileInputStream("HOMEWORK.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        value = "3";
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Runner8 runner8 = new Runner8();
        runner8.getFileInputStream();
        runner8 = null;
        System.out.println();
    }

    // prevents memory leaks !
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(fileInputStream != null) {
            fileInputStream.close();
        }
    }
}
