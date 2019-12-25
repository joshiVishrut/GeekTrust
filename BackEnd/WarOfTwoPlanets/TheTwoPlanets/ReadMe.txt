=>	This text file demostrates how to run and/or test the solution program for the problem 'The Two Planets'.

=>	How to run:
	
		->	This submission to 'The Two Planets' problem is submitted with maven build, i.e. geektrust.jar file is inlcuded and you can run it as follows:

				java -jar geektrust.jar <path_to_input_file>
	
		->	If the path entered is valid and input in the format: 'FALICORNIA_ATTACK XXXH XXXE XXAT XXSG', then the code will output the answer in the next line.

		
=>	Inside you will also find a maven project named: 'geektrust' and inside the 'src' folder you will find the source code and unit test classes inside 'src/main/java/war' & 'src/test/java' respectively;
		
		->	inside war package (src/main/java/war) you will find following files;
			1. Geektrust.java
			2. InputReader.java
			3. FalicorniaArmy.java
			4. FalicorniaArmyInputReader.java
			5. LengaburuArmy.java
			6. LengaburuArmyOptimization.java
	

=>	How to test:

	Unit Testing has been done using JUnit4 and to test you need to navigate to 'src/test/java', and inside you can find following test files:
	
		1.	InputReaderTest.java;
				-> Check abstract class InputReader and its getProblemStatement() method.
			
		2. 	FalicorniaArmyTest.java;
				-> Check class FalicorniaArmy and interface FalicorniaArmyInputReader and its two methods;
					1. isValidInput() method, &
					2. extractInput() method.
	
		3.	LengaburuArmyTest.java;
				-> Check class LengaburuArmy & interface LengaburuArmyOptimization and there methods;
					1. getRequiredUnitValues() method,
					2. horseUnitsOptimization() method,
					3. elephantUnitsOptimization() method,
					4. armouredTankUnitsOptimization() method, &
					5. slingGunUnitsOptimization() method.
					
		
		

