package war;

public class LengaburuArmy implements LengaburuArmyOptimization {
    int horseUnits, elephantUnits, armouredTankUnits, slingGunUnits;

    public int getHorseUnits() {
        return horseUnits;
    }

    public int getElephantUnits() {
        return elephantUnits;
    }

    public int getArmouredTankUnits() {
        return armouredTankUnits;
    }

    public int getSlingGunUnits() {
        return slingGunUnits;
    }

    public LengaburuArmy() {
        this.horseUnits = 0;
        this.elephantUnits = 0;
        this.armouredTankUnits = 0;
        this.slingGunUnits = 0;
    }

    public LengaburuArmy(int horseUnits, int elephantUnits, int armouredTankUnits, int slingGunUnits) {
        this.horseUnits = horseUnits;
        this.elephantUnits = elephantUnits;
        this.armouredTankUnits = armouredTankUnits;
        this.slingGunUnits = slingGunUnits;
    }

    /*
     * getRequiredUnitValues() method calculates required Lengaburu's army units.
     */
    public void getRequiredUnitValues(FalicorniaArmy alFalconeArmy) {
        this.horseUnits = (alFalconeArmy.horseUnits + 1) / 2;
        this.elephantUnits = (alFalconeArmy.elephantUnits + 1) / 2;
        this.armouredTankUnits = (alFalconeArmy.armouredTankUnits + 1) / 2;
        this.slingGunUnits = (alFalconeArmy.slingGunUnits + 1) / 2;
    }

    /*
     * displayWarResult() method displays the result of the War.
     */
    public void displayWarResult(boolean win) {
        if (win) {
            System.out.println("WIN " +
                    this.horseUnits + "H " +
                    this.elephantUnits + "E " +
                    this.armouredTankUnits + "AT " +
                    this.slingGunUnits + "SG");
        }
        else {
            System.out.println("LOSS " +
                    this.horseUnits + "H " +
                    this.elephantUnits + "E " +
                    this.armouredTankUnits + "AT " +
                    this.slingGunUnits + "SG");
        }
    }

    /*
     * horseUnitsOptimization() method check and/or optimizes the Horse army units.
     */
    public boolean horseUnitsOptimization() {
        /*
         * If Horse Troop Units are under unit limit (Horse Unit limit = 100), then return true.
         */
        if (this.horseUnits <= HORSE_UNIT_LIMIT) {
            return true;
        }

        /*
         * Calculating the required Elephant unit troops needed in order to combat opposing Horse unit troops.
         */
        int requiredElephantsByHorsesUnit = (this.horseUnits - HORSE_UNIT_LIMIT + 1) / 2;

        /*
         * All the Horse Unit troops will  be needed in order to combat the opposing forces.
         */
        this.horseUnits = HORSE_UNIT_LIMIT;

        /*
         * Checking if the required Elephant unit troops needed by Horse unit can me produced.
         */
        if (this.elephantUnits + requiredElephantsByHorsesUnit <= ELEPHANT_UNIT_LIMIT) {
            /*
             * Sending the extra Elephant unit troops along to help Horse unit.
             */
            this.elephantUnits += requiredElephantsByHorsesUnit;
            return true;
        }
        /*
         * Since Elephant unit can't supply the deficiency, the war will  be lost.
         */
        else {
            /*
             * Sending maximum number of Elephant unit troops to help along, even though war will be lost.
             */
            this.elephantUnits = ELEPHANT_UNIT_LIMIT;
            return false;
        }

    }

    /*
     * elephantUnitsOptimization() method check and/or optimizes the Elephant army units.
     */
    public boolean elephantUnitsOptimization() {
        /*
         * If Elephant Troop Units are under unit limit (Elephant Unit limit = 50), then return true.
         */
        if (this.elephantUnits <= ELEPHANT_UNIT_LIMIT) {
            return true;
        }

        /*
         * Calculating the required Horse unit troops needed in order to combat opposing Elephant unit troops.
         */
        int requiredHorsesByElephantUnit = 2*(this.elephantUnits - ELEPHANT_UNIT_LIMIT);

        /*
         * Checking if required Horse unit troops can be produced
         */
        if (this.horseUnits + requiredHorsesByElephantUnit <= HORSE_UNIT_LIMIT) {
            /*
             * Sending extra Horse unit troops to help Elephant unit.
             */
            this.horseUnits += requiredHorsesByElephantUnit;
            this.elephantUnits = ELEPHANT_UNIT_LIMIT;
            return true;
        }
        else {
            /*
             * Since Horse unit cannot supply the deficiency of Elephant unit troops,
             * calculating available Horse unit troops and required Armoured Tank unit
             * troops to combat opposing Elephant unit troops.
             */
            int availableHorsesForElephantUnit = HORSE_UNIT_LIMIT - this.horseUnits;
            int extraElephantsAboveElephantLimit = this.elephantUnits - ELEPHANT_UNIT_LIMIT - (availableHorsesForElephantUnit / 2);
            int requiredTanksByElephantUnit = (extraElephantsAboveElephantLimit + 1) / 2;

            /*
             * All the Horse & Elephant Unit troops will be needed in order to combat the opposing forces.
             */
            this.horseUnits = HORSE_UNIT_LIMIT;
            this.elephantUnits = ELEPHANT_UNIT_LIMIT;

            /*
             * Checking if required Armoured Tank unit troops can be produced
             */
            if (this.armouredTankUnits + requiredTanksByElephantUnit <= TANK_UNIT_LIMIT) {
                /*
                 * Sending extra Armoured Tank unit troops to help Elephant unit.
                 */
                this.armouredTankUnits += requiredTanksByElephantUnit;
                return true;
            }
            else {
                /*
                 * Sending maximum number of Armoured Tank unit troops to help along, even though war will be lost.
                 */
                this.armouredTankUnits = TANK_UNIT_LIMIT;
                return false;
            }
        }
    }

    /*
     * armouredTankUnitsOptimization() method check and/or optimizes the Armoured Tank army units.
     */
    public boolean armouredTankUnitsOptimization() {
        /*
         * If Armoured Tank Troop Units are under unit limit (Armoured Tank Unit limit = 50), then return true.
         */
        if (this.armouredTankUnits <= TANK_UNIT_LIMIT) {
            return true;
        }

        /*
         * Calculating the required Elephant unit troops needed in order to combat opposing Armoured Tank unit troops.
         */
        int requiredElephantsByArmouredTankUnit = 2 * (this.armouredTankUnits - TANK_UNIT_LIMIT);

        /*
         * Checking if required Elephant unit troops can be produced
         */
        if (this.elephantUnits + requiredElephantsByArmouredTankUnit <= ELEPHANT_UNIT_LIMIT) {
            /*
             * Sending extra Elephant unit troops to help Armoured Tank unit.
             */
            this.elephantUnits += requiredElephantsByArmouredTankUnit;
            this.armouredTankUnits = TANK_UNIT_LIMIT;
            return true;
        }
        else {
            /*
             * Since Elephant unit cannot supply the deficiency of Armoured Tank unit troops,
             * calculating available Elephant unit troops and required Sling Gun unit troops
             * to combat opposing Armoured Tank unit troops.
             */
            int availableElephantsForArmouredTankUnit = ELEPHANT_UNIT_LIMIT - this.elephantUnits;
            int extraTanksAboveTankLimit = this.armouredTankUnits - TANK_UNIT_LIMIT - (availableElephantsForArmouredTankUnit / 2);
            int requiredSlingGunsByTankUnit = (extraTanksAboveTankLimit + 1) / 2;

            /*
             * All the Elephant & Armoured Tank Unit troops will  be needed in order to combat the opposing forces.
             */
            this.elephantUnits = ELEPHANT_UNIT_LIMIT;
            this.armouredTankUnits = TANK_UNIT_LIMIT;

            /*
             * Checking if required Sling Gun unit troops can be produced
             */
            if (this.slingGunUnits + requiredSlingGunsByTankUnit <= SLING_GUN_UNIT_LIMIT) {
                /*
                 * Sending extra Sling Gun unit troops to help Elephant unit.
                 */
                this.slingGunUnits += requiredSlingGunsByTankUnit;
                return true;
            }
            else {
                /*
                 * Sending maximum number of Sling Gun unit troops to help along, even though war will be lost.
                 */
                this.slingGunUnits += SLING_GUN_UNIT_LIMIT;
                return false;
            }
        }
    }

    /*
     * slingGunUnitsOptimization() method check and/or optimizes the Sling Gun army units.
     */
    public boolean slingGunUnitsOptimization() {
        /*
         * If Sling Gun Troop Units are under unit limit (Sling Gun Unit limit = 50), then return true.
         */
        if (this.slingGunUnits <= SLING_GUN_UNIT_LIMIT) {
            return true;
        }

        /*
         * Calculating the required Armoured Tank unit troops needed in order
         * to combat opposing Sling GUn unit troops.
         */
        int requiredTanksBySlingGunUnit = 2 * (this.slingGunUnits - SLING_GUN_UNIT_LIMIT);

        /*
         * All the Sling Gun Unit troops will  be needed in order to combat the opposing forces.
         */
        this.slingGunUnits = SLING_GUN_UNIT_LIMIT;

        /*
         * Checking if required Armoured Tank unit troops can be produced
         */
        if (this.armouredTankUnits + requiredTanksBySlingGunUnit <= TANK_UNIT_LIMIT) {
            /*
             * Sending extra Armoured Tank unit troops to help Elephant unit.
             */
            this.armouredTankUnits += requiredTanksBySlingGunUnit;
            return true;
        }
        else {
            /*
             * Sending maximum number of Armoured Tank unit troops to help along, even though war will be lost.
             */
            this.armouredTankUnits = TANK_UNIT_LIMIT;
            return false;
        }
    }
}
