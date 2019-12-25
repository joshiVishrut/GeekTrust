import org.junit.Assert;
import org.junit.Test;
import war.InputReader;

public class InputReaderTest {
    /*
     * This class is used to unit test class InputReader.
     * You can type a valid/invalid path to an input file in String pathToInputTextFile below
     * and run shouldTestValidPathToInputTextFile() method to test getProblemStatement() method of class InputReader.
     */

    @Test
    public void shouldTestValidPathToInputTextFile() {
        /*
         * Enter a valid/invalid path below to test getProblemStatement() method of class InputReader
         */
        String pathToInputTextFile = "C:\\Code\\GeekTrust\\geektrust\\inputs\\input1.txt";

        String testOutcome = InputReader.getProblemStatement(pathToInputTextFile);

        Assert.assertNotEquals("Invalid Path", "", testOutcome);
    }
}
