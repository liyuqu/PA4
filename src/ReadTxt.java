import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadTxt {
    //ReadTxt class is for reading .txt to init monsters,heroes
    String string;
    public ArrayList<String[]> readTxt(String filepath) throws Exception {
        ArrayList<String[]> singleLine=new ArrayList<String[]>();
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int i=0;
        while ((string = br.readLine()) != null) {
            singleLine.add(string.split("\\s+"));
            i+=1;
        }
        return singleLine;
    }
}