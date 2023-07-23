package com.example.knowledgeninja;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityProfile extends AppCompatActivity implements View.OnClickListener {

  Button editUser;
  Button editFirst;

  Button editLast;
  Button editEmail;
  Button editBirth;
  Button editPFirst;
  Button editPLast;
  Button editPEmail;
  TextView textUserName;
  TextView textFirstName;
  TextView textLastName;
  TextView textEmail;
  TextView textBirth;
  TextView textPFirst;
  TextView textPLast;
  TextView textPEmail;
  EditText input;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    editUser = findViewById(R.id.edUserName); //retrieve button to assign action
    editFirst = findViewById(R.id.edFirstName);
    editLast = findViewById(R.id.edLastName);
    editEmail = findViewById(R.id.edEmail);
    editBirth = findViewById(R.id.edBirth);

    editPFirst = findViewById(R.id.edPFirstName);
    editPLast = findViewById(R.id.edPLastName);
    editPEmail = findViewById(R.id.edPEmail);

    textUserName = findViewById(R.id.UserName); //retrieve text to edit
    textFirstName = findViewById(R.id.FirstName);
    textLastName = findViewById(R.id.LastName);
    textEmail = findViewById(R.id.Email);
    textBirth = findViewById(R.id.BirthDate);

    textPFirst = findViewById(R.id.pFirstName);
    textPLast = findViewById(R.id.pLastName);
    textPEmail = findViewById(R.id.pEmail);

    editUser.setOnClickListener(this);
    editFirst.setOnClickListener(this);
    editLast.setOnClickListener(this);
    editEmail.setOnClickListener(this);
    editBirth.setOnClickListener(this);

    editPFirst.setOnClickListener(this);
    editPLast.setOnClickListener(this);
    editPEmail.setOnClickListener(this);
  }


  public void textEdit(TextView text) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    input = new EditText(this);
    input.setInputType(InputType.TYPE_CLASS_TEXT);
    builder.setView(input);

    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

      public void onClick(DialogInterface dialog, int which) {

        String newUserName = input.getText().toString();
        text.setText(newUserName);
      }
    });
    builder.setNegativeButton("Cancel", null);
    builder.show();

  }

  @Override
  public void onClick(View v) {

    int chkBtn = v.getId();

    if (v.getId() == R.id.edUserName) {
      textEdit(textUserName);
    } else {
      if (v.getId() == R.id.edFirstName) {
        textEdit(textFirstName);
      } else {
        if (v.getId() == R.id.edLastName) {
          textEdit(textLastName);
        } else {
          if (v.getId() == R.id.edBirth) {
            textEdit(textBirth);
          } else {
            if (v.getId() == R.id.edEmail) {
              textEdit(textEmail);
            } else {
              if (v.getId() == R.id.edPFirstName) {
                textEdit(textPFirst);
              } else {
                if (v.getId() == R.id.edPLastName) {
                  textEdit(textPLast);
                } else {
                  if (v.getId() == R.id.edPEmail) {
                    textEdit(textPEmail);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}



