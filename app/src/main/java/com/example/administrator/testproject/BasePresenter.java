package com.example.administrator.testproject;

import com.example.administrator.testproject.bean.ChildrenA;
import com.example.administrator.testproject.utils.MyHttpUtils;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class BasePresenter {
    private List<Callback.Cancelable> cancelableList = new ArrayList<>();
    public void addCancelable(Callback.Cancelable cancelable){
        cancelableList.add(cancelable);
    }
    public void removeCancelable(Callback.Cancelable cancelable){
        cancelableList.remove(cancelable);
    }
    public void cancelAll(){
        for (int i=0;i<cancelableList.size();i++){
            cancelableList.get(i).cancel();
        }
    }
    public void isCancel(){
        for (int i=0;i<cancelableList.size();i++){
            boolean iscancel = cancelableList.get(i).isCancelled();
        }
    }
    public void test(){
        BaiduParams params = new BaiduParams();
        params.wd = "xUtils";
        MyHttpUtils.getInstance().sendPost(params, new ManagerCallback<String>(){
            @Override
            public void onSuccess(String returnContent) {
                super.onSuccess(returnContent);
                LogUtil.d("String类型"+returnContent);
            }
        },ChildrenA.class,this);
    }
}
