# DataBindingAndRxjavaDemo

一 Data Binding
官方地址：
https://developer.android.com/topic/libraries/data-binding/index.html?hl=zh-cn#build_environment
1. android {

dataBinding {

        enabled = true
    }
}

2  layout xmlns:android="http://schemas.android.com/apk/res/android">
<data>
<variable name="user" type="com.example.User"/>
<data>
   <LinearLayout </LinearLayout>
   <layout>。
3.  ActivityMain2Binding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main2);
        binding.setUser(user);
4.public class User extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}

5.很简单，很好用，特别是用在adapter上

ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
//or
ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
Event Handling

adapter布局吃重用性不受改变。

二 所谓观察值模式

今天突然看了看Rxjava的简单用法，感觉用法还是很灵活多变，比Eventbus好用，至于性能，不予评论，之前otto临死前把希望给了Rx，而不是Eventbus。
1.compile 'io.reactivex.rxjava2:rxandroid:2.0.1'

2.Observable.just(new Bean(editText.getText().toString()));
3.observable.subscribe(MainActivity.getActivity())
4.MainActivity extends Activity implements Observer<Bean>

@Override public void onSubscribe(Disposable d) {}
@Override public void onNext(Bean value) {/*do something*/ }
@Override public void onError(Throwable e) {}
@Override public void onComplete() {}

如果想用，可以自己简单封装一下，用起来还是挺方便的。


异步
RxJava的另一特性，异步，RxAndroid https://github.com/ReactiveX/RxAndroid 可以代替子线程 和 Handler。
