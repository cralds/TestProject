package com.example.administrator.testproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.testproject.R;
import com.example.administrator.testproject.TabActivity.CrashHandler;
import com.rey.material.widget.Button;
import com.rey.material.widget.FloatingActionButton;

import cn.passguard.PassGuardEdit;

/**
 * Created by Administrator on 2016/8/5.
 */
public class FragmentOne extends Fragment {
    private View v;
    public static final String LOGIN_PWD_REGEX = "^[a-zA-Z0-9~!@#\\$%\\^&\\*\\(\\)_\\+`\\-=\\[\\];',\\./\\{\\}\\|:<>\\?]{6,20}$";
    public static final String LOGIN_PWD_INPUT_REGEX = "[a-zA-Z0-9~!@#\\$%\\^&\\*\\(\\)_\\+`\\-=\\[\\];',\\./\\{\\}\\|:<>\\?]*";
    private PassGuardEdit edit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentone,null);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
//        edit = (PassGuardEdit) v.findViewById(R.id.paylogin_pwd);
//        edit = new PassGuardEdit(getActivity(),null);
//        initPass(edit);


//        CrashHandler.getInstance().init(getActivity());
        Button bt_flat = (Button)v.findViewById(R.id.button_bt_flat);
        Button bt_flat_color = (Button)v.findViewById(R.id.button_bt_flat_color);
        Button bt_flat_wave = (Button)v.findViewById(R.id.button_bt_flat_wave);
        Button bt_flat_wave_color = (Button)v.findViewById(R.id.button_bt_flat_wave_color);

        bt_flat_wave_color.applyStyle(R.array.button_raise_wave_color);

        Button bt_raise = (Button)v.findViewById(R.id.button_bt_raise);
        Button bt_raise_color = (Button)v.findViewById(R.id.button_bt_raise_color);
        Button bt_raise_wave = (Button)v.findViewById(R.id.button_bt_raise_wave);
        Button bt_raise_wave_color = (Button)v.findViewById(R.id.button_bt_raise_wave_color);
        FloatingActionButton bt_float = (FloatingActionButton)v.findViewById(R.id.button_bt_float);
        FloatingActionButton bt_float_color = (FloatingActionButton)v.findViewById(R.id.button_bt_float_color);
        FloatingActionButton bt_float_wave = (FloatingActionButton)v.findViewById(R.id.button_bt_float_wave);
        FloatingActionButton bt_float_wave_color = (FloatingActionButton)v.findViewById(R.id.button_bt_float_wave_color);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                }

//                System.out.println(v + " " + ((RippleDrawable)v.getBackground()).getDelayClickType());
            }
        };

        View.OnClickListener listener_delay = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v instanceof  FloatingActionButton){
                    FloatingActionButton bt = (FloatingActionButton)v;
                    bt.setLineMorphingState((bt.getLineMorphingState() + 1) % 2, true);
                }

//                System.out.println(v + " " + ((RippleDrawable)v.getBackground()).getDelayClickType());
            }
        };

        bt_flat.setOnClickListener(listener);
        bt_flat_wave.setOnClickListener(listener);
        bt_raise.setOnClickListener(listener);
        bt_raise_wave.setOnClickListener(listener);
        bt_float.setOnClickListener(listener);
        bt_float_wave.setOnClickListener(listener);

        bt_flat_color.setOnClickListener(listener_delay);
        bt_flat_wave_color.setOnClickListener(listener_delay);
        bt_raise_color.setOnClickListener(listener_delay);
        bt_raise_wave_color.setOnClickListener(listener_delay);
        bt_float_color.setOnClickListener(listener_delay);
        bt_float_wave_color.setOnClickListener(listener_delay);

    }

    /**初始化密码控件**/
    public void initPass(PassGuardEdit pge) {
        pge.useNumberPad(false);// true为仅使用数字键盘，false为使用字母和数字全键盘（默认）
        pge.setMaxLength(20);
        pge.setEncrypt(true);// true为加密状态开启，false为普通输入框
        pge.setButtonPress(true); // true为有按键状态，false为没有
        pge.setShowPassword(true);
        pge.setInputRegex(LOGIN_PWD_INPUT_REGEX);
        pge.setMatchRegex(LOGIN_PWD_REGEX);
        pge.setReorder(PassGuardEdit.KEY_NONE_CHAOS);
        pge.setWatchOutside(true);
        // innerTranPayPwd.EditTextAlwaysShow(true);
        // innerTranPayPwd.needScrollView(true);
        // innerTranPayPwd.setScrollView(findViewById(R.id.main));
        pge.initPassGuardKeyBoard();
        // pge.setCipherKey("13893882396453810022112887149901");
    }
}
