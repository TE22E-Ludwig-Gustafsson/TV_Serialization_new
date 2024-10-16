import java.util.ArrayList;

public class TvMain {
    private ArrayList<TvSeries> shows;


    public TvMain() {
        shows = new ArrayList<>();
        createShowData();
    }

    private void createShowData() {
        TvSeries show1 = new TvSeries("Breaking Bad");
        shows.addEpisodes(7,1);

    }



}
