package kr.jonghyeok.android.liberty4u.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import kr.jonghyeok.android.liberty4u.R;
import kr.jonghyeok.android.liberty4u.databinding.FragmentGuideBinding;
import kr.jonghyeok.android.liberty4u.databinding.FragmentItemListBinding;

public class ItemListFragment extends Fragment {
    private FragmentItemListBinding binding;
    public ItemListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentItemListBinding.inflate(getLayoutInflater());
        
        addEventListener();
    }

    private void addEventListener() {
        binding.btnWeapon.setOnClickListener(view -> {
            binding.layoutItemListWeaponSubChoices.setVisibility(View.VISIBLE);
            binding.layoutItemListArmorSubChoices.setVisibility(View.GONE);
            binding.layoutItemListAccessorySubChoices.setVisibility(View.GONE);
        });

        binding.btnArmor.setOnClickListener(view -> {
            binding.layoutItemListWeaponSubChoices.setVisibility(View.GONE);
            binding.layoutItemListArmorSubChoices.setVisibility(View.VISIBLE);
            binding.layoutItemListAccessorySubChoices.setVisibility(View.GONE);
        });

        binding.btnAccessory.setOnClickListener(view -> {
            binding.layoutItemListWeaponSubChoices.setVisibility(View.GONE);
            binding.layoutItemListArmorSubChoices.setVisibility(View.GONE);
            binding.layoutItemListAccessorySubChoices.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binding.getRoot();
    }
}