package it.polarorb.databindingexample.mvp.add;


import android.app.DatePickerDialog;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import it.polarorb.databindingexample.common.Formatters;
import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;

public class AddPresenter implements DatePickerDialog.OnDateSetListener {
    private String whatToDo;
    private String howToDo;
    private FragmentManager fragmentManager;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    private int month = Calendar.getInstance().get(Calendar.MONTH);
    private int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private DatePicker.OnDateChangedListener onDateChangedListener;

    public void onDateClicked(View view) {
        DatePickerDialog dialog = new DatePickerDialog(view.getContext(), this, year, month, day);
        dialog.show();
    }

    public void onAddClicked(View view) {
        Todo todo = new Todo(whatToDo, getDate(), howToDo);
        MockData.todoList.add(todo);
        fragmentManager.popBackStack();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.day = dayOfMonth;
        onDateChangedListener.onDateChanged(view, year, month, dayOfMonth);
    }

    private Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    String getDateString() {
        return Formatters.TODO_DATE_FORMATTER.format(getDate());
    }

    void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    void setHowToDo(String howToDo) {
        this.howToDo = howToDo;
    }

    void setOnDateChangedListener(DatePicker.OnDateChangedListener onDateChangedListener) {
        this.onDateChangedListener = onDateChangedListener;
    }
}
