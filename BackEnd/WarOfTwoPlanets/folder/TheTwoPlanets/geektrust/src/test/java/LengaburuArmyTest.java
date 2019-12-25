import org.junit.Assert;
import org.junit.Test;
import war.LengaburuArmy;
import war.FalicorniaArmy;

public class LengaburuArmyTest {

    @Test
    public void shouldGetRequiredUnitValuesFromFalicorniaArmyUnits() {
        /*
         * Enter valid/invalid values in war.LengaburuArmyOptimization.FalicorniaArmy class constructor to check getRequiredUnitValues() method of class LengaburuArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(200, 100, 20, 10);
        LengaburuArmy testKingShanArmy = new LengaburuArmy();

        testKingShanArmy.getRequiredUnitValues(testAlFalconeArmy);

        int expectedHorseUnits = (testAlFalconeArmy.getHorseUnits() + 1) / 2;
        Assert.assertEquals("Error in calculating required Horse Units, " +
                "in getRequiredUnitValues() method of class LengaburuArmy",
                expectedHorseUnits, testKingShanArmy.getHorseUnits());

        int expectedElephantUnits = (testAlFalconeArmy.getElephantUnits() + 1) / 2;
        Assert.assertEquals("Error in calculating required Elephant Units, " +
                "in getRequiredUnitValues() method of class LengaburuArmy",
                expectedElephantUnits, testKingShanArmy.getElephantUnits());

        int expectedArmouredTankUnits = (testAlFalconeArmy.getArmouredTankUnits() + 1) / 2;
        Assert.assertEquals("Error in calculating required Armoured Tank Units, " +
                "in getRequiredUnitValues() method of class LengaburuArmy",
                expectedArmouredTankUnits, testKingShanArmy.getArmouredTankUnits());

        int expectedSlingGunUnits = (testAlFalconeArmy.getSlingGunUnits() + 1) / 2;
        Assert.assertEquals("Error in calculating required Horse Units, " +
                "in getRequiredUnitValues() method of class LengaburuArmy",
                expectedSlingGunUnits, testKingShanArmy.getSlingGunUnits());
    }

    @Test
    public void shouldCheckHorseUnitLimitAndNeighBoringUnitsForSupport() {
        /*
         * Enter valid/invalid values in war.LengaburuArmyOptimization.FalicorniaArmy class constructor to check horseUnitsOptimization() method of class LengaburuArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(250, 50, 20, 10);
        LengaburuArmy testKingShanArmy = new LengaburuArmy();

        testKingShanArmy.getRequiredUnitValues(testAlFalconeArmy);

        Assert.assertEquals("Error in horseUnitsOptimization() method of class LengaburuArmy",
                true, testKingShanArmy.horseUnitsOptimization());
    }

    @Test
    public void shouldCheckElephantUnitLimitAndNeighBoringUnitsForSupport() {
        /*
         * Enter valid/invalid values in war.LengaburuArmyOptimization.FalicorniaArmy class constructor to check elephantUnitsOptimization() method of class LengaburuArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(176, 120, 15, 10);
        LengaburuArmy testKingShanArmy = new LengaburuArmy();

        testKingShanArmy.getRequiredUnitValues(testAlFalconeArmy);

        Assert.assertEquals("Error in elephantUnitsOptimization() method of class LengaburuArmy",
                true, testKingShanArmy.elephantUnitsOptimization());
    }

    @Test
    public void shouldCheckArmouredTankUnitLimitAndNeighBoringUnitsForSupport() {
        /*
         * Enter valid/invalid values in war.LengaburuArmyOptimization.FalicorniaArmy class constructor to check armouredTankUnitsOptimization() method of class LengaburuArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(160, 96, 25, 8);
        LengaburuArmy testKingShanArmy = new LengaburuArmy();

        testKingShanArmy.getRequiredUnitValues(testAlFalconeArmy);

        Assert.assertEquals("Error in armouredTankUnitsOptimization() method of class LengaburuArmy",
                true, testKingShanArmy.armouredTankUnitsOptimization());
    }

    @Test
    public void shouldCheckSlingGunUnitLimitAndNeighBoringUnitsForSupport() {
        /*
         * Enter valid/invalid values in war.LengaburuArmyOptimization.FalicorniaArmy class constructor to check slingGunUnitsOptimization() method of class LengaburuArmy
         */
        FalicorniaArmy testAlFalconeArmy = new FalicorniaArmy(160, 96, 11, 13);
        LengaburuArmy testKingShanArmy = new LengaburuArmy();

        testKingShanArmy.getRequiredUnitValues(testAlFalconeArmy);

        Assert.assertEquals("Error in slingGunUnitsOptimization() method of class LengaburuArmy",
                true, testKingShanArmy.slingGunUnitsOptimization());
    }
}
