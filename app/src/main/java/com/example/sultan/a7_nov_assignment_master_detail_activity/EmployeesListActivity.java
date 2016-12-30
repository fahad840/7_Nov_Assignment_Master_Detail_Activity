package com.example.sultan.a7_nov_assignment_master_detail_activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class EmployeesListActivity extends AppCompatActivity implements EmployeesListFragment.ListItemSelectedListener {

    private boolean isRotate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_list);
        checkRotationLayout();
    }

    private void checkRotationLayout() {
        FrameLayout fragmentEmployeeDetil = (FrameLayout) findViewById(R.id.flDetailContainer);
        // If there is a second pane for details
        if (fragmentEmployeeDetil != null) {
            isRotate = true;
            EmployeesListFragment fragmentEmployeesList = (EmployeesListFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmenEmployeesList);
            fragmentEmployeesList.setActivateOnItemClick(true);
        }
    }

    @Override
    public void ItemSelected(Employee employee) {
        if (isRotate) {
            EmployeeDetailFragment fragmentEmployee = EmployeeDetailFragment.newInstance(employee);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentEmployee);
            ft.commit();
        } else {
            Intent intent = new Intent(this, EmployeeDetailActivity.class);
            intent.putExtra("employee", employee);
            startActivity(intent);
        }
    }
}
