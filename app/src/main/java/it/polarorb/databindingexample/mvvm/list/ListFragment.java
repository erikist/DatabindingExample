package it.polarorb.databindingexample.mvvm.list;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import it.polarorb.databindingexample.databinding.FragmentMvvmListBinding;

public class ListFragment extends BaseFragment {

    @Inject
    public ListViewModel listViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DatabindingExampleApplication)getActivity().getApplication()).getDatabindingExampleApplicationComponent().inject(this);
        listViewModel.setFragmentManager(getFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mvvm_list, container, false);
        FragmentMvvmListBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(listViewModel);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listViewModel.getAdapter());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getClass().getSimpleName());
        listViewModel.onResume();
    }
}
