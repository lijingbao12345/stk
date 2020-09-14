package com.example.goods.basemvp.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.goods.R;
//封装toolbar，已经不用
public class BaseToolbar {

    //ToolBar帮助类的构造方法,方便用户自定义ToolBar,进行对象的初始化
    //layoutID:布局资源,context:上下文

    //上下文,把一个Xml布局资源转换成View的时候用到
    private Context context;
    //布局资源
    private FrameLayout contextView;
    //打气筒,为了转换成View对象
    private LayoutInflater inflater;
    //用户传入的XML资源对象
    private View userView;
    //Toolbar的对象,通过getToolBar获取
    private Toolbar toolbar;
    private TextView toolbar_tv;


    public BaseToolbar(Context context, int layoutID) {
        //传递上下文
        this.context = context;
        //因为普通类没有getInflater()方法可以调用,所以传递一个上下文,通过Layout.from()静态方法得到LayoutInfater的一个对象
        inflater = LayoutInflater.from(context);
        //初始化整个内容
        initContextView();
        //初始化用户自定义布局
        initUserView(layoutID);
        //初始化ToolBar对象
        initToolBar();
    }

    /**
     * 初始化整个布局内容
     */
    public void initContextView() {
        //创建一个布局作为视图的容器,视图容器的父容器
        contextView = new FrameLayout(context);
        //设置参数对象,定义宽高都是填充父窗体,
        //ctrl+q
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //把参数对象传递给视图容器
        contextView.setLayoutParams(params);
    }

    //初始化用户自定义的布局
    private void initUserView(int layoutID) {
        //把用户传递过来的XML布局资源转化为一个View对象
        userView = inflater.inflate(layoutID, null);
        //设置参数对象,定义宽高都是填充父窗体
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //把参数对象传递给视图容器
        userView.setLayoutParams(params);
    }

    private void initToolBar() {
        //把一个装有ToolBar的布局资源转换为一个View对象
        View inflate = inflater.inflate(R.layout.activity_tool_bar, contextView);
        //找到布局XML资源里的ToolBar,设置为全局变量
        toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);

        toolbar_tv = inflate.findViewById(R.id.toolbar_tv);

    }

    /**
     * 返回ToolBar的对象,方便用户对ToolBar的自定义
     *
     * @return
     */
    public Toolbar getToolBar() {
        return toolbar;
    }

    public TextView getToolbar_tv() {
        return toolbar_tv;
    }

    /**
     * 获取默认的根布局对象,FrameLayout
     */
    public FrameLayout getContextView() {
        return contextView;
    }

    //使用
/*

    //进行布局加载方法的复写
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //创建ToolBarHelp对象,传递参数,1.上下文 2.布局资源(就由继承ToolBarActivity的Activity去写)
        BaseToolbar toolBarHelp = new BaseToolbar(this, layoutResID);
        //获取封装好的ToolBar对象
        Toolbar toolBar = toolBarHelp.getToolBar();

        TextView toolbar_tv = toolBarHelp.getToolbar_tv();
        //设置ToolBarhelp类中默认指定的根容器
        setContentView(toolBarHelp.getContextView());
        //设置支持ToolBar
        setSupportActionBar(toolBar);
        //自定义一些ToolBar的个性化设置
        onCreateCustomToolbar(toolBar, toolbar_tv);
    }


    */
/**
 * 自定义一些ToolBar的个性设置,继承的Activity记得要对它进行复写
 *
 * @param toolBar
 *//*

    public void onCreateCustomToolbar(Toolbar toolBar, TextView toolbarTv) {
        toolBar.inflateMenu(R.menu.menu_toolbar);
        //直接在这里初始化toolbar标题为空
        toolBar.setTitle("");

        //如果我重写方法的activity或者fragment没有在重写后的方法里面写标题，此标题会默认显示，其余操作同理
        toolbarTv.setText("默认显示的标题");
        //默认显示左上角返回键图标
        toolBar.setNavigationIcon(R.drawable.jz_backward_icon);
    }

    //当用户点击菜单栏中的某一个选项时,会调用该方法,重写此方法,当点击左上方图标时,关闭Activity
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onContextItemSelected(item);
    }
*/

}
