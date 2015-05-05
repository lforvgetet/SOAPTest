package com.fis.www.soaptest;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends ActionBarActivity {
Button saxXML;
    Button PullXML;
    Button Clear;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //呼叫webservice

        saxXML=(Button)findViewById(R.id.saxXML );
        PullXML=(Button)findViewById(R.id.PullXML );
        Clear=(Button)findViewById(R.id.Clear );
        textView=(TextView)findViewById(R.id.textView );
        saxXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Books> books= new ArrayList<>();
                try{
                    SAXParserFactory factory= SAXParserFactory.newInstance();
                    SAXParser parser= factory.newSAXParser();
                    SaxXMLHandler handler = new SaxXMLHandler();
                    InputStream is = getApplicationContext().getAssets().open("books.xml");
                    parser.parse(is, handler);
                    is.close();
                    books = handler.getBooks();
                    textView.setText("Size:"+ books.size());
                    for(Books book: books){
                        textView.append("\nISBN:"+book.getIsbn());
                        textView.append("\nAuthor:"+book.getAuthor());
                        textView.append("\nDate:"+book.getPublichdate());

                    }
                }catch(Exception ex){

                   textView.setText(ex.getMessage());
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
