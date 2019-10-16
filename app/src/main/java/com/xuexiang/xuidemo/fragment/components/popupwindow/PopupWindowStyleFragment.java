package com.xuexiang.xuidemo.fragment.components.popupwindow;

import android.view.View;

import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.adapter.simple.AdapterItem;
import com.xuexiang.xui.adapter.simple.XUISimpleAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.popupwindow.popup.XUISimplePopup;
import com.xuexiang.xuidemo.DemoDataProvider;
import com.xuexiang.xuidemo.R;
import com.xuexiang.xuidemo.base.BaseFragment;
import com.xuexiang.xuidemo.utils.XToastUtils;
import com.xuexiang.xutil.display.DensityUtils;

import butterknife.OnClick;

/**
 * @author xuexiang
 * @date 2017/11/12 下午4:34
 */
@Page(name = "弹出框统一样式")
public class PopupWindowStyleFragment extends BaseFragment {
    private XUISimplePopup mListPopup;
    private XUISimplePopup mMenuPopup;

    @Override
    protected TitleBar initTitle() {
        TitleBar titleBar = super.initTitle();
        titleBar.setCenterClickListener(new View.OnClickListener() {
            @SingleClick
            @Override
            public void onClick(View view) {
                mMenuPopup.showDown(view);
            }
        });
        titleBar.addAction(new TitleBar.TextAction("菜单") {
            @SingleClick
            @Override
            public void performAction(View view) {
                mMenuPopup.showDown(view);
            }
        });
        return titleBar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popupwindow_style;
    }

    @Override
    protected void initViews() {
        initListPopup();
        initMenuPopup();
    }

    @Override
    protected void initListeners() {

    }

    private void initListPopup() {
        mListPopup = new XUISimplePopup(getContext(), DemoDataProvider.dpiItems)
                .create(DensityUtils.dip2px(getContext(), 170), new XUISimplePopup.OnPopupItemClickListener() {
                    @Override
                    public void onItemClick(XUISimpleAdapter adapter, AdapterItem item, int position) {
                        XToastUtils.toast(item.getTitle().toString());
                    }
                })
                .setHasDivider(true);
    }

    private void initMenuPopup() {
        mMenuPopup = new XUISimplePopup(getContext(), DemoDataProvider.menuItems)
                .create(new XUISimplePopup.OnPopupItemClickListener() {
                    @Override
                    public void onItemClick(XUISimpleAdapter adapter, AdapterItem item, int position) {
                        XToastUtils.toast(item.getTitle().toString());
                    }
                });
    }

    @SingleClick
    @OnClick({R.id.btn_commonlist_popup, R.id.btn_menu_popup})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commonlist_popup:
                mListPopup.showDown(v);
                break;
            case R.id.btn_menu_popup:
                mMenuPopup.showDown(v);
                break;
            default:
                break;
        }
    }


}
