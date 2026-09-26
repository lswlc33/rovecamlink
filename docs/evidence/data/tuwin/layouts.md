# TUWIN — 布局/菜单/配置 XML 全量解析

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 生成时间：2026-09-21T16:21:58.757Z
> 253 个 XML；逐文件列出根元素、用到的控件类、可见文案（android:text/hint/contentDescription/title/summary）与 id/key
> 文案若为 `@string/xxx`，其真实文本按 `res-strings-default.md` 与 `res-strings-zh.md` 查表

---

## layout（249 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| abc_action_bar_title_item | (aapt2) | LinearLayout TextView | - | @0x7f090051 @0x7f090050 |
| abc_action_bar_up_container | (aapt2) | LinearLayout | - | - |
| abc_action_menu_item_layout | (aapt2) | androidx.appcompat.view.menu.ActionMenuItemView | - | - |
| abc_action_menu_layout | (aapt2) | androidx.appcompat.widget.ActionMenuView | - | - |
| abc_action_mode_bar | (aapt2) | androidx.appcompat.widget.ActionBarContextView | - | - |
| abc_action_mode_close_item_material | (aapt2) | ImageView | ?0x7f030014 | @0x7f09005a |
| abc_activity_chooser_view | (aapt2) | view FrameLayout ImageView | - | @0x7f09005e @0x7f090161 @0x7f0901b4 @0x7f090128 |
| abc_activity_chooser_view_list_item | (aapt2) | LinearLayout ImageView TextView | - | @0x7f09020d @0x7f0901ae @0x7f090368 |
| abc_alert_dialog_button_bar_material | (aapt2) | androidx.appcompat.widget.ButtonBarLayout Button | - | @0x7f0900e7 @0x0102001b @0x0102001a @0x01020019 |
| abc_alert_dialog_material | (aapt2) | androidx.appcompat.widget.AlertDialogLayout include FrameLayout ImageView androidx.core.widget.NestedScrollView LinearLayout android.widget.Space TextView | - | @0x7f090294 @0x7f090114 @0x7f0902df @0x7f0902e0 @0x7f090353 @0x0102000b @0x7f090352 @0x7f0902de @0x7f09011f @0x7f09011e |
| abc_alert_dialog_title_material | (aapt2) | LinearLayout ImageView androidx.appcompat.widget.DialogTitle android.widget.Space | - | @0x7f090379 @0x7f09036d @0x01020006 @0x7f090063 @0x7f090369 |
| abc_cascading_menu_item_layout | (aapt2) | androidx.appcompat.view.menu.ListMenuItemView ImageView LinearLayout TextView Space | - | @0x7f090198 @0x7f090113 @0x7f090368 @0x7f0902f7 @0x7f090321 |
| abc_dialog_title_material | (aapt2) | androidx.appcompat.widget.FitWindowsLinearLayout TextView include | - | @0x7f090368 |
| abc_expanded_menu_layout | (aapt2) | androidx.appcompat.view.menu.ExpandedMenuView | - | @0x7f090162 |
| abc_list_menu_item_checkbox | (aapt2) | CheckBox | - | @0x7f0900f8 |
| abc_list_menu_item_icon | (aapt2) | ImageView | - | @0x7f0901ae |
| abc_list_menu_item_layout | (aapt2) | androidx.appcompat.view.menu.ListMenuItemView RelativeLayout TextView | - | @0x7f090368 @0x7f0902f7 |
| abc_list_menu_item_radio | (aapt2) | RadioButton | - | @0x7f0902b6 |
| abc_popup_menu_header_item_layout | (aapt2) | FrameLayout TextView | - | @0x01020016 |
| abc_popup_menu_item_layout | (aapt2) | androidx.appcompat.view.menu.ListMenuItemView ImageView LinearLayout RelativeLayout TextView | - | @0x7f090198 @0x7f090113 @0x7f090368 @0x7f0902f7 @0x7f090321 |
| abc_screen_content_include | (aapt2) | merge androidx.appcompat.widget.ContentFrameLayout | - | @0x7f09004c |
| abc_screen_simple | (aapt2) | androidx.appcompat.widget.FitWindowsLinearLayout androidx.appcompat.widget.ViewStubCompat include | - | @0x7f09004e @0x7f090059 |
| abc_screen_simple_overlay_action_mode | (aapt2) | androidx.appcompat.widget.FitWindowsFrameLayout include androidx.appcompat.widget.ViewStubCompat | - | @0x7f09004e @0x7f090059 |
| abc_screen_toolbar | (aapt2) | androidx.appcompat.widget.ActionBarOverlayLayout include androidx.appcompat.widget.ActionBarContainer androidx.appcompat.widget.Toolbar androidx.appcompat.widget.ActionBarContextView | - | @0x7f090127 @0x7f09004d @0x7f09004b @0x7f090053 |
| abc_search_dropdown_item_icons_2line | (aapt2) | RelativeLayout ImageView TextView | - | @0x01020007 @0x7f09014f @0x01020008 @0x01020015 @0x01020014 |
| abc_search_view | (aapt2) | LinearLayout TextView ImageView view | @0x7f110015 ｜ @0x7f110013 ｜ @0x7f110016 ｜ @0x7f110017 | @0x7f0902e5 @0x7f0902e4 @0x7f0902e6 @0x7f0902e8 @0x7f0902ea @0x7f0902eb @0x7f0902ec @0x7f0902e7 @0x7f090322 @0x7f0902e9 @0x7f0902ed |
| abc_select_dialog_material | (aapt2) | view | - | @0x7f0902ef |
| abc_tooltip | (aapt2) | LinearLayout TextView | - | @0x7f090243 |
| activity_about | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView | @0x7f110142 ｜ @0x7f110089 | @0x7f090226 @0x7f09040c @0x7f090393 @0x7f090392 @0x7f09039b |
| activity_actionbar | (aapt2) | LinearLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar FrameLayout | - | @0x7f090228 @0x7f09005c @0x7f090183 |
| activity_connect_helper | (aapt2) | LinearLayout ScrollView ImageView TextView Space com.noober.background.view.BLTextView | - | @0x7f0901d9 @0x7f0903cf @0x7f0903a1 @0x7f0903a2 @0x7f090093 |
| activity_connect_helper_detail | (aapt2) | LinearLayout com.noober.background.view.BLLinearLayout TextView | @0x7f11006d ｜ @0x7f11005f ｜ @0x7f1100a4 ｜ @0x7f1100a5 ｜ @0x7f110085 ｜ @0x7f110086 ｜ @0x7f11029a | - |
| activity_daily_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar com.tuwinsmart.tuwin.presentation.widget.video.PlayListControlVideo androidx.recyclerview.widget.RecyclerView LinearLayout ImageView TextView com.noober.background.view.BLTextView | @0x7f1100bc ｜ @0x7f110099 ｜ @0x7f1100c9 | @0x7f090374 @0x7f09042b @0x7f0902c3 @0x7f090216 @0x7f0900a5 @0x7f09009e @0x7f0903b2 |
| activity_device_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar com.tuwinsmart.tuwin.presentation.widget.video.FFmpegPlayerView ImageView ProgressBar TextView com.noober.background.view.BLTextView com.tuwinsmart.tuwin.presentation.widget.BatteryView com.noober.background.view.BLLinearLayout androidx.core.widget.NestedScrollView LinearLayout com.noober.background.view.BLImageView RelativeLayout | @0x7f11016b ｜ @0x7f110270 ｜ @0x7f1103f8 ｜ @0x7f1103ac ｜ @0x7f1103f9 ｜ @0x7f1101f3 ｜ @0x7f1102b6 ｜ @0x7f1102cf ｜ @0x7f1102ce ｜ @0x7f1102a3 ｜ @0x7f1102a4 ｜ @0x7f1103c6 ｜ @0x7f1101db | @0x7f090374 @0x7f09042b @0x7f0902a6 @0x7f09029d @0x7f0903d7 @0x7f0900b8 @0x7f09007b @0x7f090215 @0x7f0900d8 @0x7f0900d1 @0x7f0900ad @0x7f090325 @0x7f0900cf @0x7f0901e7 @0x7f0903de @0x7f0903dd @0x7f090106 @0x7f0901ea @0x7f0903f9 @0x7f0903f5 @0x7f090104 @0x7f0901e8 @0x7f0903e1 @0x7f0903e0 @0x7f090102 @0x7f0901e6 @0x7f0903da @0x7f0903d9 @0x7f0900ff @0x7f09018d @0x7f090395 @0x7f090394 @0x7f0900dc @0x7f0901ed @0x7f090403 @0x7f090402 @0x7f0903a9 |
| activity_device_list | (aapt2) | LinearLayout androidx.recyclerview.widget.RecyclerView | - | @0x7f0902d4 |
| activity_download_list | (aapt2) | FrameLayout androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView TextView | @0x7f110250 | @0x7f0902c4 @0x7f0902c3 @0x7f0903f3 |
| activity_external_web | (aapt2) | LinearLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar FrameLayout | - | @0x7f090375 @0x7f09043e |
| activity_feedback | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout TextView FrameLayout Spinner com.noober.background.view.BLEditText com.noober.background.view.BLTextView | @0x7f1100fd ｜ @0x7f110106 ｜ @0x7f110105 ｜ @0x7f1100f9 ｜ @0x7f1103b6 | @0x7f0903a5 @0x7f0901fa @0x7f09030b @0x7f0903a7 @0x7f09015f @0x7f09015e @0x7f0900da |
| activity_flash | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView | - | @0x7f0901c6 |
| activity_home | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ViewStub LinearLayout ImageView com.noober.background.view.BLTextView | @0x7f11013d ｜ @0x7f11001e ｜ @0x7f11013b | @0x7f090183 @0x7f0902a0 @0x7f090217 @0x7f09009c @0x7f0901e1 @0x7f0903c4 @0x7f090095 @0x7f0901cb @0x7f090390 @0x7f0900b5 @0x7f0901e0 @0x7f0903c3 |
| activity_m3_device_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView LinearLayout TextView FrameLayout com.tuwinsmart.tuwin.presentation.widget.video.FFmpegPlayerView ProgressBar View androidx.recyclerview.widget.RecyclerView | @0x7f110173 ｜ 4K 30FPS ｜ 9.8G/28.8G ｜ @0x7f110382 ｜ @0x7f11016b ｜ @0x7f110134 ｜ 100 | @0x7f0901c0 @0x7f09038f @0x7f09038d @0x7f090213 @0x7f09038c @0x7f090212 @0x7f09038b @0x7f09020f @0x7f0901c5 @0x7f090182 @0x7f090164 @0x7f09029a @0x7f0901c3 @0x7f09020e @0x7f0901c1 @0x7f090387 @0x7f0901c2 @0x7f0900fe @0x7f090422 @0x7f0901c4 @0x7f0901ca @0x7f0902d2 @0x7f0901c8 @0x7f090421 @0x7f090181 @0x7f090423 |
| activity_m3_device_settings | (aapt2) | LinearLayout TextView androidx.recyclerview.widget.RecyclerView | @0x7f11015b | @0x7f0903f4 @0x7f0902d7 |
| activity_m3_factory_reset | (aapt2) | ScrollView LinearLayout FrameLayout TextView | @0x7f1100ef | @0x7f0900a9 |
| activity_m3_firmware_upgrade | (aapt2) | ScrollView LinearLayout FrameLayout TextView ProgressBar Button | @0x7f11008a ｜ V1.0.0 ｜ @0x7f110391 ｜ @0x7f1103fb ｜ 0% ｜ @0x7f11039f | @0x7f09039e @0x7f0900d4 @0x7f0903e9 @0x7f09040b @0x7f09029c @0x7f09040a @0x7f0900e0 |
| activity_m3_storage | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ImageView TextView com.noober.background.view.BLTextView androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout include com.flyco.tablayout.SlidingTabLayout com.tuwinsmart.tuwin.presentation.widget.SwipeViewPager LinearLayout | @0x7f1103cf ｜ @0x7f110397 ｜ @0x7f11038c ｜ @0x7f1100db ｜ @0x7f1100bc ｜ @0x7f110099 | @0x7f090376 @0x7f090107 @0x7f090096 @0x7f090404 @0x7f090184 @0x7f0900a6 @0x7f0903b5 @0x7f0900d3 @0x7f090187 @0x7f09009a @0x7f0903e8 @0x7f0903e7 @0x7f0902e3 @0x7f09032f @0x7f090430 @0x7f090156 @0x7f0903b9 @0x7f090216 @0x7f0900a5 @0x7f0901d5 @0x7f0903b1 @0x7f09009e @0x7f0901d2 @0x7f0903a3 |
| activity_m3_storage_settings | (aapt2) | ScrollView LinearLayout FrameLayout TextView | @0x7f11012d | @0x7f0900ac |
| activity_m3_video_play | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView FrameLayout com.noober.background.view.BLTextView LinearLayout com.tuwinsmart.tuwin.presentation.widget.video.PlayListControlVideo | @0x7f110045 ｜ @0x7f1100d4 ｜ @0x7f11016b ｜ @0x7f1103fd ｜ @0x7f1100bc ｜ @0x7f110099 | @0x7f090374 @0x7f090096 @0x7f090404 @0x7f090185 @0x7f0900dd @0x7f0903b5 @0x7f09020f @0x7f09042a @0x7f09040f @0x7f090216 @0x7f0900a5 @0x7f09009e |
| activity_m3_wifi_settings | (aapt2) | ScrollView LinearLayout FrameLayout TextView | @0x7f11040f ｜ @0x7f110048 | @0x7f0900e3 @0x7f090415 @0x7f0900e4 |
| activity_more_settings | (aapt2) | ScrollView LinearLayout TextView FrameLayout Switch | @0x7f110135 ｜ @0x7f11028d ｜ @0x7f11025c ｜ @0x7f1103ba ｜ @0x7f11029c ｜ @0x7f11029b ｜ @0x7f1100d9 ｜ @0x7f110398 ｜ @0x7f110418 ｜ @0x7f110032 ｜ @0x7f110129 ｜ @0x7f110128 ｜ @0x7f11040c ｜ @0x7f110409 ｜ @0x7f110136 ｜ @0x7f1100a6 ｜ @0x7f110414 ｜ @0x7f1103b3 ｜ @0x7f11011d ｜ @0x7f1100ef | @0x7f090099 @0x7f090397 @0x7f0900db @0x7f0900a7 @0x7f0903b6 @0x7f0900e1 @0x7f09032b @0x7f0900ba @0x7f090327 @0x7f0900e6 @0x7f09032c @0x7f090328 @0x7f09032a @0x7f09032d @0x7f0900e2 @0x7f090414 @0x7f0900a0 @0x7f0903a6 @0x7f0900e5 @0x7f0900d9 @0x7f0900d7 @0x7f0903f2 @0x7f0900ca |
| activity_play_video | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar com.tuwinsmart.tuwin.presentation.widget.video.PlayListControlVideo TextView FrameLayout LinearLayout ProgressBar | @0x7f11010b ｜ @0x7f1100d6 ｜ @0x7f110045 | @0x7f090374 @0x7f09042b @0x7f0903d2 @0x7f090202 @0x7f0903f0 @0x7f0902b4 @0x7f0903ef @0x7f0900d6 |
| activity_privacy | (aapt2) | FrameLayout | - | - |
| activity_ride3_pro_daily_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView FrameLayout com.tuwinsmart.tuwin.presentation.widget.video.FFmpegPlayerView LinearLayout ProgressBar | @0x7f110045 ｜ @0x7f1103da ｜ @0x7f1102d0 ｜ @0x7f11016b ｜ @0x7f1103fd ｜ @0x7f110099 ｜ @0x7f1100bc ｜ @0x7f1100d6 | @0x7f090374 @0x7f090096 @0x7f090404 @0x7f0900d5 @0x7f090201 @0x7f09042b @0x7f090200 @0x7f0900c8 @0x7f0901b5 @0x7f090219 @0x7f09040f @0x7f090216 @0x7f09009e @0x7f0900a5 @0x7f090202 @0x7f0903f0 @0x7f0902b4 @0x7f0903ef @0x7f0900d6 |
| activity_ride3_pro_settings | (aapt2) | LinearLayout ScrollView TextView FrameLayout androidx.recyclerview.widget.RecyclerView | @0x7f110136 ｜ @0x7f1100a3 ｜ @0x7f110412 ｜ @0x7f1103ac ｜ @0x7f11011d ｜ @0x7f1100ef ｜ @0x7f110287 ｜ @0x7f11035b ｜ @0x7f110358 | @0x7f090207 @0x7f0900a0 @0x7f0903a6 @0x7f0900e5 @0x7f0900d9 @0x7f0900ab @0x7f0903bd @0x7f0900a9 @0x7f0900c5 @0x7f0902c7 @0x7f0903df @0x7f0902d7 @0x7f0903ee |
| activity_ride3pro_hour_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ImageView TextView androidx.recyclerview.widget.RecyclerView ProgressBar LinearLayout Button com.tuwinsmart.tuwin.presentation.widget.Ride3ProLoadingCardView | @0x7f11038c ｜ @0x7f1100db ｜ @0x7f11015e ｜ @0x7f11029d ｜ @0x7f110099 ｜ @0x7f1100bc | @0x7f090376 @0x7f090096 @0x7f090404 @0x7f0900a6 @0x7f0900a8 @0x7f090187 @0x7f09009a @0x7f0903e8 @0x7f0903e7 @0x7f0902c3 @0x7f0902ad @0x7f0903b8 @0x7f09015c @0x7f0900cc @0x7f090216 @0x7f09009e @0x7f0901d2 @0x7f0903a3 @0x7f0900a5 @0x7f0901d5 @0x7f0903b1 @0x7f090129 |
| activity_ride3pro_hour_playback_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView LinearLayout Space androidx.core.widget.NestedScrollView FrameLayout com.tuwinsmart.tuwin.presentation.widget.video.FFmpegPlayerView androidx.recyclerview.widget.RecyclerView com.tuwinsmart.tuwin.presentation.ui.album.Ride3ProHourTimelineView View com.tuwinsmart.tuwin.presentation.widget.RecordingControlEventsView ProgressBar | @0x7f110045 ｜ @0x7f1103da ｜ @0x7f11016b ｜ @0x7f1103fd ｜ @0x7f1102d0 ｜ @0x7f11030c ｜ @0x7f11029d ｜ @0x7f1102d9 ｜ @0x7f1102b3 ｜ @0x7f1102ab ｜ @0x7f110099 ｜ @0x7f1100bc ｜ @0x7f1100d6 | @0x7f090374 @0x7f090096 @0x7f090404 @0x7f09036b @0x7f09036c @0x7f0901ee @0x7f090405 @0x7f09036e @0x7f0901ef @0x7f090406 @0x7f0900d5 @0x7f0902a4 @0x7f090201 @0x7f09042b @0x7f0902a6 @0x7f090200 @0x7f090219 @0x7f0900c8 @0x7f0901b5 @0x7f0902a5 @0x7f0900ce @0x7f090306 @0x7f090429 @0x7f0902f3 @0x7f0903ea @0x7f0902c2 @0x7f09040f @0x7f090308 @0x7f0901a9 @0x7f0903c6 @0x7f0903c7 @0x7f0901a8 @0x7f0901a7 @0x7f0903c5 @0x7f0901a5 @0x7f0902c1 @0x7f0901a6 @0x7f0902b8 @0x7f090307 @0x7f090216 @0x7f09009e @0x7f0900a5 @0x7f090202 @0x7f0903f0 @0x7f0902b4 @0x7f0903ef @0x7f0900d6 |
| activity_ride3pro_indexed_storage | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ImageView TextView androidx.fragment.app.FragmentContainerView | @0x7f1103ac | @0x7f090376 @0x7f090096 @0x7f0901b9 |
| activity_ride3pro_storage | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ImageView TextView com.noober.background.view.BLTextView androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout include com.flyco.tablayout.SlidingTabLayout com.tuwinsmart.tuwin.presentation.widget.SwipeViewPager LinearLayout | @0x7f1103ac ｜ @0x7f11038c ｜ @0x7f110099 ｜ @0x7f1100bc | @0x7f090376 @0x7f090107 @0x7f090096 @0x7f090404 @0x7f090184 @0x7f0900a6 @0x7f0903b5 @0x7f0900d3 @0x7f090187 @0x7f09009a @0x7f0903e8 @0x7f0903e7 @0x7f0902e3 @0x7f09032f @0x7f090430 @0x7f090216 @0x7f09009e @0x7f0901d2 @0x7f0903a3 @0x7f0900a5 @0x7f0901d5 @0x7f0903b1 |
| activity_ride5_hour_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout FrameLayout ImageView TextView androidx.recyclerview.widget.RecyclerView ProgressBar LinearLayout Button | @0x7f11038c ｜ @0x7f1100db ｜ @0x7f11015e ｜ @0x7f11029d ｜ @0x7f110099 ｜ @0x7f1100bc | @0x7f090376 @0x7f090096 @0x7f090404 @0x7f0900a6 @0x7f0900a8 @0x7f090187 @0x7f09009a @0x7f0903e8 @0x7f0903e7 @0x7f0902c3 @0x7f0902ad @0x7f0903b8 @0x7f09015c @0x7f0900cc @0x7f090216 @0x7f09009e @0x7f0901d2 @0x7f0903a3 @0x7f0900a5 @0x7f0901d5 @0x7f0903b1 |
| activity_ride5_hour_playback_detail | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView LinearLayout Space androidx.core.widget.NestedScrollView FrameLayout com.tuwinsmart.tuwin.presentation.widget.video.PlayListControlVideo androidx.recyclerview.widget.RecyclerView com.tuwinsmart.tuwin.presentation.ui.album.ride5.Ride5HourTimelineView View com.tuwinsmart.tuwin.presentation.widget.RecordingControlEventsView ProgressBar | @0x7f110045 ｜ @0x7f1103da ｜ @0x7f11016b ｜ @0x7f1103fd ｜ @0x7f110324 ｜ @0x7f11032d ｜ @0x7f11029d ｜ @0x7f110328 ｜ @0x7f110319 ｜ @0x7f110313 ｜ @0x7f110099 ｜ @0x7f1100bc ｜ @0x7f1100d6 | @0x7f090374 @0x7f090096 @0x7f090404 @0x7f09036b @0x7f09036c @0x7f0901ee @0x7f090405 @0x7f09036e @0x7f0901ef @0x7f090406 @0x7f0900d5 @0x7f0902a4 @0x7f090201 @0x7f09042b @0x7f0902a6 @0x7f090200 @0x7f090219 @0x7f0900c8 @0x7f0901b5 @0x7f0902a5 @0x7f0900ce @0x7f090306 @0x7f090429 @0x7f0902f3 @0x7f0903ea @0x7f0902c2 @0x7f09040f @0x7f090308 @0x7f0901a9 @0x7f0903c6 @0x7f0903c7 @0x7f0901a8 @0x7f0901a7 @0x7f0903c5 @0x7f0901a5 @0x7f0902c1 @0x7f0901a6 @0x7f0902b8 @0x7f090307 @0x7f090216 @0x7f09009e @0x7f0900a5 @0x7f090202 @0x7f0903f0 @0x7f0902b4 @0x7f0903ef @0x7f0900d6 |
| activity_show_pics | (aapt2) | androidx.viewpager.widget.ViewPager | - | @0x7f090430 |
| activity_storage_manager | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.noober.background.view.BLView com.tuwinsmart.tuwin.presentation.widget.wave.MultiWaveHeader TextView ImageView View | @0x7f1103a9 ｜ @0x7f110299 ｜ @0x7f110383 ｜ @null ｜ @0x7f11012b ｜ @0x7f1100d8 ｜ @0x7f1103a6 | @0x7f09042c @0x7f09043c @0x7f0903f8 @0x7f0903f7 @0x7f0903fa @0x7f0903e2 @0x7f0900cb @0x7f0901d8 @0x7f09042e @0x7f0903be @0x7f0900c7 |
| activity_storage_tab | (aapt2) | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout include com.flyco.tablayout.SlidingTabLayout com.tuwinsmart.tuwin.presentation.widget.SwipeViewPager | - | @0x7f0902e3 @0x7f09032f @0x7f090430 |
| activity_upgrade | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView LinearLayout TextView ProgressBar com.noober.background.view.BLTextView | @0x7f110097 ｜ @0x7f110269 ｜ @0x7f1100d6 ｜ @0x7f1103de ｜ @0x7f1103df | @0x7f0901f0 @0x7f09021f @0x7f09021b @0x7f0903d8 @0x7f09029b @0x7f090409 @0x7f090408 @0x7f090404 @0x7f0903fb @0x7f09021e @0x7f090407 @0x7f0900df |
| activity_webview | (aapt2) | LinearLayout com.tuwinsmart.tuwin.presentation.widget.ToolBar FrameLayout WebView com.tuwinsmart.tuwin.presentation.widget.WebProgress | - | @0x7f090375 @0x7f09043e @0x7f09043d @0x7f0902ad |
| app_update_dialog_update | (aapt2) | LinearLayout ImageView TextView ScrollView com.azhon.appupdate.view.NumberProgressBar Button View ImageButton | @0x7f110030 ｜ @0x7f110026 | @0x7f0901ce @0x7f090404 @0x7f0903f1 @0x7f0903a4 @0x7f090277 @0x7f0900de @0x7f090208 @0x7f0901aa |
| custom_dialog | (aapt2) | RelativeLayout Button | Ok | @0x7f090135 |
| design_bottom_navigation_item | (aapt2) | merge FrameLayout View ImageView com.google.android.material.internal.BaselineLayout TextView | @null | @0x7f090266 @0x7f090265 @0x7f090267 @0x7f090268 @0x7f09026a @0x7f090269 |
| design_bottom_sheet_dialog | (aapt2) | FrameLayout androidx.coordinatorlayout.widget.CoordinatorLayout View | - | @0x7f090112 @0x7f090118 @0x7f09037b @0x7f09012c |
| design_layout_snackbar | (aapt2) | view | - | - |
| design_layout_snackbar_include | (aapt2) | view TextView Button | - | @0x7f090302 @0x7f090301 |
| design_layout_tab_icon | (aapt2) | ImageView | @null | - |
| design_layout_tab_text | (aapt2) | TextView | - | - |
| design_menu_item_action_area | (aapt2) | FrameLayout | - | - |
| design_navigation_item | (aapt2) | com.google.android.material.internal.NavigationMenuItemView | - | - |
| design_navigation_item_header | (aapt2) | LinearLayout | - | @0x7f09026b |
| design_navigation_item_separator | (aapt2) | FrameLayout View | - | - |
| design_navigation_item_subheader | (aapt2) | TextView | - | - |
| design_navigation_menu | (aapt2) | com.google.android.material.internal.NavigationMenuView | - | @0x7f090130 |
| design_navigation_menu_item | (aapt2) | merge CheckedTextView ViewStub | - | @0x7f09012f @0x7f09012e |
| design_text_input_end_icon | (aapt2) | com.google.android.material.internal.CheckableImageButton | - | @0x7f09035b |
| design_text_input_start_icon | (aapt2) | com.google.android.material.internal.CheckableImageButton | - | @0x7f09035d |
| dialog_common | (aapt2) | com.noober.background.view.BLLinearLayout TextView com.noober.background.view.BLTextView | - | @0x7f090404 @0x7f0903fb @0x7f0900c3 @0x7f0900d2 |
| dialog_connect_helper | (aapt2) | FrameLayout com.noober.background.view.BLLinearLayout TextView com.noober.background.view.BLTextView | @0x7f1103d9 ｜ @0x7f110274 ｜ @0x7f110165 ｜ @0x7f110166 ｜ @0x7f1103ad ｜ @0x7f1103ae ｜ @0x7f1100dc ｜ @0x7f11025a | @0x7f0903ce @0x7f0903cd @0x7f0903f9 @0x7f0903f6 @0x7f0900da @0x7f0900c6 |
| dialog_connect2 | (aapt2) | ScrollView com.noober.background.view.BLConstraintLayout TextView ImageView com.noober.background.view.BLTextView | @0x7f110403 ｜ @null ｜ @0x7f110402 ｜ @0x7f110401 ｜ @0x7f110400 | @0x7f090441 @0x7f0903b0 @0x7f090442 @0x7f0903af @0x7f090413 @0x7f0900da |
| dialog_connection_progress | (aapt2) | FrameLayout com.noober.background.view.BLConstraintLayout ProgressBar ImageView TextView | @null ｜ @0x7f110061 | @0x7f09031d @0x7f0902af @0x7f0901d0 @0x7f09039a @0x7f090398 @0x7f090399 |
| dialog_device_wifi_scan | (aapt2) | FrameLayout com.noober.background.view.BLConstraintLayout TextView View ProgressBar androidx.recyclerview.widget.RecyclerView androidx.constraintlayout.widget.Barrier LinearLayout com.noober.background.view.BLTextView | @0x7f110390 ｜ @0x7f110241 ｜ @0x7f11037e ｜ @0x7f110045 ｜ @0x7f11029f ｜ @0x7f1100aa ｜ @0x7f11005d | @0x7f0903ae @0x7f0903ab @0x7f090132 @0x7f0902b0 @0x7f0902d5 @0x7f090133 @0x7f0903ad @0x7f090131 @0x7f0900a1 @0x7f0900a4 @0x7f090134 @0x7f0903aa @0x7f0900a3 |
| dialog_firmware_download | (aapt2) | FrameLayout com.noober.background.view.BLLinearLayout View com.noober.background.view.BLFrameLayout ImageView TextView ProgressBar com.noober.background.view.BLTextView | @0x7f11011d ｜ @0x7f110119 ｜ @0x7f110117 ｜ 0% ｜ @0x7f110114 | @0x7f09016a @0x7f09016f @0x7f09016b @0x7f09016c @0x7f09016d @0x7f09016e @0x7f090169 |
| dialog_firmware_update | (aapt2) | FrameLayout View com.noober.background.view.BLLinearLayout RelativeLayout com.noober.background.view.BLImageView ImageView TextView ScrollView com.noober.background.view.BLTextView | @0x7f110051 ｜ @0x7f11011c ｜ @0x7f110249 ｜ @0x7f110157 ｜ @0x7f1103e9 | @0x7f090087 @0x7f090115 @0x7f090378 @0x7f09010c @0x7f0901af @0x7f09036a @0x7f090426 @0x7f09041d @0x7f09041e @0x7f09041f |
| dialog_firmware_upload | (aapt2) | FrameLayout com.noober.background.view.BLLinearLayout com.tuwinsmart.tuwin.presentation.widget.FirmwareUploadRingView LinearLayout TextView ImageView ProgressBar View com.noober.background.view.BLTextView | 0% ｜ @0x7f1103ef ｜ @null ｜ @0x7f110120 ｜ @0x7f110121 ｜ @0x7f110126 ｜ -- ｜ @0x7f110124 ｜ @0x7f110125 ｜ @0x7f11029d | @0x7f090174 @0x7f090173 @0x7f090177 @0x7f090172 @0x7f090176 @0x7f090178 @0x7f090179 @0x7f09017a @0x7f090170 @0x7f090171 @0x7f090175 |
| dialog_m3_mode_selector | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout View TextView androidx.recyclerview.widget.RecyclerView | @0x7f110399 | @0x7f090424 @0x7f09038f @0x7f0902d1 |
| dialog_progress | (aapt2) | LinearLayout ProgressBar TextView | - | @0x7f0903cb |
| dialog_ride3pro_storage_loading | (aapt2) | FrameLayout com.tuwinsmart.tuwin.presentation.widget.Ride3ProLoadingCardView | - | @0x7f09031f |
| dialog_setting_selection | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout View TextView androidx.recyclerview.widget.RecyclerView | @0x7f110395 ｜ @0x7f110045 | @0x7f090424 @0x7f0903b0 @0x7f0902d6 @0x7f090097 |
| empty_control_video | (aapt2) | RelativeLayout FrameLayout com.noober.background.view.BLLinearLayout ImageView TextView LinearLayout ProgressBar | @0x7f1100bc ｜ 1x ｜ @0x7f110272 ｜ @0x7f11037f ｜ @0x7f11028a ｜ @0x7f110240 | @0x7f090324 @0x7f0901fd @0x7f090077 @0x7f0901fb @0x7f0900b0 @0x7f0900ae @0x7f0903bf @0x7f0900b3 @0x7f0900b2 @0x7f0901dd @0x7f0903c1 @0x7f0900af @0x7f0901df @0x7f0903c2 @0x7f0901da @0x7f09019b |
| fragment_album | (aapt2) | LinearLayout androidx.constraintlayout.widget.ConstraintLayout TextView ImageView com.noober.background.view.BLTextView FrameLayout com.flyco.tablayout.SlidingTabLayout com.tuwinsmart.tuwin.presentation.widget.SwipeViewPager | @0x7f1100d0 ｜ @0x7f110096 ｜ @0x7f110397 ｜ @0x7f11038c ｜ @0x7f110252 ｜ @0x7f110138 ｜ @0x7f110099 | @0x7f090107 @0x7f0900a6 @0x7f0903b5 @0x7f0900d3 @0x7f090187 @0x7f09009a @0x7f0903e8 @0x7f0903e7 @0x7f09021a @0x7f0900c9 @0x7f090218 @0x7f09032f @0x7f090430 @0x7f09009e @0x7f0903a3 |
| fragment_connect | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView FrameLayout androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView ViewStub | - | @0x7f090100 @0x7f0901e3 @0x7f0902c4 @0x7f0902c3 @0x7f0902a0 |
| fragment_empty_mode | (aapt2) | FrameLayout | - | - |
| fragment_helper | (aapt2) | LinearLayout TextView com.noober.background.view.BLLinearLayout ImageView FrameLayout | @0x7f11013b ｜ @0x7f11030f ｜ @0x7f110374 ｜ @0x7f1101ff ｜ @0x7f11027e ｜ @0x7f11001b ｜ @0x7f110102 ｜ @0x7f110022 | @0x7f0900d0 @0x7f0900c4 @0x7f090092 @0x7f0900aa @0x7f0900b6 @0x7f0903c9 |
| fragment_local_download_list | (aapt2) | LinearLayout androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView ImageView TextView | @0x7f1100bc ｜ @0x7f110099 | @0x7f0902c4 @0x7f0902c3 @0x7f090216 @0x7f0900a5 @0x7f09009e |
| fragment_m3_storage_list | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout androidx.recyclerview.widget.RecyclerView TextView | @0x7f1100db | @0x7f0902c3 @0x7f0903b8 |
| fragment_normal_photo_mode | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout LinearLayout TextView View | - | @0x7f090210 @0x7f090389 @0x7f09008f |
| fragment_normal_record_mode | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout LinearLayout View TextView | - | @0x7f090211 @0x7f0901c9 @0x7f09038a @0x7f090090 |
| fragment_ride3pro_indexed_storage | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView ProgressBar TextView LinearLayout Button com.tuwinsmart.tuwin.presentation.widget.Ride3ProLoadingCardView | @0x7f1100db ｜ @0x7f11015e ｜ @0x7f11029d | @0x7f0902c4 @0x7f0902c3 @0x7f0902ad @0x7f0903b8 @0x7f09015c @0x7f0903ba @0x7f0900cc @0x7f0901a4 |
| fragment_ride3pro_storage_list | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout androidx.recyclerview.widget.RecyclerView ProgressBar TextView FrameLayout | @0x7f1100db ｜ @0x7f1102fd | @0x7f0902c3 @0x7f0902ad @0x7f0903b8 @0x7f090220 @0x7f0903ca |
| fragment_storage_list | (aapt2) | FrameLayout LinearLayout androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView ImageView TextView com.tuwinsmart.tuwin.presentation.widget.ride5.Ride5LoadingCardView | @0x7f1100bc ｜ @0x7f110099 | @0x7f0902c4 @0x7f0902c3 @0x7f090216 @0x7f0900a5 @0x7f09009e @0x7f0901a4 |
| fragment_storage_local | (aapt2) | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout include com.flyco.tablayout.SlidingTabLayout com.tuwinsmart.tuwin.presentation.widget.SwipeViewPager | - | @0x7f09013e @0x7f09032f @0x7f090430 |
| fragment_timelapse_photo_mode | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout LinearLayout TextView com.tuwinsmart.tuwin.presentation.widget.StrokeTextView View | - | @0x7f090210 @0x7f090389 @0x7f09038e @0x7f090091 |
| ime_base_split_test_activity | (aapt2) | LinearLayout | - | - |
| ime_secondary_split_test_activity | (aapt2) | LinearLayout EditText Button | EditText ｜ Hide Ime | @0x7f090153 @0x7f09019d |
| item_alert_view_bottom | (aapt2) | FrameLayout TextView ImageView | @0x7f1100ad | @0x7f0903ff @0x7f0901e9 |
| item_banner_page | (aapt2) | FrameLayout com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView | @null | @0x7f0901cd |
| item_camera_mode | (aapt2) | TextView | Mode | @0x01020014 |
| item_daily_video_item | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView com.noober.background.view.BLView TextView com.noober.background.view.BLImageView | - | @0x7f0901f1 @0x7f0901e9 @0x7f09040e @0x7f0900fd @0x7f0903c8 |
| item_date_header | (aapt2) | FrameLayout TextView com.noober.background.view.BLTextView | @0x7f11038c | @0x7f0903a0 @0x7f0900d3 |
| item_device_entry | (aapt2) | com.noober.background.view.BLLinearLayout ImageView LinearLayout TextView | @0x7f110023 | @0x7f0901d3 @0x7f0903a6 @0x7f0901cc |
| item_device_header | (aapt2) | TextView | @0x7f110374 | @0x7f090396 |
| item_device_wifi | (aapt2) | com.noober.background.view.BLConstraintLayout ImageView View TextView com.noober.background.view.BLTextView | @null ｜ @0x7f11005a | @0x7f0901d4 @0x7f09042d @0x7f0903ac @0x7f0900a2 |
| item_download_list_item | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView com.noober.background.view.BLView TextView FrameLayout ImageView | @0x7f110379 ｜ @0x7f1103fa ｜ @0x7f11029e ｜ @0x7f11037b | @0x7f0901f1 @0x7f09040d @0x7f090411 @0x7f0903db @0x7f090410 @0x7f090105 @0x7f090432 @0x7f090433 @0x7f090098 |
| item_download_list_title | (aapt2) | FrameLayout TextView LinearLayout | @0x7f1100c2 ｜ @0x7f11004d | @0x7f0903a0 @0x7f0900cd @0x7f0900d3 |
| item_download_list_video_date_title | (aapt2) | FrameLayout TextView com.noober.background.view.BLTextView | @0x7f110376 ｜ @0x7f11038c | @0x7f0903a0 @0x7f0900d3 |
| item_download_list_video_item | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView com.noober.background.view.BLView TextView com.noober.background.view.BLImageView | @0x7f11037d | @0x7f0901f1 @0x7f0901e4 @0x7f0903c8 @0x7f0900fd |
| item_feedback_device_spinner | (aapt2) | TextView | - | @0x01020014 |
| item_home_list_add_device | (aapt2) | com.noober.background.view.BLFrameLayout com.noober.background.view.BLTextView | @0x7f11001c | @0x7f090186 |
| item_home_list_brand | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout androidx.cardview.widget.CardView androidx.viewpager2.widget.ViewPager2 com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView | @null | @0x7f0900ec @0x7f090431 @0x7f0901e5 |
| item_home_list_device | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout androidx.cardview.widget.CardView FrameLayout ImageView ProgressBar TextView androidx.appcompat.widget.AppCompatTextView com.noober.background.view.BLImageView | @0x7f1100de ｜ @0x7f110099 ｜ @0x7f11025b ｜ @0x7f1100a0 | @0x7f090188 @0x7f0901f2 @0x7f09029d @0x7f09009f @0x7f09009e @0x7f0901d3 @0x7f0903dc @0x7f0903a6 @0x7f0903a8 @0x7f0900bb @0x7f0900b7 @0x7f090101 @0x7f090094 |
| item_home_list_device_title | (aapt2) | TextView | @0x7f1100a1 | - |
| item_home_list_service_card | (aapt2) | androidx.cardview.widget.CardView androidx.constraintlayout.widget.ConstraintLayout ImageView TextView | @0x7f11008f ｜ @0x7f11008e ｜ @0x7f11008d | @0x7f0901e2 @0x7f090404 @0x7f0903fc @0x7f09009d |
| item_home_list_weather | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.ExcludeFontPaddingTextView TextView ProgressBar | @0x7f11037c ｜ @0x7f110378 ｜ @0x7f11037a ｜ @0x7f110253 | @0x7f090086 @0x7f0903fe @0x7f09039f @0x7f0903cc @0x7f090221 @0x7f0903d0 |
| item_m3_mode_option | (aapt2) | LinearLayout ImageView TextView | Mode | @0x7f0901c7 @0x7f090388 |
| item_m3_setting | (aapt2) | LinearLayout TextView Switch ImageView | Setting Name ｜ Value | @0x7f0903ec @0x7f0903ed @0x7f090329 @0x7f0901cc |
| item_m3_storage_file | (aapt2) | FrameLayout ImageView LinearLayout TextView com.noober.background.view.BLImageView | @0x7f1103c4 ｜ @0x7f11010e | @0x7f0901ec @0x7f0901d7 @0x7f090400 @0x7f0900f8 |
| item_photo_view_with_loading | (aapt2) | FrameLayout com.github.chrisbanes.photoview.PhotoView ProgressBar | - | @0x7f0902a2 @0x7f0902ad |
| item_ride3_pro_settings_item | (aapt2) | LinearLayout TextView | - | @0x7f0903ec @0x7f0903eb |
| item_ride3_pro_settings_section | (aapt2) | TextView | - | @0x7f0903e5 |
| item_ride3pro_hour_recording | (aapt2) | FrameLayout ImageView View LinearLayout TextView | - | @0x7f0900ee @0x7f0901ec @0x7f090412 @0x7f09040e |
| item_ride3pro_selected_video | (aapt2) | FrameLayout View androidx.constraintlayout.widget.ConstraintLayout ImageView TextView androidx.appcompat.widget.AppCompatTextView | @0x7f1102ba | @0x7f0902f2 @0x7f0902f1 @0x7f0900ed @0x7f090365 @0x7f0901ec @0x7f090412 @0x7f0903bc @0x7f09039c @0x7f0903b7 @0x7f0900bc |
| item_ride5_hour_recording | (aapt2) | FrameLayout ImageView View LinearLayout TextView | - | @0x7f0900ee @0x7f0901ec @0x7f090412 @0x7f09040e |
| item_ride5_selected_video | (aapt2) | FrameLayout View androidx.constraintlayout.widget.ConstraintLayout ImageView TextView androidx.appcompat.widget.AppCompatTextView | @0x7f11031e | @0x7f0902f2 @0x7f0902f1 @0x7f0900ed @0x7f090365 @0x7f0901ec @0x7f090412 @0x7f0903bc @0x7f09039c @0x7f0903b7 @0x7f0900bc |
| item_setting_option | (aapt2) | TextView | Option | @0x7f0903d1 |
| item_storage_list_download | (aapt2) | com.noober.background.view.BLConstraintLayout com.noober.background.view.BLTextView ImageView | @0x7f1100c3 ｜ @0x7f11024d | @0x7f090103 @0x7f0903b3 @0x7f0903b4 @0x7f0901cc |
| item_storage_list_empty | (aapt2) | TextView | @0x7f110256 | @0x7f0903f3 |
| item_storage_list_item | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.noober.background.view.BLImageView com.noober.background.view.BLView ImageView TextView | @0x7f110098 | @0x7f0901f1 @0x7f0900fd @0x7f0903c8 |
| item_storage_list_loading | (aapt2) | LinearLayout ProgressBar TextView | @0x7f11015f | - |
| item_storage_list_sdcard | (aapt2) | com.noober.background.view.BLConstraintLayout TextView ImageView FrameLayout com.noober.background.view.BLView | @0x7f110283 ｜ @0x7f1103b4 | @0x7f0903e3 @0x7f0903e4 @0x7f090432 @0x7f090433 |
| item_storage_list_section | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout TextView ImageView | @0x7f1103a5 | @0x7f0903e5 @0x7f0900a8 |
| item_storage_list_video_date_title | (aapt2) | FrameLayout TextView com.noober.background.view.BLTextView | @0x7f110377 ｜ @0x7f11038c | @0x7f0903a0 @0x7f0900d3 |
| item_storage_list_video_item | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView com.noober.background.view.BLView ImageView TextView com.noober.background.view.BLImageView | @0x7f11037d | @0x7f0901f1 @0x7f0901d6 @0x7f0903bb @0x7f0900fd @0x7f0903c8 |
| layout_actionbar | (aapt2) | com.noober.background.view.BLLinearLayout RelativeLayout ImageView TextView LinearLayout ImageButton | - | @0x7f090214 @0x7f0901ab @0x7f090404 @0x7f0901e3 @0x7f0901ad @0x7f0901ac |
| layout_battery | (aapt2) | LinearLayout androidx.constraintlayout.widget.ConstraintLayout com.noober.background.view.BLView TextView ImageView | 99 | @0x7f090080 @0x7f090084 @0x7f090085 @0x7f090082 @0x7f090081 @0x7f090083 @0x7f090391 @0x7f0901cf |
| layout_tab | (aapt2) | RelativeLayout TextView com.flyco.tablayout.widget.MsgView | - | @0x7f0903fd @0x7f0902d0 |
| layout_tab_bottom | (aapt2) | RelativeLayout LinearLayout TextView ImageView com.flyco.tablayout.widget.MsgView | - | @0x7f09021c @0x7f0903fd @0x7f0901eb @0x7f0902d0 |
| layout_tab_left | (aapt2) | RelativeLayout LinearLayout ImageView TextView com.flyco.tablayout.widget.MsgView | - | @0x7f09021c @0x7f0901eb @0x7f0903fd @0x7f0902d0 |
| layout_tab_right | (aapt2) | RelativeLayout LinearLayout TextView ImageView com.flyco.tablayout.widget.MsgView | - | @0x7f09021c @0x7f0903fd @0x7f0901eb @0x7f0902d0 |
| layout_tab_segment | (aapt2) | RelativeLayout LinearLayout TextView com.flyco.tablayout.widget.MsgView | - | @0x7f09021c @0x7f0903fd @0x7f0902d0 |
| layout_tab_top | (aapt2) | RelativeLayout LinearLayout ImageView TextView com.flyco.tablayout.widget.MsgView | - | @0x7f09021c @0x7f0901eb @0x7f0903fd @0x7f0902d0 |
| layout_toast | (aapt2) | FrameLayout com.noober.background.view.BLTextView | - | @0x7f09036f |
| layout_video_cover | (aapt2) | ImageView | - | @0x7f0901d1 |
| m3_alert_dialog | (aapt2) | androidx.appcompat.widget.AlertDialogLayout include FrameLayout ImageView androidx.core.widget.NestedScrollView LinearLayout android.widget.Space TextView | @null | @0x7f090294 @0x7f090114 @0x7f0902df @0x7f0902e0 @0x7f090353 @0x0102000b @0x7f090352 @0x7f0902de @0x7f09011f @0x7f09011e |
| m3_alert_dialog_actions | (aapt2) | ScrollView androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @0x7f0900e7 @0x0102001b @0x7f090309 @0x0102001a @0x01020019 |
| m3_alert_dialog_title | (aapt2) | LinearLayout ImageView androidx.appcompat.widget.DialogTitle android.widget.Space | - | @0x7f090379 @0x7f09036d @0x01020006 @0x7f090063 @0x7f090369 |
| m3_auto_complete_simple_item | (aapt2) | TextView | - | - |
| m3_side_sheet_dialog | (aapt2) | FrameLayout androidx.coordinatorlayout.widget.CoordinatorLayout View | - | @0x7f090112 @0x7f090118 @0x7f09037b @0x7f090227 |
| material_chip_input_combo | (aapt2) | com.google.android.material.timepicker.ChipTextInputComboView | - | - |
| material_clock_display | (aapt2) | LinearLayout include | - | @0x7f09022d @0x7f090236 @0x7f090239 |
| material_clock_display_divider | (aapt2) | TextView | - | - |
| material_clock_period_toggle | (aapt2) | com.google.android.material.button.MaterialButtonToggleGroup com.google.android.material.button.MaterialButton | @0x7f1101de ｜ @0x7f1101ec ｜ @0x7f1101f0 | @0x7f090234 @0x7f090232 @0x7f090233 |
| material_clock_period_toggle_land | (aapt2) | com.google.android.material.button.MaterialButtonToggleGroup Button | @0x7f1101ec ｜ @0x7f1101f0 | @0x7f090234 @0x7f090232 @0x7f090233 |
| material_clockface_textview | (aapt2) | TextView | - | - |
| material_clockface_view | (aapt2) | merge com.google.android.material.timepicker.ClockHandView | - | @0x7f09022f @0x7f090230 |
| material_radial_view_group | (aapt2) | merge View | - | @0x7f0900fc |
| material_textinput_timepicker | (aapt2) | LinearLayout include | - | @0x7f090234 |
| material_time_chip | (aapt2) | com.google.android.material.chip.Chip | - | - |
| material_time_input | (aapt2) | com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText TextView | - | @0x7f090237 |
| material_timepicker | (aapt2) | merge androidx.constraintlayout.helper.widget.Flow include com.google.android.material.timepicker.ClockFaceView | - | @0x7f09023c @0x7f09022e @0x7f09022d @0x7f090234 @0x7f09022f |
| material_timepicker_dialog | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout TextView com.google.android.material.timepicker.TimePickerView ViewStub com.google.android.material.button.MaterialButton Button | @0x7f1101f1 ｜ @0x7f11023d ｜ @0x7f11023e | @0x7f09019c @0x7f09023f @0x7f09023a @0x7f09023d @0x7f09023b @0x7f09023e |
| material_timepicker_textinput_display | (aapt2) | LinearLayout include | - | @0x7f090235 @0x7f090238 |
| mtrl_alert_dialog | (aapt2) | androidx.appcompat.widget.AlertDialogLayout include FrameLayout View androidx.core.widget.NestedScrollView LinearLayout android.widget.Space TextView | - | @0x7f090294 @0x7f090114 @0x7f0902df @0x7f0902e0 @0x7f090353 @0x0102000b @0x7f090352 @0x7f0902de @0x7f09011f @0x7f09011e |
| mtrl_alert_dialog_actions | (aapt2) | ScrollView androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @0x7f0900e7 @0x0102001b @0x7f090309 @0x0102001a @0x01020019 |
| mtrl_alert_dialog_title | (aapt2) | LinearLayout ImageView androidx.appcompat.widget.DialogTitle android.widget.Space | - | @0x7f090379 @0x7f09036d @0x01020006 @0x7f090063 @0x7f090369 |
| mtrl_alert_select_dialog_item | (aapt2) | TextView | - | @0x01020014 |
| mtrl_alert_select_dialog_multichoice | (aapt2) | CheckedTextView | - | @0x01020014 |
| mtrl_alert_select_dialog_singlechoice | (aapt2) | CheckedTextView | - | @0x01020014 |
| mtrl_auto_complete_simple_item | (aapt2) | TextView | - | - |
| mtrl_calendar_day | (aapt2) | TextView | - | - |
| mtrl_calendar_day_of_week | (aapt2) | TextView | - | - |
| mtrl_calendar_days_of_week | (aapt2) | GridView | - | @0x7f09024f |
| mtrl_calendar_horizontal | (aapt2) | LinearLayout include FrameLayout androidx.recyclerview.widget.RecyclerView | - | @0x7f090253 @0x7f090255 @0x7f09024e |
| mtrl_calendar_month | (aapt2) | com.google.android.material.datepicker.MaterialCalendarGridView | - | @0x7f090246 |
| mtrl_calendar_month_labeled | (aapt2) | LinearLayout TextView include | - | @0x7f09024b |
| mtrl_calendar_month_navigation | (aapt2) | LinearLayout FrameLayout com.google.android.material.button.MaterialButton | @0x7f110211 ｜ @0x7f110210 | @0x7f090247 @0x7f090248 @0x7f09024a @0x7f090249 |
| mtrl_calendar_months | (aapt2) | androidx.recyclerview.widget.RecyclerView | - | @0x7f090252 |
| mtrl_calendar_vertical | (aapt2) | LinearLayout include View | - | - |
| mtrl_calendar_year | (aapt2) | TextView | - | - |
| mtrl_layout_snackbar | (aapt2) | view | - | - |
| mtrl_layout_snackbar_include | (aapt2) | view TextView Button | - | @0x7f090302 @0x7f090301 |
| mtrl_navigation_rail_item | (aapt2) | merge FrameLayout View ImageView com.google.android.material.internal.BaselineLayout TextView | @null | @0x7f090266 @0x7f090265 @0x7f090267 @0x7f090268 @0x7f09026a @0x7f090269 |
| mtrl_picker_actions | (aapt2) | LinearLayout Button | @0x7f110215 ｜ @0x7f110216 | @0x7f090123 @0x7f0900eb @0x7f090110 |
| mtrl_picker_dialog | (aapt2) | LinearLayout include androidx.fragment.app.FragmentContainerView | - | @0x7f090251 @0x7f090250 |
| mtrl_picker_fullscreen | (aapt2) | LinearLayout include androidx.fragment.app.FragmentContainerView | - | @0x7f09025a @0x7f090250 |
| mtrl_picker_header_dialog | (aapt2) | merge LinearLayout FrameLayout include View | - | @0x7f09025b @0x7f09025d |
| mtrl_picker_header_fullscreen | (aapt2) | merge LinearLayout com.google.android.material.button.MaterialButton FrameLayout TextView include View | @0x7f110215 ｜ @0x7f110228 | @0x7f090191 @0x7f0900eb @0x7f09025d @0x7f090262 @0x7f09025c @0x7f090110 |
| mtrl_picker_header_selection_text | (aapt2) | TextView | - | @0x7f09025c |
| mtrl_picker_header_title_text | (aapt2) | TextView | - | @0x7f090262 |
| mtrl_picker_header_toggle | (aapt2) | com.google.android.material.internal.CheckableImageButton | - | @0x7f09025e |
| mtrl_picker_text_input_date | (aapt2) | FrameLayout com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText | @0x7f11022a | @0x7f090254 @0x7f09025f |
| mtrl_picker_text_input_date_range | (aapt2) | ScrollView LinearLayout com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText Space | @0x7f11022c ｜ @0x7f11022b | @0x7f090261 @0x7f090260 |
| mtrl_search_bar | (aapt2) | TextView | - | @0x7f09027f |
| mtrl_search_view | (aapt2) | merge View com.google.android.material.internal.ClippableRoundedCornerLayout LinearLayout FrameLayout com.google.android.material.appbar.MaterialToolbar TextView EditText ImageButton com.google.android.material.internal.TouchObserverFrameLayout | @0x7f11038a | @0x7f090288 @0x7f090287 @0x7f090280 @0x7f09028a @0x7f090286 @0x7f09028c @0x7f090284 @0x7f09028b @0x7f090289 @0x7f090285 @0x7f090281 @0x7f090283 @0x7f090282 |
| notification_action | (aapt2) | LinearLayout ImageView TextView | - | @0x7f090052 @0x7f090055 @0x7f09005b |
| notification_action_tombstone | (aapt2) | LinearLayout ImageView TextView | - | @0x7f090052 @0x7f090055 @0x7f09005b |
| notification_media_action | (aapt2) | ImageButton | - | @0x7f090041 |
| notification_media_cancel_action | (aapt2) | ImageButton | - | @0x7f0900ea |
| notification_template_big_media | (aapt2) | RelativeLayout include LinearLayout ImageView | - | @0x7f09031c @0x7f090242 @0x7f090054 |
| notification_template_big_media_custom | (aapt2) | RelativeLayout include LinearLayout FrameLayout DateTimeView Chronometer TextView ImageView | - | @0x7f09031c @0x7f090276 @0x7f090275 @0x7f0902cb @0x7f090366 @0x7f0900fa @0x7f0901ba @0x7f090242 @0x7f090054 |
| notification_template_big_media_narrow | (aapt2) | RelativeLayout ImageView include LinearLayout | - | @0x7f09031c @0x7f0901ae @0x7f090242 @0x7f090054 |
| notification_template_big_media_narrow_custom | (aapt2) | RelativeLayout ImageView include LinearLayout FrameLayout DateTimeView Chronometer TextView | - | @0x7f09031c @0x7f0901ae @0x7f090276 @0x7f090275 @0x7f0902cb @0x7f090366 @0x7f0900fa @0x7f0901ba @0x7f090242 @0x7f090054 |
| notification_template_custom_big | (aapt2) | FrameLayout include LinearLayout ViewStub TextView ImageView | - | @0x7f090274 @0x7f090276 @0x7f090275 @0x7f0902cb @0x7f090366 @0x7f0900fa @0x7f0901ba @0x7f090054 @0x7f09005d |
| notification_template_icon_group | (aapt2) | FrameLayout ImageView | - | @0x7f0901b0 @0x7f0901ae @0x7f0902ca |
| notification_template_lines_media | (aapt2) | LinearLayout TextView DateTimeView Chronometer | - | @0x7f090209 @0x7f090368 @0x7f090366 @0x7f0900fa @0x7f09033e @0x7f09020a @0x7f09033d @0x7f0901ba |
| notification_template_media | (aapt2) | LinearLayout include ImageView | - | @0x7f09031c @0x7f090242 @0x7f090159 |
| notification_template_media_custom | (aapt2) | LinearLayout include FrameLayout DateTimeView Chronometer TextView ImageView | - | @0x7f09031c @0x7f090276 @0x7f090275 @0x7f0902cb @0x7f090366 @0x7f0900fa @0x7f0901ba @0x7f090242 @0x7f090159 |
| notification_template_part_chronometer | (aapt2) | Chronometer | - | @0x7f0900fa |
| notification_template_part_time | (aapt2) | DateTimeView | - | @0x7f090366 |
| play_list_control_video | (aapt2) | RelativeLayout FrameLayout com.noober.background.view.BLLinearLayout ImageView TextView LinearLayout SeekBar ProgressBar | @0x7f1100bc ｜ @0x7f110271 ｜ @0x7f110272 ｜ @0x7f11037f ｜ @0x7f110098 ｜ 1x ｜ 00:00/00:00 | @0x7f090324 @0x7f0901fd @0x7f090077 @0x7f0901fb @0x7f0900b0 @0x7f0900ae @0x7f0903bf @0x7f0900b3 @0x7f0901f9 @0x7f0901dc @0x7f09011c @0x7f0902ac @0x7f09037a @0x7f0901de @0x7f0901db @0x7f0901fc @0x7f0900b1 @0x7f0903c0 @0x7f0900b4 @0x7f09008a @0x7f0901da @0x7f09019b @0x7f0903e6 |
| select_dialog_item_material | (aapt2) | TextView | - | @0x01020014 |
| select_dialog_multichoice_material | (aapt2) | CheckedTextView | - | @0x01020014 |
| select_dialog_singlechoice_material | (aapt2) | CheckedTextView | - | @0x01020014 |
| support_simple_spinner_dropdown_item | (aapt2) | TextView | - | @0x01020014 |
| toast_layout | (aapt2) | LinearLayout ImageView TextView | @0x7f1103d4 | @0x7f090371 @0x7f090370 @0x7f090372 |
| video_brightness | (aapt2) | LinearLayout RelativeLayout ImageView TextView | 50% | @0x7f09006d @0x7f090113 @0x7f09006e @0x7f09006c |
| video_layout_ad | (aapt2) | RelativeLayout LinearLayout View ImageView ProgressBar TextView | @0x7f11014f ｜ 00 | @0x7f090324 @0x7f090190 @0x7f090221 @0x7f090316 @0x7f0901f5 @0x7f090061 |
| video_layout_custom | (aapt2) | RelativeLayout LinearLayout TextView SeekBar ImageView ProgressBar moe.codeest.enviews.ENDownloadView moe.codeest.enviews.ENPlayView | 00:00 | @0x7f090324 @0x7f090364 @0x7f0901f9 @0x7f09011c @0x7f0902ac @0x7f09037a @0x7f090190 @0x7f09008a @0x7f090078 @0x7f090221 @0x7f090316 @0x7f0902ff @0x7f090225 @0x7f090203 @0x7f090077 @0x7f090368 @0x7f0902ab |
| video_layout_normal | (aapt2) | RelativeLayout LinearLayout TextView SeekBar ImageView ProgressBar | 00:00 | @0x7f090324 @0x7f090364 @0x7f0901f9 @0x7f09011c @0x7f0902ac @0x7f09037a @0x7f090190 @0x7f09008a @0x7f090078 @0x7f090203 @0x7f090077 @0x7f090368 @0x7f090221 @0x7f090316 @0x7f0902ff @0x7f090225 |
| video_layout_sample_ad | (aapt2) | RelativeLayout ProgressBar ImageView LinearLayout TextView moe.codeest.enviews.ENDownloadView SeekBar | 00:00 ｜ @0x7f11014f ｜ 00 | @0x7f090324 @0x7f090440 @0x7f090364 @0x7f09008a @0x7f090078 @0x7f090203 @0x7f090077 @0x7f090368 @0x7f090221 @0x7f090316 @0x7f0902ff @0x7f090225 @0x7f0901f9 @0x7f09011c @0x7f0902ac @0x7f09037a @0x7f090190 @0x7f0901f5 @0x7f090061 |
| video_layout_standard | (aapt2) | RelativeLayout LinearLayout TextView SeekBar ImageView ProgressBar moe.codeest.enviews.ENDownloadView moe.codeest.enviews.ENPlayView | 00:00 | @0x7f090324 @0x7f090364 @0x7f0901f9 @0x7f09011c @0x7f0902ac @0x7f09037a @0x7f090190 @0x7f09008a @0x7f090078 @0x7f090203 @0x7f090077 @0x7f090368 @0x7f090221 @0x7f090316 @0x7f0902ff @0x7f090225 |
| video_progress_dialog | (aapt2) | RelativeLayout LinearLayout ImageView TextView ProgressBar | - | @0x7f090113 @0x7f090148 @0x7f09039d @0x7f0903b7 @0x7f090149 |
| video_volume_dialog | (aapt2) | LinearLayout RelativeLayout ProgressBar ImageView | - | @0x7f090113 @0x7f09043b |
| view_alert | (aapt2) | LinearLayout TextView com.bskim.maxheightscrollview.widgets.MaxHeightScrollView View Button | - | @0x7f0901f6 @0x7f090418 @0x7f090417 @0x7f0902e1 @0x7f090416 @0x7f0900b9 @0x7f090425 @0x7f0900c2 |
| view_alert_bottom | (aapt2) | LinearLayout TextView androidx.recyclerview.widget.RecyclerView | - | @0x7f0903b0 @0x7f0903af @0x7f0902d3 |
| view_alert_loading | (aapt2) | LinearLayout ProgressBar TextView | @0x7f1100b7 | @0x7f090136 @0x7f090367 |
| view_edit_bottom | (aapt2) | LinearLayout com.noober.background.view.BLTextView TextView com.noober.background.view.BLEditText com.noober.background.view.BLLinearLayout View | @0x7f1100ae ｜ @0x7f1100af ｜ @0x7f110146 ｜ @0x7f110148 ｜ @0x7f110149 | @0x7f090097 @0x7f0903b0 @0x7f09009b @0x7f090150 @0x7f09021d @0x7f090151 @0x7f090152 |
| view_global_loading_status | (aapt2) | merge View ProgressBar ImageView TextView | - | @0x7f090221 @0x7f0901b4 @0x7f09033d |
| view_recording_control_events | (aapt2) | merge LinearLayout TextView ImageView androidx.recyclerview.widget.RecyclerView | @0x7f110297 | @0x7f0902bb @0x7f0902ba @0x7f0902be @0x7f0902b9 @0x7f0902bc @0x7f0902bd |
| view_ride3pro_hour_playback_overlay | (aapt2) | FrameLayout LinearLayout TextView ImageView SeekBar ProgressBar | @0x7f110271 ｜ @0x7f110272 ｜ @0x7f11037f ｜ @0x7f1100bc ｜ @0x7f1102bf ｜ @0x7f110098 ｜ @0x7f1102c4 ｜ @0x7f110134 | @0x7f0901fe @0x7f0900c1 @0x7f0903d5 @0x7f0900c0 @0x7f0900bd @0x7f0901ff @0x7f0900bf @0x7f0903d3 @0x7f0903d6 @0x7f0902ee @0x7f0900be @0x7f0903d4 @0x7f0902b2 |
| view_ride3pro_loading_card | (aapt2) | merge ProgressBar TextView | - | @0x7f090223 @0x7f090224 @0x7f090222 |
| view_ride3pro_playback_overlay | (aapt2) | FrameLayout LinearLayout TextView ImageView SeekBar | @0x7f110271 ｜ @0x7f110272 ｜ @0x7f11037f ｜ @0x7f1100bc ｜ @0x7f110098 | @0x7f0901fe @0x7f0900c1 @0x7f0903d5 @0x7f0900c0 @0x7f0900bd @0x7f0901ff @0x7f0900bf @0x7f0903d3 @0x7f0902ee @0x7f0903d6 @0x7f0900be |
| view_ride5_hour_playback_overlay | (aapt2) | FrameLayout LinearLayout TextView ImageView SeekBar ProgressBar | @0x7f110271 ｜ @0x7f110272 ｜ @0x7f11037f ｜ @0x7f1100bc ｜ @0x7f11031f ｜ @0x7f110098 ｜ @0x7f110320 ｜ @0x7f110134 | @0x7f0901fe @0x7f0900c1 @0x7f0903d5 @0x7f0900c0 @0x7f0900bd @0x7f0901ff @0x7f0900bf @0x7f0903d3 @0x7f0903d6 @0x7f0902ee @0x7f0900be @0x7f0903d4 @0x7f0902b3 @0x7f0902b2 |
| view_ride5_loading_card | (aapt2) | merge ProgressBar TextView | - | @0x7f090223 @0x7f090224 @0x7f090222 |
| viewstub_permission_layout | (aapt2) | androidx.constraintlayout.widget.ConstraintLayout ImageView TextView | @0x7f11026b | @0x7f0901e2 @0x7f090401 |

## xml（4 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| app_update_file | (aapt2) | paths external-path external-cache-path | - | - |
| file_paths | (aapt2) | resources paths external-path files-path | - | - |
| locales_config | (aapt2) | locale-config locale | - | - |
| network_config | (aapt2) | network-security-config base-config | - | - |
