package war;

public interface FalicorniaArmyInputReader {
    /*
     * Falicornia Army's Unit Limits
     */
    int HORSE_UNIT_LIMIT = 300;
    int ELEPHANT_UNIT_LIMIT = 200;
    int TANK_UNIT_LIMIT = 40;
    int SLING_GUN_UNIT_LIMIT = 20;

    /*
     * isValidInput() method to check validity of input.
     * extractInput() method to extract unit values from input problem statement.
     */
    boolean isValidInputUnitValues();
    boolean extractInput(String problemStatement);
}
