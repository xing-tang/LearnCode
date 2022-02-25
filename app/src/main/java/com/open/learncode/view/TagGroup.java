//package com.open.learncode.view;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Color;
//import android.graphics.RectF;
//import android.graphics.drawable.ShapeDrawable;
//import android.graphics.drawable.shapes.RoundRectShape;
//import android.util.AttributeSet;
//import android.util.TypedValue;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.List;
//
//import learncode.open.com.learncode.R;
//
///**
// * TagGroup
// *
// * @Description:
// * @Author: xing.tang
// */
//public class TagGroup extends ViewGroup {
//
//    /**
//     * 行间距
//     */
//    private int verticalSpacing = 0;
//    /**
//     * 列间距
//     */
//    private int horizontalSpacing = 0;
//    /**
//     * 字体大小
//     */
//    private float textSize = 0;
//    /**
//     * 圆角大小
//     */
//    private float tag_radius = 0;
//    /**
//     * 表框粗细大小
//     */
//    private float tag_border = 0;
//    /**
//     * 标签内边距 顶部
//     */
//    private int tag_padding_Top = 0;
//    /**
//     * 标签内边距 底部
//     */
//    private int tag_padding_Bottom = 0;
//    /**
//     * 标签内边距 左边
//     */
//    private int tag_padding_Left = 0;
//    /**
//     * 标签内边距 右边
//     */
//    private int tag_padding_Right = 0;
//    /**
//     * 标签字体颜色
//     */
//    private int tag_color = 0;
//
//    /**
//     * 上下文环境
//     */
//    private Context mContext;
//    /**
//     * 标签颜色值列表
//     */
//    private String[] colors = null;
//
//    public TagGroup(Context context) {
//        this(context, null);
//    }
//
//    public TagGroup(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public TagGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.mContext = context;
//
//        tag_padding_Left = DeviceUtil.dpToPx(context, 4);
//        tag_padding_Top = DeviceUtil.dpToPx(context, 2);
//        tag_padding_Right = DeviceUtil.dpToPx(context, 4);
//        tag_padding_Bottom = DeviceUtil.dpToPx(context, 2);
//        tag_radius = DeviceUtil.dpToPx(context, 2);
//        tag_border = 0.5f;
//        textSize = DeviceUtil.pxToSp(context, 10);
//        verticalSpacing = DeviceUtil.dpToPx(context, 5);
//        horizontalSpacing = DeviceUtil.dpToPx(context, 5);
//        tag_color = Color.parseColor("#333333");
//
//        colors = new String[]{"#DF3031", "#FE7460", "#4BAEEE", "#7ED321", "#F5A623", "#DF3031", "#E93140", "#4BAEEE", "#7ED321", "#F5A623"};
//        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TagGroup, defStyleAttr, R.style.TagGroup);
//        try {
//            textSize = a.getDimension(R.styleable.TagGroup_tag_textSize, textSize);
//            horizontalSpacing = (int) a.getDimension(R.styleable.TagGroup_tag_horizontalSpacing, horizontalSpacing);
//            verticalSpacing = (int) a.getDimension(R.styleable.TagGroup_tag_verticalSpacing, verticalSpacing);
//            tag_padding_Left = (int) a.getDimension(R.styleable.TagGroup_tag_padding_Left, tag_padding_Left);
//            tag_padding_Top = (int) a.getDimension(R.styleable.TagGroup_tag_padding_Top, tag_padding_Top);
//            tag_padding_Right = (int) a.getDimension(R.styleable.TagGroup_tag_padding_Right, tag_padding_Right);
//            tag_padding_Bottom = (int) a.getDimension(R.styleable.TagGroup_tag_padding_Bottom, tag_padding_Bottom);
//            tag_color = a.getColor(R.styleable.TagGroup_tag_textColor, tag_color);
//            tag_radius = a.getDimension(R.styleable.TagGroup_tag_radius, tag_radius);
//            tag_border = a.getDimension(R.styleable.TagGroup_tag_border, tag_border);
//        } finally {
//            a.recycle();
//        }
//
//    }
//
//    /**
//     * dp 转 px
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,13:49
//     * <h3>UpdateTime</h3> 2016/8/4,13:49
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param dp
//     * @return
//     */
//    public int dp2px(float dp) {
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
//                getResources().getDisplayMetrics());
//    }
//
//    /**
//     * sp 转 px
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,13:50
//     * <h3>UpdateTime</h3> 2016/8/4,13:50
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param sp
//     * @return
//     */
//    public float sp2px(float sp) {
//        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, sp,
//                getResources().getDisplayMetrics());
//    }
//
//    /**
//     * 设置标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:08
//     * <h3>UpdateTime</h3> 2016/8/4,11:08
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tags 标签列表
//     */
//    public void setTagView(List<String> tags) {
//        if (tags != null && tags.size() > 0) {
//            setTagView(tags.toArray(new String[tags.size()]));
//        }
//    }
//
//    /**
//     * 设置标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:08
//     * <h3>UpdateTime</h3> 2016/8/4,11:08
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tags 标签列表
//     */
//    public void setTagView(List<String> tags, int tag_color) {
//        if (tags != null && tags.size() > 0) {
//            setTagView(tag_color, tags.toArray(new String[tags.size()]));
//        }
//    }
//
//    /**
//     * 设置标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:08
//     * <h3>UpdateTime</h3> 2016/8/4,11:08
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tags 标签
//     */
//    private void setTagView(String... tags) {
//        removeAllViews();
//        int index = 0;
//        for (final String tag : tags) {
//            appendTags(tag, index);
//            index++;
//            if (index + 1 > colors.length) {
//                index = 0;
//            }
//        }
//    }
//
//    /**
//     * 设置标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:08
//     * <h3>UpdateTime</h3> 2016/8/4,11:08
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tags 标签
//     */
//    private void setTagView(int tag_color, String... tags) {
//        int index = 0;
//        removeAllViews();
//        for (final String tag : tags) {
//            appendTags(tag, index, tag_color);
//            index++;
//            if (index + 1 > colors.length) {
//                index = 0;
//            }
//        }
//    }
//
//    /**
//     * 添加绘制标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:07
//     * <h3>UpdateTime</h3> 2016/8/4,11:07
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tag   标签内容
//     * @param index 颜色值下标
//     */
//    private void appendTags(CharSequence tag, final int index) {
//        TextView tagView = new TextView(mContext);
//        int borderColor = Color.parseColor(colors[index]);
//        tagView.setText(tag);
//        tagView.setPadding(tag_padding_Left, tag_padding_Top, tag_padding_Right, tag_padding_Bottom);
//        tagView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
//        tagView.setTextColor(borderColor);
//        tagView.setBackgroundDrawable(createRoundedRectDrawable(borderColor, tag_radius, tag_border));
//        tagView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (tagClickListener != null) {
//                    tagClickListener.onClick(index);
//                }
//            }
//        });
//        addView(tagView);
//    }
//
//    /**
//     * 添加绘制标签
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:07
//     * <h3>UpdateTime</h3> 2016/8/4,11:07
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param tag   标签内容
//     * @param index 颜色值下标
//     */
//    private void appendTags(CharSequence tag, final int index, int tag_color) {
//        TextView tagView = new TextView(mContext);
//        tagView.setText(tag);
//        tagView.setPadding(tag_padding_Left, tag_padding_Top, tag_padding_Right, tag_padding_Bottom);
//        tagView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
//        tagView.setTextColor(tag_color > 0 ? tag_color : this.tag_color);
//        tagView.setBackgroundResource(R.drawable.bg_taggroup);
//        tagView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (tagClickListener != null) {
//                    tagClickListener.onClick(index);
//                }
//            }
//        });
//        addView(tagView);
//    }
//
//    private OnTagClickListener tagClickListener;
//
//    public void setTagClickListener(OnTagClickListener tagClickListener) {
//        this.tagClickListener = tagClickListener;
//    }
//
//    public interface OnTagClickListener {
//        void onClick(int position);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        final int heigthMode = MeasureSpec.getMode(heightMeasureSpec);
//        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        //测量子视图
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//
//        int width = 0;
//        int heigth = 0;
//
//        int row = 0;//行数
//        int rowWidth = 0;//标记的宽度
//        int rowMaxHeight = 0;//标记的高度
//
//        //获取子View的个数
//        int count = getChildCount();
//
//        //编辑子view
//        for (int i = 0; i < count; i++) {
//            final View child = getChildAt(i);
//            final int childwidth = child.getMeasuredWidth();
//            final int childheigth = child.getMeasuredHeight();
//
//            //判断子View是否被不占位隐藏
//            if (child.getVisibility() != View.GONE) {
//                rowWidth += childwidth;
//                //判断单行的宽度是否已经大于组件的宽度，如果已经大于，则换行
//                if (rowWidth > widthSize) {
//                    rowWidth = childwidth;//下一行的宽度
//                    heigth += rowMaxHeight + verticalSpacing;
//                    rowMaxHeight = childheigth;//下一行的最大高度
//                    row++;//记录行数
//                } else {
//                    //单行的高度
//                    rowMaxHeight = Math.max(rowMaxHeight, childheigth);
//                }
//                rowWidth += horizontalSpacing;
//            }
//        }
//        //最后一行的高度
//        heigth += rowMaxHeight;
//        //最后一行的内间距
//        heigth += getPaddingBottom() + getPaddingTop();
//
//        //如果标签只有一行，则就设置宽度包裹标签
//        if (row == 0) {
//            width += rowWidth;
//            width += getPaddingLeft() + getPaddingRight();
//        } else {
//            //如果标签超过一行，则设置宽度填充父布局
//            width = widthSize;
//        }
//        //设置组件的大小
//        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize : width, heigthMode == MeasureSpec.EXACTLY ? heightSize : heigth);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//        final int parentLeft = getPaddingLeft();
//        final int parantRight = r - l - getPaddingRight();
//        final int parantTop = getPaddingTop();
//        final int paranBottom = b - t - getPaddingBottom();
//
//        int childLeft = parentLeft;
//        int chilidTop = parantTop;
//
//        int rowMaxHeight = 0;
//        final int count = getChildCount();
//
//        for (int i = 0; i < count; i++) {
//
//            final View child = getChildAt(i);
//            final int width = child.getMeasuredWidth();
//            final int height = child.getMeasuredHeight();
//
//            if (child.getVisibility() != View.GONE) {
//                if (childLeft + width > parantRight) {//换行
//                    childLeft = parentLeft;
//                    chilidTop += rowMaxHeight + verticalSpacing;
//                    rowMaxHeight = height;
//                } else {
//                    rowMaxHeight = Math.max(rowMaxHeight, height);
//                }
//                child.layout(childLeft, chilidTop, childLeft + width, chilidTop + height);
//
//                childLeft += width + horizontalSpacing;
//            }
//        }
//    }
//
//    /**
//     * 绘制带边框的背景
//     * <p/>
//     * <h3>Version</h3> 1.0
//     * <h3>CreateTime</h3> 2016/8/4,11:06
//     * <h3>UpdateTime</h3> 2016/8/4,11:06
//     * <h3>CreateAuthor</h3> 陈广重
//     * <h3>UpdateAuthor</h3> 陈广重
//     * <h3>UpdateInfo</h3> (此处输入修改内容,若无修改可不写.)
//     *
//     * @param color      边框颜色
//     * @param radius     圆角值
//     * @param insetWidth 边框粗细
//     * @return
//     */
//    public static ShapeDrawable createRoundedRectDrawable(int color, float radius, float insetWidth) {
//        float[] outerRadii = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
//        float[] innerRadii = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
//        RectF inset = new RectF(insetWidth, insetWidth, insetWidth, insetWidth);
//        RoundRectShape roundRectShape = new RoundRectShape(outerRadii, inset, innerRadii);
//        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
//        shapeDrawable.getPaint().setColor(color);
//        return shapeDrawable;
//    }
//}
