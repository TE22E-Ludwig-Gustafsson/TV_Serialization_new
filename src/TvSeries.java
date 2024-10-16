import java.util.ArrayList;
import java.util.Scanner;

public class TvSeries {
    private String name;
    private ArrayList<Integer> episodes;
    private int rating;

    // Default konstruktor
    public TvSeries() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange namn på TV-serien: ");
        this.name = scanner.nextLine();
        this.episodes = new ArrayList<>();
        this.rating = 0;
    }

    public TvSeries(String inName) {
        this.name = inName;
        this.episodes = new ArrayList<>();
        this.rating = 0;
    }

    // Metod för att lägga till episoder till en viss säsong
    public void addEpisodes(int numOfEpisodes, int season) {
        // Säkerställer att listan har tillräckligt många element för att täcka upp till den angivna säsongen
        while (episodes.size() < season) {
            episodes.add(0);  // Fyller med 0 för varje säsong som inte har episoder än
        }
        // Uppdaterar antalet episoder för den angivna säsongen
        episodes.set(season - 1, numOfEpisodes);
    }

    // Metod för att ändra betyget
    public void changeRating(int newRating) {
        this.rating = newRating;
    }

    // Metod för att skriva ut information om serien
    public void printInfo() {
        System.out.println("Namn: " + name);
        System.out.println("Betyg: " + rating);
        for (int i = 0; i < episodes.size(); i++) {
            System.out.println("Säsong " + (i + 1) + ": " + episodes.get(i) + " episoder");
        }
    }

    // Getters för att möjliggöra serialisering
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getEpisodes() {
        return episodes;
    }

    public int getRating() {
        return rating;
    }

    // Setters för deserialisering
    public void setName(String name) {
        this.name = name;
    }

    public void setEpisodes(ArrayList<Integer> episodes) {
        this.episodes = episodes;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

