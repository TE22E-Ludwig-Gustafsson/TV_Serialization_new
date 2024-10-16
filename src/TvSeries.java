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
}
