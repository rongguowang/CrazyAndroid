package org.crazyandroid.launcher;


import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.content.Intent;
import android.database.Cursor;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;

public class ViewContactActivity extends Activity{
    private EditText view1 = null;
    private EditText view2 = null;
    private Button button = null;
    final int PICK_CONTENT = 0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontact);

        view1 = (EditText)findViewById(R.id.view1);
        view2 = (EditText)findViewById(R.id.view2);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone_v2");
                startActivityForResult(intent, PICK_CONTENT);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
        case PICK_CONTENT:
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = managedQuery(contactData, null, null, null, null);

                if (cursor.moveToFirst()) {
                    String contactId = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(
                            ContactsContract.Contacts.DISPLAY_NAME));
                    String phoneNumber = "phone Number not found";
                    Cursor phones = getContentResolver().query(ContactsContract.
                            CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.
                            CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);

                    if (phones.moveToFirst()) {
                        phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        view1.setText(contactData.toString());
                        view2.setText(phoneNumber);
                        phones.close();
                    }
                    cursor.close();
                }
            }
            break;
        }
    }
}
