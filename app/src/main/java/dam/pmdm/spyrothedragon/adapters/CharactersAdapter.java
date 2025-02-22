package dam.pmdm.spyrothedragon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.models.Character;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

    private List<Character> list;
    private Context context;

    public CharactersAdapter(Context context, List<Character> charactersList) {
        this.context = context;
        this.list = charactersList;
    }

    @Override
    public CharactersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharactersViewHolder holder, int position) {
        Character character = list.get(position);
        holder.nameTextView.setText(character.getName());

        // Cargar la imagen (simulado con un recurso drawable)
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(character.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageImageView.setImageResource(imageResId);

        // Si el personaje es Spyro, habilitar el Easter Egg
        if (character.getName().equalsIgnoreCase("Spyro")) {
            holder.imageImageView.setOnLongClickListener(v -> {
                showFireAnimation(holder.fireGifImageView);
                return true;
            });
        }
    }

    private void showFireAnimation(GifImageView fireGifImageView) {
        try {
            GifDrawable gifDrawable = new GifDrawable(context.getResources(), R.drawable.fire_gif);
            fireGifImageView.setImageDrawable(gifDrawable);
            fireGifImageView.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Toast.makeText(context, "Error al cargar la animación", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CharactersViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView imageImageView;
        GifImageView fireGifImageView;

        public CharactersViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            imageImageView = itemView.findViewById(R.id.image);
            fireGifImageView = itemView.findViewById(R.id.fireGif); // Asegúrate de que existe en el XML

        }
    }
}
