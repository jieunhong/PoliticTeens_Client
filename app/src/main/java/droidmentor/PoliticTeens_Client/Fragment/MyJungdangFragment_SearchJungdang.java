package droidmentor.PoliticTeens_Client.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import droidmentor.PoliticTeens_Client.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyJungdangFragment_SearchJungdang extends Fragment {

    FragmentManager manager;  //Fragment를 관리하는 클래스의 참조변수
    FragmentTransaction tran;  //실제로 Fragment를 추가/삭제/재배치 하는 클래스의 참조변수

    public MyJungdangFragment_SearchJungdang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myjungdangs_searchjungdang, container, false);
        manager = (FragmentManager) getFragmentManager();

        //SegmentedButtonGroup myjundang_buttonGroup = (SegmentedButtonGroup) rootView.findViewById(R.id.myjundang_buttonGroup);
        /*myjundang_buttonGroup.setOnClickListener( new SegmentedButtonGroup.OnClickedButtonPosition(){
            @Override
            public  void onClickedButtonPosition(){

            }
        });*/
        TextView my=(TextView)view.findViewById(R.id.my_jungdang);
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tran = manager.beginTransaction();
                Fragment frag = new MyJungdangFragment();
                tran.replace(R.id.search_jungdang_layout, frag);
                tran.addToBackStack(null);
                tran.commit();
            }
        });

        return view;
    }

}
