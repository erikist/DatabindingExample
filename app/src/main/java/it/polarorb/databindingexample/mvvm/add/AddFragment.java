package it.polarorb.databindingexample.mvvm.add;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import it.polarorb.databindingexample.MainActivity;
import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.base.BaseFragment;
import it.polarorb.databindingexample.dagger.DatabindingExampleApplication;
import it.polarorb.databindingexample.databinding.FragmentMvvmAddBinding;

public class AddFragment extends BaseFragment {
    @Inject
    public AddViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DatabindingExampleApplication)getActivity().getApplication()).getDatabindingExampleApplicationComponent().inject(this);
        viewModel.setFragmentManager(getActivity().getSupportFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mvvm_add, container, false);
        FragmentMvvmAddBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(viewModel);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getClass().getSimpleName());
    }
}
