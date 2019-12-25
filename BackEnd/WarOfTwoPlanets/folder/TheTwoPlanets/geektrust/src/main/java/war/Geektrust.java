package war;

public class Geektrust {
    public static void main(String[] argument) {
        /*
         * This code reads a path to the text file from String argument and stores it into String pathToInputTxt.
         */
        String pathToInputTxt = "";
        try {
            pathToInputTxt = argument[0];
        }
        catch (Exception e) {
            System.out.println("Error while reading input file path from argument");
            return;
        }

        /*
         * Getting Input Problem Statement, from the given path to a text file,
         * through getProblemStatement() method of InputReader class.
         *
         * For more details check class InputReader.
         */
        String problemStatement = InputReader.getProblemStatement(pathToInputTxt);

        /*
         * The following if statement checks if String problemStatement is empty,
         * if problemStatement is empty it signals error in reading input.
         */
        if (problemStatement.equals("")) {
            System.out.println("Input text file not found at location: " + pathToInputTxt);
            return;
        }

        /*
         * Creating a war.LengaburuArmyOptimization.FalicorniaArmy object alFalconeArmy that stores
         * unit values of attacking Falicornia's army.
         *
         * Note: For more details and/or implementations of extractInput() & isValidInput() methods,
         * check class war.LengaburuArmyOptimization.FalicorniaArmy.
         */
        FalicorniaArmy alFalconeArmy = new FalicorniaArmy();

        /*
         * extractInput() method extracts the values of each unit, of Falicornia's army,
         * from input String problemStatement.
         *
         * If the input text file is not in format: 'FALICORNIA_ATTACK XXXH XXXE XXAT XXSG',
         * this method will throw an exception.
         */
        if (!alFalconeArmy.extractInput(problemStatement)) {
            System.out.println("Incorrect input format!");
            return;
        }

        /*
         * isValidInput() method check whether the values extracted
         * from input String problemStatement is valid or not.
         *
         * If the values are invalid, the program is terminated here
         * displaying error message: "Incorrect input values!".
         */
        if (alFalconeArmy.isValidInputUnitValues() == false) {
            System.out.println("Incorrect input values!");
            return;
        }

        /*
         * Creating a LengaburuArmy object kingShanArmy that
         * stores units values of defending Lengaburu's army.
         *
         * For more details and/or implementation of getRequiredUnitValues() method,
         * check class LengaburuArmy
         */
        LengaburuArmy kingShanArmy = new LengaburuArmy();

        /*
         * getRequiredUnitValues() method calculates required unit values of Lengaburu's army
         * in order to defend incoming attack.
         *
         * Note: Required units values calculated by getRequiredUnitValues() method
         * might exceed unit limits of Lengaburu's army.
         */
        kingShanArmy.getRequiredUnitValues(alFalconeArmy);

        /*
         * boolean win is used to determine the outcome of the war.
         * win is set to true, i.e. initially assuming the war can be won.
         */
        boolean win = true;

        /*
         * The following 4 methods are used to determine the outcome of the War:
         * 		1. horseUnitsOptimization()
         * 		2. elephantUnitsOptimization()
         * 		3. armouredTankUnitsOptimization()
         *		4. slingGunUnitsOptimization()
         *
         * Each of above methods checks whether required units (calculated by getRequiredUnitValues() method)
         * falls under the unit limit of Lengaburu's army.
         * If required unit troops are greater than unit limit, then these method checks
         * whether neighboring unit troops can supply the deficiency.
         *
         * Here, if any of the 4 units fail to match up to the enemy units,
         * boolean variable win is set to false, i.e. War is lost.
         *
         * For more details and/or implementations of following methods
         * check class LengaburuArmy
         */
        if (!kingShanArmy.horseUnitsOptimization()) win = false;

        if (!kingShanArmy.elephantUnitsOptimization()) win = false;

        if (!kingShanArmy.armouredTankUnitsOptimization()) win = false;

        if (!kingShanArmy.slingGunUnitsOptimization()) win = false;

        /*
         * Displaying the result of the War.
         */
        kingShanArmy.displayWarResult(win);
    }
}
