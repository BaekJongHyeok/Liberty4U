package kr.jonghyeok.android.liberty4u.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.jonghyeok.android.liberty4u.R;
import kr.jonghyeok.android.liberty4u.databinding.FragmentGuideBinding;
import kr.jonghyeok.android.liberty4u.ui.view.recyclerview.guide.HotItemList;
import kr.jonghyeok.android.liberty4u.ui.view.recyclerview.guide.HotRecyclerViewAdapter;
import kr.jonghyeok.android.liberty4u.ui.view.recyclerview.guide.RecentItemList;
import kr.jonghyeok.android.liberty4u.ui.view.recyclerview.guide.RecentRecyclerViewAdapter;

public class GuideFragment extends Fragment {
    private FragmentGuideBinding binding;

    private HotRecyclerViewAdapter hotAdapter;
    private RecentRecyclerViewAdapter recentAdapter;
    private List<HotItemList> hotItems;
    private List<RecentItemList> recentItems;

    public GuideFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentGuideBinding.inflate(getLayoutInflater());

        binding.rvHotGuide.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvRecentGuide.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Sample data
        hotItems = new ArrayList<>();
        hotItems.add(new HotItemList(R.drawable.guide_character_detail));
        hotItems.add(new HotItemList(R.drawable.guide_codex));
        hotItems.add(new HotItemList(R.drawable.guide_guild));
        hotItems.add(new HotItemList(R.drawable.guide_map));
        hotItems.add(new HotItemList(R.drawable.guide_chat));

        // Sample data
        recentItems = new ArrayList<>();
        recentItems.add(new RecentItemList("https://example.com/image1.jpg", "출석부", "매일 출석을 통해 보상을 획득할 수 있는 콘텐츠"));
        recentItems.add(new RecentItemList("https://example.com/image2.jpg", "지역성격", "캐릭터가 위치한 지역에 따라 플레이어 간 전투 가능 여부와 사망 페널티가 다르게 적용됩니다."));
        recentItems.add(new RecentItemList("https://example.com/image2.jpg", "파올라의 차원진", "협력하여 강력한 몬스터가 있는 던전을 공략"));

        hotAdapter = new HotRecyclerViewAdapter(requireContext(), hotItems);
        binding.rvHotGuide.setAdapter(hotAdapter);

        recentAdapter = new RecentRecyclerViewAdapter(requireContext(), recentItems);
        binding.rvRecentGuide.setAdapter(recentAdapter);

        addEventClickListener();
    }

    private void addEventClickListener() {
        binding.btnGotoWebGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tl.plaync.com/ko-kr/guidebook/index"));
                startActivity(myIntent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binding.getRoot();
    }
}