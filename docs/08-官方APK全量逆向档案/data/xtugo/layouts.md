# XTU GO — 布局/菜单/配置 XML 全量解析

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 581 个 XML；逐文件列出根元素、用到的控件类、可见文案（android:text/hint/contentDescription/title/summary）与 id/key
> 文案若为 `@string/xxx`，其真实文本按 `res-strings-default.md` 与 `res-strings-zh.md` 查表

---

## layout（546 个）

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
| activity_about_camera | activity_about_camera.xml | TextView | @string/chip ｜ @string/sensor ｜ @string/os ｜ @string/hardware_feature ｜ @string/app_version ｜ @string/firmware_version ｜ @string/build_date ｜ @string/upgrade_firmware | @+id/about_camera_name @+id/textDeviceChip @+id/textDeviceSensor @+id/textDeviceOS @+id/textHardwareFeature @+id/textAppVer @+id/textFirmwareVersion @+id/textBuildDate @+id/textUpgradeFirmware |
| activity_about_client | activity_about_client.xml | TextView | @string/back_finsh_activity ｜ @string/customerServiceHotline ｜ +86-15999693535 ｜ @string/client_version ｜ @string/soft_version ｜ @string/contactUs ｜ support@xtucam.com ｜ @string/check_update ｜ @string/text_icp | @+id/client_name @+id/textClientVersion @+id/textBuildDate @+id/textCheckUpdate @+id/textICP |
| activity_agreement_permission | activity_agreement_permission.xml | TextView | - | @+id/titleView |
| activity_album | activity_album.xml | androidx.appcompat.widget.Toolbar androidx.viewpager2.widget.ViewPager2 | - | @+id/viewToolbar @+id/viewToolbar2 @+id/viewPager2 |
| activity_album_preview | activity_album_preview.xml | androidx.appcompat.widget.Toolbar com.gku.actioncam.hisilicon.dv.localimage.weight.PhotoViewPager com.gku.actioncam.hisilicon.dv.ui.weight.BottomButtomItem | - | @+id/toolbar @+id/vpager @+id/iv_share_yutupro @+id/iv_edit_yutupro @+id/iv_video_edit_yutupro @+id/iv_delete_yutupro |
| activity_amba_device_setting | activity_amba_device_setting.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/amba_system_recy_model |
| activity_amba_pic_preview | activity_amba_pic_preview.xml | TextView androidx.viewpager2.widget.ViewPager2 | @string/pic | @+id/ViewPager2 |
| activity_amba_playback | activity_amba_playback.xml | TextView com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView com.gku.actioncam.hisilicon.dv.filebrowser.HiGridView Button | @string/camera_gallery ｜ @string/action_selectAll ｜ @string/cancel ｜ @string/ok | @+id/ibtvTitle @+id/ibSelectAll @+id/refresh_header_view @+id/ibImgGridView @+id/ibUndo @+id/ibConfirm |
| activity_amba_preview | activity_amba_preview.xml | com.gku.actioncam.widget.VideoView TextView | - | @+id/ijkplayer_video @+id/tvPrompt |
| activity_amba_remote_photo | activity_amba_remote_photo.xml | com.gku.actioncam.hisilicon.dv.imagelookover.SwitchImageView TextView | - | @+id/switch_image_view @+id/ibprogress |
| activity_amba_remote_video | activity_amba_remote_video.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.widget.VideoView | - | @+id/amba_control_video |
| activity_amba_work_setting | activity_amba_work_setting.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/amba_work_recy_model |
| activity_announcement_latest | activity_announcement_latest.xml | com.google.android.material.appbar.MaterialToolbar TextView androidx.core.widget.NestedScrollView androidx.recyclerview.widget.RecyclerView | @string/latest_announcement ｜ @string/end_announcement | @+id/toolbar @+id/recycler_announcement_latest |
| activity_audio_collect | activity_audio_collect.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.appcompat.widget.LinearLayoutCompat TextView androidx.recyclerview.widget.RecyclerView | @string/xtugo_extract_music ｜ @string/xtugo_local_music | @+id/ll_select @+id/tv_collect @+id/tv_local @+id/rv_list |
| activity_bit_rate | activity_bit_rate.xml | TextView EditText Button | Bitrate:  ｜ Set Bitrate | @+id/textBitRate @+id/editBitRate @+id/btnBitRate |
| activity_camera_album | activity_camera_album.xml | androidx.constraintlayout.widget.ConstraintLayout | - | - |
| activity_camera_album2 | activity_camera_album2.xml | androidx.constraintlayout.widget.ConstraintLayout | - | - |
| activity_camera_file | activity_camera_file.xml | TextView com.cy.androidview.shapeview.TextViewShape com.cy.tablayoutniubility.TabLayoutNoScroll com.cy.tablayoutniubility.IndicatorLineView androidx.viewpager.widget.ViewPager com.gku.base.view.ShimmerLayoutSimple | @string/camera_file ｜ @string/choose | @+id/tv_title @+id/tv_choose @+id/TabLayoutNoScroll @+id/ViewPager @+id/ShimmerLayoutSimple |
| activity_camera_video | activity_camera_video.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.recyclerview.widget.RecyclerView | @string/camera_gallery ｜ @string/cancel ｜ @string/xtugo_nofile_hint | @+id/tv_title @+id/tv_cancal @+id/rv_list @+id/tv_no_file |
| activity_control | activity_control.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.constraintlayout.widget.Guideline cn.rxt.qscase.ui.camera.player.CompatLivePreviewPlayer TextView m.mifan.ui.widget.PressImageView cn.rxt.caeuicore.widget.RecStatusTextView com.google.android.material.tabs.TabLayout cn.rxt.qscase.ui.widget.ZoomRateView cn.rxt.caeuicore.widget.ShutterActionButton RadioButton | @string/text_camera_preview ｜ 10 ｜ @string/text_taking_photo ｜ @string/pref_res_shoot ｜ @string/text_taking_pictures ｜ @string/text_time_lapse_image ｜ @string/text_time_lapse_video ｜ @string/text_video | @+id/controlParent @+id/guideline2 @+id/viewPlayer @+id/viewTitle @+id/viewButtonBack @+id/viewDelayNum @+id/viewLongExposure @+id/viewTextRecStatus @+id/viewTextBurstPhotoStatus @+id/viewTextRes @+id/viewVoiceRes @+id/viewTabMode @+id/viewActionAlbum @+id/viewActionSettings @+id/zoomRateView @+id/viewActionShutter @+id/rb_taking_pictures @+id/rb_timelapse_image @+id/rb_timelapse_video @+id/rb_video @+id/viewButtonFullScreen |
| activity_custom_live | activity_custom_live.xml | androidx.appcompat.widget.Toolbar androidx.core.widget.NestedScrollView androidx.constraintlayout.widget.ConstraintLayout TextView EditText com.gku.actioncam.remote_live.widget.ExpandSelectView | @string/rl_live_wifi ｜ @string/rl_selete_wifi ｜ @string/rl_rtmp_push_address ｜ @string/rl_input_rtmp ｜ @string/rl_start_live | @+id/custom_live_toolbar @+id/custom_live_wifi_scan @+id/custom_live_wifi_name @+id/custom_live_rtmp_edit @+id/rl_start_live_text |
| activity_cut | activity_cut.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.videoedit.MyVideoView androidx.appcompat.widget.LinearLayoutCompat androidx.recyclerview.widget.RecyclerView Button | @string/speed_0 ｜ 0.00s ｜  -  ｜ 7.00s ｜ @string/audio_clipping ｜ @string/original_audio_on ｜ @string/more_music ｜ @string/cut ｜ @string/theme_music ｜ @string/ok ｜ @string/cancel | @+id/tv_speed @+id/videoview @+id/tv_start_time @+id/tv_end_time @+id/video_thumb_listview @+id/ll_audio @+id/tv_audio_cut @+id/tv_video_audio_open @+id/tv_more_audio @+id/rv_audio @+id/tv_video_cut @+id/tv_music @+id/btn_cut @+id/btn_cancal |
| activity_device_add | activity_device_add.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.core.widget.NestedScrollView androidx.appcompat.widget.LinearLayoutCompat androidx.viewpager2.widget.ViewPager2 TextView androidx.recyclerview.widget.RecyclerView | @string/motionCamera | @+id/vp_device_add @+id/sport_camera @+id/rv_device_add |
| activity_device_add_new | activity_device_add_new.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.core.widget.NestedScrollView androidx.appcompat.widget.LinearLayoutCompat TextView com.gku.actioncam.sigmastar.widget.IconTextView androidx.recyclerview.widget.RecyclerView | @string/add_device ｜ @string/select_add_device ｜ @string/motionCamera | @+id/it_scan @+id/it_bluetooth @+id/it_handle @+id/sport_camera @+id/rv_device_add |
| activity_device_manager | activity_device_manager.xml | TextView com.cy.switchbuttonniubility.SimpleSwitchButton androidx.recyclerview.widget.RecyclerView Button | @string/gku_delete ｜ @string/device_manager ｜ @string/gku_share_edit ｜ @string/devicer_manager_auto_download ｜ @string/gku_all ｜ @string/devicer_manager_no_devices ｜ @string/devicer_manager_check_update ｜ @string/devicer_manager_auto_clear_download | @+id/tv_delete @+id/tv_manager @+id/switch_button @+id/tv_empty_hint @+id/recycler_view @+id/tv_check_version @+id/tv_check_version_hint |
| activity_device_str | activity_device_str.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/recy_device |
| activity_device_upgrade | activity_device_upgrade.xml | TextView com.cy.androidview.shapeview.TextViewShape com.cy.androidview.shapeview.LinearLayoutShape com.gku.loginmodule.ui.widget.CustomRoundProgress | @string/gku_firmware_update_title ｜ @string/devicer_manager_upgrade_to ｜ @string/devicer_manager_what_new ｜ @string/devicer_manager_check_update ｜ @string/gku_firmware_update_start | @+id/tv_device_name @+id/tv_old_version @+id/tv_new_version @+id/tv_check_version @+id/tv_content @+id/tv_hint @+id/progress @+id/tv_button |
| activity_download_packages | activity_download_packages.xml |  | - | - |
| activity_exception | activity_exception.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/exception_log |
| activity_gkucam_player | activity_gkucam_player.xml | androidx.core.widget.NestedScrollView com.gku.gkucamplayer.video.LandLayoutVideo | - | @+id/post_detail_nested_scroll @+id/detail_player |
| activity_hisi_camera_file | activity_hisi_camera_file.xml | TextView com.cy.androidview.shapeview.TextViewShape com.cy.tablayoutniubility.TabLayoutNoScroll com.cy.tablayoutniubility.IndicatorLineView androidx.viewpager.widget.ViewPager | @string/camera_file ｜ @string/choose | @+id/tv_choose @+id/TabLayoutNoScroll @+id/ViewPager |
| activity_hisi_pic_preview | activity_hisi_pic_preview.xml | TextView androidx.viewpager2.widget.ViewPager2 | @string/pic | @+id/ViewPager2 |
| activity_home | activity_home.xml | androidx.viewpager.widget.ViewPager com.gku.actioncam.hisilicon.dv.ui.weight.BottomButtomItem Button | @string/delete ｜ @string/action_selectAll ｜ Log | @+id/mFvpager @+id/bottom_photo @+id/bottom_camera @+id/bottom_xtu_plus @+id/bottom_user @+id/delete_files @+id/select_all_files @+id/btn_log |
| activity_hwscaning | activity_hwscaning.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.hisilicon.dv.ui.weight.ScrollingYellowLineView TextView | - | @+id/scrollingYellowLineView @+id/viewSSIDhw @+id/viewPSWhw |
| activity_icatch_video_player | activity_icatch_video_player.xml | androidx.constraintlayout.widget.ConstraintLayout m.mifan.acase.icatch.IcatchVideoView TextView | - | @+id/viewSurface @+id/viewTitle @+id/viewCacheValue @+id/viewProgress @+id/viewDuration |
| activity_image_edit | activity_image_edit.xml | androidx.appcompat.widget.Toolbar uk.co.senab.photoview.PhotoView androidx.recyclerview.widget.RecyclerView com.gku.actioncam.hisilicon.dv.localimage.weight.SimpleTabLinearLayout TextView | @string/image_edit_tools ｜ @string/image_edit_filter ｜ @string/image_edit_effect | @+id/toolbar @+id/pv_cover @+id/rlv_action @+id/tab |
| activity_image_edit_clip | activity_image_edit_clip.xml | androidx.appcompat.widget.Toolbar com.yalantis.ucrop.view.UCropView TextView | - | @+id/toolbar @+id/ucv_cover @+id/tv_size |
| activity_image_edit_effect | activity_image_edit_effect.xml | androidx.appcompat.widget.Toolbar jp.co.cyberagent.android.gpuimage.GPUImageView | - | @+id/toolbar @+id/iv_cover |
| activity_launcher | activity_launcher.xml | androidx.constraintlayout.widget.ConstraintLayout | - | - |
| activity_local_album | activity_local_album.xml |  | - | - |
| activity_login_register_module | activity_login_register_module.xml | com.google.android.material.appbar.MaterialToolbar TextView | @string/tourists_enter_text | @+id/toolbar_login |
| activity_main | activity_main.xml | androidx.constraintlayout.widget.ConstraintLayout com.google.android.material.bottomnavigation.BottomNavigationView | - | @+id/viewBottomNav |
| activity_main2 | activity_main2.xml | androidx.constraintlayout.widget.ConstraintLayout Button | shutter | @+id/viewButtonShutter |
| activity_multi_pb | activity_multi_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar com.google.android.material.tabs.TabLayout | - | @+id/toolbar @+id/tabs |
| activity_online_and_offline_player | activity_online_and_offline_player.xml | androidx.constraintlayout.widget.ConstraintLayout | - | - |
| activity_permission | activity_permission.xml | TextView | - | @+id/tv |
| activity_phone_space | activity_phone_space.xml | com.gku.actioncam.sigmastar.widget.MyCircleProgress TextView | 手机存储已用 0g,剩余 0g | @+id/mcp_space @+id/tv_space |
| activity_photo_pb | activity_photo_pb.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_prefer_str | activity_prefer_str.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/amba_work_recy_model |
| activity_preferences | activity_preferences.xml | androidx.constraintlayout.widget.ConstraintLayout m.mifan.ui.widget.SimpleToolbar androidx.recyclerview.widget.RecyclerView | - | @+id/viewToolbar @+id/viewRecyclerView |
| activity_preview | activity_preview.xml | com.google.android.material.appbar.AppBarLayout androidx.appcompat.widget.Toolbar | - | @+id/AppBarLayout @+id/toolbar |
| activity_preview_new | activity_preview_new.xml | TextView com.gku.actioncam.sigmastar.widget.StateView | - | @+id/tvCountDownTime @+id/tvPrompt @+id/sv_message |
| activity_privacy_agreement | activity_privacy_agreement.xml | TextView | @string/back_finsh_activity | - |
| activity_q_r_show | activity_q_r_show.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.appcompat.widget.Toolbar androidx.constraintlayout.widget.Guideline TextView | @string/rl_camera_scan_qr ｜ @string/rl_start_live | @+id/qr_show_toolbar @+id/_guideline @+id/_qr_show_scan_qr_text |
| activity_question_description | activity_question_description.xml | androidx.constraintlayout.widget.ConstraintLayout EditText TextView RadioButton Button | @string/contentHint ｜ @string/contactDetails ｜ @string/feedbackByEmail ｜ @string/feedbackByPhone ｜ @string/contactHint ｜ @string/submit | @+id/detail_content @+id/contact_details @+id/radio_email @+id/radio_phone @+id/remain_contact_details @+id/submit |
| activity_question_select | activity_question_select.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.recyclerview.widget.RecyclerView | @string/issueSelect | @+id/issue_select @+id/rv_question_select |
| activity_report_feedback | activity_report_feedback.xml | com.google.android.material.appbar.MaterialToolbar TextView | @string/report_feedback | @+id/toolbar @+id/tv_report_feedback |
| activity_s_s_bluetooth_tx | activity_s_s_bluetooth_tx.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape | @string/microphone_connection ｜ @string/tx_connection_1 ｜ @string/tx_not_connected ｜ @string/tx_connection_2 ｜ @string/tx_connection_hint | @+id/titleModeText @+id/tv_bt_tx_name1 @+id/tv_bt_tx_status1 @+id/tv_bt_tx_name2 @+id/tv_bt_tx_status2 |
| activity_s_s_camera_about | activity_s_s_camera_about.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.appcompat.widget.Toolbar TextView | @string/ss_about_camera_app_version ｜ @string/ss_about_camera_fw_version ｜ @string/ss_about_camera_fw_date ｜ @string/ss_about_camera_bluetooth_version ｜ @string/ss_about_camera_bluetooth_bluetoothtxoneversion ｜ @string/ss_about_camera_bluetooth_bluetoothtxtwoversion ｜ @string/ss_clear_cache | @+id/ss_about_camera_tool @+id/ss_about_camera_app_version @+id/ss_about_camera_fw_version @+id/ss_about_camera_version_date @+id/bluetooth_version @+id/bluetooth_version_name @+id/bluetooth_txoneversion_name @+id/bluetooth_txtwoversion_name @+id/clear_cache @+id/clear_cache_size |
| activity_s_s_device_setting | activity_s_s_device_setting.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.recyclerview.widget.RecyclerView | - | @+id/titleModeText @+id/ss_device_setting_recycle |
| activity_s_s_mode_setting | activity_s_s_mode_setting.xml | TextView androidx.recyclerview.widget.RecyclerView com.gku.base.view.ShimmerLayoutSimple | @string/ss_device_setting | @+id/titleModeText @+id/enterDeviceSett @+id/ss_mode_setting_recycle @+id/ShimmerLayoutSimple |
| activity_s_s_photo_remote_play | activity_s_s_photo_remote_play.xml | androidx.appcompat.widget.Toolbar androidx.viewpager2.widget.ViewPager2 | - | @+id/ss_remote_photo_toolbar @+id/ViewPager2 |
| activity_s_s_playback | activity_s_s_playback.xml | androidx.appcompat.widget.Toolbar com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout androidx.viewpager2.widget.ViewPager2 | - | @+id/ss_playback_tool @+id/ss_playback_tab @+id/ss_playback_view_pager |
| activity_s_s_video_remote_play | activity_s_s_video_remote_play.xml | androidx.appcompat.widget.Toolbar androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.sigmastar.widget.SSVideoView | - | @+id/ss_video_remote_play_tool @+id/video_remote_play_video |
| activity_scan_wifi | activity_scan_wifi.xml | androidx.appcompat.widget.Toolbar TextView | @string/rl_selete_wifi | @+id/scan_wifi_toolbar |
| activity_select_live | activity_select_live.xml | androidx.appcompat.widget.Toolbar TextView | @string/rl_selete_plaform | @+id/select_tool_bar |
| activity_select_live_device | activity_select_live_device.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.recyclerview.widget.RecyclerView Button | @string/douyin_live ｜ @string/select_live_device_model ｜ @string/select_live_device_supprt_model ｜ @string/ok | @+id/recycler_view @+id/btn_confirm |
| activity_select_live_wifi | activity_select_live_wifi.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape EditText androidx.recyclerview.widget.RecyclerView com.gku.base.view.ShimmerLayoutSimple Button | @string/live_device_connect ｜ @string/wifi_info ｜ @string/manual_input ｜ @string/live_device_select_wifi_down ｜ @string/unchoose_net ｜ @string/input_pwd ｜ @string/no_pwd_noneed_input ｜ @string/live_device_select_wifi ｜ @string/link | @+id/manual_input @+id/ll_select_wifi @+id/tv_ssid @+id/ev_password @+id/recycler_view @+id/layout_shimmer @+id/btn_connect |
| activity_send_soft | activity_send_soft.xml | TextView Button | @string/firm_sending ｜ @string/finish | @+id/sending_text @+id/update_finish |
| activity_simulate | activity_simulate.xml | TextView | - | @+id/text_tip |
| activity_stream | activity_stream.xml |  | - | - |
| activity_stream_demo | activity_stream_demo.xml | TextView Button Switch androidx.appcompat.widget.AppCompatCheckBox RadioButton | 初始化 ｜ 授权 ｜ 获取头像昵称 ｜ 游戏开播 ｜ 我同意抖音主播入驻协议 ｜ 推流方式： ｜ app推流 ｜ 机内推流 ｜ 开播方式： ｜ 平面 ｜ 180度 ｜ 360度 ｜ 开始直播 ｜ 退出登录 ｜ 直播设置 ｜ token ｜ 关播 | @+id/result_console @+id/init_btn @+id/auth_btn @+id/me_btn @+id/switch_to_game @+id/live_agreement @+id/cam_type_app @+id/cam_type_hardware @+id/live_type_flat @+id/live_type_180 @+id/live_type_360 @+id/start_broadcast @+id/quit_btn @+id/stream_setting @+id/stream_token @+id/stream_quit |
| activity_stream_setting_first | activity_stream_setting_first.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape com.cy.rvadapterniubility.recyclerview.VerticalRecyclerView com.google.android.material.button.MaterialButton | @string/live_setting ｜ @string/choose_live_platform ｜ @string/start_live_setting | @+id/VerticalRecyclerView @+id/stream_setting |
| activity_stream_setting_second | activity_stream_setting_second.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape com.cy.androidview.selectorview.RadioButtonSelector com.google.android.material.button.MaterialButton Button | @string/douyin_live ｜ @string/gku_select_dev_type ｜ @string/select_live_device_switch_model ｜ @string/verify_connected_device ｜ @string/live_device_connect ｜ @string/select_live_device_switch_wifi ｜ @string/live_device_connect_hint ｜ @string/live_params ｜ @string/resolution ｜ @string/high_720p ｜ @string/high_1080p ｜ @string/fps ｜ @string/standard_25 ｜ @string/sports_30 ｜ @string/bitrate ｜ @string/bitrate_flue ｜ @string/bitrate_high ｜ @string/account_login ｜ @string/video_channel_auth ｜ @string/uninit ｜ @string/revoke_authorization ｜ @string/gku_privacy_key_privacy ｜ @string/start_stream_simple ｜ @string/close_live_room | @+id/switch_device @+id/ll_select_device @+id/tv_select_device @+id/tv_device_connect_status @+id/img_device_connect_dot @+id/switch_wifi @+id/ll_connect_wifi @+id/tv_connect_hint @+id/tv_wifi_connect_status @+id/tv_wif_connect_dot @+id/rbs_720 @+id/rbs_1080 @+id/rbs_25 @+id/rbs_30 @+id/rbs_flu @+id/rbs_high @+id/tv_b_status @+id/cancel_author @+id/tv_agreement @+id/stream_start @+id/stream_end |
| activity_stream_setting_second_rtmp | activity_stream_setting_second_rtmp.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape com.cy.androidview.selectorview.RadioButtonSelector EditText com.google.android.material.button.MaterialButton | RTMP推流 ｜ @string/gku_select_dev_type ｜ @string/select_live_device_switch_model ｜ @string/live_device_connect ｜ @string/live_device_connect_hint ｜ 直播参数 ｜ @string/resolution ｜ @string/high_720p ｜ @string/high_1080p ｜ @string/fps ｜ @string/standard_25 ｜ @string/sports_30 ｜ @string/bitrate ｜ @string/bitrate_flue ｜ @string/bitrate_high ｜ @string/push_stream_addr ｜ RTMP ｜ @string/rtmp_example ｜ @string/next_step | @+id/switch_device @+id/ll_select_device @+id/tv_select_device @+id/ll_connect_wifi @+id/tv_connect_hint @+id/rbs_720 @+id/rbs_1080 @+id/rbs_25 @+id/rbs_30 @+id/rbs_flu @+id/rbs_high @+id/et_rtmp @+id/stream_start |
| activity_stream_setting_third | activity_stream_setting_third.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.google.android.material.button.MaterialButton | @string/start_live ｜ @string/prepare_finish_connect_wifi ｜ @string/kaibo ｜ @string/guanbo | @+id/tv_not_ready @+id/tv_log @+id/stream_start @+id/stream_end |
| activity_stream_wifi | activity_stream_wifi.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.rvadapterniubility.refreshrv.LinearRefreshLayout com.gku.base.view.ShimmerLayoutSimple | @string/choose_wifi | @+id/LinearRefreshLayout @+id/ShimmerLayoutSimple |
| activity_stream_wifi_typein | activity_stream_wifi_typein.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape EditText com.google.android.material.button.MaterialButton | @string/choose_wifi ｜ @string/wifi_info ｜ @string/choose_net ｜ @string/ssis_hint ｜ @string/input_pwd ｜ @string/no_pwd_noneed_input ｜ @string/confirm | @+id/ev_ssid @+id/ev_password @+id/confirm_wifi |
| activity_streaming | activity_streaming.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape com.google.android.material.button.MaterialButton | @string/start_live ｜ @string/streaming ｜ LIVE· ｜ 00:00 ｜ 关播 | @+id/tv_timer @+id/stream_end |
| activity_television | activity_television.xml |  | - | - |
| activity_track | activity_track.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.widget.VideoView TextView Button com.amap.api.maps.MapView com.google.android.gms.maps.MapView | @string/back_finsh_activity | @+id/mapVideoView @+id/track_video_name @+id/sr @+id/sr_export @+id/sr_show @+id/gps_info_constraint @+id/gaodeMapView @+id/googleMapView @+id/speed_text @+id/longtitude_text @+id/latitude_text |
| activity_track_land | activity_track_land.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.widget.VideoView TextView | @string/back_finsh_activity | @+id/mapVideoView @+id/track_video_name |
| activity_upload_firmware | activity_upload_firmware.xml |  | - | - |
| activity_user_info | activity_user_info.xml | com.google.android.material.appbar.MaterialToolbar TextView | @string/user_info | @+id/toolbar_user_info |
| activity_video_pb | activity_video_pb.xml |  | - | - |
| activity_video_pb_2 | activity_video_pb_2.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | - |
| activity_video_player | activity_video_player.xml | androidx.constraintlayout.widget.ConstraintLayout m.mifan.player.PlayerView androidx.appcompat.widget.Toolbar | - | @+id/viewPlayer @+id/viewToolbarView |
| activity_video_share | activity_video_share.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.videoedit.MyVideoView | @string/action_share ｜ @string/save_to_phone | @+id/tv_title @+id/videoview @+id/tv_time @+id/tv_save @+id/tv_share |
| activity_web | activity_web.xml | com.google.android.material.appbar.MaterialToolbar TextView | 这是WebView的标题 | @+id/toolbar @+id/tv_web_view_title |
| activity_web_view | activity_web_view.xml | com.cy.androidview.shapeview.RelativeLayoutShape TextView | - | @+id/layout_title @+id/tv_title |
| activity_webview | activity_webview.xml |  | - | - |
| activity_wifi_channel | activity_wifi_channel.xml | TextView EditText Button | Current WiFi Channel  ｜ Set WiFi Channel | @+id/textWifiChannel @+id/editWifiChannel @+id/btnSetWifiChannel |
| alertdialog_progress | alertdialog_progress.xml | TextView | Message | @+id/tvDialogTitle01 @+id/tvDialogMessage01 |
| amu_info_window | amu_info_window.xml | TextView | - | @+id/window |
| amu_text_bubble | amu_text_bubble.xml | com.google.maps.android.ui.RotationLayout TextView | - | @+id/amu_text |
| amu_webview | amu_webview.xml |  | - | - |
| auto_download_layout_size | auto_download_layout_size.xml | TextView EditText | @string/setting_auto_download_size_limit ｜ 1.0GB | @+id/item_text @+id/download_size |
| base_dialog_loading | base_dialog_loading.xml | com.cy.androidview.shapeview.LinearLayoutShape com.cy.androidview.loadingview.FourCircleLoadingView | - | @+id/FourCircleLoadingView |
| bottom_buttom_item_layout | bottom_buttom_item_layout.xml | TextView | @string/camera_set | @+id/btn_text |
| broadcast_init_progress_dialog | broadcast_init_progress_dialog.xml | TextView | @string/broadcast_in_loading | - |
| brvah_quick_view_load_more | brvah_quick_view_load_more.xml | TextView | @string/brvah_loading ｜ @string/brvah_load_failed ｜ @string/brvah_load_complete ｜ @string/brvah_load_end | @+id/loading_text @+id/tv_prompt |
| camer_mode_switch_layout | camer_mode_switch_layout.xml | RadioButton | - | @+id/video_radio @+id/capture_radio @+id/timeLapse_radio |
| camera_group_layout | camera_group_layout.xml | TextView | @string/camera_name | @+id/camera_name_text |
| camera_name_password_set | camera_name_password_set.xml | TextView EditText | @string/camera_wifi_name ｜ @string/camera_wifi_password | @+id/camera_name @+id/wifi_password |
| camera_scan | camera_scan.xml | androidx.camera.view.PreviewView | - | @+id/previewView |
| check_internet | check_internet.xml | TextView | @string/check_internet | @+id/dlgFragMsg |
| common_layout_progress_dialog_fullscreen | common_layout_progress_dialog_fullscreen.xml |  | - | - |
| content_download_size_dialog | content_download_size_dialog.xml | EditText TextView | GB | @+id/download_size |
| content_multi_pb | content_multi_pb.xml | androidx.viewpager.widget.ViewPager | - | @+id/vPager |
| content_panorama_video_pb | content_panorama_video_pb.xml | TextView Switch com.gku.dashcam.icatch.ProgressWheel | @string/more_settings ｜ @string/delete ｜ @string/text_stablization ｜ 00:00 ｜ / | @+id/video_pb_video_name @+id/delete_txv @+id/eis_switch @+id/video_pb_time_lapsed @+id/video_pb_time_duration @+id/video_pb_spinner |
| content_photo_pb | content_photo_pb.xml | androidx.viewpager.widget.ViewPager TextView | @string/text_panorama | @+id/viewpager @+id/panorama_type_btn @+id/pb_index_info |
| content_video_pb | content_video_pb.xml | com.example.icatchplayerlibrary.MPreview TextView com.example.icatchplayerlibrary.ProgressWheel | 20151245233_1245.mp4 ｜ 00:00 | @+id/video_pb_view @+id/video_pb_video_name @+id/video_pb_time_lapsed @+id/video_pb_time_duration @+id/video_pb_spinner |
| copy_file_dialog | copy_file_dialog.xml | TextView | @string/update_dialog_remind ｜ 0% | @+id/dialog_title @+id/copy_progress_text |
| custom_dialog | custom_dialog.xml | Button | Ok | @+id/dialog_button |
| custom_toast | custom_toast.xml | TextView | - | @+id/toast_text |
| cv_layout_calendar_view | cv_layout_calendar_view.xml | com.haibin.calendarview.MonthViewPager com.haibin.calendarview.WeekViewPager com.haibin.calendarview.YearViewPager | - | @+id/vp_month @+id/vp_week @+id/selectLayout |
| cv_week_bar | cv_week_bar.xml | TextView | @string/sun ｜ @string/mon ｜ @string/tue ｜ @string/wed ｜ @string/thu ｜ @string/fri ｜ @string/sat | - |
| cy_loadmore_horizontal_foot_default | cy_loadmore_horizontal_foot_default.xml | com.cy.refreshlayoutniubility.ThreeScaleCircleView TextView | 没有更多了哦~ | @+id/animView @+id/tv |
| cy_loadmore_vertical_foot_default | cy_loadmore_vertical_foot_default.xml | com.cy.refreshlayoutniubility.ThreeScaleCircleView TextView | 没有更多了哦~ | @+id/animView @+id/tv |
| cy_refresh_finished_default | cy_refresh_finished_default.xml | TextView | - | @+id/tv |
| cy_staggerd_item | cy_staggerd_item.xml |  | - | - |
| cy_staggerd_item_0 | cy_staggerd_item_0.xml |  | - | - |
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
| device_item | device_item.xml | TextView | wifiName | @+id/tvWifiName |
| device_manage | device_manage.xml | TextView | ${app_name} ｜ @string/phone_gallery | - |
| dialog_activate | dialog_activate.xml | TextView Button | @string/activate_title ｜ @string/activate_content_title ｜ @string/activate_text_content ｜ @string/activate_success ｜ @string/trial_left ｜ @string/activate_agree | @+id/tv_activated_content @+id/btn_trial @+id/btn_activate |
| dialog_amba_progress | dialog_amba_progress.xml |  | - | - |
| dialog_amba_sd_media_delete | dialog_amba_sd_media_delete.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.loadingview.FourCircleLoadingView com.cy.androidview.shapeview.TextViewShape | @string/delete ｜ @string/cancel | @+id/tv_delete_count @+id/tv_cancel |
| dialog_amba_sd_media_download | dialog_amba_sd_media_download.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/ss_download ｜ @string/download_hint ｜ @string/chongshi ｜ @string/cancel | @+id/tv_download_hint @+id/tv_download_count @+id/tv_download_time_left @+id/tv_log @+id/tv_file_name @+id/tv_download_percent @+id/tv_error @+id/tv_retry @+id/tv_cancel |
| dialog_amba_sd_media_long_click | dialog_amba_sd_media_long_click.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/delete ｜ @string/action_download | @+id/tv_name @+id/tv_length @+id/tv_time @+id/tv_path @+id/layout_delete @+id/layout_download |
| dialog_app_update | dialog_app_update.xml | TextView Button | 发现新版本 ｜ xtugo: v6.0.3 ｜ 更新内容 ｜ 立即升級 ｜ 暂不升级 | @+id/tvDialogTitle @+id/tvDialogAppVersion @+id/txtDialogUpdateMessage @+id/txtDialogUpdatePercent @+id/btnDialogOK @+id/btnDialogCancel |
| dialog_ask | dialog_ask.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/cancel ｜ @string/confirm | @+id/tv_content @+id/tv_cancel @+id/tv_confirm |
| dialog_bottom_fast_setting | dialog_bottom_fast_setting.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.recyclerview.widget.RecyclerView Button | 相机设置 ｜ @string/exit_fastSetting | @+id/setting_text @+id/setting_recycle @+id/button_disconnect |
| dialog_bottom_settings | dialog_bottom_settings.xml | TextView | - | @+id/titleView |
| dialog_common_confirm | dialog_common_confirm.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/cancel ｜ @string/confirm | @+id/tv_title @+id/tv_content @+id/tv_cancel @+id/tv_sure |
| dialog_common_hint | dialog_common_hint.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/confirm | @+id/tv_title @+id/tv_content @+id/tv_sure |
| dialog_confirm | dialog_confirm.xml | TextView Button | @string/deletefile_tip ｜ @string/deletefile_msg ｜ @string/cancel ｜ @string/action_delete | @+id/tvDialogTitle @+id/tvDialogMessage @+id/btnDialogCancel @+id/btnDialogOK |
| dialog_confirm_with_checkbox | dialog_confirm_with_checkbox.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView CheckBox | - | @+id/tv_message @+id/cb_no_remind |
| dialog_cut_audio | dialog_cut_audio.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.videoedit.CloudMusicLoadingView | 00:00s-20:00s ｜ 完成 ｜ 取消 | @+id/tv_collect_time @+id/tv_cut_ok @+id/tv_cut_cancal |
| dialog_cut_video | dialog_cut_video.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | 手机视频 ｜ 相机视频 | @+id/tv_local_iamge @+id/tv_camera |
| dialog_download_soft | dialog_download_soft.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/downloading_update_pack ｜ 0% ｜ @string/cancel | @+id/tv_progress @+id/tv_cancel |
| dialog_file_action | dialog_file_action.xml | TextView Button | File Name ｜ @string/action_edit ｜ @string/action_delete ｜ @string/action_share ｜ @string/action_download ｜ @string/action_push ｜ @string/action_fileInfo ｜ @string/cancel | @+id/tvDialogTitle @+id/btnDialogCancel |
| dialog_file_info | dialog_file_info.xml | TextView Button | @string/action_fileInfo ｜ @string/ok | @+id/tvDialogTitle @+id/ibfilename @+id/ibfilesize @+id/ibmodifyTime @+id/ibstoragepath @+id/btnDialogCancel |
| dialog_hisi_sd_media_delete | dialog_hisi_sd_media_delete.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.loadingview.FourCircleLoadingView com.cy.androidview.shapeview.TextViewShape | @string/delete ｜ @string/cancel | @+id/tv_delete_count @+id/tv_cancel |
| dialog_hisi_sd_media_download | dialog_hisi_sd_media_download.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/ss_download ｜ @string/chongshi ｜ @string/cancel | @+id/tv_download_hint @+id/tv_download_count @+id/tv_download_time_left @+id/tv_file_name @+id/tv_download_percent @+id/tv_error @+id/tv_retry @+id/tv_cancel |
| dialog_hisi_sd_media_long_click | dialog_hisi_sd_media_long_click.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/delete ｜ @string/action_download | @+id/tv_name @+id/tv_length @+id/tv_time @+id/tv_path @+id/layout_delete @+id/layout_download |
| dialog_hisi_yingyan_progress | dialog_hisi_yingyan_progress.xml |  | - | - |
| dialog_listshow | dialog_listshow.xml | TextView Button | @string/action_fileInfo ｜ @string/cancel ｜ @string/reconnect | @+id/tvDialogTitle @+id/tvDialogMessage @+id/btnCancel01 @+id/btnCancel02 @+id/btnDialogOK01 |
| dialog_loading | dialog_loading.xml | TextView | @string/loading | @+id/tv_loading_tx |
| dialog_loading_fullscreen | dialog_loading_fullscreen.xml |  | - | - |
| dialog_ly_period_preference | dialog_ly_period_preference.xml | TextView Switch | @string/cam_setting_timing_1_start ｜ 00:00 ｜ @string/cam_setting_timing_1_stop ｜ @string/cam_setting_timing_2_start ｜ @string/cam_setting_timing_2_stop | @+id/switchTitleView @+id/switchView @+id/viewItem1Title @+id/viewItem1Value @+id/viewItem2Title @+id/viewItem2Value @+id/viewItem3Title @+id/viewItem3Value @+id/viewItem4Title @+id/viewItem4Value |
| dialog_modify_wifi | dialog_modify_wifi.xml | TextView EditText Button | @string/modify_wifi_info ｜ @string/ssid ｜ @string/password ｜ @string/cancel ｜ @string/ok | @+id/tvDialogTitle @+id/txtWifiStart @+id/etSSID @+id/etPassword @+id/btnDialogCancel @+id/btnDialogApply |
| dialog_my_bottom_sheet | dialog_my_bottom_sheet.xml | androidx.constraintlayout.widget.ConstraintLayout TextView Button | @string/permission_specification_hyh ｜ @string/storage_permission ｜ @string/storage_permission_description_hyh ｜ @string/location_permission_hyh ｜ @string/location_permission_description_hyh ｜ @string/bluetooth_permission_hyh ｜ @string/bluetooth_permission_description_hyh ｜ @string/media_permission_hyh ｜ @string/media_permission_description_hyh ｜ @string/enter_app_hyh | @+id/dialogTit @+id/storagePermissionLy @+id/storagePermission @+id/locationPermissionLy @+id/locationPermission @+id/bluetoothPermissionLy @+id/bluetoothPermission @+id/mediaPermissionLy @+id/mediaPermission @+id/enter |
| dialog_normal_progress | dialog_normal_progress.xml | TextView | @string/text_loading | @+id/dialogMessage |
| dialog_notify | dialog_notify.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/gku_tip ｜ @string/cancel ｜ @string/confirm | @+id/tv_content @+id/tv_cancel @+id/tv_confirm |
| dialog_pref_list | dialog_pref_list.xml | com.cy.translucentparent.StatusBarView m.mifan.ui.widget.SimpleToolbar | - | @+id/viewToolbar |
| dialog_progress | dialog_progress.xml | TextView Button | Dialog Title ｜ @string/cancel | @+id/tvDialogTitle @+id/tvDialogMessage @+id/download_progress_text @+id/btnDialogCancel |
| dialog_retry | dialog_retry.xml | com.cy.androidview.shapeview.LinearLayoutShape com.cy.androidview.loadingview.FourCircleLoadingView TextView com.cy.androidview.shapeview.TextViewShape | @string/cancel ｜ @string/retry | @+id/FourCircleLoadingView @+id/tv_content @+id/tv_cancel @+id/tv_retry |
| dialog_screen | dialog_screen.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/recyclerView |
| dialog_send_soft | dialog_send_soft.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/sending_soft_pack ｜ 0% ｜ @string/cancel | @+id/tv_progress @+id/tv_cancel |
| dialog_target_time | dialog_target_time.xml | TextView Switch | 开始时间: ｜ 00:00 ｜ 结束时间: | @+id/switchTitleView @+id/switchView @+id/timeStartTitleView @+id/timeStartValueView @+id/timeStopTitleView @+id/timeStopValueView |
| dialog_time | dialog_time.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | 00 ｜ @string/dialog_time_hour ｜ @string/dialog_time_minute ｜ @string/dialog_time_sec ｜ 1 ｜ 2 ｜ 3 ｜ 4 ｜ 5 ｜ 6 ｜ 7 ｜ 8 ｜ 9 ｜ 0 | @+id/hourTextView @+id/hourNameTextView @+id/minuteTextView @+id/minuteNameTextView @+id/secTextView @+id/secNameTextView @+id/number1View @+id/number2View @+id/number3View @+id/number4View @+id/number5View @+id/number6View @+id/number7View @+id/number8View @+id/number9View @+id/number0View |
| dialog_timelapse | dialog_timelapse.xml | RadioButton TextView | - | @+id/normalRadioButton @+id/normalTitleView @+id/tlRadioButton @+id/tlTitleView @+id/offRadioButton @+id/offTitleView |
| dialog_video_long_click | dialog_video_long_click.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView com.cy.androidview.shapeview.TextViewShape | @string/delete ｜ @string/action_download | @+id/tv_name @+id/tv_length @+id/tv_time @+id/tv_path @+id/layout_delete @+id/layout_download |
| dialog_video_save_tophone | dialog_video_save_tophone.xml | com.gku.actioncam.sigmastar.widget.roundview.RoundLinearLayout TextView com.gku.actioncam.sigmastar.widget.roundview.RoundRelativeLayout EditText androidx.appcompat.widget.LinearLayoutCompat com.gku.actioncam.sigmastar.widget.roundview.RoundTextView | 保存视频到手机 ｜ 请输入文件名 ｜ 取消 ｜ 确定 | @+id/edit_video_name @+id/tv_cancal @+id/tv_ok |
| dialog_wifi_preferences | dialog_wifi_preferences.xml | TextView EditText Button | @string/title_wifi_name ｜ @string/title_wifi_password ｜ @android:string/cancel ｜ @string/ok | @+id/wifiNameValueView @+id/passwordValueView @+id/cancelButton @+id/okButton |
| dmc_control_loading_dialog | dmc_control_loading_dialog.xml | TextView | - | @+id/txtDialog |
| dmc_video_control | dmc_video_control.xml | TextView | - | @+id/tvTitle @+id/tvCurrentPosition @+id/tvDuration |
| download | download.xml | TextView com.gku.dashcam.icatch.utils.NumberProgressBar | filename ｜ Status | @+id/fileName @+id/downloadStatus @+id/numberbar |
| download_content_dialog | download_content_dialog.xml | TextView | test | @+id/message |
| download_dialog_title | download_dialog_title.xml | TextView | @string/download_manager ｜ @string/cancel | @+id/cancel_all_txv |
| download_single_dialog_title | download_single_dialog_title.xml | TextView | @string/download_manager | - |
| downloadfile_exception | downloadfile_exception.xml | TextView RadioButton | @string/download_exception ｜ @string/auto_rename ｜ @string/over_load_file ｜ @string/skip ｜ @string/ok | @+id/ibContent @+id/rbrename @+id/rboverload @+id/ibUndo @+id/ibConfirm |
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
| file_browser_gridview | file_browser_gridview.xml | TextView com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView com.gku.actioncam.hisilicon.dv.filebrowser.HiGridView Button | @string/camera_gallery ｜ @string/action_selectAll ｜ @string/cancel ｜ @string/ok | @+id/ibtvTitle @+id/ibSelectAll @+id/refresh_header_view @+id/ibImgGridView @+id/ibUndo @+id/ibConfirm |
| file_filter | file_filter.xml | TextView | 筛选文件 ｜ 时间段 ｜ 到 ｜ 摄像头类型 ｜ 重置 ｜ 确定 | @+id/min_time_edt @+id/max_time_edt @+id/sensors_type_txv @+id/filter_reset @+id/filter_sure |
| fragment_camera_file | fragment_camera_file.xml | androidx.constraintlayout.widget.ConstraintLayout com.scwang.smart.refresh.layout.SmartRefreshLayout com.scwang.smart.refresh.header.ClassicsHeader androidx.recyclerview.widget.RecyclerView TextView com.scwang.smart.refresh.footer.ClassicsFooter | @string/xtugo_nofile_hint | @+id/local_album_fragment @+id/refresh_layout @+id/rv_list @+id/tv_no_file |
| fragment_delete_account | fragment_delete_account.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.button.MaterialButton | @string/text_delete_account ｜ @string/text_delete_des ｜ @string/delete_account ｜ @string/verify_code ｜ @string/btn_send_code_text_1 ｜ @string/delete_account_pt ｜ @string/text_delete_tips ｜ @string/text_sure | @+id/tv_register_title @+id/tv_register_des @+id/et_account_layout @+id/et_account @+id/et_verify_code @+id/btn_get_verify_code @+id/et_pwd @+id/btn_confirm |
| fragment_device_add | fragment_device_add.xml | androidx.constraintlayout.widget.ConstraintLayout com.cy.androidview.roundview.FrameLayoutRound | - | @+id/fl_device_add |
| fragment_device_add_1_list | fragment_device_add_1_list.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.widget.RadarView androidx.recyclerview.widget.RecyclerView com.cy.androidview.shapeview.TextViewShape | @string/device_connect ｜ @string/device_searching ｜ @string/select_device1 ｜ @string/connect ｜ @string/connecting | @+id/title_add @+id/content @+id/radar @+id/tv_scan_devices @+id/device_list @+id/btn_connect @+id/tv_bottom_content |
| fragment_device_add_2_key | fragment_device_add_2_key.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.TextViewShape | @string/match_code ｜ 0 ｜ @string/cancel_match | @+id/tv_device_add_key @+id/tv_pin_1 @+id/tv_pin_2 @+id/tv_pin_3 @+id/tv_pin_4 @+id/bt_cancel_key |
| fragment_device_add_3_connect | fragment_device_add_3_connect.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.TextViewShape | @string/device_connect ｜ @string/connect ｜ @string/connecting | @+id/tv_device_connect_status @+id/bt_start_connect @+id/tv_bottom_content |
| fragment_device_add_wave | fragment_device_add_wave.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.newUi.deviceAdd.DiffuseView2 androidx.recyclerview.widget.RecyclerView Button | Bluetooth adapter is disabled. ｜ ENABLE ｜ @string/device_searching ｜ 未发现设备 ｜ 确定设备已开启，并靠近手机 ｜ 帮助 | @+id/diffuseView1 @+id/diffuseView2 @+id/searching @+id/device_list @+id/helper |
| fragment_forget_pwd | fragment_forget_pwd.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.button.MaterialButton | @string/text_reset_pwd ｜ @string/text_reset_des ｜ @string/email ｜ @string/verify_code ｜ @string/btn_send_code_text_1 ｜ @string/text_new_pwd ｜ @string/text_password_tips ｜ @string/text_sure | @+id/tv_register_title @+id/tv_register_des @+id/et_account_layout @+id/et_account @+id/et_verify_code @+id/btn_get_verify_code @+id/et_new_pwd @+id/btn_confirm |
| fragment_hisi_camera_pic | fragment_hisi_camera_pic.xml | com.cy.androidview.selectorview.ImageViewSelector TextView com.cy.rvadapterniubility.refreshrv.GridRefreshLayout com.gku.base.view.ShimmerLayoutSimple | - | @+id/ivs @+id/tv_count @+id/GridRefreshLayout @+id/ShimmerLayoutSimple |
| fragment_hisi_camera_record | fragment_hisi_camera_record.xml | com.cy.androidview.selectorview.ImageViewSelector TextView com.cy.rvadapterniubility.refreshrv.GridRefreshLayout com.gku.base.view.ShimmerLayoutSimple | - | @+id/ivs @+id/tv_count @+id/GridRefreshLayout @+id/ShimmerLayoutSimple |
| fragment_login | fragment_login.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.textview.MaterialTextView com.google.android.material.button.MaterialButton com.google.android.material.radiobutton.MaterialRadioButton | @string/text_login ｜ @string/des_login ｜ @string/email ｜ @string/password ｜ @string/meet_problem ｜ @string/forget_pwd ｜ @string/no_account ｜ @string/sign_up_now | @+id/tv_login_title @+id/tv_login_des @+id/et_account_layout @+id/et_email_login @+id/et_pwd_login @+id/btn_meet_problem @+id/btn_forget_pwd @+id/tv_register @+id/btn_login @+id/btn_radio_login @+id/tv_agreement |
| fragment_modify_pwd | fragment_modify_pwd.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.button.MaterialButton | @string/text_modify_pwd ｜ @string/text_modify_des ｜ @string/text_old_pwd ｜ @string/text_new_pwd ｜ @string/text_password_tips ｜ @string/text_sure | @+id/tv_register_title @+id/tv_register_des @+id/et_account_layout @+id/et_account @+id/et_old_pwd @+id/et_new_pwd @+id/btn_confirm |
| fragment_multi_pb | fragment_multi_pb.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/no_content ｜ @string/dialog_preview | @+id/no_content_txv @+id/tv_loading @+id/recycler_view |
| fragment_operation_fail | fragment_operation_fail.xml | TextView com.google.android.material.button.MaterialButton | @string/operation_fail ｜ @string/register_fail_des ｜ @string/back_to_register ｜ @string/meet_problem_click_here | @+id/tv_fail_title @+id/tv_fail_des @+id/btn_fail_back @+id/tv_fail_meet_problem |
| fragment_operation_success | fragment_operation_success.xml | TextView com.google.android.material.button.MaterialButton | @string/operation_success ｜ @string/register_success_des ｜ @string/login_now | @+id/tv_success_title @+id/tv_success_des @+id/btn_success_back |
| fragment_phone_number | fragment_phone_number.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.button.MaterialButton | @string/phone_number ｜ @string/phone_number_des_1 ｜ @string/text_sure | @+id/tv_login_title @+id/tv_login_des @+id/et_phone_number @+id/btn_confirm |
| fragment_register | fragment_register.xml | TextView com.google.android.material.textfield.TextInputLayout com.google.android.material.textfield.TextInputEditText com.google.android.material.button.MaterialButton com.google.android.material.radiobutton.MaterialRadioButton | @string/text_register ｜ @string/des_register ｜ @string/email ｜ @string/verify_code ｜ @string/btn_send_code_text_1 ｜ @string/password ｜ @string/radio_text_5 ｜ @string/radio_text_2 ｜ @string/radio_text_3 ｜ @string/radio_text_4 ｜ @string/radio_text_7 | @+id/tv_register_title @+id/tv_register_des @+id/et_account_layout @+id/et_email @+id/et_verify_code @+id/btn_get_verify_code @+id/et_pwd @+id/btn_register @+id/btn_radio_register @+id/tv_radio_2 @+id/tv_radio_4 |
| fragment_report_feedback | fragment_report_feedback.xml | androidx.core.widget.NestedScrollView TextView com.sherlockshi.widget.SherlockSpinner EditText androidx.recyclerview.widget.RecyclerView Button | @string/product_type ｜ @string/spinner_default_text ｜ @string/product_model ｜ @string/problem_type ｜ @string/problem_description ｜ @string/problem_des_add_hint ｜ @string/send_firm | @+id/sp_product_type @+id/sp_product_model @+id/sp_problem_type @+id/et_problem_des @+id/rv_media_list @+id/btn_send_feedback |
| fragment_stream_setting_four | fragment_stream_setting_four.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.shapeview.LinearLayoutShape com.cy.androidview.shapeview.TextViewShape | @string/start_live ｜ @string/connecting ｜ @string/stream ｜ · ｜ 00:00 ｜ @string/close_live_room | @+id/tv_hint @+id/tv_time @+id/tv_close |
| fragment_user_center | fragment_user_center.xml | androidx.core.widget.NestedScrollView androidx.recyclerview.widget.RecyclerView | - | @+id/recycler_user @+id/recycler_user_other @+id/recycler_user_yutupro |
| fragment_user_center_contact_us_item | fragment_user_center_contact_us_item.xml | TextView | 淘宝 | @+id/user_center_new_item_title |
| fragment_user_center_item | fragment_user_center_item.xml | TextView | 淘宝 | @+id/item_title |
| fragment_user_center_item_title_and_other | fragment_user_center_item_title_and_other.xml | TextView | 我是标题 | @+id/item_title |
| fragment_user_center_item_yutupro | fragment_user_center_item_yutupro.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/technicalSupport | @+id/user_item_yutupro @+id/item_image_name_yutupro |
| fragment_user_center_new | fragment_user_center_new.xml | androidx.core.widget.NestedScrollView androidx.recyclerview.widget.RecyclerView | - | @+id/recycler_login_info @+id/recycler_contact_us @+id/recycler_setting_options |
| fragment_user_center_new_setting_options_item | fragment_user_center_new_setting_options_item.xml | TextView | 我是标题 ｜ · | @+id/user_center_new_item_title @+id/user_center_new_item_red_dot |
| fragment_user_center_new_top_item | fragment_user_center_new_top_item.xml | TextView | @string/user_id_des ｜ xyz@gkuvision.com | @+id/user_center_top_item_text_left @+id/user_center_top_item_text_right |
| fragment_user_info | fragment_user_info.xml | androidx.core.widget.NestedScrollView androidx.recyclerview.widget.RecyclerView com.google.android.material.button.MaterialButton | @string/text_sign_out | @+id/recycler_user_info_1 @+id/recycler_user_info_2 @+id/btn_sign_out |
| fragment_user_info_item | fragment_user_info_item.xml | TextView | @string/email ｜ xyz@gkuvision.com | @+id/user_info_item_text_left @+id/user_info_item_text_right |
| fragment_wave | fragment_wave.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.gku.actioncam.sigmastar.bluetooth.DiffuseView Button | Bluetooth adapter is disabled. ｜ ENABLE ｜ 搜索中... ｜ 未发现设备 ｜ 确定设备已开启，并靠近手机 ｜ 帮助 | @+id/diffuseView1 @+id/diffuseView2 @+id/searching @+id/helper |
| frg_about | frg_about.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/text_about ｜ @string/text_clear_cache ｜ @string/text_user_permission | @+id/viewTitleBar @+id/viewVersion @+id/viewActionClearCache @+id/viewUserAgreement |
| frg_album | frg_album.xml | com.google.android.material.tabs.TabLayout androidx.viewpager.widget.ViewPager | - | @+id/tablayout @+id/vpager |
| frg_album_caddx | frg_album_caddx.xml | com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout androidx.viewpager.widget.ViewPager | - | @+id/ss_tab @+id/vpager |
| frg_album_page | frg_album_page.xml | androidx.recyclerview.widget.RecyclerView TextView | @string/text_no_file | @+id/viewRecyclerView @+id/viewNoFile |
| frg_album_page_item_preview | frg_album_page_item_preview.xml | androidx.viewpager2.widget.ViewPager2 com.cy.translucentparent.StatusBarView androidx.appcompat.widget.Toolbar | - | @+id/viewPager2 @+id/viewToolbarView |
| frg_album_page_item_preview_wrapper | frg_album_page_item_preview_wrapper.xml | androidx.viewpager2.widget.ViewPager2 androidx.appcompat.widget.Toolbar | - | @+id/viewPager2 @+id/viewToolbarView |
| frg_camera_album | frg_camera_album.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.appcompat.widget.Toolbar com.google.android.material.tabs.TabLayout m.mifan.ui.widget.ViewPagerX | - | @+id/viewToolbar @+id/viewTabLayout @+id/viewActionToolbar @+id/viewPager |
| frg_connection | frg_connection.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.constraintlayout.widget.Guideline | @string/text_home ｜ @string/text_connection_camera | @+id/viewTitleBar @+id/guideline |
| frg_dialog_agreemwnta_permission | frg_dialog_agreemwnta_permission.xml | TextView androidx.core.widget.NestedScrollView | @string/text_hint_title | @+id/tvMessage |
| frg_home | frg_home.xml | androidx.constraintlayout.widget.ConstraintLayout TextView m.mifan.ui.widget.PressImageView m.mifan.ui.widget.PressTextView | IRO ｜ @string/text_add_dv | @+id/viewActionSettings @+id/viewActionAlbum @+id/viewActionAdd |
| frg_local_album | frg_local_album.xml | androidx.constraintlayout.widget.ConstraintLayout TextView m.mifan.ui.widget.PressImageView androidx.appcompat.widget.Toolbar com.google.android.material.tabs.TabLayout m.mifan.ui.widget.ViewPagerX | @string/text_album | @+id/viewTitleBar @+id/viewActionSelectViewOn @+id/viewActionToolbar @+id/viewTabLayout @+id/viewPager |
| general_pop_recycler_item | general_pop_recycler_item.xml | TextView | 0.5Sec | @+id/item_recy_itemname |
| general_popupwindow | general_popupwindow.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/recycler_pop |
| grid_item_layout | grid_item_layout.xml | com.gku.actioncam.hisilicon.dv.ui.weight.CameraItemView | - | @+id/item_camera |
| hicheck_widget | hicheck_widget.xml | CheckBox | - | @android:id/checkbox |
| icatch_content_preview | icatch_content_preview.xml | TextView com.gku.dashcam.icatch.ui.customview.ZoomView | @string/text_not_support_preview ｜ 4M ｜ / ｜ 1123 ｜ FHD 30 ｜ 40:10 ｜ 00:00:00 | @+id/not_support_preview_txv @+id/image_size_txv @+id/separator1 @+id/remain_capture_count_text @+id/video_size_txv @+id/separator2 @+id/remain_recording_time_text @+id/recording_time @+id/delay_capture_text @+id/zoom_view |
| image_edit_layout_action_item | image_edit_layout_action_item.xml | TextView | - | @+id/tv_title |
| image_lookover | image_lookover.xml | com.gku.actioncam.hisilicon.dv.imagelookover.SwitchImageView TextView | - | @+id/switch_image_view @+id/ibprogress |
| image_toolbar | image_toolbar.xml | TextView | @string/file_browser | - |
| ime_base_split_test_activity | ime_base_split_test_activity.xml |  | - | - |
| ime_secondary_split_test_activity | ime_secondary_split_test_activity.xml | EditText Button | EditText ｜ Hide Ime | @+id/edit_text_id @+id/hide_ime_id |
| include_location_dialog | include_location_dialog.xml | TextView | @string/ble_location_notice | - |
| include_pickerview_topbar | include_pickerview_topbar.xml | Button TextView | @string/pickerview_cancel ｜ @string/pickerview_submit | @+id/btnCancel @+id/tvTitle @+id/btnSubmit |
| item_announcement_create_time | item_announcement_create_time.xml | TextView | 2020-01-01 00:00:00 | @+id/announcement_item_create_time |
| item_announcement_latest | item_announcement_latest.xml | TextView | 骁图最新6K防抖运动相机！ ｜ 万众期待的XTU最新运动相机出炉啦！\106K高清拍摄，支持4K6O防抖\10点击查看详情资讯 | @+id/announcement_latest_item_title @+id/announcement_latest_item_content |
| item_audio | item_audio.xml | TextView | - | @+id/tv_audio_name |
| item_audio_collect | item_audio_collect.xml | TextView com.gku.actioncam.sigmastar.widget.roundview.RoundTextView com.gku.actioncam.sigmastar.videoedit.CloudMusicLoadingView | audioname ｜ 00:59 ｜ @string/xtugo_use ｜ 00:00s-20:00s | @+id/tv_name @+id/tv_time @+id/tv_use @+id/tv_collect_time |
| item_camera_pic_amba | item_camera_pic_amba.xml | com.cy.androidview.rectangleview.FrameLayoutRectangle TextView com.cy.androidview.selectorview.ImageViewSelector | @string/downloaded_no | @+id/tv_download_state @+id/ivs @+id/tv_retry |
| item_camera_pic_hisi | item_camera_pic_hisi.xml | com.cy.androidview.rectangleview.FrameLayoutRectangle TextView com.cy.androidview.selectorview.ImageViewSelector | @string/downloaded_no | @+id/tv_download_state @+id/ivs |
| item_camera_record_amba | item_camera_record_amba.xml | com.cy.androidview.rectangleview.FrameLayoutRectangle TextView com.cy.androidview.selectorview.ImageViewSelector | @string/downloaded_no ｜ 00:00:00 | @+id/tv_download_state @+id/tv_duration @+id/ivs @+id/tv_retry |
| item_camera_record_hisi | item_camera_record_hisi.xml | com.cy.androidview.rectangleview.FrameLayoutRectangle TextView com.cy.androidview.selectorview.ImageViewSelector | @string/downloaded_no ｜ 00:00:00 | @+id/tv_download_state @+id/tv_duration @+id/ivs |
| item_device_manager | item_device_manager.xml | TextView com.gku.loginmodule.ui.widget.CusProgressBar | @string/devicer_manager_download_fw ｜ @string/gku_firmware_update_start ｜ @string/gku_download_doing ｜ @string/gku_download_state_failed ｜ @string/gku_firmware_update_try_again | @+id/tv_device_name @+id/tv_device_model @+id/tv_device_version @+id/tv_device_upgrade @+id/tv_download_version @+id/tv_start_upgrade @+id/progress_bar @+id/tv_retry |
| item_filter | item_filter.xml | TextView | test | @+id/text |
| item_pb_recyclerview_grid | item_pb_recyclerview_grid.xml |  | - | - |
| item_pb_recyclerview_list | item_pb_recyclerview_list.xml | TextView | photo name ｜ 00:00 ｜ 12.5M ｜ 2015-09-02 11:33 | @+id/local_photo_name @+id/local_video_duration @+id/local_photo_size @+id/local_photo_date |
| item_pic_preview_hisi | item_pic_preview_hisi.xml | com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView com.gku.base.view.ShimmerLayoutSimple | - | @+id/SubsamplingScaleImageView @+id/ShimmerLayoutSimple |
| item_preference | item_preference.xml | TextView Switch | - | @+id/titleView @+id/summaryView @+id/switchView |
| item_preference_list_item | item_preference_list_item.xml | cn.rxt.qscase.ui.camera.preferences.widget.ListItemView | - | - |
| item_pure_image | item_pure_image.xml |  | - | - |
| item_report_feedback | item_report_feedback.xml | TextView | @string/problem_des_add_text | @+id/tv_item_report_feedback_video_time @+id/tv_item_report_feedback_size_des |
| item_select_live_device | item_select_live_device.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/xtu_x1 | @+id/layout_bg @+id/item_desc |
| layout_basepickerview | layout_basepickerview.xml |  | - | - |
| layout_camera_model_item_layout | layout_camera_model_item_layout.xml | TextView | - | @+id/item_title |
| layout_connected_camera | layout_connected_camera.xml | TextView Button | @string/enter_camera ｜ @string/connected_update_version_text ｜ @string/connected_camera ｜ @string/viewFile | @+id/camera_name @+id/camera_connected_state @+id/connected_update_version_tips @+id/connect_state @+id/see_file @+id/enter_camera_btn |
| layout_connected_camera_caddx | layout_connected_camera_caddx.xml | TextView Button | @string/enter_camera ｜ @string/connected_update_version_text ｜ @string/connected_camera | @+id/camera_name @+id/camera_connected_state @+id/connected_update_version_tips @+id/connect_state @+id/enter_camera_btn |
| layout_device_add_item | layout_device_add_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/xtu_x1 | @+id/item_desc |
| layout_device_add_title_bar | layout_device_add_title_bar.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/device_connect | @+id/layout_title_add |
| layout_dialog_jump | layout_dialog_jump.xml | androidx.constraintlayout.widget.ConstraintLayout TextView Button | text ｜ 确认 ｜ 取消 | @+id/dialog_tips @+id/dialog_confirm |
| layout_dialog_no_confirm_tip | layout_dialog_no_confirm_tip.xml | TextView Button | @android:string/cancel | @+id/ss_dialog_tip_message @+id/ss_dialog_tip_cancel |
| layout_dialog_size | layout_dialog_size.xml | TextView RadioButton | @string/download_video ｜ @string/down_load_size_big ｜ @string/down_load_size_small ｜ @string/down_load_size_sure | @+id/btn_radio1 @+id/btn_radio2 @+id/tv_sure |
| layout_dialog_ss_download | layout_dialog_ss_download.xml | TextView Button | @string/downloadVideoToLocal_hint ｜ @string/cancel | @+id/download_catalogue @+id/ss_dialog_download_count @+id/ss_dialog_download_text @+id/ss_dialog_download_progress_Text @+id/ss_dialog_download_cancel |
| layout_dialog_ss_info | layout_dialog_ss_info.xml | TextView Button | @string/ok | @+id/ss_dialog_info_message_name @+id/ss_dialog_info_message_size @+id/ss_dialog_info_message_create @+id/ss_dialog_info_message_path @+id/ss_dialog_info_cancel |
| layout_dialog_ss_list | layout_dialog_ss_list.xml | androidx.recyclerview.widget.RecyclerView Button | @android:string/cancel | @+id/ss_dialog_list_recycle @+id/ss_dialog_list_cancel |
| layout_dialog_ss_message_tip | layout_dialog_ss_message_tip.xml | TextView Button | @string/cancel ｜ @string/ok | @+id/ss_dialog_message_tip_message @+id/ss_dialog_message_tip_cancel @+id/ss_dialog_message_tip_ok |
| layout_dialog_ss_progress | layout_dialog_ss_progress.xml |  | - | - |
| layout_dialog_ss_progress_text | layout_dialog_ss_progress_text.xml | TextView | 0% | @+id/tv_progress |
| layout_dialog_ss_rename_group | layout_dialog_ss_rename_group.xml | RadioButton Button | @string/ss_overload ｜ @string/ss_skip ｜ @string/cancel ｜ @string/ok | @+id/ss_dialog_rename_group_overload @+id/ss_dialog_rename_group_skip @+id/ss_dialog_rename_group_cancel @+id/ss_dialog_rename_group_ok |
| layout_dialog_ss_video_quelity_group | layout_dialog_ss_video_quelity_group.xml | RadioButton Button | @string/ss_hd ｜ @string/ss_normal ｜ @string/cancel ｜ @string/ok | @+id/ss_dialog_video_quality_group_hd @+id/ss_dialog_video_quality_group_normal @+id/ss_dialog_video_quality_group_cancel @+id/ss_dialog_video_quality_group_ok |
| layout_dialog_ss_wifi | layout_dialog_ss_wifi.xml | TextView EditText Button | @string/ss_wifi_ssid ｜ @string/ss_wifi_password ｜ @android:string/cancel ｜ @string/ok | @+id/ss_dialog_wifi_ssid_edit @+id/ss_dialog_wifi_ssid_tail @+id/ss_dialog_wifi_password_edit @+id/ss_dialog_wifi_cancel @+id/ss_dialog_wifi_ok |
| layout_dialog_tip | layout_dialog_tip.xml | TextView Button | @android:string/cancel ｜ @string/ok | @+id/dialog_tip_message @+id/dialog_tip_cancel @+id/dialog_tip_confirm |
| layout_dialog_title | layout_dialog_title.xml | TextView | - | @+id/dialog_title |
| layout_disconnect_camera_1 | layout_disconnect_camera_1.xml | TextView androidx.constraintlayout.widget.ConstraintLayout Button | @string/welcome_camera_xtu ｜ @string/no_connect_camera ｜ @string/next_step ｜ @string/previous_step | @+id/text_page_title @+id/text_page_step @+id/conn_btn @+id/scan_btn @+id/next_btn @+id/previous_btn |
| layout_dv_set_item | layout_dv_set_item.xml | TextView com.suke.widget.SwitchButton | 显示日期时间 ｜ 12131231 | @+id/item_title_dv @+id/item_value_text_dv @+id/item_wechat_switch_dv |
| layout_fast_setting_item | layout_fast_setting_item.xml | androidx.constraintlayout.widget.ConstraintLayout | - | - |
| layout_fast_setting_item_click | layout_fast_setting_item_click.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/sleep | @+id/item_desc |
| layout_fast_setting_item_select | layout_fast_setting_item_select.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/sleep ｜ 10s | @+id/item_desc @+id/item_value |
| layout_fast_setting_popup_recycle_item | layout_fast_setting_popup_recycle_item.xml | TextView | - | @+id/ss_fast_setting_popup_list_item_text |
| layout_fast_setting_popup_view | layout_fast_setting_popup_view.xml | androidx.recyclerview.widget.RecyclerView | - | @+id/ss_fast_setting_popup_recycle |
| layout_issue_select_item | layout_issue_select_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | 我是标题 | @+id/issue_select_item_title |
| layout_live_platform | layout_live_platform.xml |  | - | - |
| layout_mode_select_popup_list_item | layout_mode_select_popup_list_item.xml | TextView | - | @+id/layout_ss_select_popup_list_item_text |
| layout_mode_select_popup_view | layout_mode_select_popup_view.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/ss_mode_select_video ｜ @string/ss_mode_select_photo | @+id/popup_video_text @+id/popup_photo_text @+id/layout_ss_mode_select_popup_list |
| layout_mode_set_item | layout_mode_set_item.xml | TextView | 显示日期时间 | @+id/item_title @+id/item_value_text |
| layout_permission_agreement | layout_permission_agreement.xml | androidx.constraintlayout.widget.ConstraintLayout TextView Button | @string/permission_title ｜ @string/permission_explanation ｜ @string/privacy_agreement_cancel ｜ @string/privacy_agreement_agree | @+id/permission_title @+id/permission_content @+id/disagree @+id/agree |
| layout_photos | layout_photos.xml |  | - | - |
| layout_prefer_title | layout_prefer_title.xml | TextView | @string/model_set ｜ @string/device_set | @+id/mode_set_tv @+id/device_set_tv |
| layout_privacy_agreement | layout_privacy_agreement.xml | TextView | @string/welcome_pr_tip ｜ @string/privacy_agreement_cancel ｜ @string/privacy_agreement_agree | @+id/welcome_pr_tip @+id/pa_cancel @+id/pa_agree |
| layout_privacy_web_view | layout_privacy_web_view.xml | TextView | @string/welcome_agree_pr_tip ｜ @string/privacy_agreement_cancel ｜ @string/privacy_agreement_agree | @+id/welcome_pr_tip @+id/pa_cancel @+id/pa_agree |
| layout_progress_wheel_small | layout_progress_wheel_small.xml | com.example.icatchplayerlibrary.ProgressWheel | - | @+id/pw_spinner |
| layout_question_select_title_bar | layout_question_select_title_bar.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/questionFeedback | @+id/layout_title_question_select |
| layout_refresh_footer | layout_refresh_footer.xml | TextView | @string/list_header_loading ｜ @string/list_no_more | @+id/tv_loading |
| layout_s_s_playback_recycle_item | layout_s_s_playback_recycle_item.xml | com.gku.actioncam.sigmastar.widget.PlaybackImageView TextView | - | @+id/ss_playback_recycle_item_image @+id/ss_playback_recycle_item_download @+id/ss_playback_recycle_item_time |
| layout_s_s_remote_fragment | layout_s_s_remote_fragment.xml | com.scwang.smart.refresh.layout.SmartRefreshLayout androidx.recyclerview.widget.RecyclerView TextView | - | @+id/ss_remote_refresh @+id/ss_remote_recycle @+id/tv_no_file |
| layout_scan_wifi_list_item | layout_scan_wifi_list_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/scan_wifi_list_item_name |
| layout_ss_list_dialog_recycle_operate_item | layout_ss_list_dialog_recycle_operate_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/ss_list_dialog_recycle_operate_item_name |
| layout_ss_list_dialog_recycle_setting_item | layout_ss_list_dialog_recycle_setting_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/ss_list_dialog_recycle_setting_item_name |
| layout_ss_playback_popup_select_button | layout_ss_playback_popup_select_button.xml | Button | @string/ss_select_all ｜ @string/ss_delete ｜ @string/ss_download | @+id/ss_select_mode_button_all_select @+id/ss_select_mode_button_delete @+id/ss_select_mode_button_download |
| layout_ss_setting_item_click | layout_ss_setting_item_click.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/ss_setting_item_name |
| layout_ss_setting_item_select | layout_ss_setting_item_select.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/ss_setting_item_name @+id/ss_setting_item_value |
| layout_ss_setting_item_switch | layout_ss_setting_item_switch.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.appcompat.widget.SwitchCompat | - | @+id/ss_setting_item_name @+id/ss_setting_item_switch |
| layout_stateview | layout_stateview.xml | TextView | 提示信息 | @+id/tv_message |
| layout_tab_segment | layout_tab_segment.xml | TextView | - | @+id/tv_tab_title |
| layout_title_bar | layout_title_bar.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/action_selectAll ｜ @string/cancel ｜ @string/user_center ｜ @string/xtu_plus | @+id/layout_red @+id/album_text @+id/tv_select_all @+id/tv_unselect_all @+id/tv_user_center @+id/tv_xtu_plus |
| layout_title_user_guide | layout_title_user_guide.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | @string/xtu_s2 | @+id/layout_title_user |
| layout_top_popup_recycle_item | layout_top_popup_recycle_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView Button | @string/popup_Window ｜ 连接 | @+id/popup_text @+id/popup_button |
| layout_top_popup_view | layout_top_popup_view.xml | androidx.constraintlayout.widget.ConstraintLayout androidx.recyclerview.widget.RecyclerView | - | @+id/top_popup_list |
| layout_user_center_item | layout_user_center_item.xml | TextView | 淘宝 | @+id/item_title |
| layout_user_guide | layout_user_guide.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.sigmastar.newUi.deviceAdd.Pager.PhotoViewPager TextView Button | @string/open_wifi ｜ @string/open_wifi_step ｜ @string/next_step ｜ @string/previous_step | @+id/pv_pager @+id/page_title @+id/page_content @+id/next_btn @+id/previous_btn |
| layout_video_opera | layout_video_opera.xml | androidx.appcompat.widget.AppCompatSeekBar TextView | - | @+id/video_opera_seek @+id/video_opera_time |
| layout_videos | layout_videos.xml |  | - | - |
| layout_wechat_center | layout_wechat_center.xml | TextView Button | @string/tips ｜ @string/go_wechat ｜ 稍后再去 ｜ 去关注 | @+id/cancel @+id/sure |
| layout_wifi_dialog | layout_wifi_dialog.xml | TextView EditText | @string/ssid ｜ @string/password ｜ @string/rl_wifi_cancel ｜ @string/rl_wifi_confirm | @+id/scan_wifi_dialog_ssid_text @+id/scan_wifi_dialog_ssid_edit @+id/scan_wifi_dialog_pwd_edit @+id/scan_wifi_dialog_negative @+id/scan_wifi_dialog_positive |
| layout_xtu_plus | layout_xtu_plus.xml | com.cy.androidview.roundview.FrameLayoutRound androidx.viewpager2.widget.ViewPager2 com.cy.viewpager2adapterniubility.SimpleIndicatorView com.cy.androidview.shapeview.TextViewShape TextView | @string/start_live ｜ @string/more_func_expect | @+id/vp2_loop_banner @+id/indicator @+id/tv_start_live |
| list_items | list_items.xml | TextView | TextView01 | @+id/ItemTitle |
| live_init_progress_dialog | live_init_progress_dialog.xml | TextView | @string/live_in_loading | - |
| load_dialog | load_dialog.xml | TextView | @string/list_header_loading | @+id/tv_load_dialog |
| load_dialog_big | load_dialog_big.xml | TextView | @string/list_header_loading | @+id/tv_load_dialog |
| local_firmware_item | local_firmware_item.xml | TextView Button | @string/upgrade_firmware | @+id/textFirmwareName @+id/btnUpgradeFirmware |
| m3_alert_dialog | m3_alert_dialog.xml | androidx.appcompat.widget.AlertDialogLayout androidx.core.widget.NestedScrollView android.widget.Space TextView | - | @+id/parentPanel @+id/scrollView @+id/textSpacerNoTitle @android:id/message @+id/textSpacerNoButtons |
| m3_alert_dialog_actions | m3_alert_dialog_actions.xml | androidx.appcompat.widget.ButtonBarLayout Button android.widget.Space | - | @android:id/button3 @+id/spacer @android:id/button2 @android:id/button1 |
| m3_alert_dialog_title | m3_alert_dialog_title.xml | androidx.appcompat.widget.DialogTitle android.widget.Space | - | @+id/alertTitle @+id/titleDividerNoCustom |
| m3_auto_complete_simple_item | m3_auto_complete_simple_item.xml | TextView | - | - |
| m3_side_sheet_dialog | m3_side_sheet_dialog.xml | androidx.coordinatorlayout.widget.CoordinatorLayout | - | @+id/coordinator |
| main | main.xml | TextView | - | @+id/tvCountDownTime @+id/tvPrompt |
| main_frag_land | main_frag_land.xml | TextView | 00:00:00 ｜ 1080P ｜ 2.5G/8.0G ｜ 15S ｜ @string/add_five_second | @+id/tvCaptureInfo @+id/tvRecordTime @+id/tvResolution @+id/tvStorageAvailable @+id/short_video_time_text @+id/short_video_add_time_text |
| main_frag_port | main_frag_port.xml | TextView | 0G/0G ｜ 00:00:00 ｜ 15S ｜ @string/add_five_second | @+id/tvResolution @+id/tvStorageAvailable @+id/tvCaptureInfo @+id/tvRecordTime @+id/short_video_time_text @+id/short_video_add_time_text |
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
| material_timepicker_dialog | material_timepicker_dialog.xml | androidx.constraintlayout.widget.ConstraintLayout TextView androidx.constraintlayout.widget.Barrier com.google.android.material.timepicker.TimePickerView com.google.android.material.button.MaterialButton Button | @string/material_timepicker_select_time ｜ @string/mtrl_timepicker_cancel ｜ @string/mtrl_timepicker_confirm | @+id/header_title @+id/barrier @+id/material_timepicker_view @+id/material_timepicker_mode_button @+id/material_timepicker_cancel_button @+id/material_timepicker_ok_button |
| material_timepicker_textinput_display | material_timepicker_textinput_display.xml |  | - | - |
| mediacontroller | mediacontroller.xml | TextView | - | @+id/mediacontroller_time_current @+id/mediacontroller_time_total @+id/mediacontroller_file_name |
| menu_burst | menu_burst.xml | TextView | @string/burst_rate_1_2 ｜ @string/burst_rate_1_3 ｜ @string/burst_rate_1_5 ｜ @string/burst_rate_1_10 ｜ @string/burst_rate_1_15 ｜ @string/burst_rate_1_20 ｜ @string/burst_rate_1_25 ｜ @string/burst_rate_1_30 | - |
| menu_file | menu_file.xml | TextView | @string/action_delete ｜ @string/action_share ｜ @string/action_download ｜ @string/action_fileInfo | - |
| menu_mode | menu_mode.xml | TextView | @string/mode_video_normal ｜ @string/mode_photo_single ｜ @string/mode_multi_burst ｜ @string/mode_multi_timelapse ｜ @string/mode_photo_timer ｜ @string/mode_video_timelapse ｜ @string/mode_video_loop | - |
| menu_time | menu_time.xml | TextView | @string/time_1 ｜ @string/time_3 ｜ @string/time_5 ｜ @string/time_10 ｜ @string/time_15 ｜ @string/time_30 ｜ @string/time_45 ｜ @string/time_60 | - |
| menu_timelapse | menu_timelapse.xml | TextView | @string/timelapse_0 ｜ @string/timelapse_1 ｜ @string/timelapse_2 ｜ @string/timelapse_3 ｜ @string/timelapse_5 ｜ @string/timelapse_10 ｜ @string/timelapse_15 ｜ @string/timelapse_30 ｜ @string/timelapse_45 ｜ @string/timelapse_60 | - |
| menu_work_mode | menu_work_mode.xml | TextView androidx.recyclerview.widget.RecyclerView | @string/master_mode_video ｜ @string/master_mode_photo ｜ @string/master_mode_multi ｜ @string/mode_video_normal ｜ @string/mode_video_loop ｜ @string/mode_video_timelapse ｜ @string/mode_video_slow ｜ @string/mode_photo_single ｜ @string/mode_multi_timelapse ｜ @string/mode_multi_burst ｜ @string/mode_photo_timer ｜ 快速录像 ｜ @string/mode_multi_continuous | @+id/tvMasterModeVideo @+id/tvMasterModePhoto @+id/tvMasterModeMulti @+id/item_recycler |
| module_base_xtugo_dialog_ask | module_base_xtugo_dialog_ask.xml |  | - | - |
| module_camera_fragment_camera_pic | module_camera_fragment_camera_pic.xml | com.cy.androidview.selectorview.ImageViewSelector TextView com.cy.rvadapterniubility.recyclerview.VerticalGridRecyclerView com.gku.base.view.ShimmerLayoutSimple | - | @+id/ivs @+id/tv_count @+id/VerticalGridRecyclerView @+id/ShimmerLayoutSimple |
| module_camera_fragment_camera_record | module_camera_fragment_camera_record.xml | com.cy.androidview.selectorview.ImageViewSelector TextView com.cy.rvadapterniubility.recyclerview.VerticalGridRecyclerView com.gku.base.view.ShimmerLayoutSimple | - | @+id/ivs @+id/tv_count @+id/VerticalGridRecyclerView @+id/ShimmerLayoutSimple |
| module_camera_item_pic_preview | module_camera_item_pic_preview.xml | com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView com.gku.base.view.ShimmerLayoutSimple | - | @+id/SubsamplingScaleImageView @+id/ShimmerLayoutSimple |
| module_camera_item_tab_camera_file | module_camera_item_tab_camera_file.xml | TextView | - | @+id/tv |
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
| mtrl_search_bar | mtrl_search_bar.xml | TextView | - | @+id/open_search_bar_text_view |
| mtrl_search_view | mtrl_search_view.xml | com.google.android.material.internal.ClippableRoundedCornerLayout com.google.android.material.appbar.MaterialToolbar TextView EditText com.google.android.material.internal.TouchObserverFrameLayout | - | @+id/open_search_view_root @+id/open_search_view_dummy_toolbar @+id/open_search_view_toolbar @+id/open_search_view_search_prefix @+id/open_search_view_edit_text @+id/open_search_view_content_container |
| multi_pb_edit_view | multi_pb_edit_view.xml | TextView | Selected(0) | @+id/info_selected_num |
| my_activity_setting | my_activity_setting.xml | TextView com.cy.androidview.shapeview.LinearLayoutShape | @string/setting ｜ @string/about_app ｜ @string/text_title_user_agreement ｜ @string/privacy_policy ｜ @string/update_version | @+id/layout_about_app @+id/layout_user_agreement @+id/layout_privacy @+id/layout_camera_update |
| my_item_switch | my_item_switch.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | @string/please_stay_tuned | @+id/tv_example @+id/tv_coming_soon |
| my_item_wifi_switch | my_item_wifi_switch.xml | com.cy.androidview.shapeview.LinearLayoutShape TextView | 敬请期待 | @+id/tv_example @+id/tv_coming_soon |
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
| pb_photo_item | pb_photo_item.xml | uk.co.senab.photoview.PhotoView com.gku.dashcam.icatch.ProgressWheel | - | @+id/photo @+id/progress_wheel |
| pickerview_options | pickerview_options.xml | com.contrarywind.view.WheelView | - | @+id/options1 @+id/options2 @+id/options3 |
| pickerview_time | pickerview_time.xml | com.contrarywind.view.WheelView | - | @+id/year @+id/month @+id/day @+id/hour @+id/min @+id/second |
| playback_preview_item | playback_preview_item.xml | androidx.constraintlayout.widget.ConstraintLayout uk.co.senab.photoview.PhotoView | - | @+id/playback_bg |
| popup_select_view | popup_select_view.xml | androidx.constraintlayout.widget.ConstraintLayout com.gku.actioncam.hisilicon.dv.ui.weight.BottomButtomItem | - | @+id/iv_favorite_yutupro @+id/iv_share_la_yutupro @+id/iv_delete_la_yutupro |
| preference | preference.xml | TextView | - | @android:id/title @android:id/summary |
| preference_category | preference_category.xml | TextView | - | @android:id/title @android:id/summary |
| preference_screen | preference_screen.xml | TextView | - | @android:id/title @android:id/summary |
| ps_activity_container | ps_activity_container.xml |  | - | - |
| ps_album_folder_item | ps_album_folder_item.xml | TextView com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_camera_roll_num | @+id/tv_select_tag @+id/tv_folder_name |
| ps_alert_dialog | ps_alert_dialog.xml |  | - | - |
| ps_bottom_nav_bar | ps_bottom_nav_bar.xml | com.luck.picture.lib.widget.MediumBoldTextView CheckBox | @string/ps_preview ｜ @string/ps_editor ｜ @string/ps_default_original_image | @+id/ps_tv_preview @+id/ps_tv_editor @+id/cb_original |
| ps_common_dialog | ps_common_dialog.xml | TextView Button | @string/ps_prompt ｜ @string/ps_prompt_image_content ｜ @string/ps_cancel ｜ @string/ps_confirm | @+id/tvTitle @+id/tv_content @+id/btn_cancel @+id/btn_commit |
| ps_complete_selected_layout | ps_complete_selected_layout.xml | com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_please_select | @+id/ps_tv_select_num @+id/ps_tv_complete |
| ps_custom_preview_image | ps_custom_preview_image.xml | com.luck.picture.lib.photoview.PhotoView | - | @+id/preview_image |
| ps_dialog_camera_selected | ps_dialog_camera_selected.xml | TextView | @string/ps_photograph ｜ @string/ps_record_video ｜ @string/ps_cancel | @+id/ps_tv_photo @+id/ps_tv_video @+id/video_line @+id/bottom_line @+id/ps_tv_cancel |
| ps_empty | ps_empty.xml |  | - | - |
| ps_fragment_preview | ps_fragment_preview.xml | androidx.constraintlayout.widget.ConstraintLayout com.luck.picture.lib.magical.MagicalView com.luck.picture.lib.widget.PreviewTitleBar com.luck.picture.lib.widget.PreviewBottomNavBar com.luck.picture.lib.widget.MediumBoldTextView com.luck.picture.lib.widget.CompleteSelectView | - | @+id/magical @+id/title_bar @+id/bottom_nar_bar @+id/ps_tv_selected @+id/ps_tv_selected_word @+id/ps_complete_select |
| ps_fragment_selector | ps_fragment_selector.xml | androidx.constraintlayout.widget.ConstraintLayout com.luck.picture.lib.widget.RecyclerPreloadView com.luck.picture.lib.widget.MediumBoldTextView com.luck.picture.lib.widget.TitleBar com.luck.picture.lib.widget.BottomNavBar com.luck.picture.lib.widget.CompleteSelectView | @string/ps_empty | @+id/recycler @+id/tv_current_data_time @+id/title_bar @+id/bottom_nar_bar @+id/ps_complete_select @+id/tv_data_empty |
| ps_item_grid_audio | ps_item_grid_audio.xml | com.luck.picture.lib.widget.SquareRelativeLayout com.luck.picture.lib.widget.MediumBoldTextView | 00:00 | @+id/tvCheck @+id/tv_duration |
| ps_item_grid_camera | ps_item_grid_camera.xml | com.luck.picture.lib.widget.SquareRelativeLayout com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_take_picture | @+id/tvCamera |
| ps_item_grid_image | ps_item_grid_image.xml | com.luck.picture.lib.widget.SquareRelativeLayout com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_gif_tag | @+id/tvCheck @+id/tv_media_tag |
| ps_item_grid_video | ps_item_grid_video.xml | com.luck.picture.lib.widget.SquareRelativeLayout com.luck.picture.lib.widget.MediumBoldTextView | 00:00 | @+id/tvCheck @+id/tv_duration |
| ps_preview_audio | ps_preview_audio.xml | com.luck.picture.lib.photoview.PhotoView TextView | 00:00 | @+id/preview_image @+id/tv_audio_name @+id/tv_current_time @+id/tv_total_duration |
| ps_preview_gallery_item | ps_preview_gallery_item.xml | com.luck.picture.lib.widget.SquareRelativeLayout | - | - |
| ps_preview_image | ps_preview_image.xml | com.luck.picture.lib.photoview.PhotoView | - | @+id/preview_image |
| ps_preview_video | ps_preview_video.xml | com.luck.picture.lib.photoview.PhotoView | - | @+id/preview_image |
| ps_remind_dialog | ps_remind_dialog.xml | com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_know | @+id/tv_content @+id/btnOk |
| ps_title_bar | ps_title_bar.xml | com.luck.picture.lib.widget.MarqueeTextView com.luck.picture.lib.widget.MediumBoldTextView | @string/ps_cancel | @+id/ps_tv_title @+id/ps_tv_cancel |
| ps_window_folder | ps_window_folder.xml | com.luck.picture.lib.widget.RoundCornerRelativeLayout androidx.recyclerview.widget.RecyclerView | - | @+id/round_group @+id/folder_list |
| pull_to_refresh | pull_to_refresh.xml | TextView | @string/list_header_fresh_down | @+id/tvHeadViewMsg |
| sample_video_land | sample_video_land.xml | TextView com.gku.codeest.enviews.ENDownloadView | 00:00 | @+id/current @+id/total @+id/loading @+id/title |
| sample_video_normal | sample_video_normal.xml | TextView com.gku.codeest.enviews.ENDownloadView com.gku.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/loading @+id/start @+id/title |
| scan_add_item | scan_add_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView com.cy.androidview.roundview.LinearLayoutRound androidx.appcompat.widget.LinearLayoutCompat | @string/xtu_max2 ｜ XTU_as65d ｜ 12345678 | @+id/item_paired_status @+id/item_card @+id/item_device_name @+id/item_device_ssid @+id/item_device_pwd |
| scankit_dialog_custom | scankit_dialog_custom.xml | TextView | 取消 ｜ 确定 | @+id/dialog_title @+id/dialog_message @+id/dialog_negative @+id/dialog_positive |
| scankit_dialog_layout | scankit_dialog_layout.xml | TextView Button | @string/scankit_no_code_tip ｜ @string/scankit_confirm | @+id/dialog_tilte @+id/dialog_sure_btn |
| scankit_layout | scankit_layout.xml |  | - | - |
| scankit_title_landscape | scankit_title_landscape.xml | TextView | @string/scankit_title_all ｜ @string/scankit_title_all_level_two | @+id/scankit_title_scan_land @+id/scankit_title_scan_land_level_two |
| scankit_zxl_capture | scankit_zxl_capture.xml | com.huawei.hms.scankit.ViewfinderView TextView | @string/scankit_title ｜ @string/scankit_light ｜ @string/scankit_scan_tip | @+id/viewfinderView @+id/title_scan @+id/flash_light_text |
| scankit_zxl_capture_customed | scankit_zxl_capture_customed.xml |  | - | - |
| scankit_zxl_capture_new | scankit_zxl_capture_new.xml | com.huawei.hms.scankit.ViewfinderView TextView | @string/scankit_light ｜ @string/scankit_title_all ｜ @string/scankit_title_all_level_two | @+id/viewfinderView @+id/flash_light_text @+id/title_scan @+id/title_scan_level_two |
| select_dialog_item_material | select_dialog_item_material.xml | TextView | - | @android:id/text1 |
| select_dialog_multichoice_material | select_dialog_multichoice_material.xml | CheckedTextView | - | @android:id/text1 |
| select_dialog_singlechoice_material | select_dialog_singlechoice_material.xml | CheckedTextView | - | @android:id/text1 |
| server_file_item | server_file_item.xml | TextView Button | @string/action_download | @+id/textFileName @+id/btnDownloadFile |
| setting_actionbar | setting_actionbar.xml | TextView | @string/settings | @+id/tv |
| setting_enable_wifi_hotspot | setting_enable_wifi_hotspot.xml | TextView EditText | SSID ｜ Password | @+id/wifi_ssid @+id/wifi_password |
| setting_menu | setting_menu.xml |  | - | - |
| setting_menu_item | setting_menu_item.xml | TextView | Title ｜ value | @+id/item_text @+id/item_value |
| setting_switch_layout | setting_switch_layout.xml | TextView androidx.appcompat.widget.SwitchCompat | name | @+id/item_name @+id/switchCompat |
| single_download_content_dialog | single_download_content_dialog.xml | TextView com.gku.dashcam.icatch.utils.NumberProgressBar | filename ｜ Status | @+id/fileName @+id/downloadStatus @+id/numberbar |
| splash_screen_view | splash_screen_view.xml |  | - | - |
| srl_classics_footer | srl_classics_footer.xml | TextView | @string/srl_footer_pulling | @+id/srl_classics_title |
| srl_classics_header | srl_classics_header.xml | TextView | @string/srl_header_pulling ｜ @string/srl_header_update | @+id/srl_classics_title @+id/srl_classics_update |
| support_simple_spinner_dropdown_item | support_simple_spinner_dropdown_item.xml | TextView | - | @android:id/text1 |
| ucrop_activity_photobox | ucrop_activity_photobox.xml | androidx.appcompat.widget.Toolbar TextView com.yalantis.ucrop.view.UCropView | @string/ucrop_label_edit_photo | @+id/toolbar @+id/toolbar_title @+id/ucrop |
| ucrop_aspect_ratio | ucrop_aspect_ratio.xml | com.yalantis.ucrop.view.widget.AspectRatioTextView | - | - |
| ucrop_controls | ucrop_controls.xml | TextView | @string/ucrop_crop ｜ @string/ucrop_rotate ｜ @string/ucrop_scale | @+id/text_view_crop @+id/text_view_rotate @+id/text_view_scale |
| ucrop_fragment_photobox | ucrop_fragment_photobox.xml | com.yalantis.ucrop.view.UCropView | - | @+id/ucrop |
| ucrop_layout_rotate_wheel | ucrop_layout_rotate_wheel.xml | TextView com.yalantis.ucrop.view.widget.HorizontalProgressWheelView | - | @+id/text_view_rotate @+id/rotate_scroll_wheel |
| ucrop_layout_scale_wheel | ucrop_layout_scale_wheel.xml | TextView com.yalantis.ucrop.view.widget.HorizontalProgressWheelView | 100% | @+id/text_view_scale @+id/scale_scroll_wheel |
| ucrop_view | ucrop_view.xml | com.yalantis.ucrop.view.GestureCropImageView com.yalantis.ucrop.view.OverlayView | - | @+id/image_view_crop @+id/view_overlay |
| update_dialog_layout | update_dialog_layout.xml | TextView CheckBox Button | @string/update_dialog_remind ｜ @string/has_new_version ｜ @string/no_more_reminder ｜ @string/cancel ｜ @string/dialog_ok | @+id/dialog_title @+id/dialog_message @+id/dialog_check @+id/cancel @+id/ok |
| update_firm_send | update_firm_send.xml | TextView Button | @string/firm_sending ｜ @string/finish | @+id/sending_text @+id/update_finish |
| update_version_ready_activity | update_version_ready_activity.xml | TextView Button | @string/config_send_firm ｜ @string/send_firm ｜ @string/send_cancel | @+id/update_firm_version_text @+id/send_firm @+id/send_firm_cancel |
| user_guide_item | user_guide_item.xml | androidx.constraintlayout.widget.ConstraintLayout uk.co.senab.photoview.PhotoView | - | @+id/pv_bg |
| video_brightness | video_brightness.xml | TextView | 50% | @+id/app_video_brightness |
| video_layout_ad | video_layout_ad.xml | TextView | @string/jump_ad ｜ 00 | @+id/jump_ad @+id/ad_time |
| video_layout_custom | video_layout_custom.xml | TextView com.gku.codeest.enviews.ENDownloadView com.gku.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/loading @+id/start @+id/title |
| video_layout_normal | video_layout_normal.xml | TextView | 00:00 | @+id/current @+id/total @+id/title |
| video_layout_sample_ad | video_layout_sample_ad.xml | TextView com.gku.codeest.enviews.ENDownloadView | 00:00 ｜ @string/jump_ad ｜ 00 | @+id/title @+id/loading @+id/current @+id/total @+id/jump_ad @+id/ad_time |
| video_layout_standard | video_layout_standard.xml | TextView com.gku.codeest.enviews.ENDownloadView com.gku.codeest.enviews.ENPlayView | 00:00 | @+id/current @+id/total @+id/title @+id/loading @+id/start |
| video_progress_dialog | video_progress_dialog.xml | TextView | - | @+id/tv_current @+id/tv_duration |
| video_thumb_item_layout | video_thumb_item_layout.xml |  | - | - |
| video_volume_dialog | video_volume_dialog.xml |  | - | - |
| view_album_page_item_preview | view_album_page_item_preview.xml | uk.co.senab.photoview.PhotoView | - | @+id/viewCoverView |
| view_album_page_item_preview_wrapper | view_album_page_item_preview_wrapper.xml | uk.co.senab.photoview.PhotoView | - | @+id/viewCoverView |
| view_album_preview_item | view_album_preview_item.xml | uk.co.senab.photoview.PhotoView | - | @+id/iv_bg |
| view_camera_media_item | view_camera_media_item.xml | CheckBox TextView | - | @+id/viewCheckbox @+id/viewSize @+id/viewDuration |
| view_icon_text | view_icon_text.xml | com.cy.androidview.roundview.LinearLayoutRound TextView | @string/scan_add_device | @+id/tvText |
| view_ijk_lib_player | view_ijk_lib_player.xml | TextView | 00:00 | @+id/positionTextView @+id/durationTextView |
| view_image | view_image.xml | TextView | - | @+id/tv_time |
| view_image_1 | view_image_1.xml | TextView | - | @+id/header |
| view_item_header | view_item_header.xml | TextView | - | @+id/header |
| view_local_album_item | view_local_album_item.xml | CheckBox | - | @+id/viewCheckbox |
| view_newitem_header | view_newitem_header.xml | TextView | - | @+id/header_new @+id/batch_select |
| view_normal_preference_view | view_normal_preference_view.xml | TextView m.mifan.ui.widget.SwitchImageView | - | @+id/viewTextTitle @+id/viewTextSummary @+id/viewTextSummary2 @+id/viewIconSwitch |
| view_preference_lis_item | view_preference_lis_item.xml | androidx.constraintlayout.widget.ConstraintLayout TextView m.mifan.ui.widget.SwitchImageView | - | @+id/viewTextTitle @+id/viewIconCheckbox |
| view_simple_toolbar | view_simple_toolbar.xml | m.mifan.ui.widget.PressImageView TextView | - | @+id/viewActionReturn @+id/viewAction1 @+id/viewTextTitle |
| welcome | welcome.xml | TextView | - | @+id/tv_version |
| wifi_device_list | wifi_device_list.xml | TextView com.gku.actioncam.hisilicon.dv.wifi.HiWifiScrollView | @string/switch_home_wlan | @+id/wifi_scroll_view |
| wifi_passwd_link | wifi_passwd_link.xml | TextView EditText Button | @string/wifi_passwd ｜ @string/input_passwd_tip ｜ @string/cancel ｜ @string/link | @+id/tvDialogTitle @+id/etPasswd @+id/ibUndo @+id/ibConnect |
| wifi_verify_device | wifi_verify_device.xml | TextView Button | Dialog Title ｜ @string/verify_msg ｜ @string/cancel ｜ @string/verify_wifi | @+id/tvDialogTitle @+id/ibUndo @+id/ibverify |
| zoom_rate_view | zoom_rate_view.xml | androidx.constraintlayout.widget.ConstraintLayout TextView | - | @+id/numRate |
| zoombar_view | zoombar_view.xml | TextView | x 1.5 | @+id/zoom_rate |
| zxl_camera_scan | zxl_camera_scan.xml | androidx.camera.view.PreviewView com.king.view.viewfinderview.ViewfinderView | - | @+id/previewView @+id/viewfinderView |

## menu（14 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| menu_album_page_item_local | menu_album_page_item_local.xml | item | - | @+id/menuShare @+id/menuDelete |
| menu_album_page_item_preview | menu_album_page_item_preview.xml | item | - | @+id/menuDelete @+id/menuDownload |
| menu_album_share | menu_album_share.xml | item | - | @+id/menu_share |
| menu_camera_album | menu_camera_album.xml | item | - | @+id/menuSelectViewOn |
| menu_camera_album_action_bar | menu_camera_album_action_bar.xml | item | - | @+id/menuSelectAll @+id/menuDownload @+id/menuDelete |
| menu_local_album_action_bar | menu_local_album_action_bar.xml | item | - | @+id/menuShare @+id/menuDelete |
| menu_main_nav | menu_main_nav.xml | item | - | @+id/connectionFragment @+id/localAlbumFragment @+id/aboutFragment |
| menu_multi_pb | menu_multi_pb.xml | item | @string/menu_list ｜ @string/menu_grid ｜ @string/menu_lists ｜ @string/menu_quick_lists | @+id/menu_multi_pb_filter @+id/grid @+id/liner @+id/quick_liner |
| menu_preview | menu_preview.xml | item | @string/setting | @+id/action_setting |
| menu_save | menu_save.xml | item | - | @+id/menu_save |
| menu_scan_wifi_refresh | menu_scan_wifi_refresh.xml | item | refresh | @+id/scan_wifi_refresh |
| menu_ss_device_setting | menu_ss_device_setting.xml | item | @string/ss_device_setting | @+id/menu_ss_device_setting |
| menu_ss_playback | menu_ss_playback.xml | item | @string/ss_delete ｜ @string/ss_download ｜ @string/cancel ｜ @string/ss_file_info ｜ 后台下载 | @+id/menu_ss_playback_delete @+id/menu_ss_playback_download @+id/menu_ss_playback_select_out @+id/menu_ss_playback_info @+id/menu_ss_playback_download_task |
| ucrop_menu_activity | ucrop_menu_activity.xml | item | @string/ucrop_menu_crop | @+id/menu_crop @+id/menu_loader |

## xml（7 个）

| 名称 | 限定符 | 根元素/控件 | 文案 | id/key |
|---|---|---|---|---|
| file_paths | file_paths.xml |  | - | - |
| network_config_base | network_config_base.xml |  | - | - |
| network_security_config | network_security_config.xml |  | - | - |
| paths_base | paths_base.xml |  | - | - |
| preferences | preferences.xml | com.gku.actioncam.hisilicon.dv.setting.HiListPreference | @string/video_resolution ｜ @string/loop_type ｜ @string/interval ｜ @string/photo_resolution ｜ @string/time ｜ @string/rate ｜ test ｜ @string/video_mode ｜ @string/boot_action ｜ @string/screen_auto_sleep | key_mode_video_normal_resolution key_mode_video_loop_resolution key_mode_video_loop_type key_mode_video_timelapse_resolution key_mode_video_timelapse_interval key_mode_video_slow_resolution key_mode_photo_single_resolution key_mode_photo_timer_resolution key_mode_photo_timer_time key_mode_multi_burst_resolution key_mode_multi_burst_rate key_mode_multi_timelapse_resolution key_mode_multi_timelapse_interval video_resolution @array/video_resolution_values_ntsc video_mode @array/video_mode_values boot_action @array/boot_action_values screen_auto_sleep @array/screen_auto_sleep_values |
| ps_file_paths | ps_file_paths.xml |  | - | - |
| settingpreferences | settingpreferences.xml |  | - | - |
