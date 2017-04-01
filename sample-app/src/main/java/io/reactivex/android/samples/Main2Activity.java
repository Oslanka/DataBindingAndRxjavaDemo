package io.reactivex.android.samples;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.android.samples.databinding.ActivityMain2Binding;

public class Main2Activity extends Activity {
    //    private  final CompositeDisposable disposables = new CompositeDisposable();
    private Observable<Bean> observable;

    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);

        ActivityMain2Binding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main2);
        binding.setUser(user);

        final EditText editText = (EditText) findViewById(R.id.edit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setFirstName("" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button button = (Button) findViewById(R.id.button_run_scheduler);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable = Observable.just(new Bean(editText.getText().toString()));
                observable.subscribe(MainActivity.getActivity());
                Main2Activity.this.finish();
            }
        });
    }

//    public static Observable<String> getObservable() {
//        return observable;
//    }
    //    public static Observable<String>  sampleObservable() {
//
//        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
//            @Override
//            public ObservableSource<? extends String> call() throws Exception {
//                // Do some long running operation
//                return Observable.observable("");
//            }
//        });
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        disposables.clear();
    }
}
