import org.junit.Assert;
import org.junit.Test;
import war.FalicorniaArmy;

public class FalicorniaArmyTest {

    @Test
    public void shouldExtractUnitTroopsFromInputStringAndCheckInputFormat() {
        /*
         * Enter valid/invalid input to check extractInput() method of class FalicorniaArmy
         */
        String testInputProblemStatement = "FALICORNIA_ATTACK 300H 200E 40AT 20SG";

        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy();

        boolean testOutcome = testAlFalconeArmy.extractInput(testInputProblemStatement);

        if (testOutcome) {
            System.out.println("Input Statement '" + testInputProblemStatement + "' is in correct format.");
        }
        else {
            System.out.print(testInputProblemStatement);
        }

        Assert.assertEquals("Invalid Input Fromat", true, testOutcome);
    }

    @Test
    public void shouldCheckValidInputUnitValues() {
        /*
         * Enter valid/invalid values in FalicorniaArmy class constructor to check extractInput() method of class FalicorniaArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(300, 200, 40, 20);

        Assert.assertEquals("Incorrect Input Values", true, testAlFalconeArmy.isValidInputUnitValues());
    }
}
