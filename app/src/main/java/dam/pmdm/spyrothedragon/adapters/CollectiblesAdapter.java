package dam.pmdm.spyrothedragon.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.models.Collectible;
import dam.pmdm.spyrothedragon.ui.VideoEasterEggActivity;

public class CollectiblesAdapter extends RecyclerView.Adapter<CollectiblesAdapter.CollectiblesViewHolder> {

    private List<Collectible> list;
    private int clickCount = 0;
    private Handler handler = new Handler();
    private static final int CLICK_THRESHOLD = 4; // Número de toques necesarios
    private static final int TIMEOUT = 1000; // Tiempo para resetear en milisegundos

    public CollectiblesAdapter(List<Collectible> collectibleList) {
        this.list = collectibleList;
    }

    @Override
    public CollectiblesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CollectiblesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectiblesViewHolder holder, int position) {
        Collectible collectible = list.get(position);
        holder.nameTextView.setText(collectible.getName());

        // Cargar la imagen (simulado con un recurso drawable)
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(collectible.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageImageView.setImageResource(imageResId);


        // Detectar el Easter Egg al pulsar sobre la imagen
        holder.imageImageView.setOnClickListener(v -> {
            clickCount++;

            // Reiniciar el contador después de un tiempo si no se presiona seguido
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(() -> clickCount = 0, TIMEOUT);

            // Si alcanza el número de clicks necesario, abrir la actividad del video
            if (clickCount == CLICK_THRESHOLD) {
                clickCount = 0; // Reiniciar el contador
                Context context = v.getContext();
                Intent intent = new Intent(context, VideoEasterEggActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CollectiblesViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView imageImageView;

        public CollectiblesViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            imageImageView = itemView.findViewById(R.id.image);
        }
    }
}
