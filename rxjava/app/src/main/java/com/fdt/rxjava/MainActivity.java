package com.fdt.rxjava;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.security.PrivateKey;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public class MainActivity extends AppCompatActivity {
    public static final String tag = "rxJava";
    private ImageView imageView;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(tag,  "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(tag,  "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(tag,  "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(tag,  "Observable emit 4" + "\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                i++;
                if (i == 2) mDisposable.dispose();

                Log.e(tag, "onNext : value : " + integer + "\n" );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(tag, "onError : value : " + e.getMessage() + "\n" );
            }

            @Override
            public void onComplete() {
                Log.e(tag, "onComplete" + "\n" );
            }
        });

        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> emitter) throws Exception {

            }
        });

    }

    private Disposable mDosposable;


}
