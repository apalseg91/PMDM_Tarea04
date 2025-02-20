package dam.pmdm.spyrothedragon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController = null;
    private int currentGuideStep = 1;
    private static final int TOTAL_STEPS = 6;
    private MenuItem itemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = dam.pmdm.spyrothedragon.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.navHostFragment));
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);
        binding.navView.setOnItemSelectedListener(this::selectedBottomMenu);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_characters ||
                    destination.getId() == R.id.navigation_worlds ||
                    destination.getId() == R.id.navigation_collectibles) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });

        showGuideStep(currentGuideStep);
    }

    private boolean selectedBottomMenu(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.nav_characters)
            navController.navigate(R.id.navigation_characters);
        else if (menuItem.getItemId() == R.id.nav_worlds)
            navController.navigate(R.id.navigation_worlds);
        else
            navController.navigate(R.id.navigation_collectibles);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        itemInfo = menu.findItem(R.id.action_info);//guardo la ref de botón de info
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_info) {
            showInfoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_about)
                .setMessage(R.string.text_about)
                .setPositiveButton(R.string.accept, null)
                .show();
    }

    private void showGuideStep(int step) {
        LayoutInflater inflater = getLayoutInflater();
        FrameLayout guideContainer = binding.guideContainer;
        getSupportActionBar().hide();
        disableButtons();
        guideContainer.removeAllViews();



        int layoutResId = 0;
        switch (step) {
            case 1:
                layoutResId = R.layout.guide_no1;

                break;
            case 2:
                layoutResId = R.layout.guide_no2;
                break;
            case 3:
                layoutResId = R.layout.guide_no3;
                break;
            case 4:
                layoutResId = R.layout.guide_no4;
                break;
            case 5:
                layoutResId = R.layout.guide_no5;
                getSupportActionBar().show();
                break;
            case 6:
                layoutResId = R.layout.guide_no6;
                break;
        }
        if (layoutResId != 0) {
            View guideView = inflater.inflate(layoutResId, guideContainer, false);
            guideContainer.addView(guideView);
            guideContainer.setVisibility(View.VISIBLE);

            Button nextButton = guideView.findViewById(R.id.btnNextStep);
            Button skipButton = guideView.findViewById(R.id.btnSkipGuide);

            nextButton.setOnClickListener(v -> onNextGuideStep());
            skipButton.setOnClickListener(v -> onSkipGuide());
        }
    }

    public void onNextGuideStep() {
        if (currentGuideStep < TOTAL_STEPS) {
            currentGuideStep++;
            showGuideStep(currentGuideStep);
        }
    }

    public void onSkipGuide() {
        currentGuideStep = 1;
        FrameLayout guideContainer = findViewById(R.id.guideContainer);
        guideContainer.removeAllViews();
        guideContainer.setVisibility(View.GONE);
        enableActionBar();
        enableButtons();
    }

    public void disableButtons(){
        BottomNavigationView bottomBar = binding.navView;
        MenuItem itemCharacters = bottomBar.getMenu().findItem(R.id.nav_characters);
        MenuItem itemWorls = bottomBar.getMenu().findItem(R.id.nav_worlds);
        MenuItem itemCollectibles = bottomBar.getMenu().findItem(R.id.nav_collectibles);
        itemCharacters.setEnabled(false);
        itemWorls.setEnabled(false);
        itemCollectibles.setEnabled(false);
        if (itemInfo != null){
            itemInfo.setEnabled(false);
        }
    }
    public void enableActionBar(){
getSupportActionBar().show();
        if (itemInfo != null){
            itemInfo.setEnabled(true);
        }
    }

    public void enableButtons(){
        BottomNavigationView bottomBar = binding.navView;
        MenuItem itemCharacters = bottomBar.getMenu().findItem(R.id.nav_characters);
        MenuItem itemWorls = bottomBar.getMenu().findItem(R.id.nav_worlds);
        MenuItem itemCollectibles = bottomBar.getMenu().findItem(R.id.nav_collectibles);
        itemCharacters.setEnabled(true);
        itemWorls.setEnabled(true);
        itemCollectibles.setEnabled(true);
        if (itemInfo != null){
            itemInfo.setEnabled(true);
        }
    }
}

