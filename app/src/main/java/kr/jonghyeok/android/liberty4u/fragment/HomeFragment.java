package kr.jonghyeok.android.liberty4u.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.jonghyeok.android.liberty4u.ContentGridAdapter;
import kr.jonghyeok.android.liberty4u.ContentItem;
import kr.jonghyeok.android.liberty4u.R;
import kr.jonghyeok.android.liberty4u.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        ContentGridAdapter adapter = new ContentGridAdapter();
        adapter.addItem(new ContentItem("지팡이"));
        adapter.addItem(new ContentItem("지팡이"));
        adapter.addItem(new ContentItem("지팡이"));
        adapter.addItem(new ContentItem("지팡이"));
        adapter.addItem(new ContentItem("지팡이"));
        adapter.addItem(new ContentItem("지팡이"));

        binding.gridContents.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }
}