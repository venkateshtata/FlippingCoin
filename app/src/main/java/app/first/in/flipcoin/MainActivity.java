package app.first.in.flipcoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_flip;

    ImageView coin;

    Random r;

    int coinSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_flip = (Button)findViewById(R.id.b_flip);

        coin = (ImageView)findViewById(R.id.coin);

        r = new Random();

        b_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                coinSide = r.nextInt(2);

                if(coinSide == 0){
                    coin.setImageResource(R.drawable.head);
                    Toast.makeText(getApplicationContext(), "It's Heads!", Toast.LENGTH_LONG).show();
                }
                else if (coinSide == 1){
                    coin.setImageResource(R.drawable.tail);
                    Toast.makeText(getApplicationContext(), "It's Tails!", Toast.LENGTH_LONG).show();
                }

                RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(1000);
                coin.startAnimation(rotate);

            }
        });
    }
}
