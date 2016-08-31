package com.mercury.gnusin.picassodownloader;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoDownloaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_picasso_downloader);

        new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                Log.d("Picasso error 1", exception.getMessage());
            }
        };

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Uri uri = Uri.parse(getString(R.string.uri_picture));
        Picasso picasso = Picasso.with(this);
        picasso.setLoggingEnabled(true);
        picasso.load(uri).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                Log.d("Picasso error 2", "");
            }
        });
    }
}
