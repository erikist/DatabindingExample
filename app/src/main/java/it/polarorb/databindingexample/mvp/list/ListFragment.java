package it.polarorb.databindingexample.mvp.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import it.polarorb.databindingexample.MainActivity;
import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.base.BaseFragment;
import it.polarorb.databindingexample.dagger.DatabindingExampleApplication;

public class ListFragment extends BaseFragment {

    @Inject
    public ListPresenter listPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DatabindingExampleApplication)getActivity().getApplication()).getDatabindingExampleApplicationComponent().inject(this);
        listPresenter.setFragmentManager(getFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mvp_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setAdapter(listPresenter.getAdapter());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(listPresenter::onAddClicked);
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getClass().getSimpleName());
        listPresenter.onResume();
    }
}
