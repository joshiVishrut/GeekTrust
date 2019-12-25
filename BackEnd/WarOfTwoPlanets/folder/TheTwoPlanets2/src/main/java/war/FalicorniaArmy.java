package war;

public class FalicorniaArmy implements FalicorniaArmyInputReader {
    int horseUnits, elephantUnits, armouredTankUnits, slingGunUnits;

    public int getHorseUnits() {
        return this.horseUnits;
    }

    public int getElephantUnits() {
        return this.elephantUnits;
    }

    public int getArmouredTankUnits() {
        return this.armouredTankUnits;
    }

    public int getSlingGunUnits() {
        return this.slingGunUnits;
    }

    public FalicorniaArmy() {
        this.horseUnits = -1;
        this.elephantUnits = -1;
        this.armouredTankUnits = -1;
        this.slingGunUnits = -1;
    }

    public FalicorniaArmy(int horses, int elephants, int armouredTanks, int slingGuns) {
        this.horseUnits = horses;
        this.elephantUnits = elephants;
        this.armouredTankUnits = armouredTanks;
        this.slingGunUnits = slingGuns;
    }

    /*
     * isValidInput() method determines validity of input
     * by checking input unit values against maximum unit limit and minimum unit values.
     */
    public boolean isValidInputUnitValues() {
        if (this.horseUnits > HORSE_UNIT_LIMIT || this.horseUnits < 0) {
            return false;
        }
        if (this.elephantUnits > ELEPHANT_UNIT_LIMIT || this.elephantUnits < 0) {
            return false;
        }
        if (this.armouredTankUnits > TANK_UNIT_LIMIT || this.armouredTankUnits < 0) {
            return false;
        }
        if (this.slingGunUnits > SLING_GUN_UNIT_LIMIT || this.slingGunUnits < 0) {
            return false;
        }

        return true;
    }

    public boolean extractInput(String problemStatement) {
        /*
         * The following code might throw an exception if the input format is incorrect.
         */
        try {
            problemStatement = problemStatement.substring(18);

            boolean horseUnitExtracted = false, elephantUnitExtraced = false, armouredTankUnitExtracted = false, slingGunUnitExtracted = false;
            int problemStatementLength = problemStatement.length();

            for (int startIndex = 0, endIndex = 0; endIndex < problemStatementLength; endIndex++) {
                // Extracting Horses Units
                if (problemStatement.charAt(endIndex) == 'H') {
                    // Checking correct order
                    if (problemStatement.charAt(endIndex - 1) == ' ' || problemStatement.charAt(endIndex + 1) != ' ') {
                        return false;
                    }

                    horseUnitExtracted = true;

                    this.horseUnits = Integer.parseInt(problemStatement.substring(startIndex, endIndex));

                    endIndex += 2;
                    startIndex = endIndex;
                }

                // Extracting Elephants Units
                if (problemStatement.charAt(endIndex) == 'E') {
                    // Checking correct order of unit value extraction
                    if (!horseUnitExtracted) {
                        return false;
                    }

                    // Checking correct order
                    if (problemStatement.charAt(endIndex - 1) == ' ' || problemStatement.charAt(endIndex + 1) != ' ') {
                        return false;
                    }

                    elephantUnitExtraced = true;

                    this.elephantUnits = Integer.parseInt(problemStatement.substring(startIndex, endIndex));

                    endIndex += 2;
                    startIndex = endIndex;
                }

                // Extracting Armoured Tanks Units
                if (problemStatement.charAt(endIndex) == 'A') {
                    // Checking correct order of unit value extraction
                    if (!elephantUnitExtraced) {
                        return false;
                    }

                    // Checking correct order
                    if (problemStatement.charAt(endIndex - 1) == ' ' ||
                            problemStatement.charAt(endIndex + 1) != 'T' ||
                            problemStatement.charAt(endIndex + 2) != ' ') {
                        return false;
                    }

                    armouredTankUnitExtracted = true;

                    this.armouredTankUnits = Integer.parseInt(problemStatement.substring(startIndex, endIndex));

                    endIndex += 3;
                    startIndex = endIndex;
                }

                // Extracting Sling Guns Units
                if (problemStatement.charAt(endIndex) == 'S') {
                    // Checking correct order of unit value extraction
                    if (!armouredTankUnitExtracted) {
                        return false;
                    }

                    // Checking correct order
                    if (problemStatement.charAt(endIndex - 1) == ' ' ||
                            problemStatement.charAt(endIndex + 1) != 'G') {
                        return false;
                    }

                    slingGunUnitExtracted = true;

                    this.slingGunUnits = Integer.parseInt(problemStatement.substring(startIndex, endIndex));

                    break;
                }
            }

            if (!horseUnitExtracted || !elephantUnitExtraced || !armouredTankUnitExtracted || !slingGunUnitExtracted) {
                return false;
            }

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
