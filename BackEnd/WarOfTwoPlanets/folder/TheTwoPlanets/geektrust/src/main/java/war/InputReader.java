package war;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class InputReader {
    public static String getProblemStatement(String pathToInputTxt) {
        try {
            /*
             * String pathToInputTxt is passed as an argument in class File's file object initialization.
             * Note: If the String path contains an invalid path this method will throw an exception.
             */
            File file = new File(pathToInputTxt);

            /*
             * The following code reads the input from the input text file, at path: pathToInputTxt,
             * and converts it into a string, this string is stored in String problemStatement.
             *
             * Note: If the text file is empty or path (in String pathToInputTxt) invalid,
             * the following code will throw an exception.
             */
            BufferedReader br = new BufferedReader(new FileReader(file));
            String problemStatement = br.readLine();
            br.close();

            return problemStatement;
        }
        catch(Exception e) {
            /*
             * If an exception occurs while reading input, an empty String is returned,
             * signaling to the main function an error has occurred while reading input.
             */
            return "";
        }
    }
}
