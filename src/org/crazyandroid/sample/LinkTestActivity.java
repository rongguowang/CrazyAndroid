package org.crazyandroid.sample;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;


public class LinkTestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.link);

        // text1 shows the android:autoLink property, which
        // automatically linkifies things like URLs and phone numbers
        // found in the text.  No java code is needed to make this
        // work.

        // text2 has links specified by putting <a> tags in the string
        // resource.  By default these links will appear but not
        // respond to user input.  To make them active, you need to
        // call setMovementMethod() on the TextView object.

        TextView t2 = (TextView) findViewById(R.id.text2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

        // text3 shows creating text with links from HTML in the Java
        // code, rather than from a string resource.  Note that for a
        // fixed string, using a (localizable) resource as shown above
        // is usually a better way to go; this example is intended to
        // illustrate how you might display text that came from a
        // dynamic source (eg, the network).

        TextView t3 = (TextView) findViewById(R.id.text3);
        t3.setText(
            Html.fromHtml(
                "<b>text3:</b>  Text with a " +
                "<a href=\"http://www.google.com\">link</a> " +
                "created in the Java source code using HTML."));
        t3.setMovementMethod(LinkMovementMethod.getInstance());

        // text4 illustrates constructing a styled string containing a
        // link without using HTML at all.  Again, for a fixed string
        // you should probably be using a string resource, not a
        // hardcoded value.

        SpannableString ss = new SpannableString(
            "text4: Click here to dial the phone.");

        ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 6,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan("tel:4155551212"), 13, 17,
                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView t4 = (TextView) findViewById(R.id.text4);
        t4.setText(ss);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
