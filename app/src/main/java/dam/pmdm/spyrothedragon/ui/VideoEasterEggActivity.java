package dam.pmdm.spyrothedragon.ui;

import android.net.Uri;
import android.os.Bundle;

import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import dam.pmdm.spyrothedragon.R;

public class VideoEasterEggActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_easter_egg);

        VideoView videoView = findViewById(R.id.videoEasterEgg);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.easter_egg_2; // Nombre del archivo en res/raw
        Uri uri = Uri.parse(videoPath);

        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(this)); // Controles de reproducción
        videoView.requestFocus();
        videoView.start();

        // Al terminar el video, volver a la pestaña de coleccionables
        videoView.setOnCompletionListener(mp -> {
            finish(); // Cierra la actividad y vuelve a la anterior
        });
    }
}
