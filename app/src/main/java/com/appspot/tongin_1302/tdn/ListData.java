package com.appspot.tongin_1302.tdn;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016-07-15.
 */
public class ListData {
    /**
     * 리스트 정보를 담고 있을 객체 생성
     */
    // 아이콘

    public Drawable mIcon;

    // 제목
    public String mTitle;

    // 날짜
    public String mDate;

    public int mId;

    /**
     * 알파벳 이름으로 정렬
     */
    /*public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(ListData mListDate_1, ListData mListDate_2) {
            return sCollator.compare(mListDate_1.mTitle, mListDate_2.mTitle);
        }
    };*/
}