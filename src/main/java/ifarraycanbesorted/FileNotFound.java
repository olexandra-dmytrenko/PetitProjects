package ifarraycanbesorted;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by olexandra on 3/17/16.
 */
public class FileNotFound extends Exception{
    public static void main(String args[]) {
        File file = new File("E://file.txt");
        //Checked exception, determined during compilation, programmers exception. Try-catch will help. E.g. FileNotFoundException
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //----------------
        ArrayList list = new ArrayList(3);
        //Unchecked (Runtime) exception will be caused. Again programmer's mistake but generally invoked by user. E.g. ArrayIndexOutOfBoundsException, IndexOutOfBoundsException. Are ignored at the time of compilation.
        list.get(4);

        //Errors: neither programmer not user are in charge, like StackOverflowError. Are ignored at the time of compilation.
    }
}
