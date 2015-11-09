import java.io.IOException;


public class main{
    public static void main (String [] args)throws IOException{

        AssignDate date1 = new AssignDate();
        Constraints const1 = new Constraints();
        GenerateFixtures user1 = new GenerateFixtures();
        user1.GenerateTable();
        const1.readConstraints();
        date1.getDay();
        date1.setDate();

    }
}

