import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krystian on 03/11/2015.
 */
public class Teams {


    public int GetNumberOfTeams()throws IOException
    {
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

        return count;
    }
}
