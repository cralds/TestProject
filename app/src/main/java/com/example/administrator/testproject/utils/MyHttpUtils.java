package com.example.administrator.testproject.utils;

import com.example.administrator.testproject.BasePresenter;
import com.example.administrator.testproject.ManagerCallback;
import com.example.administrator.testproject.bean.Children;
import com.example.administrator.testproject.bean.ChildrenA;
import com.example.administrator.testproject.bean.Parent;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MyHttpUtils<T extends Parent> {
    private static volatile MyHttpUtils instance;
    public static MyHttpUtils getInstance(){
        if (instance == null){
            synchronized (MyHttpUtils.class){
                instance = new MyHttpUtils();
            }
        }
        return instance;
    }
    public void setGet(RequestParams params,final ManagerCallback<String> callback){
        final Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    public void sendPost(RequestParams params, final ManagerCallback callback, final Class<T> tClass, final BasePresenter presenter){
         Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                T obj = gson.fromJson(result,tClass);
                if (obj.isSuccess()){
                    if (obj instanceof Children){
                        callback.onSuccess(((Children) obj).getData());
                    }
                    if (obj instanceof ChildrenA){
                        callback.onSuccess(((ChildrenA) obj).getData());
                    }
                }
                else{
                    callback.onFailure(obj.getMsg());
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                presenter.isCancel();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                presenter.isCancel();
            }

            @Override
            public void onFinished() {

            }
        });

        presenter.addCancelable(cancelable);
//        Children parent = new Children();
//        parent.setName("cral");
//        parent.setAge(22);
//        parent.setSuccess(true);
//
//        Student student  = new Student();
//        student.setStudentName("student");
//        student.setAge(20);
//        List<Student> list = new ArrayList<>();
//        list.add(student);
//
//        parent.setData(list);
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(parent);
//        T obj = gson.fromJson(jsonStr,tClass);
//        if (obj.isSuccess()){
//            if (obj instanceof Children){
//                callback.onSuccess(((Children) obj).getData());
//            }
//            if (obj instanceof ChildrenA){
//                callback.onSuccess(((ChildrenA) obj).getData());
//            }
//        }
//        else{
//            callback.onFailure(obj.getMsg());
//        }
    }

    public  void download(RequestParams params,final ManagerCallback<String> callback){
        x.http().get(params, new Callback.ProgressCallback<File>() {

            @Override
            public void onSuccess(File result) {
                LogUtil.d("scucess");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.d("onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.d("onCancelled");
            }

            @Override
            public void onFinished() {
                LogUtil.d("onFinished");
            }

            @Override
            public void onWaiting() {
                LogUtil.d("onWaiting");
            }

            @Override
            public void onStarted() {
                LogUtil.d("onStarted");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                LogUtil.d("onLoading"+total+"current"+current);
            }
        });
    }

}
