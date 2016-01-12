package com.massivcode.fragmentexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 화면에 동적으로 배치할 프래그먼트 클래스 입니다.
 * <p/>
 * 앞에서도 수업했지만, Fragment 클래스를 만들기 위해서는 Fragment 클래스를 상속받아야 합니다.
 */
public class Fragment1 extends Fragment {

    private String mParam1;
    private String mParam2;


    //    /**
//     * 객체의 생성과 동시에 데이터를 받아서 세팅하려면 생성자를 통해서 해야겠죠?
//     *
//     * 하지만 구글에서는 프래그먼트 클래스에서 기본 생성자 이외의 생성자를 허용하지 않습니다.
//     * 그래서 아래의 부분을 보시면 빨간 밑줄이 쳐져서 관련 메세지를 출력하고 있죠.
//     */
//    public Fragment1(String str1, String str2) {
//    }

    /**
     * 따라서 구글이 권장하는, 권고사항을 따르기 위해선 아래와 같은 메소드를 만들어야 합니다.
     */
    public static Fragment1 newInstance(String param1, String param2) {
        // 우선 프래그먼트 객체를 생성하고
        Fragment1 fragment = new Fragment1();

        // 이 메소드의 파라미터로 들어오는 2개의 문자열 데이터를 보관하기 위한 변수인 Bundle 객체를 생성
        Bundle args = new Bundle();

        // 2개의 문자열 데이터를 번들 객체에 put 하고
        args.putString("param1", param1);
        args.putString("param2", param2);

        // 위에서 생성한 프래그먼트 객체에 setArguments 메소드를 이용하여 위에서 생성한 번들 객체를 세팅합니다.
        fragment.setArguments(args);

        return fragment;
    }

    /**
     * 위에서 setArguments 메소드로 세팅했던 데이터를 꺼내다 쓰는 방법도 알아봐야겠죠?
     * 이전까지 액티비티 클래스에 존재했었던 onCreate 메소드와 동일하게 이것 역시 프래그먼트가 생성되는
     * 시점에 호출되는 메소드 입니다.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 인텐트를 통한 액티비티 전환에 대해서 공부했을때를 생각해보면 getIntent 메소드를 이용해서
         * 데이터가 담겨있는 인텐트 객체를 얻어왔고, 거기서 데이터를 하나씩 꺼내다 썼습니다.
         *
         * 여기서는 getArguments 메소드를 이용합니다.
         */
        if(getArguments() != null) {
            // 위에서 "param1" 이라는 key 로 넣었던 value를 꺼내오고,
            mParam1 = getArguments().getString("param1");
            // "param2" 에 매칭되는 value도 꺼내와서 멤버변수(전역변수)에 각각 대입합니다.
            mParam2 = getArguments().getString("param2");
        }

    }

    /**
     * 마지막으로 위에서 진행했던 과정으로 얻어온 문자열 데이터 2개를 UI에 표시해보겠습니다.
     * TextView 2개에 데이터를 출력할건데요.
     *
     * 프래그먼트의 onCreate() 메소드는 액티비티의 메소드와는 다르게 UI 관련 작업은 할 수 없습니다.
     * 프래그먼트의 UI 를 구성해주는 메소드를 오버라이딩 해야 합니다.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         * 안드로이드의 레이아웃은 xml 파일로 제작하는데,
         * 그렇게 제작한 내용을 소스 코드화 하는 것을 레이아웃 인플레이팅, 인플레이트 라고 표현합니다.
         */

        // 밑의 부분이 바로 액티비티의 setContentView() 메소드와 유사한 역할을 합니다.
        View view = inflater.inflate(R.layout.fragment1, container, false);

        /**
         * 액티비티에서는 그냥 findViewById 하면 되었는데, 프래그먼트는 View 객체에 UI 가 담겨있어서
         * view.findViewById 이런 식으로 접근합니다.
         */
        TextView textView1 = (TextView) view.findViewById(R.id.text1);
        TextView textView2 = (TextView) view.findViewById(R.id.text2);

        /**
         * 그리고 문자열 데이터 2개를 세팅해야겠네요.
         */
        textView1.setText(mParam1);
        textView2.setText(mParam2);

        return view;
    }
}
