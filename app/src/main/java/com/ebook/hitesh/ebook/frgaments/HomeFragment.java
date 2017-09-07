package com.ebook.hitesh.ebook.frgaments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebook.hitesh.ebook.R;
import com.ebook.hitesh.ebook.adapters.AdpHome;
import com.ebook.hitesh.ebook.models.BookModel;

import java.util.ArrayList;

/**
 * Created by vijay on 27-08-2017.
 */

public class HomeFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private ArrayList<BookModel> bookModelList;
    private AdpHome adpHome;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_home);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));

        bookModelList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookModel bookModel = new BookModel();
            bookModel.setName("Half GirlFriend");
            bookModel.setAuthor("Chetan Bhagat");
            bookModel.setRating(i);

            bookModelList.add(bookModel);
        }
        adpHome = new AdpHome(bookModelList);
        recyclerView.setAdapter(adpHome);
        return rootView;
    }
}
