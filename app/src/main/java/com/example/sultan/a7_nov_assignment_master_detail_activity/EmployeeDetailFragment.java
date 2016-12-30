package com.example.sultan.a7_nov_assignment_master_detail_activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EmployeeDetailFragment extends Fragment {

    private Employee employee;

    public static EmployeeDetailFragment newInstance(Employee employee) {
        EmployeeDetailFragment fragmentDemo = new EmployeeDetailFragment();
        Bundle bd = new Bundle();
        bd.putSerializable("employee", employee);
        fragmentDemo.setArguments(bd);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employee = (Employee) getArguments().getSerializable("employee");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_detail, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
        tvTitle.setText(employee.getTitle());
        tvBody.setText(employee.getBody());
        return view;
    }

}