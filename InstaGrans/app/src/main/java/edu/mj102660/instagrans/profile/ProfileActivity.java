package edu.mj102660.instagrans.profile;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.MainActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.cart.Panier;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.ui.cart.CartFragment;

public class ProfileActivity extends AppCompatActivity implements ClickableActivity {


    ImageButton backButton;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intent = getIntent();

        int pos = intent.getIntExtra(getString(R.string.GRANNY), 0);

        Granny granny = Grans.getInstance().get(pos);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        ImageView granny_pic = findViewById(R.id.granny_pic);
        String resName = (granny.getUrlPicture());
        resName = resName.replace(".png", "");

        int resID =  getResources().getIdentifier(resName, "drawable", getPackageName());

        Bitmap userBitmap = BitmapFactory.decodeResource(getResources(), resID);

        RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(granny_pic, userBitmap);
        granny_pic.setImageDrawable(roundedImageDrawable);


        ImageButton subscribe = findViewById(R.id.subcribe);

        TextView name = findViewById(R.id.name);
        name.setText(granny.getName());

        TextView description = findViewById(R.id.desc);
        description.setText(granny.getDesc());

        TextView location = findViewById(R.id.location);
        location.setText(granny.getLocation());

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating((float)granny.getScore());

        Button button = findViewById(R.id.button);
        Locale locale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        button.setText(getString(R.string.rent) + granny.getName() + currencyFormatter.format(granny.getPrice()));

        button.setOnClickListener(view -> {
            Panier panier = Panier.getInstance();
            panier.setGranny(granny);

            Toast toast = Toast.makeText(this, "Granny ajoutée au panier", Toast.LENGTH_SHORT);
            toast.show();
        });

        GridView image_grid = findViewById(R.id.image_grid);

//        ProfileDishesAdapter adapter = new ProfileDishesAdapter(this, granny.getDishes());
//        image_grid.setAdapter(adapter);


    }

    @Override
    public void onClickGranny(int index) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}