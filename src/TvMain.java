import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TvMain {
    public final Scanner scanner1;
    private ArrayList<TvSeries> shows;


    public TvMain() {
        shows = new ArrayList<>();
        scanner1 = new Scanner(System.in);
        readFromFile();
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- TV Series Menu ---");
            System.out.println("1. Lägg till ny TV-serie");
            System.out.println("2. Visa alla TV-serier");
            System.out.println("3. Ändra en TV-serie");
            System.out.println("4. Spara och avsluta");
            System.out.print("Välj ett alternativ: ");

            int choice = scanner1.nextInt();
            scanner1.nextLine(); // Konsumera newline

            switch (choice) {
                case 1:
                    addNewSeries();
                    break;
                case 2:
                    displayAllShows();
                    break;
                case 3:
                    modifySeries();
                    break;
                case 4:
                    write2File();
                    System.out.println("Programmet avslutas...");
                    return;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    // Metod för att lägga till en ny TV-serie
    public void addNewSeries() {
        System.out.println("Ange namn på TV-serien: ");
        String name = scanner1.nextLine();
        TvSeries newShow = new TvSeries(name);
        System.out.println("Ange betyg för serien: ");
        int rating = scanner1.nextInt();
        newShow.changeRating(rating);

        System.out.println("Hur många säsonger vill du lägga till? ");
        int seasons = scanner1.nextInt();
        for (int i = 1; i <= seasons; i++) {
            System.out.println("Ange antalet episoder för säsong " + i + ": ");
            int episodes = scanner1.nextInt();
            newShow.addEpisodes(episodes, i );
        }

        shows.add(newShow);
        System.out.println("Tv-serien har lagt till!");
    }

    //Metod för att visa all information om Tv-serierna
     public void displayAllShows(){
        if (shows.isEmpty()) {
            System.out.println("Inga serier att visa.");
        } else {
            for (TvSeries show : shows) {
                show.printInfo();
                System.out.println();
            }
        }
    }





    // Metod för att skriva objekt till fil
    public void write2File() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tvshows.ser"))) {
            oos.writeObject(shows);
            System.out.println("Data har skrivits till fil.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metod för att läsa in objekt från fil
    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tvshows.ser"))) {
            shows = (ArrayList<TvSeries>) ois.readObject();
            System.out.println("Data har lästs från fil.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}






