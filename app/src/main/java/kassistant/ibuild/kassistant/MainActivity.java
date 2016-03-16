package kassistant.ibuild.kassistant;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kassistant.ibuild.kassistant.magnet.IconCallback;
import kassistant.ibuild.kassistant.magnet.Magnet;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class MainActivity extends FragmentActivity{

    /*private TextToSpeech textToSpeechObject ;
    private boolean isReady = false ;
    List<Locale> localeList = new ArrayList<Locale>();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*findViewById(R.id.listen).setOnClickListener(this);
        textToSpeechObject = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeechObject.setLanguage(Locale.FRENCH);
                    isReady = true;
                }
                Locale[] locales = Locale.getAvailableLocales();
                for (Locale locale : locales) {
                    int res = textToSpeechObject.isLanguageAvailable(locale);
                    if (res == TextToSpeech.LANG_COUNTRY_AVAILABLE) {
                        localeList.add(locale);
                    }
                }
                fillSpinner();
            }
        });
        textToSpeechObject.setSpeechRate(0.7f);*/
        View view = getLayoutInflater().inflate(R.layout.magnet_chat,null,false);
        //textPart = view.findViewById(R.id.chat_text);
        Magnet mMagnet = new Magnet.Builder(this)
                .setIconView(view) // required
                .setIconCallback(new IconCallback() {
                    @Override
                    public void onFlingAway() {

                    }

                    @Override
                    public void onMove(float v, float v1) {

                    }

                    @Override
                    public void onIconClick(View view, float v, float v1) {
                        //textPart.setVisibility(View.VISIBLE);
                    }

                    @Override

                    public void onIconDestroyed() {
                        View view = getLayoutInflater().inflate(R.layout.magnet_chat,null,false);
                        Magnet mMagnet = new Magnet.Builder(MainActivity.this)
                                .setIconView(view)
                                .setIconCallback(null)
                                .setRemoveIconResId(R.drawable.trash)
                                .setRemoveIconShadow(R.drawable.bottom_shadow)
                                .setShouldFlingAway(true)
                                .setShouldStickToWall(true)
                                .setIsOnlyRightWall(true)
                                .setRemoveIconShouldBeResponsive(false)
                                .build();
                        mMagnet.show();

                    }

                    @Override
                    public void onIconTouchDown() {
                        //textPart.setVisibility(View.GONE);
                    }

                    @Override
                    public void onIconTouchUp() {

                    }
                })
                .setRemoveIconResId(R.drawable.trash)
                .setRemoveIconShadow(R.drawable.bottom_shadow)
                .setShouldFlingAway(true)
                .setShouldStickToWall(true)
                .setIsOnlyRightWall(true)
                .setRemoveIconShouldBeResponsive(false)

                .build();

        mMagnet.show();
    }
/*

    public void fillSpinner(){
        Spinner langList = (Spinner) findViewById(R.id.langList) ;
        List<String> langNameList = new ArrayList<String>();
        for (Locale locale:localeList) {
            langNameList.add(locale.getDisplayName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, langNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langList.setAdapter(dataAdapter);

    }
*/
/*

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.listen){
            Spinner langList = (Spinner) findViewById(R.id.langList) ;
            int position = langList.getSelectedItemPosition();
            Locale loc = localeList.get(position);
            Log.d("Language",position+" "+loc.getDisplayName()+" "+loc.getCountry());
            String input = ((EditText)findViewById(R.id.input)).getText().toString();
            if(isReady){
                textToSpeechObject.setLanguage(loc);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    textToSpeechObject.speak(input,TextToSpeech.QUEUE_FLUSH,null,"");
                else
                    textToSpeechObject.speak(input,TextToSpeech.QUEUE_FLUSH,null);
            }
        }
    }

*/
/*
    @Override
    public void onPause(){
        if(textToSpeechObject!=null){
            textToSpeechObject.stop();
        }
        super.onPause();
    }

    @Override
    public void onDestroy(){
        if(textToSpeechObject!=null){
            textToSpeechObject.shutdown();
        }
        textToSpeechObject = null ;
        super.onDestroy();
    }

*/
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
