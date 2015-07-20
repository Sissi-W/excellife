package com.example.reshello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends FragmentActivity implements OnClickListener{

    private Button addButtom;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        addButtom = (Button)findViewById(R.id.add_button);
        addButtom.setOnClickListener(this);
	}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_button:
                //
                Intent intent = new Intent();
                intent.setClass(this,MyExcelLifeActivity.class);
                this.startActivity(intent);
        }

    }
}
