import java.io.*;
import java.util.ArrayList;

public class TvMain {
    private ArrayList<TvSeries> shows;


    public TvMain() {
        shows = new ArrayList<>();
        createShowData();
    }

    // Skapar initialt dataset
    public void createShowData() {
        TvSeries show1 = new TvSeries("Breaking Bad");
        show1.addEpisodes(7, 1);
        show1.addEpisodes(13, 2);
        show1.changeRating(9);

        TvSeries show2 = new TvSeries("Stranger Things");
        show2.addEpisodes(8, 1);
        show2.addEpisodes(9, 2);
        show2.changeRating(8);

        shows.add(show1);
        shows.add(show2);

        // Skriv datat till fil så att det finns sparat till nästa gång
        write2File();
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

    // Metod för att visa all information om TV-serierna
    public void displayAllShows() {
        for (TvSeries show : shows) {
            show.printInfo();
            System.out.println();
        }
    }
}




