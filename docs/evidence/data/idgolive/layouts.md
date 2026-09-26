# idGoLive — 布局/菜单/配置 XML 全量解析

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 344 个 XML；逐文件列出根元素、用到的控件类、可见文案（android:text/hint/contentDescription/title/summary）与 id/key
> 文案若为 `@string/xxx`，其真实文本按 `res-strings-default.md` 与 `res-strings-zh.md` 查表

---

## layout（316 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| abc_action_bar_title_item | abc_action_bar_title_item.xml | TextView | - | @+id/action_bar_title @+id/action_bar_subtitle |
| abc_action_bar_up_container | abc_action_bar_up_container.xml |  | - | - |
| abc_action_menu_item_layout | abc_action_menu_item_layout.xml | androidx.appcompat.view.menu.ActionMenuItemView | - | - |
| abc_action_menu_layout | abc_action_menu_layout.xml | androidx.appcompat.widget.ActionMenuView | - | - |
| abc_action_mode_bar | abc_action_mode_bar.xml | androidx.appcompat.widget.ActionBarContextView | - | - |
| abc_action_mode_close_item_material | abc_action_mode_close_item_material.xml |  | - | - |
| abc_activity_chooser_view | abc_activity_chooser_view.xml |  | - | - |
| abc_activity_chooser_view_list_item | abc_activity_chooser_view_list_item.xml | TextView | - | @+id/title |
| abc_alert_dialog_button_bar_material | abc_alert_dialog_button_bar_material.xml | androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @android:id/button3 @+id/spacer @android:id/button2 @android:id/button1 |
| abc_alert_dialog_material | abc_alert_dialog_material.xml | androidx.appcompat.widget.AlertDialogLayout androidx.core.widget.NestedScrollView android.widget.Space TextView | - | @+id/parentPanel @+id/scrollView @+id/textSpacerNoTitle @android:id/message @+id/textSpacerNoButtons |
| abc_alert_dialog_title_material | abc_alert_dialog_title_material.xml | androidx.appcompat.widget.DialogTitle android.widget.Space | - | @+id/alertTitle @+id/titleDividerNoCustom |
| abc_cascading_menu_item_layout | abc_cascading_menu_item_layout.xml | androidx.appcompat.view.menu.ListMenuItemView TextView | - | @+id/title @+id/shortcut |
| abc_dialog_title_material | abc_dialog_title_material.xml | androidx.appcompat.widget.FitWindowsLinearLayout TextView | - | @+id/title |
| abc_expanded_menu_layout | abc_expanded_menu_layout.xml | androidx.appcompat.view.menu.ExpandedMenuView | - | @+id/expanded_menu |
| abc_list_menu_item_checkbox | abc_list_menu_item_checkbox.xml | CheckBox | - | @+id/checkbox |
| abc_list_menu_item_icon | abc_list_menu_item_icon.xml |  | - | - |
| abc_list_menu_item_layout | abc_list_menu_item_layout.xml | androidx.appcompat.view.menu.ListMenuItemView TextView | - | @+id/title @+id/shortcut |
| abc_list_menu_item_radio | abc_list_menu_item_radio.xml | RadioButton | - | @+id/radio |
| abc_popup_menu_header_item_layout | abc_popup_menu_header_item_layout.xml | TextView | - | @android:id/title |
| abc_popup_menu_item_layout | abc_popup_menu_item_layout.xml | androidx.appcompat.view.menu.ListMenuItemView TextView | - | @+id/title @+id/shortcut |
| abc_screen_content_include | abc_screen_content_include.xml | androidx.appcompat.widget.ContentFrameLayout | - | @+id/action_bar_activity_content |
| abc_screen_simple | abc_screen_simple.xml | androidx.appcompat.widget.FitWindowsLinearLayout androidx.appcompat.widget.ViewStubCompat | - | @+id/action_bar_root @+id/action_mode_bar_stub |
| abc_screen_simple_overlay_action_mode | abc_screen_simple_overlay_action_mode.xml | androidx.appcompat.widget.FitWindowsFrameLayout androidx.appcompat.widget.ViewStubCompat | - | @+id/action_bar_root @+id/action_mode_bar_stub |
| abc_screen_toolbar | abc_screen_toolbar.xml | androidx.appcompat.widget.ActionBarOverlayLayout androidx.appcompat.widget.ActionBarContainer androidx.appcompat.widget.Toolbar androidx.appcompat.widget.ActionBarContextView | - | @+id/decor_content_parent @+id/action_bar_container @+id/action_bar @+id/action_context_bar |
| abc_search_dropdown_item_icons_2line | abc_search_dropdown_item_icons_2line.xml | TextView | - | @android:id/text2 @android:id/text1 |
| abc_search_view | abc_search_view.xml | TextView | - | @+id/search_badge |
| abc_select_dialog_material | abc_select_dialog_material.xml |  | - | - |
| abc_tooltip | abc_tooltip.xml | TextView | - | @+id/message |
| activity_about_app | activity_about_app.xml | TextView | @string/about_app ｜ @string/feedback ｜ @string/software_protocol ｜ @string/language ｜ @string/download_firmware ｜ @string/version_info ｜ V1.0.0 | @+id/tv_title @+id/tv_version_info |
| activity_change_language | activity_change_language.xml | androidx.constraintlayout.widget.ConstraintLayout TextView CheckBox | @string/language ｜ 中文简体 ｜ English ｜ 中文繁体 ｜ 한국어 ｜ ภาษาไทย ｜ 日本語 | @+id/tv_title @+id/cb_chinese_s @+id/cb_english @+id/cb_chinese_t @+id/cb_korean @+id/cb_thai @+id/cb_japanese |
| activity_common_video_player | activity_common_video_player.xml | com.tinyai.libmediacomponent.components.media.VideoPlayerView | - | @+id/video_player_view |
| activity_connect_course | activity_connect_course.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/connect_course ｜ @string/step_one ｜ @string/please_open_wifi ｜ @string/please_open_wifi_tips ｜ @string/step_two ｜ @string/search_wifi_list_then_connect ｜ @string/devices_wif_name ｜ @string/step_three ｜ @string/return_app_then_use | @+id/tv_title @+id/tv_step_one @+id/tv_step_one_content @+id/tv_step_one_description @+id/tv_step_two @+id/tv_step_two_content @+id/tv_device_name_pwd @+id/tv_step_three @+id/tv_step_three_content |
| activity_device_settings_ly | activity_device_settings_ly.xml | TextView androidx.recyclerview.widget.RecyclerView Button | @string/title_setting ｜ @string/device_name_pwd ｜ id221_Device_model_one ｜ ******** ｜ @string/format_device ｜ @string/reset_device | @+id/tv_title @+id/tv_device_name @+id/tv_device_pwd @+id/rv_settings @+id/btn_format @+id/btn_reset |
| activity_download_file_ly | activity_download_file_ly.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/downloading_file | @+id/tv_title @+id/rv_remote_files |
| activity_download_firmware | activity_download_firmware.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/download_firmware ｜ @string/loading_data_waiting | @+id/tv_title @+id/tv_hint @+id/rv_firmwares |
| activity_exo_test | activity_exo_test.xml | TextView androidx.constraintlayout.widget.ConstraintLayout com.icatch.golive.video.LandLayoutVideo | @string/about_app | @+id/tv_title @+id/detail_player |
| activity_feedback | activity_feedback.xml | androidx.constraintlayout.widget.ConstraintLayout TextView EditText Button | @string/feedback ｜ @string/input_device_type ｜ @string/input_device_usage_region ｜ @string/submit ｜ @string/input_email ｜ @string/input_phone ｜ @string/input_your_feedback_content | @+id/tv_title @+id/et_device_type @+id/et_device_usage_region @+id/btn_submit @+id/et_email @+id/et_phone @+id/et_content |
| activity_launch | activity_launch.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/appbar @+id/toolbar |
| activity_launch_help | activity_launch_help.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/toolbar |
| activity_license | activity_license.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/toolbar |
| activity_live_video_ly | activity_live_video_ly.xml | TextView com.icatch.golive.video.EmptyControlVideo | @string/title_preview ｜ 4K ｜ 30fps ｜ @string/hd_quality_hint ｜ 00:00:00 ｜ @string/pause_record ｜ @string/setting_title_camera_switch ｜ @string/remote_file ｜ @string/take_pictures | @+id/tv_title @+id/tv_resolution @+id/tv_fps @+id/tv_hd_hint @+id/video_view @+id/tv_recording_time @+id/tv_video_state |
| activity_local_files | activity_local_files.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView com.google.android.material.tabs.TabLayout | @string/local_file ｜ @string/all ｜ @string/select | @+id/toolbar @+id/tv_title @+id/tv_select_all @+id/tv_selector @+id/tabs |
| activity_local_multi_pb | activity_local_multi_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar com.google.android.material.tabs.TabLayout TextView | @string/local_file | @+id/toolbar @+id/tabs @+id/tv_title |
| activity_local_photo_pb | activity_local_photo_pb.xml | com.icatch.golive.ui.ExtendComponent.HackyViewPager TextView | - | @+id/viewpager @+id/pb_index_info |
| activity_local_photo_wall | activity_local_photo_wall.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/toolbar |
| activity_login_facebook | activity_login_facebook.xml | com.facebook.login.widget.LoginButton | - | @+id/login_button |
| activity_login_google | activity_login_google.xml | TextView Button com.google.android.gms.common.SignInButton | @string/title_text ｜ @string/signed_out ｜ @string/sign_out ｜ @string/disconnect ｜ @string/refresh_token | @+id/title_text @+id/status @+id/detail @+id/button_optional_action @+id/sign_in_button @+id/sign_out_button @+id/disconnect_button @+id/refresh_token_button |
| activity_multi_pb | activity_multi_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar com.google.android.material.tabs.TabLayout | - | @+id/toolbar @+id/tabs |
| activity_multi_pb2 | activity_multi_pb2.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView com.google.android.material.tabs.TabLayout | @string/remote_file | @+id/toolbar @+id/tv_title @+id/tabs |
| activity_panorama_local_photo_pb | activity_panorama_local_photo_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_panorama_local_video_pb | activity_panorama_local_video_pb.xml | TextView Switch com.icatch.golive.ui.ExtendComponent.ProgressWheel com.icatch.golive.ui.ExtendComponent.ZoomView | 20151245_1245.mp4 ｜ @string/more_settings ｜ @string/text_stablization ｜ 00:00 ｜ / | @+id/local_pb_video_name @+id/eis_txv @+id/eis_switch @+id/local_pb_time_lapsed @+id/local_pb_time_duration @+id/local_pb_spinner @+id/zoom_view @+id/codec_info_txv |
| activity_panorama_photo_pb | activity_panorama_photo_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_pb_local_video | activity_pb_local_video.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_photo_pb | activity_photo_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_preview | activity_preview.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView | @string/title_preview | @+id/AppBarLayout @+id/toolbar @+id/tv_title |
| activity_pv_size_setting | activity_pv_size_setting.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView RadioButton Button | @string/please_set_the_correct_resolution_and_fps ｜ @string/video_resolution ｜ @string/video_frame_rate ｜ 30 fps ｜ 15 fps ｜ 10 fps ｜ Video codec ｜ H264 ｜ MJPG ｜ start Pv | @+id/appbar @+id/toolbar @+id/video_fps_30 @+id/video_fps_15 @+id/video_fps_10 @+id/video_codec_h264 @+id/video_codec_mjpg @+id/start_pv |
| activity_remote_file_ly | activity_remote_file_ly.xml | TextView Button androidx.viewpager.widget.ViewPager | @string/remote_file ｜ @string/all ｜ @string/select ｜ @string/title_video ｜ @string/title_photo ｜ @string/title_emergency | @+id/tv_title @+id/tv_select_all @+id/tv_selector @+id/btn_video @+id/btn_photo @+id/btn_emergency @+id/vPager |
| activity_remote_files | activity_remote_files.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView com.google.android.material.tabs.TabLayout Button | @string/remote_file ｜ @string/all ｜ @string/select ｜ @string/title_video ｜ @string/title_photo ｜ @string/title_emergency | @+id/toolbar @+id/tv_title @+id/tv_select_all @+id/tv_selector @+id/tabs @+id/btn_video @+id/btn_photo @+id/btn_emergency |
| activity_start_page | activity_start_page.xml | androidx.constraintlayout.utils.widget.ImageFilterView | - | - |
| activity_usb_preview | activity_usb_preview.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/AppBarLayout @+id/toolbar |
| activity_video_pb | activity_video_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_video_player | activity_video_player.xml | TextView cn.jzvd.JzvdStd | File Name | @+id/tv_title @+id/jz_video |
| activity_video_player_ly | activity_video_player_ly.xml | TextView androidx.constraintlayout.widget.ConstraintLayout com.icatch.golive.video.LandLayoutVideo | @string/about_app | @+id/tv_title @+id/detail_player |
| activity_web | activity_web.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/software_protocol | @+id/tv_title |
| activity_wifi_ap | activity_wifi_ap.xml | TextView EditText RadioButton Button | SSID ｜ test01 ｜ Password ｜ 1234567890 ｜ no ｜ wpa ｜ wpa2 ｜ 开启wifi热点 ｜ 关闭wifi热点 | @+id/et_ssid @+id/et_password @+id/rd_no @+id/rd_wpa @+id/rd_wpa2 @+id/bt_start_wifiap @+id/bt_stop_wifiap @+id/tv_state |
| album_activity_album_dark | album_activity_album_dark.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/app_bar_layout @+id/toolbar |
| album_activity_album_light | album_activity_album_light.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/app_bar_layout @+id/toolbar |
| album_activity_gallery | album_activity_gallery.xml | com.yanzhenjie.album.widget.photoview.FixViewPager com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView androidx.appcompat.widget.AppCompatCheckBox | @string/album_check ｜ @string/album_item_unavailable | @+id/view_pager @+id/app_bar_layout @+id/toolbar @+id/tv_duration @+id/check_box |
| album_activity_null | album_activity_null.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar TextView androidx.appcompat.widget.AppCompatButton | @string/album_camera_image_capture ｜ @string/album_camera_video_capture | @+id/app_bar_layout @+id/toolbar @+id/tv_message @+id/btn_camera_image @+id/btn_camera_video |
| album_content_album | album_content_album.xml | androidx.recyclerview.widget.RecyclerView androidx.appcompat.widget.AppCompatButton com.yanzhenjie.album.widget.ColorProgressBar TextView | @string/album_loading | @+id/recycler_view @+id/btn_switch_dir @+id/btn_preview @+id/progress_bar |
| album_dialog_floder | album_dialog_floder.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/rv_content_list |
| album_dialog_loading | album_dialog_loading.xml | com.yanzhenjie.album.widget.ColorProgressBar TextView | - | @+id/progress_bar @+id/tv_message |
| album_item_content_button | album_item_content_button.xml | com.yanzhenjie.album.widget.SquareCardView com.yanzhenjie.album.widget.SquareImageView | @string/album_title | @+id/iv_album_content_button |
| album_item_content_image | album_item_content_image.xml | com.yanzhenjie.album.widget.SquareCardView com.yanzhenjie.album.widget.TransferLayout androidx.appcompat.widget.AppCompatCheckBox TextView | @string/album_item_unavailable | @+id/check_box |
| album_item_content_video | album_item_content_video.xml | com.yanzhenjie.album.widget.SquareCardView com.yanzhenjie.album.widget.TransferLayout androidx.appcompat.widget.AppCompatCheckBox TextView | @string/album_item_unavailable | @+id/check_box @+id/tv_duration |
| album_item_dialog_folder | album_item_dialog_folder.xml | androidx.appcompat.widget.AppCompatRadioButton TextView | - | @+id/rb_gallery_preview_check @+id/tv_gallery_preview_title |
| album_toolbar_dark | album_toolbar_dark.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/app_bar_layout @+id/toolbar |
| album_toolbar_light | album_toolbar_light.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/app_bar_layout @+id/toolbar |
| alert_dialog_change_device_info | alert_dialog_change_device_info.xml | TextView EditText | @string/change_device_info ｜ @string/input_device_name ｜ @string/input_device_pwd ｜ @string/cancel ｜ @string/device_info_modify | @+id/tv_title @+id/et_device_name @+id/et_device_pwd @+id/tv_cancel @+id/tv_confirm |
| audio_switch_layout | audio_switch_layout.xml | TextView CheckBox | @string/setting_audio_switch | @+id/item_text @+id/switcher |
| auto_download_layout | auto_download_layout.xml | TextView CheckBox | @string/setting_auto_download | @+id/item_text @+id/switcher |
| auto_download_layout_size | auto_download_layout_size.xml | TextView | @string/setting_auto_download_size_limit ｜ 1.0GB | @+id/item_text @+id/download_size |
| bluetooth_header | bluetooth_header.xml | TextView | BlueTooth devices | @+id/bt_header |
| bluetooth_status | bluetooth_status.xml | TextView | bluetooth device ｜ bluetooth mac ｜ Unbinded | @+id/bluetooth_name @+id/bluetooth_mac @+id/bluetooth_connect |
| browser_actions_context_menu_page | browser_actions_context_menu_page.xml | androidx.browser.browseractions.BrowserActionsFallbackMenuView TextView | - | @+id/browser_actions_menu_view @+id/browser_actions_header_text |
| browser_actions_context_menu_row | browser_actions_context_menu_row.xml | TextView | - | @+id/browser_actions_menu_item_text |
| cam_slot_item | cam_slot_item.xml | TextView com.icatch.golive.ui.ExtendComponent.RoundAngleImageView | Disconnected ｜ WDV8000_FDG | @+id/slot_connect_state @+id/slot_camera_name @+id/slotPhoto |
| cam_slot_item_add | cam_slot_item_add.xml | TextView com.icatch.golive.ui.ExtendComponent.RoundAngleImageView | @string/text_add_new_camera | @+id/slot_add_camera @+id/slotPhoto |
| camer_mode_switch_layout | camer_mode_switch_layout.xml | RadioButton | - | @+id/video_radio @+id/capture_radio @+id/timeLapse_radio |
| camera_name_password_set | camera_name_password_set.xml | TextView EditText | @string/camera_wifi_name ｜ @string/camera_wifi_password | @+id/camera_name @+id/wifi_password |
| com_facebook_activity_layout | com_facebook_activity_layout.xml |  | - | - |
| com_facebook_device_auth_dialog_fragment | com_facebook_device_auth_dialog_fragment.xml | androidx.cardview.widget.CardView androidx.appcompat.widget.AppCompatImageView TextView Button | @android:string/cancel | @+id/confirmation_code @+id/com_facebook_device_auth_instructions @+id/cancel_button |
| com_facebook_login_fragment | com_facebook_login_fragment.xml |  | - | - |
| com_facebook_smart_device_dialog_fragment | com_facebook_smart_device_dialog_fragment.xml | androidx.cardview.widget.CardView androidx.appcompat.widget.AppCompatImageView TextView Button | @string/com_facebook_smart_device_instructions ｜ @string/com_facebook_smart_device_instructions_or ｜ @android:string/cancel | @+id/confirmation_code @+id/com_facebook_smart_instructions_0 @+id/com_facebook_smart_instructions_or @+id/com_facebook_device_auth_instructions @+id/cancel_button |
| com_facebook_tooltip_bubble | com_facebook_tooltip_bubble.xml | TextView | - | @+id/com_facebook_tooltip_bubble_view_text_body |
| common_item_layout | common_item_layout.xml | TextView Switch | ddd | @+id/title_content_txv @+id/right_switch @+id/right_text_txv |
| common_setting_layout | common_setting_layout.xml |  | - | - |
| content_download_size_dialog | content_download_size_dialog.xml | EditText TextView | GB | @+id/download_size |
| content_launch | content_launch.xml | TextView com.icatch.golive.ui.ExtendComponent.RoundAngleImageView | @string/main_page_name ｜ @string/connect_course ｜ @string/about_app ｜ @string/no_files_found ｜ @string/title_video ｜ @string/title_photo | @+id/local_video @+id/no_local_videos @+id/local_photo @+id/no_local_photos |
| content_launch_help_img | content_launch_help_img.xml | TextView | @string/launch_help_qa ｜ @string/launch_help_qa_1 ｜ @string/launch_help_qa_2 ｜ https://youtu.be/V_gPlCbHaNI ｜ @string/launch_help_qa_3 ｜ @string/launch_help_qa_4 ｜ @string/launch_help_qa_5 ｜ @string/launch_help_qa_6 ｜ @string/launch_help_qa_7 ｜ @string/launch_help_qa_8 ｜ https://business.facebook.com/ismartdvuser/ ｜ @string/launch_help_qa_8_2 ｜ @string/launch_help_qa_9 ｜ https://youtu.be/GSnqVBMUWkk ｜ @string/launch_help_qa_10 ｜ @string/setting_app_version ｜ @string/gallery_download ｜ iSport Cam 1.2 ｜ https://play.google.com/store/apps/details?id=com.icatch.wificam.isportcam ｜ iSmart DV OLD version ｜ https://drive.google.com/drive/folders/1GgynPf8nXXKaDsDEys3bD0RtRaEy5R6O?usp=sharing ｜ @string/launch_help_qa_end | @+id/demovideotextView @+id/FBtextView @+id/btndown12 @+id/btndown14 @+id/txturl14 |
| content_local_multi_pb | content_local_multi_pb.xml | androidx.viewpager.widget.ViewPager | - | @+id/vPager |
| content_local_photo_wall | content_local_photo_wall.xml | TextView com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView | @string/no_content | @+id/no_content_txv @+id/local_photo_wall_grid_view |
| content_multi_pb | content_multi_pb.xml | androidx.viewpager.widget.ViewPager | - | @+id/vPager |
| content_panorama_local_photo_pb | content_panorama_local_photo_pb.xml | com.icatch.golive.ui.ExtendComponent.ZoomView TextView | - | @+id/zoom_view @+id/local_pb_photo_name |
| content_panorama_local_video_pb | content_panorama_local_video_pb.xml | TextView Switch com.icatch.golive.ui.ExtendComponent.ProgressWheel com.icatch.golive.ui.ExtendComponent.ZoomView | 20151245_1245.mp4 ｜ 更多设置 ｜ 防抖 ｜ 00:00 ｜ / | @+id/codec_info_txv @+id/local_pb_video_name @+id/eis_txv @+id/eis_switch @+id/local_pb_time_lapsed @+id/local_pb_time_duration @+id/local_pb_spinner @+id/zoom_view |
| content_panorama_photo_pb | content_panorama_photo_pb.xml | com.icatch.golive.ui.ExtendComponent.ProgressWheel TextView | - | @+id/progress_wheel @+id/pb_index_info |
| content_panorama_preview | content_panorama_preview.xml | TextView com.icatch.golive.ui.ExtendComponent.ZoomView Button com.tinyai.libmediacomponent.components.media.PreviewPlayerView | 4M ｜ / ｜ 1123 ｜ 4K ｜ 30fps ｜ 40:10 ｜ @string/hd_quality_hint ｜ @string/google_account ｜ @string/start_youtube_live ｜ @string/facebook_start_live ｜ Start customer live ｜ @string/remote_file ｜ @string/state_record ｜ @string/state_camera ｜ 00:00:00 ｜ @string/text_not_support_preview ｜ 01/09/2025 17:49:28 ｜ @string/setting_title_camera_switch ｜ @string/pause_record | @+id/tv_battery_value @+id/image_size_txv @+id/separator1 @+id/remain_capture_count_text @+id/video_size_txv @+id/separator2 @+id/remain_recording_time_text @+id/delay_capture_text @+id/zoom_view @+id/google_account_btn @+id/youtube_live_btn @+id/facebook_live_btn @+id/customer_live_btn @+id/tv_state_record @+id/tv_state_camera @+id/recording_time @+id/not_support_preview_txv @+id/preview_player_view @+id/tv_watermark @+id/tv_video_state |
| content_panorama_video_pb | content_panorama_video_pb.xml | com.tinyai.libmediacomponent.components.media.VideoPlayerView TextView Switch | @string/more_settings ｜ @string/gallery_delete ｜ @string/text_stablization | @+id/video_player_view @+id/delete_txv @+id/eis_txv @+id/eis_switch |
| content_pb_local_video | content_pb_local_video.xml | com.icatch.sbcapp.ExtendComponent.MPreview TextView com.icatch.sbcapp.ExtendComponent.ProgressWheel | 20151245_1245.mp4 ｜ 00:00 | @+id/local_pb_view @+id/local_pb_video_name @+id/local_pb_time_lapsed @+id/local_pb_time_duration @+id/local_pb_spinner |
| content_photo_pb | content_photo_pb.xml | androidx.viewpager.widget.ViewPager TextView | - | @+id/viewpager @+id/pb_index_info |
| content_usb_preview | content_usb_preview.xml | TextView Button androidx.appcompat.widget.SwitchCompat | @string/text_not_support_preview ｜ 4M ｜ / ｜ 1123 ｜ FHD 30 ｜ 40:10 ｜ Image size ｜ 00:00:00 ｜ @string/google_account ｜ @string/start_youtube_live ｜ @string/facebook_start_live ｜ Audio | @+id/not_support_preview_txv @+id/image_size_txv @+id/separator1 @+id/remain_capture_count_text @+id/video_size_txv @+id/separator2 @+id/remain_recording_time_text @+id/image_size_setting_txv @+id/recording_time @+id/delay_capture_text @+id/google_account_btn @+id/youtube_live_btn @+id/facebook_live_btn @+id/audioSwitcher |
| custom_dialog | custom_dialog.xml | Button | Ok | @+id/dialog_button |
| custom_toast | custom_toast.xml | TextView | @string/warm_reminder_content | @+id/text |
| design_bottom_navigation_item | design_bottom_navigation_item.xml | com.google.android.material.internal.BaselineLayout TextView | - | @+id/navigation_bar_item_labels_group @+id/navigation_bar_item_small_label_view @+id/navigation_bar_item_large_label_view |
| design_bottom_sheet_dialog | design_bottom_sheet_dialog.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | @+id/coordinator |
| design_layout_snackbar | design_layout_snackbar.xml |  | - | - |
| design_layout_snackbar_include | design_layout_snackbar_include.xml | TextView Button | - | @+id/snackbar_text @+id/snackbar_action |
| design_layout_tab_icon | design_layout_tab_icon.xml |  | - | - |
| design_layout_tab_text | design_layout_tab_text.xml | TextView | - | - |
| design_menu_item_action_area | design_menu_item_action_area.xml |  | - | - |
| design_navigation_item | design_navigation_item.xml | com.google.android.material.internal.NavigationMenuItemView | - | - |
| design_navigation_item_header | design_navigation_item_header.xml |  | - | - |
| design_navigation_item_separator | design_navigation_item_separator.xml |  | - | - |
| design_navigation_item_subheader | design_navigation_item_subheader.xml | TextView | - | - |
| design_navigation_menu | design_navigation_menu.xml | com.google.android.material.internal.NavigationMenuView | - | @+id/design_navigation_view |
| design_navigation_menu_item | design_navigation_menu_item.xml | CheckedTextView | - | @+id/design_menu_item_text |
| design_text_input_end_icon | design_text_input_end_icon.xml | com.google.android.material.internal.CheckableImageButton | - | @+id/text_input_end_icon |
| design_text_input_start_icon | design_text_input_start_icon.xml | com.google.android.material.internal.CheckableImageButton | - | @+id/text_input_start_icon |
| dialog_basic | dialog_basic.xml | com.prolificinteractive.materialcalendarview.MaterialCalendarView TextView com.icatchtek.basecomponent.customcomponent.MProgressWheel | - | @+id/calendarView @+id/textView @+id/calendar_spinner |
| dialog_loading | dialog_loading.xml | TextView | 加载中... | @+id/tipTextView |
| dialog_privacy_policy | dialog_privacy_policy.xml | TextView | @string/content_privacy_policy_1 | @+id/txv_privacy_policy |
| dialog_progress | dialog_progress.xml | TextView | Downloading... | @+id/progressText |
| dialog_web | dialog_web.xml |  | - | - |
| download | download.xml | TextView com.icatch.golive.ui.ExtendComponent.NumberProgressBar | filename ｜ Status | @+id/fileName @+id/downloadStatus @+id/numberbar |
| download_content_dialog | download_content_dialog.xml | TextView | test | @+id/message |
| download_dialog_title | download_dialog_title.xml | TextView | @string/download_manager ｜ @string/cancel_all | @+id/cancel_all_txv |
| download_single_dialog_title | download_single_dialog_title.xml | TextView | @string/download_manager | - |
| empty_control_video | empty_control_video.xml |  | - | - |
| exo_list_divider | exo_list_divider.xml |  | - | - |
| exo_player_control_view | exo_player_control_view.xml | TextView | - | @+id/exo_position @+id/exo_duration |
| exo_player_view | exo_player_view.xml | com.google.android.exoplayer2.ui.AspectRatioFrameLayout com.google.android.exoplayer2.ui.SubtitleView TextView | - | @+id/exo_content_frame @+id/exo_subtitles @+id/exo_error_message |
| exo_styled_player_control_ffwd_button | exo_styled_player_control_ffwd_button.xml | Button | - | @+id/exo_ffwd_with_amount |
| exo_styled_player_control_rewind_button | exo_styled_player_control_rewind_button.xml | Button | - | @+id/exo_rew_with_amount |
| exo_styled_player_control_view | exo_styled_player_control_view.xml | TextView | - | @+id/exo_position @+id/exo_duration |
| exo_styled_player_view | exo_styled_player_view.xml | com.google.android.exoplayer2.ui.AspectRatioFrameLayout com.google.android.exoplayer2.ui.SubtitleView TextView | - | @+id/exo_content_frame @+id/exo_subtitles @+id/exo_error_message |
| exo_styled_settings_list | exo_styled_settings_list.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/exo_settings_listview |
| exo_styled_settings_list_item | exo_styled_settings_list_item.xml | TextView | - | @+id/exo_main_text @+id/exo_sub_text |
| exo_styled_sub_settings_list_item | exo_styled_sub_settings_list_item.xml | TextView | - | @+id/exo_text |
| exo_track_selection_dialog | exo_track_selection_dialog.xml | com.google.android.exoplayer2.ui.TrackSelectionView | - | @+id/exo_track_selection_view |
| file_filter | file_filter.xml | TextView | 筛选文件 ｜ 时间段 ｜ 到 ｜ 摄像头类型 ｜ 重置 ｜ 确定 | @+id/min_time_edt @+id/max_time_edt @+id/sensors_type_txv @+id/filter_reset @+id/filter_sure |
| file_list_layout | file_list_layout.xml | com.handmark.pulltorefresh.library.PullToRefreshListView TextView | Selected(0) | @+id/list_view @+id/info_selected_num |
| fragment_add_new_cam | fragment_add_new_cam.xml | TextView Button | @string/title_activity_add_new_cam ｜ @string/text_btpair_done ｜ @string/text_btpair_auto_connect_wifi ｜ @string/text_auto_connect_tips ｜ @string/text_btpair_auto_connect_wifi_btn ｜ @string/text_btpair_already_connect_cam ｜ @string/text_btpair_connect_wifi ｜ @string/text_connect_camera_by_usb ｜ @string/text_otg_tips ｜ @string/text_add_camaera_usb ｜ @string/text_btpair_support_bt ｜ @string/text_btpair | @+id/title @+id/save @+id/wifi_auto_connect @+id/wifi_connect_camera @+id/usb_connect_camera @+id/bt_pair |
| fragment_btpair_begin | fragment_btpair_begin.xml | TextView Button | @string/title_fragment_btpair_begin ｜ @string/text_ready_pair ｜ @string/text_btpair_search_camera ｜ @string/text_btpair_search_ble | @+id/title @+id/button_bluetooth_search @+id/button_ble_search |
| fragment_btpair_completed | fragment_btpair_completed.xml | TextView | @string/title_fragment_btpair_completed ｜ @string/text_btpair_done ｜ @string/text_btpair_connect_cam ｜ @string/text_btpair_connect_operationsteps | @+id/title @+id/done_txv |
| fragment_btpair_setup | fragment_btpair_setup.xml | TextView EditText Button | @string/title_fragment_btpair_wifisetup ｜ @string/text_btpair_skip ｜ @string/text_btpair_setup_camwifi ｜ Ssid ｜ Password ｜ @string/text_btpair_setup | @+id/title @+id/skip_txv @+id/bt_wifisetup_camera_ssid @+id/bt_wifisetup_camera_password @+id/bt_wifisetup |
| fragment_device_files | fragment_device_files.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/no_data | @+id/no_content_txv @+id/rv_remote_files |
| fragment_item_grid | fragment_item_grid.xml | TextView | - | @android:id/empty |
| fragment_item_list | fragment_item_list.xml | TextView | - | @android:id/empty |
| fragment_local_device_files | fragment_local_device_files.xml | androidx.recyclerview.widget.RecyclerView TextView | @string/no_content | @+id/rv_remote_files @+id/no_content_txv |
| fragment_local_pb_list | fragment_local_pb_list.xml | TextView com.tinyai.libmediacomponent.components.filelist.FileListView | @string/no_content | @+id/no_content_txv @+id/file_list_view |
| fragment_multi_pb | fragment_multi_pb.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/no_content | @+id/no_content_txv @+id/recycler_view |
| fragment_multi_pb_photo | fragment_multi_pb_photo.xml | TextView com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView | @string/no_content | @+id/no_content_txv @+id/multi_pb_photo_grid_view |
| fragment_multi_pb_video | fragment_multi_pb_video.xml | TextView com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView | @string/no_content | @+id/no_content_txv @+id/multi_pb_video_grid_view |
| fragment_multi_pb2 | fragment_multi_pb2.xml | TextView com.tinyai.libmediacomponent.components.filelist.FileListView | @string/no_content | @+id/no_content_txv @+id/file_list_view |
| fragment_remote_device_files | fragment_remote_device_files.xml | androidx.recyclerview.widget.RecyclerView com.icatch.golive.ui.ExtendComponent.ProgressWheel TextView | @string/no_content | @+id/rv_remote_files @+id/pw_load_more @+id/no_content_txv |
| ime_base_split_test_activity | ime_base_split_test_activity.xml |  | - | - |
| ime_secondary_split_test_activity | ime_secondary_split_test_activity.xml | EditText Button | EditText ｜ Hide Ime | @+id/edit_text_id @+id/hide_ime_id |
| include_pickerview_topbar | include_pickerview_topbar.xml | Button TextView | @string/pickerview_cancel ｜ @string/pickerview_submit | @+id/btnCancel @+id/tvTitle @+id/btnSubmit |
| input_ip | input_ip.xml | EditText | - | @+id/ip_address |
| input_password | input_password.xml | EditText | - | @+id/password |
| item_device_setting | item_device_setting.xml | TextView Switch | Left Name ｜ Right Content | @+id/tv_left @+id/tv_right @+id/switch_right |
| item_file_date | item_file_date.xml | TextView | - | @+id/tv_date |
| item_filter | item_filter.xml | TextView | test | @+id/text |
| item_firmware_info | item_firmware_info.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | BC2 前鏡頭固件包 ｜ Version：BC2-F_20250408_TW ｜ (中国版） | @+id/ll_chinese_t @+id/tv_firmware_name @+id/tv_firmware_version @+id/tv_firmware_region |
| item_local_photo_wall_grid | item_local_photo_wall_grid.xml |  | - | - |
| item_local_photo_wall_list | item_local_photo_wall_list.xml | TextView | photo name ｜ 00:00 ｜ 12.5M ｜ 2015-09-02 11:33 | @+id/local_photo_name @+id/local_video_duration @+id/local_photo_size @+id/local_photo_date |
| item_local_photo_wall_list_header | item_local_photo_wall_list_header.xml | TextView | - | @+id/photo_wall_header |
| item_local_video_wall_list | item_local_video_wall_list.xml | TextView | photo name ｜ 12.5M ｜ 2015-09-02 11:33 | @+id/local_video_name @+id/local_video_size @+id/local_video_date |
| item_local_wall_grid_header | item_local_wall_grid_header.xml | TextView | - | @+id/photo_wall_header |
| item_pb_recyclerview_grid | item_pb_recyclerview_grid.xml |  | - | - |
| item_pb_recyclerview_list | item_pb_recyclerview_list.xml | TextView | photo name ｜ 00:00 ｜ 12.5M ｜ 2015-09-02 11:33 | @+id/local_photo_name @+id/local_video_duration @+id/local_photo_size @+id/local_photo_date |
| item_video_file | item_video_file.xml | CheckBox com.icatch.golive.ui.ExtendComponent.ProgressWheel TextView | - | @+id/cb_select_item @+id/progress_wheel @+id/tv_file_info |
| item_video_file_ly | item_video_file_ly.xml | TextView CheckBox | file name 2020-11-10 mp4 ｜ 88.88MB ｜ @string/downloaded | @+id/tv_file_name @+id/tv_file_size @+id/tv_file_downloaded @+id/cb_select_item |
| iten_local_video_wall_grid | iten_local_video_wall_grid.xml |  | - | - |
| jz_dialog_brightness | jz_dialog_brightness.xml | TextView | - | @+id/tv_brightness |
| jz_dialog_progress | jz_dialog_progress.xml | TextView | - | @+id/tv_current @+id/tv_duration |
| jz_dialog_volume | jz_dialog_volume.xml | TextView | - | @+id/tv_volume |
| jz_layout_clarity | jz_layout_clarity.xml |  | - | - |
| jz_layout_clarity_item | jz_layout_clarity_item.xml | TextView | - | @+id/video_item |
| jz_layout_std | jz_layout_std.xml | TextView | 00:00 ｜ clarity ｜ @string/replay ｜ @string/video_loading_failed ｜ @string/click_to_restart | @+id/current @+id/total @+id/clarity @+id/title @+id/video_current_time @+id/replay_text @+id/retry_btn |
| layout_basepickerview | layout_basepickerview.xml |  | - | - |
| layout_progress_wheel_large | layout_progress_wheel_large.xml | com.icatch.golive.ui.ExtendComponent.ProgressWheel | - | @+id/pw_spinner |
| layout_progress_wheel_small | layout_progress_wheel_small.xml | com.icatch.golive.ui.ExtendComponent.ProgressWheel | - | @+id/pw_spinner |
| layout_refresh_footer | layout_refresh_footer.xml | TextView | 正在加载... ｜ 没有更多文件 | @+id/tv_loading |
| license_agreement_layout | license_agreement_layout.xml | TextView | @string/app_license | - |
| listview_item | listview_item.xml | TextView | - | @+id/content |
| listview_item_header | listview_item_header.xml | TextView | - | @+id/header |
| live_shared_url | live_shared_url.xml | EditText | - | @+id/shared_url |
| load_dialog | load_dialog.xml | TextView | @string/loading | @+id/tv_load_dialog |
| local_multi_pb_edit_view | local_multi_pb_edit_view.xml | TextView | Selected(0) | @+id/info_selected_num |
| m3_alert_dialog | m3_alert_dialog.xml | androidx.appcompat.widget.AlertDialogLayout androidx.core.widget.NestedScrollView android.widget.Space TextView | - | @+id/parentPanel @+id/scrollView @+id/textSpacerNoTitle @android:id/message @+id/textSpacerNoButtons |
| m3_alert_dialog_actions | m3_alert_dialog_actions.xml | androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @android:id/button3 @+id/spacer @android:id/button2 @android:id/button1 |
| m3_alert_dialog_title | m3_alert_dialog_title.xml | androidx.appcompat.widget.DialogTitle android.widget.Space | - | @+id/alertTitle @+id/titleDividerNoCustom |
| m3_auto_complete_simple_item | m3_auto_complete_simple_item.xml | TextView | - | - |
| m3_navigation_menu_divider | m3_navigation_menu_divider.xml | com.google.android.material.divider.MaterialDivider | - | - |
| m3_navigation_menu_subheader | m3_navigation_menu_subheader.xml | TextView | - | @+id/navigation_menu_subheader_label |
| m3_side_sheet_dialog | m3_side_sheet_dialog.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | @+id/coordinator |
| material_chip_input_combo | material_chip_input_combo.xml | com.google.android.material.timepicker.ChipTextInputComboView | - | - |
| material_clock_display | material_clock_display.xml |  | - | - |
| material_clock_display_divider | material_clock_display_divider.xml | TextView | - | - |
| material_clock_period_toggle | material_clock_period_toggle.xml | com.google.android.material.button.MaterialButtonToggleGroup com.google.android.material.button.MaterialButton | @string/material_clock_toggle_content_description ｜ @string/material_timepicker_am ｜ @string/material_timepicker_pm | @+id/material_clock_period_toggle @+id/material_clock_period_am_button @+id/material_clock_period_pm_button |
| material_clockface_textview | material_clockface_textview.xml | TextView | - | - |
| material_clockface_view | material_clockface_view.xml | com.google.android.material.timepicker.ClockHandView | - | @+id/material_clock_hand |
| material_radial_view_group | material_radial_view_group.xml |  | - | - |
| material_textinput_timepicker | material_textinput_timepicker.xml |  | - | - |
| material_time_chip | material_time_chip.xml | com.google.android.material.chip.Chip | - | - |
| material_time_input | material_time_input.xml | com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText TextView | - | @+id/material_label |
| material_timepicker | material_timepicker.xml | androidx.constraintlayout.helper.widget.Flow com.google.android.material.timepicker.ClockFaceView | - | @+id/material_clock_display_and_toggle @+id/material_clock_face |
| material_timepicker_dialog | material_timepicker_dialog.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.google.android.material.timepicker.TimePickerView com.google.android.material.button.MaterialButton Button | @string/material_timepicker_select_time ｜ @string/mtrl_timepicker_cancel ｜ @string/mtrl_timepicker_confirm | @+id/header_title @+id/material_timepicker_view @+id/material_timepicker_mode_button @+id/material_timepicker_cancel_button @+id/material_timepicker_ok_button |
| material_timepicker_textinput_display | material_timepicker_textinput_display.xml |  | - | - |
| media_audio_player_view_layout | media_audio_player_view_layout.xml | TextView com.icatchtek.basecomponent.customcomponent.MProgressWheel | 00:00 ｜ / | @+id/media_top_bar_title @+id/media_pb_time_lapsed @+id/tv_space @+id/media_pb_time_duration @+id/media_pb_spinner |
| media_camera_item | media_camera_item.xml | androidx.cardview.widget.CardView TextView | @string/meida_text_album ｜ @string/meida_text_share ｜ wifi ｜ setting | @+id/last_preview_time @+id/name_txv @+id/ip_txv |
| media_file_list_item | media_file_list_item.xml | com.tinyai.libmediacomponent.components.BorderImageView TextView | @string/media_text_downloaded | @+id/media_thumbnail @+id/file_duration_tv @+id/file_name @+id/downloaded_txv @+id/media_file_size_tv @+id/file_time_tv |
| media_file_recycler_list_layout | media_file_recycler_list_layout.xml | androidx.swiperefreshlayout.widget.SwipeRefreshLayout androidx.recyclerview.widget.RecyclerView TextView | @string/media_selected_num | @+id/swipe_refresh_layout @+id/list_view @+id/info_selected_num |
| media_item_pb_recyclerview_grid | media_item_pb_recyclerview_grid.xml |  | - | - |
| media_layout_refresh_footer | media_layout_refresh_footer.xml | TextView | 正在加载... ｜ 没有更多文件 | @+id/tv_loading |
| media_render_view_layout | media_render_view_layout.xml | TextView | @string/media_dialog_connecting ｜ 1.0X | @+id/media_last_preview_time @+id/media_connect_loading_txt @+id/media_scale_txt |
| meida_camera_list_layout | meida_camera_list_layout.xml | com.handmark.pulltorefresh.library.PullToRefreshListView | - | @+id/list_view |
| messenger_button_send_blue_large | messenger_button_send_blue_large.xml | TextView | @string/messenger_send_button_text | - |
| messenger_button_send_blue_round | messenger_button_send_blue_round.xml | Button | - | @+id/messenger_send_button |
| messenger_button_send_blue_small | messenger_button_send_blue_small.xml | TextView | @string/messenger_send_button_text | - |
| messenger_button_send_white_large | messenger_button_send_white_large.xml | TextView | @string/messenger_send_button_text | - |
| messenger_button_send_white_round | messenger_button_send_white_round.xml | Button | - | @+id/messenger_send_button |
| messenger_button_send_white_small | messenger_button_send_white_small.xml | TextView | @string/messenger_send_button_text | - |
| mtrl_alert_dialog | mtrl_alert_dialog.xml | androidx.appcompat.widget.AlertDialogLayout androidx.core.widget.NestedScrollView android.widget.Space TextView | - | @+id/parentPanel @+id/scrollView @+id/textSpacerNoTitle @android:id/message @+id/textSpacerNoButtons |
| mtrl_alert_dialog_actions | mtrl_alert_dialog_actions.xml | androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @android:id/button3 @+id/spacer @android:id/button2 @android:id/button1 |
| mtrl_alert_dialog_title | mtrl_alert_dialog_title.xml | androidx.appcompat.widget.DialogTitle android.widget.Space | - | @+id/alertTitle @+id/titleDividerNoCustom |
| mtrl_alert_select_dialog_item | mtrl_alert_select_dialog_item.xml | TextView | - | @android:id/text1 |
| mtrl_alert_select_dialog_multichoice | mtrl_alert_select_dialog_multichoice.xml | CheckedTextView | - | @android:id/text1 |
| mtrl_alert_select_dialog_singlechoice | mtrl_alert_select_dialog_singlechoice.xml | CheckedTextView | - | @android:id/text1 |
| mtrl_auto_complete_simple_item | mtrl_auto_complete_simple_item.xml | TextView | - | - |
| mtrl_calendar_day | mtrl_calendar_day.xml | TextView | - | - |
| mtrl_calendar_day_of_week | mtrl_calendar_day_of_week.xml | TextView | - | - |
| mtrl_calendar_days_of_week | mtrl_calendar_days_of_week.xml |  | - | - |
| mtrl_calendar_horizontal | mtrl_calendar_horizontal.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/mtrl_calendar_year_selector_frame |
| mtrl_calendar_month | mtrl_calendar_month.xml | com.google.android.material.datepicker.MaterialCalendarGridView | - | @+id/month_grid |
| mtrl_calendar_month_labeled | mtrl_calendar_month_labeled.xml | TextView | - | @+id/month_title |
| mtrl_calendar_month_navigation | mtrl_calendar_month_navigation.xml | com.google.android.material.button.MaterialButton | @string/mtrl_picker_a11y_prev_month ｜ @string/mtrl_picker_a11y_next_month | @+id/month_navigation_fragment_toggle @+id/month_navigation_previous @+id/month_navigation_next |
| mtrl_calendar_months | mtrl_calendar_months.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/mtrl_calendar_months |
| mtrl_calendar_vertical | mtrl_calendar_vertical.xml |  | - | - |
| mtrl_calendar_year | mtrl_calendar_year.xml | TextView | - | - |
| mtrl_layout_snackbar | mtrl_layout_snackbar.xml |  | - | - |
| mtrl_layout_snackbar_include | mtrl_layout_snackbar_include.xml | TextView Button | - | @+id/snackbar_text @+id/snackbar_action |
| mtrl_navigation_rail_item | mtrl_navigation_rail_item.xml | com.google.android.material.internal.BaselineLayout TextView | - | @+id/navigation_bar_item_labels_group @+id/navigation_bar_item_small_label_view @+id/navigation_bar_item_large_label_view |
| mtrl_picker_actions | mtrl_picker_actions.xml | Button | @string/mtrl_picker_cancel ｜ @string/mtrl_picker_confirm | @+id/cancel_button @+id/confirm_button |
| mtrl_picker_dialog | mtrl_picker_dialog.xml | androidx.fragment.app.FragmentContainerView | - | @+id/mtrl_calendar_frame |
| mtrl_picker_fullscreen | mtrl_picker_fullscreen.xml | androidx.fragment.app.FragmentContainerView | - | @+id/mtrl_calendar_frame |
| mtrl_picker_header_dialog | mtrl_picker_header_dialog.xml |  | - | - |
| mtrl_picker_header_fullscreen | mtrl_picker_header_fullscreen.xml | com.google.android.material.button.MaterialButton TextView | @string/mtrl_picker_cancel ｜ @string/mtrl_picker_save | @+id/cancel_button @+id/mtrl_picker_title_text @+id/mtrl_picker_header_selection_text @+id/confirm_button |
| mtrl_picker_header_selection_text | mtrl_picker_header_selection_text.xml | TextView | - | @+id/mtrl_picker_header_selection_text |
| mtrl_picker_header_title_text | mtrl_picker_header_title_text.xml | TextView | - | @+id/mtrl_picker_title_text |
| mtrl_picker_header_toggle | mtrl_picker_header_toggle.xml | com.google.android.material.internal.CheckableImageButton | - | @+id/mtrl_picker_header_toggle |
| mtrl_picker_text_input_date | mtrl_picker_text_input_date.xml | com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText | @string/mtrl_picker_text_input_date_hint | @+id/mtrl_picker_text_input_date |
| mtrl_picker_text_input_date_range | mtrl_picker_text_input_date_range.xml | com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText | @string/mtrl_picker_text_input_date_range_start_hint ｜ @string/mtrl_picker_text_input_date_range_end_hint | @+id/mtrl_picker_text_input_range_start @+id/mtrl_picker_text_input_range_end |
| mtrl_search_bar | mtrl_search_bar.xml | TextView | - | @+id/open_search_bar_text_view @+id/open_search_bar_placeholder_text_view |
| mtrl_search_view | mtrl_search_view.xml | com.google.android.material.internal.ClippableRoundedCornerLayout com.google.android.material.appbar.MaterialToolbar TextView EditText com.google.android.material.internal.TouchObserverFrameLayout | - | @+id/open_search_view_root @+id/open_search_view_dummy_toolbar @+id/open_search_view_toolbar @+id/open_search_view_search_prefix @+id/open_search_view_edit_text @+id/open_search_view_content_container |
| multi_pb_edit_view | multi_pb_edit_view.xml | TextView | Selected(0) | @+id/info_selected_num |
| my_exo_player_control_view | my_exo_player_control_view.xml | TextView com.google.android.exoplayer2.ui.DefaultTimeBar | - | @+id/exo_position @+id/exo_progress @+id/exo_duration |
| my_toast | my_toast.xml | TextView | - | @+id/message_text |
| notification_action | notification_action.xml | TextView | - | @+id/action_text |
| notification_action_tombstone | notification_action_tombstone.xml | TextView | - | @+id/action_text |
| notification_media_action | notification_media_action.xml |  | - | - |
| notification_media_cancel_action | notification_media_cancel_action.xml |  | - | - |
| notification_template_big_media | notification_template_big_media.xml |  | - | - |
| notification_template_big_media_custom | notification_template_big_media_custom.xml | TextView | - | @+id/info |
| notification_template_big_media_narrow | notification_template_big_media_narrow.xml |  | - | - |
| notification_template_big_media_narrow_custom | notification_template_big_media_narrow_custom.xml | TextView | - | @+id/info |
| notification_template_custom_big | notification_template_custom_big.xml | TextView | - | @+id/info |
| notification_template_icon_group | notification_template_icon_group.xml |  | - | - |
| notification_template_lines_media | notification_template_lines_media.xml | TextView | - | @+id/title @+id/text2 @+id/text @+id/info |
| notification_template_media | notification_template_media.xml |  | - | - |
| notification_template_media_custom | notification_template_media_custom.xml | TextView | - | @+id/info |
| notification_template_part_chronometer | notification_template_part_chronometer.xml |  | - | - |
| notification_template_part_time | notification_template_part_time.xml |  | - | - |
| pb_photo_item | pb_photo_item.xml | uk.co.senab.photoview.PhotoView com.icatch.golive.ui.ExtendComponent.ProgressWheel | - | @+id/photo @+id/progress_wheel |
| percentage_dialog | percentage_dialog.xml | TextView com.icatchtek.basecomponent.customcomponent.ImageProgressView | @string/loading ｜ 0% | @+id/tv_load_dialog @+id/text_percentage @+id/imageProgressView |
| pickerview_options | pickerview_options.xml | com.contrarywind.view.WheelView | - | @+id/options1 @+id/options2 @+id/options3 |
| pickerview_time | pickerview_time.xml | com.contrarywind.view.WheelView | - | @+id/year @+id/month @+id/day @+id/hour @+id/min @+id/second |
| preview_control_view | preview_control_view.xml | TextView | @string/meida_text_resolution_smooth ｜ 0KB/s ｜ 1 | @+id/media_top_bar_title @+id/preview_size_txv @+id/preview_video_bitrate_txv @+id/preview_client_count_txv |
| preview_player_view | preview_player_view.xml | com.tinyai.libmediacomponent.components.media.MPreviewView | - | @+id/preview_view |
| privacy_zones_view_layout | privacy_zones_view_layout.xml |  | - | - |
| pull_to_refresh_header_horizontal | pull_to_refresh_header_horizontal.xml |  | - | - |
| pull_to_refresh_header_vertical | pull_to_refresh_header_vertical.xml | TextView | - | @+id/pull_to_refresh_text @+id/pull_to_refresh_sub_text |
| sample_video_land | sample_video_land.xml | TextView moe.codeest.enviews.ENDownloadView | 00:00 | @+id/current @+id/total @+id/loading @+id/title |
| sample_video_normal | sample_video_normal.xml | TextView moe.codeest.enviews.ENDownloadView moe.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/loading @+id/start @+id/title |
| select_dialog_item_material | select_dialog_item_material.xml | TextView | - | @android:id/text1 |
| select_dialog_multichoice_material | select_dialog_multichoice_material.xml | CheckedTextView | - | @android:id/text1 |
| select_dialog_singlechoice_material | select_dialog_singlechoice_material.xml | CheckedTextView | - | @android:id/text1 |
| setting_enable_wifi_hotspot | setting_enable_wifi_hotspot.xml | TextView EditText | SSID ｜ Password | @+id/wifi_ssid @+id/wifi_password |
| setting_listview_item | setting_listview_item.xml | com.tinyai.libmediacomponent.components.setting.CommonItemView | - | @+id/common_item_view |
| setting_menu | setting_menu.xml | TextView com.tinyai.libmediacomponent.components.setting.CommonItemLayout Button | @string/device_name_pwd ｜ id221_Action_C5_XXXX ｜ ******** ｜ @string/format_device ｜ @string/reset_device | @+id/tv_device_name @+id/tv_device_pwd @+id/commont_layout @+id/btn_format @+id/btn_reset |
| setting_menu_item | setting_menu_item.xml | TextView | Title ｜ value | @+id/item_text @+id/item_value |
| setting_switch_layout | setting_switch_layout.xml | TextView androidx.appcompat.widget.SwitchCompat | name | @+id/item_name @+id/switchCompat |
| single_download_content_dialog | single_download_content_dialog.xml | TextView com.icatch.golive.ui.ExtendComponent.NumberProgressBar | filename ｜ Status | @+id/fileName @+id/downloadStatus @+id/numberbar |
| support_simple_spinner_dropdown_item | support_simple_spinner_dropdown_item.xml | TextView | - | @android:id/text1 |
| video_brightness | video_brightness.xml | TextView | 50% | @+id/app_video_brightness |
| video_control_view | video_control_view.xml | TextView com.icatchtek.basecomponent.customcomponent.MProgressWheel | 00:00 ｜ / | @+id/media_top_bar_title @+id/media_pb_time_lapsed @+id/tv_space @+id/media_pb_time_duration @+id/media_pb_spinner |
| video_layout_ad | video_layout_ad.xml | TextView | @string/jump_ad ｜ 00 | @+id/jump_ad @+id/ad_time |
| video_layout_custom | video_layout_custom.xml | TextView moe.codeest.enviews.ENDownloadView moe.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/loading @+id/start @+id/title |
| video_layout_normal | video_layout_normal.xml | TextView | 00:00 | @+id/current @+id/total @+id/title |
| video_layout_sample_ad | video_layout_sample_ad.xml | TextView moe.codeest.enviews.ENDownloadView | 00:00 ｜ @string/jump_ad ｜ 00 | @+id/title @+id/loading @+id/current @+id/total @+id/jump_ad @+id/ad_time |
| video_layout_standard | video_layout_standard.xml | TextView moe.codeest.enviews.ENDownloadView moe.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/title @+id/loading @+id/start |
| video_player_view | video_player_view.xml | com.tinyai.libmediacomponent.components.media.MPreviewView | - | @+id/preview_view |
| video_progress_dialog | video_progress_dialog.xml | TextView | - | @+id/tv_current @+id/tv_duration |
| video_volume_dialog | video_volume_dialog.xml |  | - | - |
| zoombar_view | zoombar_view.xml | TextView | x 1.5 | @+id/zoom_rate |

## menu（9 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| album_menu_album | album_menu_album.xml | item | @string/album_menu_finish | @+id/album_menu_finish |
| album_menu_gallery | album_menu_gallery.xml | item | @string/album_menu_finish | @+id/album_menu_finish |
| album_menu_item_camera | album_menu_item_camera.xml | item | @string/album_camera_image_capture ｜ @string/album_camera_video_capture | @+id/album_menu_camera_image @+id/album_menu_camera_video |
| menu_launch | menu_launch.xml | item | @string/text_btpair_skip ｜ @string/action_search ｜ @string/action_input_ip ｜ @string/action_device_pwd ｜ @string/setting_about ｜ @string/title_privacy_policy ｜ @string/help | @+id/action_done @+id/action_refresh @+id/action_search @+id/action_input_ip @+id/action_device_pwd @+id/action_about @+id/action_license @+id/action_help |
| menu_local_multi_pb | menu_local_multi_pb.xml | item | @string/menu_list | @+id/menu_multi_pb_preview_type |
| menu_local_photo_wall | menu_local_photo_wall.xml | item | @string/menu_list | @+id/menu_photo_wall_type |
| menu_local_video_wall | menu_local_video_wall.xml | item | Grid | @+id/menu_video_wall_type |
| menu_multi_pb | menu_multi_pb.xml | item | @string/menu_list ｜ @string/type_grid_view ｜ @string/type_list_view ｜ @string/type_quick_list_view | @+id/menu_multi_pb_filter @+id/grid @+id/liner @+id/quick_liner |
| menu_preview | menu_preview.xml | item | @string/setting | @+id/action_setting |

## xml（10 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| ad_services_config | ad_services_config.xml |  | - | - |
| album_camera_provider | album_camera_provider.xml |  | - | - |
| device_filter | device_filter.xml |  | - | - |
| file_provider_path | file_provider_path.xml |  | - | - |
| jz_network_security_config | jz_network_security_config.xml |  | - | - |
| m3_button_group_child_size_change | m3_button_group_child_size_change.xml | item | - | - |
| m3_split_button_inner_corner_size_state_list | m3_split_button_inner_corner_size_state_list.xml | item | - | - |
| m3expressive_button_shape_state_list | m3expressive_button_shape_state_list.xml | item | - | - |
| m3expressive_connected_buttons_inner_corner_size_state_list | m3expressive_connected_buttons_inner_corner_size_state_list.xml | item | - | - |
| network_security_config | network_security_config.xml |  | - | - |
