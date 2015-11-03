
import java.io.*;
import java.util.*;

public class GenerateFixtures {
    public static void main(String[] args) throws IOException {
        int numberOfTeams, totalNumberOfRounds, numberOfMatchesPerRound;
        int homeTeamNumber, awayTeamNumber, even, odd, roundNumber, matchNumber;

        Sport user1 = new Sport();


        String[][] fixtures;
        String[][] revisedFixtures;
        String[] elementsOfFixture;
        String fixtureAsText;
/**********************************************************************************************************************/

        //Checking how many teams are in the file.
        BufferedReader br = new BufferedReader(new FileReader("\\testing.txt"));
        String line;
        int count = 0;
        List<String> temps = new ArrayList<String>();
        while ((line = br.readLine()) != null) {

            temps.add(line);


            count++;
        }
        br.close();
        System.out.println("Number of Teams: " + count);

        for (int index = 0; index < count; index++) {
            System.out.println(temps.get(index));
        }

        numberOfTeams = count;

/**********************************************************************************************************************/




        totalNumberOfRounds = numberOfTeams - 1;
        numberOfMatchesPerRound = numberOfTeams / 2;


        fixtures = new String[totalNumberOfRounds][numberOfMatchesPerRound];

        for (roundNumber = 0; roundNumber < totalNumberOfRounds; roundNumber++) {
            for (matchNumber = 0; matchNumber < numberOfMatchesPerRound; matchNumber++) {


                //Algorithm to get fixtures


                homeTeamNumber = (roundNumber + matchNumber) % (numberOfTeams - 1);
                awayTeamNumber = (numberOfTeams - 1 - matchNumber + roundNumber) % (numberOfTeams - 1);
                if (matchNumber == 0)
                    awayTeamNumber = numberOfTeams - 1;

                fixtures[roundNumber][matchNumber] = (homeTeamNumber + 1) + " v " + (awayTeamNumber + 1);
/**********************************************************************************************************************/

            //names from file instead of numbers

                for (int index = 0; index < count; index++) {
                    //System.out.println(temps.get(index));


                    fixtures[roundNumber][matchNumber] = (temps.get(homeTeamNumber)) + " v " + (temps.get(awayTeamNumber));

                }
/**********************************************************************************************************************/


            }
        }

        revisedFixtures = new String[totalNumberOfRounds][numberOfMatchesPerRound];
        even = 0;
        odd = numberOfTeams / 2;
        for (int i = 0; i < fixtures.length; i++) {
            if (i % 2 == 0)
                revisedFixtures[i] = fixtures[even++];
            else
                revisedFixtures[i] = fixtures[odd++];
        }
        fixtures = revisedFixtures;

        for (roundNumber = 0; roundNumber < fixtures.length; roundNumber++) {
            if (roundNumber % 2 == 1) {
                fixtureAsText = fixtures[roundNumber][0];
                elementsOfFixture = fixtureAsText.split(" v ");
                fixtures[roundNumber][0] = elementsOfFixture[1] + " v " + elementsOfFixture[0];
            }
        }

        for (roundNumber = 0; roundNumber < totalNumberOfRounds; roundNumber++) {
            System.out.println("Round " + (roundNumber + 1) + "\t\t");
            for (matchNumber = 0; matchNumber < numberOfMatchesPerRound; matchNumber++) {


                System.out.println("\tMatch " + (matchNumber + 1) + ": "
                        + fixtures[roundNumber][matchNumber] + "\t");
                System.out.println();
            }
        }

    }
}


