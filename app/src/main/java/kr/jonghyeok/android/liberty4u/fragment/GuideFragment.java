package kr.jonghyeok.android.liberty4u.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
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
        hotAdapter.setOnItemClickListener(new HotRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                onClickedItem(position);
            }
        });
        binding.rvHotGuide.setAdapter(hotAdapter);

        recentAdapter = new RecentRecyclerViewAdapter(requireContext(), recentItems);
        binding.rvRecentGuide.setAdapter(recentAdapter);

        addEventClickListener();
    }

    private void addEventClickListener() {
        binding.btnGotoWebGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWebActivity("https://tl.plaync.com/ko-kr/guidebook/index");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binding.getRoot();
    }

    private void onClickedItem(int position) {
        List<String> urls = Arrays.asList(
                "https://tl.plaync.com/ko-kr/guidebook/view?title=%EC%BA%90%EB%A6%AD%ED%84%B0%20%EC%83%81%EC%84%B8%20%EC%A0%95%EB%B3%B4",
                "https://tl.plaync.com/ko-kr/guidebook/view?title=%EC%BD%94%EB%8D%B1%EC%8A%A4",
                "https://tl.plaync.com/ko-kr/guidebook/view?title=%EA%B8%B8%EB%93%9C",
                "https://tl.plaync.com/ko-kr/guidebook/view?title=%EC%A7%80%EB%8F%84",
                "https://tl.plaync.com/ko-kr/guidebook/view?title=%EC%B1%84%ED%8C%85"
        );

        if (position >= 0 && position < urls.size()) {
            startWebActivity(urls.get(position));
        }
    }

    private void startWebActivity(String url) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(myIntent);
    }
}