import java.io.IOException;


public class main{
    public static void main (String [] args)throws IOException{


        Constraints const1 = new Constraints();
        GenerateFixtures user1 = new GenerateFixtures();
        user1.GenerateTable();
        const1.readConstraints();

    }
}

