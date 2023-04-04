package edu.mj102660.instagrans.ui.cart;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

import edu.mj102660.instagrans.NotificationBuilder;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.cart.Panier;
import edu.mj102660.instagrans.databinding.FragmentCartBinding;
import edu.mj102660.instagrans.grans.Grans;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Panier panier = Panier.getInstance();
        if (panier.getGranny() != null) {
            binding.name.setText(panier.getGranny().getName());
            binding.age.setText(String.valueOf(panier.getGranny().getAge()));

            ImageView granny_pic = binding.myImageView;
            String resName = (panier.getGranny().getUrlPicture());
            resName = resName.replace(".png", "");

            int resID =  getResources().getIdentifier(resName, "drawable", getActivity().getPackageName());

            Bitmap userBitmap = BitmapFactory.decodeResource(getResources(), resID);

            RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(granny_pic, userBitmap);
            granny_pic.setImageDrawable(roundedImageDrawable);

            binding.ratingSimple.setRating((float) panier.getGranny().getScore());

            Locale locale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

            binding.price.setText(currencyFormatter.format(panier.getGranny().getPrice()));

            Double price = panier.getGranny().getPrice();
            Double TVA = 0.2;
            Double priceTVA = price + price*TVA;

            binding.tva.setText(TVA * 100 + " %");
            binding.priceTTC.setText(currencyFormatter.format(priceTVA));

            // Lancement de la notification
            NotificationBuilder notificationBuilder = new NotificationBuilder(this.getActivity());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("Test Channel", "Test Channel", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager = this.getActivity().getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }

            Button checkout = binding.buttonCheckout;
            checkout.setOnClickListener(view -> {
                notificationBuilder.buildNotification(getString(R.string.order), panier.getGranny().getName() + getString(R.string.ontw));
            });

            Button paypal = binding.buttonPaypal;
            paypal.setOnClickListener(view -> {
                notificationBuilder.buildNotification(getString(R.string.paypal_order), panier.getGranny().getName() + getString(R.string.ontw));
            });
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}