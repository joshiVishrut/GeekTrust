=>	This text file demostrates how to run and/or test the solution program for the problem 'The Two Planets'.

=>	Inside you will find package 'war', which contains following files:
		1. Geektrust.java
		2. InputReader.java
		3. FalicorniaArmy.java
		4. FalicorniaArmyInputReader.java
		5. LengaburuArmy.java
		6. LengaburuArmyOptimization.java
		7. input1.txt
		8. input2.txt
		9. input3.txt
		10. input4.txt

=>	How to run:
	
		->	This submission to 'The Two Planets' problem is submitted without any build file, i.e. run this solution using following commands:

				javac <path_of_package_war>/Geektrust.java
				java war.Geektrust <absolute_path_to_input_file>

			In above commands, 'war' is the package name.

		->	When the program is run it will ask for an input file path by displaying the message: "Enter input file path: ", here enter a valid path to an input.txt file.
			Note: If the path is invalid, the code will throw exception and display the following message:
				"Input text file not found at location: " (follow by the invalid path)
	
		->	If the path entered is valid and input in the format: 'FALICORNIA_ATTACK XXXH XXXE XXAT XXSG', then the code will output the answer in the next line.
	

=>	How to test:

	Now, inorder to test different aspects of this program, you can check and test the following classes/interfaces and their methods:
	
		1. Calculating required troops and checking whether it can be achieved:
			-> Check class LengaburuArmy & interface LengaburuArmyOptimization and there methods;
				1. getRequiredUnitValues() method,
				2. horseUnitsOptimization() method,
				3. elephantUnitsOptimization() method,
				4. armouredTankUnitsOptimization() method,
				5. slingGunUnitsOptimization() method.
					
		2. Reading input from text file;
			-> Check abstract class InputReader and its getProblemStatement() method.
		
		3. Converting Problem Statement to Falicornia's Army unit:
			-> Check class FalicorniaArmy and interface FalicorniaArmyInputReader and its two methods;
				1. isValidInput() method, &
				2. extractInput() method.

