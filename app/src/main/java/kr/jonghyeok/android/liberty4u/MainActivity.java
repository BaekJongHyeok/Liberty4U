package kr.jonghyeok.android.liberty4u;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import kr.jonghyeok.android.liberty4u.databinding.ActivityMainBinding;
import kr.jonghyeok.android.liberty4u.fragment.HomeFragment;
import kr.jonghyeok.android.liberty4u.fragment.ItemListFragment;
import kr.jonghyeok.android.liberty4u.fragment.GuideFragment;
import kr.jonghyeok.android.liberty4u.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setBottomNavigationView();

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.setSelectedItemId(R.id.fragment_home);
        }
    }

    private void setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.fragment_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
                    return true;

                case R.id.fragment_guide:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new GuideFragment()).commit();
                    return true;

                case R.id.fragment_item_list:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ItemListFragment()).commit();
                    return true;

                case R.id.fragment_settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new SettingsFragment()).commit();
                    return true;

                default:
                    return false;
            }
        });
    }
}