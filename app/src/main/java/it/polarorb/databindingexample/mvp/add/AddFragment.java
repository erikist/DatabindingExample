package it.polarorb.databindingexample.mvp.add;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import it.polarorb.databindingexample.MainActivity;
import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.base.BaseFragment;
import it.polarorb.databindingexample.dagger.DatabindingExampleApplication;

public class AddFragment extends BaseFragment {
    @Inject
    public AddPresenter addPresenter;
    private Button addButton;
    private EditText whatTextField;
    private EditText howTextField;
    private EditText whenTextField;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DatabindingExampleApplication)getActivity().getApplication()).getDatabindingExampleApplicationComponent().inject(this);
        addPresenter.setFragmentManager(getFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mvp_add, container, false);
        addButton = (Button) view.findViewById(R.id.add_button);
        addButton.setOnClickListener(addPresenter::onAddClicked);
        whatTextField = (EditText) view.findViewById(R.id.what_text_input);
        whatTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addPresenter.setWhatToDo(s.toString());
            }
        });
        howTextField = (EditText) view.findViewById(R.id.how_text_input);
        howTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addPresenter.setHowToDo(s.toString());
            }
        });
        whenTextField = (EditText) view.findViewById(R.id.when_text_input);
        whenTextField.setOnClickListener(addPresenter::onDateClicked);
        whenTextField.setText(addPresenter.getDateString());
        addPresenter.setOnDateChangedListener((view1, year, monthOfYear, dayOfMonth) -> whenTextField.setText(addPresenter.getDateString()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getClass().getSimpleName());
    }
}
