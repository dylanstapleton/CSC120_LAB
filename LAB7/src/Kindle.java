import java.util.Scanner;

public class Kindle {

    public static final Scanner keyboard = new Scanner(System.in);
    private int currentPage;
    private int totalPages;

    public Kindle(int numOfPages) {
        totalPages = numOfPages;
        currentPage = 1;
    }




    public String toString() {
        return "Page " + currentPage + " of " + totalPages + ".";
    }

    public void turnPages() {
        turnPages(1);
    }

    public void turnPages(int pages) {

        if (currentPage + pages > totalPages) {
            System.out.println("You were on " + this);
            System.out.println("Turning " + pages + " pages would take you past the last page.");
            currentPage = totalPages;
            System.out.println("You are now on " + this);
        } else {
            currentPage += pages;
        }


    }
}