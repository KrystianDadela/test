import java.util.Scanner;

public class Sport {

    String sport="";

    public String getSport() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter type of sport");
        this.sport = in.nextLine();

        return sport;
    }
}