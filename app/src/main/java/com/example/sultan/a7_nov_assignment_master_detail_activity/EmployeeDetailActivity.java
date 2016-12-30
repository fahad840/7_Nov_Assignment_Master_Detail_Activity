package com.example.sultan.a7_nov_assignment_master_detail_activity;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EmployeeDetailActivity extends AppCompatActivity {
    EmployeeDetailFragment fragmentEmployeeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        if (savedInstanceState == null) {
            fragmentEmployeeDetail = EmployeeDetailFragment.newInstance(employee);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentEmployeeDetail);
            ft.commit();
        }

    }
}
