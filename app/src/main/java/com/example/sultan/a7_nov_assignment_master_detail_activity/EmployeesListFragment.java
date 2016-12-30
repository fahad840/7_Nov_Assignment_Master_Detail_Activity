package com.example.sultan.a7_nov_assignment_master_detail_activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class EmployeesListFragment extends Fragment {

    private ArrayAdapter<Employee> adapterEmployees;
    private ListView lvEmployees;
    private ListItemSelectedListener listener;


    @Override
    public void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        ArrayList<Employee> employees = Employee.getEmployees();
        adapterEmployees = new ArrayAdapter<Employee>(getActivity(), android.R.layout.simple_list_item_activated_1, employees);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employees_list, container, false);
        lvEmployees = (ListView) view.findViewById(R.id.lvEmployees);
        lvEmployees.setAdapter(adapterEmployees);
        lvEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View employee, int position, long rowId) {
                Employee emp = adapterEmployees.getItem(position);
                listener.ItemSelected(emp);
            }
        });
        return view;
    }

    public interface ListItemSelectedListener {
        public void ItemSelected(Employee employee);
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        lvEmployees.setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ListItemSelectedListener) {
            listener = (ListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString() + "muimplement EmployeeListFragment.ListItemSelectedListener");
        }
    }


}
