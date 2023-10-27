package tn.mpdam.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<NewsItem> newsList = new ArrayList<>();
        newsList.add(new NewsItem("Record-Breaking Home Run in World Series", "A new home run record was set in the World Series, leaving fans in awe.", R.drawable.baseball));
        newsList.add(new NewsItem("Surprise Upset at Wimbledon Semifinals", "An unexpected upset occurred in the Wimbledon semifinals, shaking up the tennis world.", R.drawable.tennis));
        newsList.add(new NewsItem("Olympic Gold Medalist Announces Retirement", "A beloved Olympic champion officially announces their retirement from professional sports.", R.drawable.olympics));
        newsList.add(new NewsItem("NBA Playoffs: Underdog Team Advances to Finals", "A lesser-favored NBA team defies the odds and advances to the ", R.drawable.basketball));
        newsList.add(new NewsItem("Soccer Star's Stunning Hat-Trick Secures Victory", ": A soccer superstar's incredible hat-trick performance leads their team to a decisive win.", R.drawable.football));
        newsList.add(new NewsItem("First Female Coach Hired by NFL Team", " A historic moment as the NFL appoints its first female head coach for a major team.", R.drawable.nfl));
        newsList.add(new NewsItem("Tennis Legend Returns After Injury Layoff", "A tennis legend makes a triumphant comeback after a long break due to injury.", R.drawable.tennis));
        newsList.add(new NewsItem("World Chess Champion Retains Title", "The reigning world chess champion successfully defends their title in a thrilling match.", R.drawable.chess));
        newsList.add(new NewsItem("Rookie Sensation Breaks Rookie Record in MLB", "A rookie baseball player sets a new record for rookies in the MLB, capturing fans' attention.", R.drawable.baseballrookie));
        newsList.add(new NewsItem("E-sports Phenom Dominates Global Tournament", "A rising e-sports star takes the gaming world by storm, dominating a prestigious international tournament.", R.drawable.esports));


        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(dividerItemDecoration);
        rv.setAdapter(new RecyclerviewAdapater(newsList, this));
    }

    private void openEmailIntent(String title, String description) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, description);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mostfasaidi56@gmail.com"});

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
            showToast("Email sent");
        } else {
            showToast("No email app found");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
