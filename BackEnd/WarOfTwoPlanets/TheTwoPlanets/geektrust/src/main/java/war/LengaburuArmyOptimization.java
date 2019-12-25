package war;

public interface LengaburuArmyOptimization {
    /*
     * Lengaburu's Army Unit Limits.
     */
    int HORSE_UNIT_LIMIT = 100;
    int ELEPHANT_UNIT_LIMIT = 50;
    int TANK_UNIT_LIMIT = 10;
    int SLING_GUN_UNIT_LIMIT = 5;

    /*
     * getRequiredUnitValues() method: to calculate required units to defend.
     */
    void getRequiredUnitValues(FalicorniaArmy alFalconeArmy);
    /*
     * Following 4 methods check and/or optimizes unit values of Lengaburu's army.
     */
    boolean horseUnitsOptimization();
    boolean elephantUnitsOptimization();
    boolean armouredTankUnitsOptimization();
    boolean slingGunUnitsOptimization();
    /*
     * displayWarResult() method displays the result of the War.
     */
    void displayWarResult(boolean result);
}
