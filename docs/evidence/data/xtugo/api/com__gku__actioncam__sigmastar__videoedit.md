# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.videoedit

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 21 个文件 / 35 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity`
L39 · [class] public AudioCollectActivity · extends `CameraBaseActivity` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java`

字段/常量（9）：
- `String TAG = "AudioCollectActivity"`  L40
- `ImageView iv_close`  L41
- `LinearLayoutManager linearLayoutManager`  L42
- `AudioCollectAdapter mAdapter`  L43
- `RecyclerView rv_list`  L44
- `TextView tv_collect`  L45
- `TextView tv_local`  L46
- `AudioCollectAdapter audioCollectAdapter = this.mAdapter`  L332
- `AudioCollectAdapter audioCollectAdapter = this.mAdapter`  L341

方法（14）：
- `void onProgressCancelListener(DialogInterface dialog)`  L49 @Override
- `void initView()`  L53 @Override
- `void onClick(View view)`  L60 @Override
- `void onClick(View view)`  L66 @Override
- `void onClick(View view)`  L72 @Override
- `void addData()`  L85 @Override
- `int setContentRes()`  L90 @Override
- `void loadAudioData()`  L94
    - 体内字面量："collect_audio/"
- `void loadLocalVideoAudio()`  L113
- `void loadLocalAudio()`  L188
- `void onResult(ArrayList<LocalMedia> result)`  L205 @Override
    - 体内字面量："result=" · "result=" · "collect_audio/" · "flac" · "æä¸æ¯æflac" · "collect_audio/" · "/" · "/"
- `void onCancel()`  L243 @Override
    - 体内字面量："onCancel: "
- `void onPause()`  L330 @Override
- `void onDestroy()`  L339 @Override
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity$AnonymousClass4`
L132 · [class] AnonymousClass4 · implements `OnResultCallbackListener<LocalMedia>` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java`

方法（4）：
- `void onCancel()`  L134 @Override
- `void onResult(ArrayList<LocalMedia> result)`  L141 @Override
    - 体内字面量："result=" · "result=" · "collect_audio/" · "collect_audio/" · "ffmpeg -y -i " · " -vn " · "/"
- `void run()`  L168 @Override
    - 体内字面量："/" · "/"
- `void run()`  L177 @Override
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity$MeSandboxFileEngine`
L249 · [class] private MeSandboxFileEngine · implements `UriToFileTransformEngine` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java`

方法（3）：
- `private MeSandboxFileEngine()`  L250
- `File getLocalDataPath(Context context)`  L253
    - 体内字面量："mounted"
- `void onUriToFileAsyncTransform(Context context, String srcPath, String mineType, OnKeyValueResultCallbackListener call)`  L265 @Override
    - 体内字面量："/" · "é³é¢æä»¶ä¸è½æç©ºæ ¼ï¼è¯·å¨æä»¶å¤¹ä¸­éå½åæä»¶ä¹ååè¿è¡éè¯ï¼" · "collect_audio/" · "ffmpeg -y -i " · " -vn " · "/"
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity$MeSandboxFileEngine2`
L285 · [class] MeSandboxFileEngine2 · implements `UriToFileTransformEngine` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java`

方法（5）：
- `private MeSandboxFileEngine2()`  L286
- `File getLocalDataPath(Context context)`  L289
    - 体内字面量："mounted"
- `void onUriToFileAsyncTransform(final Context context, String srcPath, String mineType, OnKeyValueResultCallbackListener call)`  L301 @Override
    - 体内字面量："/"
- `void run()`  L308 @Override
    - 体内字面量："collect_audio/"
- `void lambda$onUriToFileAsyncTransform$0(Context context)`  L323
    - 体内字面量："é³é¢æä»¶ä¸è½æç©ºæ ¼ï¼è¯·å¨æä»¶å¤¹ä¸­éå½åæä»¶ä¹ååè¿è¡éè¯ï¼"
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectAdapter`
L31 · [class] public AudioCollectAdapter · extends `RecyclerView.Adapter` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectAdapter.java`

字段/常量（19）：
- `String TAG = "AudioCollectAdapter"`  L32
- `Activity activity`  L33
- `ValueAnimator animator`  L34
- `float averagePxMs`  L35
- `long leftProgress`  L36
- `long rightProgress`  L37
- `List<VideoEditInfo> videoEditInfos`  L38
- `TimerTask task = null`  L41
- `List<VideoEditInfo> list = this.videoEditInfos`  L68
- `RangeSeekBar rangeSeekBar`  L90
- `AudioCollectAdapter audioCollectAdapter = AudioCollectAdapter.this`  L157
- `AudioCollectAdapter audioCollectAdapter2 = AudioCollectAdapter.this`  L160
- `String str`  L182
- `String str2`  L183
- `long j = time / 3600000`  L184
- `ValueAnimator valueAnimator = this.animator`  L210
- `TimerTask timerTask = this.task`  L279
- `List<VideoEditInfo> list = this.videoEditInfos`  L289
- `List<VideoEditInfo> list = this.videoEditInfos`  L306

方法（24）：
- `public AudioCollectAdapter(Activity activity)`  L44
- `void addData(VideoEditInfo videoEditInfo)`  L48
- `void addAllData(List<VideoEditInfo> videos)`  L57
- `void onPause()`  L65
- `void onDestory()`  L78
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L84 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)`  L89 @Override
- `void onRangeSeekBarValuesChanged(RangeSeekBar bar, long minValue, long maxValue, int action, boolean isMin, RangeSeekBar.Thumb pressedThumb)`  L126 @Override
    - 体内字面量：".00s - " · ".00s"
- `void onClick(View view)`  L146 @Override
- `void onClick(View view)`  L152 @Override
    - 体内字面量："ffmpeg -y -i " · " -vn -acodec copy -ss "
- `String createCutFilePath(Context context)`  L173
    - 体内字面量："audiocut/"
- `String getGapTime(long time)`  L181
- `void executeCommand(String strText, String path, String name, long time)`  L204
- `void anim(final ImageView positionIcon)`  L208
- `void onAnimationUpdate(ValueAnimator animation)`  L223 @Override
- `void startVideo(final ImageView positionIcon)`  L232
- `void onCompletion(MediaPlayer mediaPlayer)`  L236 @Override
- `void run()`  L245 @Override
- `void run()`  L248 @Override
- `void videoProgressUpdate(final ImageView positionIcon)`  L259
- `void run()`  L264 @Override
- `void pauseVideo(ImageView positionIcon)`  L274
- `void selectData(int position)`  L287
- `int getItemCount()`  L305 @Override
### `com.gku.actioncam.sigmastar.videoedit.AudioCollectAdapter$MyViewHolder`
L313 · [class] MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/videoedit/AudioCollectAdapter.java`

字段/常量（8）：
- `FrameLayout fl_audio`  L314
- `LinearLayout ll_audio`  L315
- `ImageView positionIcon`  L316
- `RelativeLayout rl_audio`  L317
- `TextView tv_collect_time`  L318
- `TextView tv_name`  L319
- `TextView tv_time`  L320
- `TextView tv_use`  L321

方法（1）：
- `public MyViewHolder(View itemView)`  L323
### `com.gku.actioncam.sigmastar.videoedit.AudioDbBean`
L7 · [class] public AudioDbBean · extends `LitePalSupport` · `com/gku/actioncam/sigmastar/videoedit/AudioDbBean.java`

字段/常量（4）：
- `boolean isSelect`  L10 @Column(ignore = true)
- `String name`  L11
- `String path`  L14 @Column(defaultValue = "<binary/metadata>", unique = true)
- `long time`  L15

方法（8）：
- `String getPath()`  L17
- `void setPath(String path)`  L21
- `String getName()`  L25
- `void setName(String name)`  L29
- `long getTime()`  L33
- `void setTime(long time)`  L37
- `boolean isSelect()`  L41
- `void setSelect(boolean select)`  L45
### `com.gku.actioncam.sigmastar.videoedit.AudioListAdapter`
L21 · [class] public AudioListAdapter · extends `RecyclerView.Adapter` · `com/gku/actioncam/sigmastar/videoedit/AudioListAdapter.java`

字段/常量（6）：
- `List<AudioDbBean> datas`  L22
- `OnItemClickLis onItemClickLis`  L23
- `int selectPosition = -1`  L24
- `int i = this.selectPosition`  L54
- `List<AudioDbBean> list = this.datas`  L113
- `List<AudioDbBean> list = this.datas`  L135

方法（10）：
- `public AudioListAdapter(OnItemClickLis onItemClickLis)`  L32
- `void addData(AudioDbBean path)`  L36
- `void addAllData(List<AudioDbBean> path)`  L44
- `AudioDbBean getCurSelectAudio()`  L53
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L62 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)`  L67 @Override
- `void onClick(View view)`  L90 @Override
- `void resetRv()`  L97
- `void selectData(int position)`  L111
- `int getItemCount()`  L134 @Override
### `com.gku.actioncam.sigmastar.videoedit.AudioListAdapter$AudioViewHolder`
L142 · [class] private static AudioViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/videoedit/AudioListAdapter.java`

字段/常量（2）：
- `ImageView iv_audio`  L143
- `TextView tv_audio_name`  L144

方法（1）：
- `public AudioViewHolder(View itemView)`  L146
### `com.gku.actioncam.sigmastar.videoedit.AudioListAdapter$OnItemClickLis`
L28 · [interface] public OnItemClickLis · `com/gku/actioncam/sigmastar/videoedit/AudioListAdapter.java`

方法（1）：
- `void itemClick(int position, AudioDbBean audioDbBean)`  L29
### `com.gku.actioncam.sigmastar.videoedit.CameraVideoActivity`
L32 · [class] public CameraVideoActivity · extends `CameraBaseActivity implements MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · implements `MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · `com/gku/actioncam/sigmastar/videoedit/CameraVideoActivity.java`

字段/常量（9）：
- `String TAG = "CameraVideoActivity"`  L33
- `AlbumSubAdapter mAdapter`  L34
- `RecyclerView mRecyclerView`  L36
- `TextView tv_cancal`  L37
- `TextView tv_no_file`  L38
- `CameraVideoActivity cameraVideoActivity = CameraVideoActivity.this`  L84
- `String str`  L212
- `String str2`  L213
- `long j = time / 3600000`  L214

方法（18）：
- `void addData()`  L41 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L45 @Override
- `void refreshAlbum()`  L48
    - 体内字面量："456464132" · "onMessageEvent:  ------å¼å§å·æ°æ°æ®ï¼éæ°å»è·å"
- `void run()`  L52 @Override
    - 体内字面量："456464132" · "run:  --------------   "
- `void onCommonClick(int position)`  L62 @Override
    - 体内字面量："/" · "image/"
- `void run()`  L83 @Override
- `void run()`  L88 @Override
    - 体内字面量："videopath" · "videoname" · "videopath" · "videoname"
- `void onScanResultCallback(List<AlbumItemModel> data)`  L109 @Override
    - 体内字面量："456464132" · "onScanResultCallback:  --------------------       è¿éçæ°æ®é¿åº¦æ¯  "
- `int compare(Object obj, Object obj2)`  L116 @Override
- `int lambda$onScanResultCallback$0(AlbumItemModel albumItemModel, AlbumItemModel albumItemModel2)`  L127
- `void initView()`  L132 @Override
- `void onClick(View view)`  L139 @Override
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L145 @Override
- `int setContentRes()`  L161 @Override
- `File getLocalDataPath(Context context)`  L165
    - 体内字面量："mounted"
- `void loadFfmpegImage(Context context, String videoPath, String videoName)`  L176
    - 体内字面量："image/"
- `void loadimage(String videoPath, String videoName, int oneTime, int width, int hight, int index)`  L194
    - 体内字面量："loadimage" · "loadimage   index=" · "loadimage" · "loadimage   oneTime=" · "loadimage" · "loadimage   curtime=" · "/image/" · "/img"
- `String getGapTime(long time)`  L211
### `com.gku.actioncam.sigmastar.videoedit.CloudMusicLoadingView`
L14 · [class] public CloudMusicLoadingView · extends `View implements Runnable` · implements `Runnable` · `com/gku/actioncam/sigmastar/videoedit/CloudMusicLoadingView.java`

字段/常量（14）：
- `int DEFAULT_MIN_WIDTH = 65`  L15
- `int DEFAULT_RAIL_COUNT = 4`  L16
- `FloatEvaluator mFloatEvaluator`  L18
- `Paint mPaint`  L19
- `int mRailColor`  L20
- `int mRailCount`  L21
- `float mRailLineWidth`  L22
- `int mViewHeight`  L23
- `int mViewWidth`  L24
- `Canvas canvas2`  L68
- `int i = this.mViewWidth`  L71
- `float f2 = f - this.mRailLineWidth`  L73
- `float f3 = paddingBottom / 2.0f`  L74
- `int i2 = 1`  L77

方法（16）：
- `public CloudMusicLoadingView(Context context)`  L26
- `public CloudMusicLoadingView(Context context, AttributeSet attrs)`  L30
- `public CloudMusicLoadingView(Context context, AttributeSet attrs, int defStyleAttr)`  L34
- `void init(Context context, AttributeSet attrs, int defStyleAttr)`  L39
- `void initAttr(Context context, AttributeSet attrs, int defStyleAttr)`  L51
- `void onSizeChanged(int w, int h, int oldw, int oldh)`  L60 @Override
- `void onDraw(Canvas canvas)`  L67 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L95 @Override
- `int handleMeasure(int measureSpec)`  L100
- `void onAttachedToWindow()`  L113 @Override
- `void onDetachedFromWindow()`  L118 @Override
- `void run()`  L124 @Override
- `void start()`  L129
- `void stop()`  L133
- `int dip2px(Context context, float dipValue)`  L137
- `float nextRandomFloat(float sl)`  L141
### `com.gku.actioncam.sigmastar.videoedit.CutActivity`
L46 · [class] public CutActivity · extends `CameraBaseActivity implements AudioListAdapter.OnItemClickLis` · implements `AudioListAdapter.OnItemClickLis` · `com/gku/actioncam/sigmastar/videoedit/CutActivity.java`

字段/常量（59）：
- `AudioListAdapter AudioListAdapter`  L47
- `ValueAnimator animator`  L48
- `float averagePxMs`  L49
- `Button btn_cancal`  L50
- `Button btn_cut`  L51
- `int gpsFrameRate`  L52
- `String gpsVideoPath`  L53
- `boolean hasGsp`  L54
- `String has_audios`  L55
- `LinearLayout id_seekBarLayout`  L56
- `boolean isCloseVideoAudio`  L57
- `long leftProgress`  L58
- `ConstraintLayout ll_audio`  L59
- `LinearLayout ll_speed`  L60
- `LinearLayout ll_video`  L61
- `MediaPlayer mMediaPlayer`  L62
- `ImageView positionIcon`  L63
- `RangeSeekBar rangeSeekBar`  L64
- `long rightProgress`  L65
- `RecyclerView rv_audio`  L66
- `TrimVideoAdapter trimVideoAdapter`  L67
- `TextView tv_audio_cut`  L68
- `TextView tv_end_time`  L69
- `TextView tv_more_audio`  L70
- `TextView tv_music`  L71
- `TextView tv_speed`  L72
- `TextView tv_start_time`  L73
- `TextView tv_video_audio_open`  L74
- `TextView tv_video_cut`  L75
- `int videoHeight`  L76
- `String videoName`  L77
- `String videoPath`  L78
- `long videoTime`  L79
- `int videoWidth`  L80
- `RecyclerView video_thumb_listview`  L81
- `MyVideoView videoview`  L82
- `String TAG = "CutActivity"`  L83
- `TimerTask task = null`  L85
- `int i2 = this.videoWidth`  L101
- `int i`  L108
- `float f = this.videoWidth / this.videoHeight`  L113
- `String str = CutActivity.this.TAG`  L230
- `CutActivity cutActivity = CutActivity.this`  L231
- `String str2 = CutActivity.this.TAG`  L233
- `CutActivity cutActivity2 = CutActivity.this`  L234
- `CutActivity cutActivity = CutActivity.this`  L291
- `String str`  L350
- `String str2`  L351
- `long j = time / 3600000`  L352
- `ValueAnimator valueAnimator = this.animator`  L373
- `TimerTask timerTask = this.task`  L418
- `String str2 = "ffmpeg -y -ss " + gapTime + " -i " + videoPath + " -s " + width + Marker.ANY_MARKER + hight + " -f image2 -q:v 2 -preset superfast -vframes 1 " + str`  L472
- `String str`  L496
- `String str2 = this.isCloseVideoAudio ? "-an " : "<binary/metadata>"`  L497
- `String str4 = this.gpsVideoPath`  L499
- `String str = "ffmpeg -i " + this.videoPath + " -framerate " + this.gpsFrameRate + " -i " + saveGpsImagePath + "/img%3d.png -filter_complex [0][1]overlay=60:main_h-overlay_h-30 -y -q:v 1 -max_muxing_queue_size 1080 -vcodec libx264 -acodec copy -crf 35 -preset ultrafast -r 15 -qp 20 -threads 10 " + this.gpsVideoPath`  L538
- `AudioListAdapter audioListAdapter = this.AudioListAdapter`  L609
- `TimerTask timerTask = this.task`  L628
- `Timer timer = this.timer`  L633

方法（45）：
- `void onProgressCancelListener(DialogInterface dialog)`  L89 @Override
- `void getMediaInfo()`  L92
- `void adjustSurfaceSize()`  L107
- `String createCutFilePath()`  L129
    - 体内字面量："cut/"
- `void initViewId()`  L138
- `boolean canScrollHorizontally()`  L168 @Override
    - 体内字面量："%.0f" · ".00s"
- `void onRangeSeekBarValuesChanged(RangeSeekBar bar, long minValue, long maxValue, int action, boolean isMin, RangeSeekBar.Thumb pressedThumb)`  L182 @Override
    - 体内字面量："-----minValue----->>>>>>" · "-----maxValue----->>>>>>" · ".00s" · ".00s" · "-----leftProgress----->>>>>>" · "-----rightProgress----->>>>>>" · "-----ACTION_DOWN---->>>>>>" · "-----ACTION_MOVE---->>>>>>" · "-----ACTION_UP--leftProgress--->>>>>>"
- `void onPrepared(MediaPlayer mediaPlayer)`  L210 @Override
    - 体内字面量："videoview" · "è§é¢åå¤æ­æ¾"
- `void onCompletion(MediaPlayer mediaPlayer)`  L222 @Override
- `void onClick(View view)`  L229 @Override
- `void run()`  L239 @Override
- `void onClick(View view)`  L247 @Override
- `void onClick(View view)`  L253 @Override
    - 体内字面量："#d5d5d5" · "#5b5b5b"
- `void onClick(View view)`  L268 @Override
    - 体内字面量："#5b5b5b" · "#d5d5d5"
- `void onClick(View view)`  L283 @Override
- `void onClick(View view)`  L290 @Override
- `void loadAudioData()`  L345
- `String getGapTime(long time)`  L349
- `void anim()`  L371
- `void onAnimationUpdate(ValueAnimator animation)`  L386 @Override
- `void startVideo()`  L395
- `void run()`  L401 @Override
- `void run()`  L404 @Override
- `void pauseVideo()`  L415
- `void videoProgressUpdate()`  L426
    - 体内字面量："----onProgressUpdate-cp---->>>>>>>"
- `void run()`  L432 @Override
- `void loadData()`  L440
    - 体内字面量："/image/" · "/" · "file://"
- `void loadimage(final String videoPath, final String videoName, final int oneTime, final int width, final int hight, final int index)`  L461
- `void run()`  L467 @Override
    - 体内字面量："loadimage" · "loadimage   index=" · "loadimage" · "loadimage   oneTime=" · "/image/" · "/img"
- `void run()`  L477 @Override
- `void editVideo()`  L487
- `void cutVideo()`  L495
- `void run()`  L516 @Override
    - 体内字面量："videoPath"
- `void mixVoice(String inputPath)`  L525
    - 体内字面量："ffmpeg -y -i " · " -i " · " -filter_complex [0:a]aformat=sample_fmts=fltp:sample_rates=44100:channel_layouts=stereo,volume=1[a0];[1:a]aformat=sample_fmts=fltp:sample_rates=44100:channel_layouts=stereo,volume=0.5[a1];[a0][a1]amix=inputs=2:duration=first[aout] -map [aout] -ac 2 -c:v copy -map 0:v:0 -preset superfast " · "/" · "å½ä»¤2="
- `void replaceAudio(String inputPath)`  L530
    - 体内字面量："ffmpeg -i " · " -stream_loop -1 -i " · " -vcodec copy -y " · "/" · "å½ä»¤3="
- `void createGpsVideo()`  L535
    - 体内字面量："/" · "_gps.mp4" · "_gps"
- `void itemClick(int position, AudioDbBean audioDbBean)`  L544 @Override
- `void initView()`  L549 @Override
    - 体内字面量："videopath" · "videoname" · "image/"
- `void addData()`  L562 @Override
- `void run()`  L569 @Override
    - 体内字面量："gpsæ°æ®è·åæå" · "éåº¦\n" · "_gps" · "img00" · "_gps" · "img0" · "_gps" · "æ­¤è§é¢æ²¡ægpsæ°æ®"
- `int setContentRes()`  L594 @Override
- `void onResume()`  L599 @Override
- `void onPause()`  L606 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L616 @Override
    - 体内字面量："æ¶å°äºåè°00" · "æ¶å°äºåè°11"
- `void onDestroy()`  L626 @Override
### `com.gku.actioncam.sigmastar.videoedit.CutActivity$AnonymousClass10`
L313 · [class] AnonymousClass10 · implements `View.OnClickListener` · `com/gku/actioncam/sigmastar/videoedit/CutActivity.java`

字段/常量（1）：
- `CutActivity cutActivity = CutActivity.this`  L320

方法（3）：
- `void onClick(View view)`  L318 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L324 @Override
    - 体内字面量："å¯¹è¯æ¡æ¶å¤±äº"
- `void run()`  L328 @Override
### `com.gku.actioncam.sigmastar.videoedit.CutAudioDialog`
L29 · [class] public CutAudioDialog · extends `Dialog` · `com/gku/actioncam/sigmastar/videoedit/CutAudioDialog.java`

字段/常量（31）：
- `String TAG = "CutAudioDialog"`  L30
- `Activity activity`  L31
- `ValueAnimator animator`  L32
- `AudioDbBean audioDbBean`  L33
- `long audioLeftProgress`  L34
- `long audioRightProgress`  L35
- `float averagePxMs`  L36
- `FrameLayout fl_audio_play`  L37
- `Handler handler`  L38
- `MediaPlayer mediaPlayer`  L39
- `ImageView positionIcon_audio`  L40
- `RangeSeekBar rangeSeekBar`  L41
- `TimerTask task`  L42
- `Timer timer`  L43
- `TextView tv_collect_time`  L44
- `TextView tv_cut_cancal`  L45
- `TextView tv_cut_ok`  L46
- `CutAudioDialog cutAudioDialog = CutAudioDialog.this`  L81
- `CutAudioDialog cutAudioDialog2 = CutAudioDialog.this`  L87
- `CutAudioDialog cutAudioDialog3 = CutAudioDialog.this`  L90
- `CutAudioDialog cutAudioDialog4 = CutAudioDialog.this`  L93
- `CutAudioDialog cutAudioDialog5 = CutAudioDialog.this`  L99
- `CutAudioDialog cutAudioDialog6 = CutAudioDialog.this`  L101
- `CutAudioDialog cutAudioDialog = CutAudioDialog.this`  L112
- `CutAudioDialog cutAudioDialog = CutAudioDialog.this`  L160
- `CutAudioDialog cutAudioDialog2 = CutAudioDialog.this`  L166
- `ValueAnimator valueAnimator = this.animator`  L175
- `TimerTask timerTask = this.task`  L241
- `String str`  L249
- `String str2`  L250
- `long j = time / 3600000`  L251

方法（18）：
- `public CutAudioDialog(Activity context, AudioDbBean audioDbBean)`  L48
- `void onCreate(Bundle savedInstanceState)`  L59 @Override
- `void onClick(View view)`  L80 @Override
- `void onClick(View view)`  L111 @Override
- `String createCutFilePath(Context context)`  L121
    - 体内字面量："audiocut/"
- `void executeCommand(String strText, String path, String name, long time)`  L130
- `void initRangeSeekBar()`  L134
    - 体内字面量："0.00s-" · "%.0f" · ".00s"
- `void onRangeSeekBarValuesChanged(RangeSeekBar bar, long minValue, long maxValue, int action, boolean isMin, RangeSeekBar.Thumb pressedThumb)`  L155 @Override
    - 体内字面量：".00s - " · ".00s"
- `void anim(final ImageView positionIcon)`  L173
- `void onAnimationUpdate(ValueAnimator animation)`  L188 @Override
- `void startVideo(final ImageView positionIcon)`  L197
- `void onCompletion(MediaPlayer mediaPlayer)`  L201 @Override
- `void run()`  L210 @Override
- `void run()`  L213 @Override
- `void videoProgressUpdate(final ImageView positionIcon)`  L224
- `void run()`  L228 @Override
- `void pauseVideo(ImageView positionIcon)`  L236
- `String getGapTime(long time)`  L248
### `com.gku.actioncam.sigmastar.videoedit.CutVideoDialog`
L47 · [class] public CutVideoDialog · extends `Dialog` · `com/gku/actioncam/sigmastar/videoedit/CutVideoDialog.java`

字段/常量（11）：
- `Activity activity`  L48
- `ImageView iv_close`  L49
- `TextView tv_camera`  L50
- `TextView tv_local_iamge`  L51
- `String str = videoName`  L157
- `int i6 = 0`  L177
- `int i7 = i6 * i4`  L179
- `int i8 = 200`  L180
- `String str`  L233
- `String str2`  L234
- `long j = time / 3600000`  L235

方法（15）：
- `public CutVideoDialog(Activity context)`  L53
- `void onCreate(Bundle savedInstanceState)`  L59 @Override
- `void onClick(View view)`  L76 @Override
- `void onClick(View view)`  L83 @Override
- `void onClick(View view)`  L90 @Override
- `void getMedia()`  L97
- `void onCancel()`  L118 @Override
- `void onResult(ArrayList<LocalMedia> result)`  L122 @Override
    - 体内字面量："result=" · "result=" · "videopath" · "videoname" · "videopath" · "videoname"
- `File getLocalDataPath(Context context)`  L143
    - 体内字面量："mounted"
- `void loadFfmpegImage(Context context, String videoPath, String videoName)`  L154
    - 体内字面量："image/"
- `void run()`  L183 @Override
- `void getBitmap(Bitmap bitmap, long timeMs)`  L186 @Override
    - 体内字面量："image_" · "getBitmap" · "è·åæå" · "  bitmap  getWidth=" · "getHeight="
- `void saveBitmapFile(Bitmap bitmap, String videoName, String imageName)`  L205
    - 体内字面量："/image/"
- `void loadimage(String videoPath, String videoName, int oneTime, int width, int hight, int index)`  L220
    - 体内字面量："loadimage" · "loadimage   index=" · "loadimage" · "loadimage   oneTime=" · "ffmpeg -y -ss " · " -i " · " -s " · " -f image2 -q:v 2 -preset superfast -vframes 1 " · "/image/" · "/img" · "loadimage" · "loadimage   commands="
- `String getGapTime(long time)`  L232
### `com.gku.actioncam.sigmastar.videoedit.CutVideoDialog$MeSandboxFileEngine`
L254 · [class] private MeSandboxFileEngine · implements `UriToFileTransformEngine` · `com/gku/actioncam/sigmastar/videoedit/CutVideoDialog.java`

字段/常量（1）：
- `String strCopyPathToSandbox`  L260

方法（2）：
- `private MeSandboxFileEngine()`  L255
- `void onUriToFileAsyncTransform(Context context, String srcPath, String mineType, OnKeyValueResultCallbackListener call)`  L259 @Override
### `com.gku.actioncam.sigmastar.videoedit.FilePathUtils`
L26 · [class] public FilePathUtils · `com/gku/actioncam/sigmastar/videoedit/FilePathUtils.java`

字段/常量（7）：
- `String TAG = "FilePathUtils"`  L27
- `File filesDir`  L30
- `String str = videoName`  L45
- `int i6 = 0`  L65
- `int i7 = i6 * i4`  L67
- `int i8 = 200`  L68
- `byte[] bArr = new byte[1444]`  L185

方法（12）：
- `String getBaseLocalPath(Context context)`  L29
- `void loadFfmpegImage(final Context context, String videoPath, String videoName)`  L42
    - 体内字面量："image/"
- `void run()`  L71 @Override
- `void getBitmap(Bitmap bitmap, long timeMs)`  L74 @Override
    - 体内字面量："image_" · "getBitmap" · "è·åæå" · "  bitmap  getWidth=" · "getHeight="
- `void saveBitmapFile(Context context, Bitmap bitmap, String videoName, String imageName)`  L93
    - 体内字面量："/image/"
- `String getSaveGpsImagePath(Context context, String videoName)`  L108
    - 体内字面量："/image/"
- `Bitmap viewToBitmap(View v)`  L112
    - 体内字面量："width=" · "   height="
- `ContentValues getImageContentValues(File paramFile, long paramLong)`  L123
    - 体内字面量："_display_name" · "mime_type" · "image/jpeg" · "datetaken" · "date_modified" · "date_added" · "orientation" · "_data" · "_size"
- `boolean saveImgToSystemAlbum(String imageFile, Context context)`  L137
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `ContentValues getVideoContentValues(File paramFile, long paramLong)`  L150
    - 体内字面量："_display_name" · "mime_type" · "video/mp4" · "datetaken" · "date_modified" · "date_added" · "_data" · "_size"
- `boolean saveVideoToSystemAlbum(String videoFile, Context context)`  L163
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `boolean copyFile(String oldPath, OutputStream out)`  L181
### `com.gku.actioncam.sigmastar.videoedit.FileUtils`
L25 · [class] public FileUtils · `com/gku/actioncam/sigmastar/videoedit/FileUtils.java`

字段/常量（10）：
- `int columnIndex`  L27
- `Uri uriWithAppendedId = null`  L28
- `int columnIndex`  L46
- `Uri uriWithAppendedId = null`  L47
- `int columnIndex`  L66
- `String string = null`  L67
- `DocumentFile documentFileFromSingleUri`  L82
- `?? r10`  L147
- `byte[] bArr = new byte[8192]`  L238
- `byte[] bArr = new byte[1024]`  L276

方法（14）：
- `Uri getContentUri(Context context, File file)`  L26
- `Uri getDuplicateFileUri(Context context, File file)`  L45
- `String getPath(Context context, Uri uri)`  L65
- `String getName(Context context, Uri uri)`  L81
- `String getExtension(String name)`  L89
- `String getMimeType(String name)`  L97
- `String getMimeType(Context context, Uri uri)`  L101
- `Uri getContentUri(String mimeType)`  L108
    - 体内字面量："image" · "video" · "audio" · "external"
- `String getDirName(String mimeType)`  L121
    - 体内字面量："image" · "video" · "audio"
- `Uri copyFileToExternal(Context context, String str, File file)`  L146
- `boolean copy(InputStream inputStream, OutputStream outputStream)`  L236
- `boolean deleteSystem(Context context, Uri uri)`  L254
- `boolean delete(Context context, Uri uri)`  L263
- `int copySdcardFile(String fromFile, String toFile)`  L272
### `com.gku.actioncam.sigmastar.videoedit.GlideEngine`
L13 · [class] public GlideEngine · implements `ImageEngine` · `com/gku/actioncam/sigmastar/videoedit/GlideEngine.java`

字段/常量（1）：
- `GlideEngine instance`  L14

方法（8）：
- `void loadImage(Context context, String url, ImageView imageView)`  L17 @Override
- `void loadImage(Context context, ImageView imageView, String url, int maxWidth, int maxHeight)`  L24 @Override
- `void loadAlbumCover(Context context, String url, ImageView imageView)`  L31 @Override
- `void loadGridImage(Context context, String url, ImageView imageView)`  L38 @Override
- `void pauseRequests(Context context)`  L45 @Override
- `void resumeRequests(Context context)`  L50 @Override
- `private GlideEngine()`  L54
- `GlideEngine createGlideEngine()`  L57
### `com.gku.actioncam.sigmastar.videoedit.MediaDecoder`
L9 · [class] public MediaDecoder · `com/gku/actioncam/sigmastar/videoedit/MediaDecoder.java`

字段/常量（4）：
- `String TAG = "MediaDecoder"`  L10
- `String fileLength`  L11
- `MediaMetadataRetriever retriever`  L12
- `MediaMetadataRetriever mediaMetadataRetriever = this.retriever`  L28

方法（4）：
- `public MediaDecoder(String file)`  L18
    - 体内字面量："fileLength : "
- `boolean decodeFrame(long timeMs, int width, int height, OnGetBitmapListener listener)`  L27
- `Bitmap compressBitmapToGivenWidthAndHeight(Bitmap bitmap, double newWidth, double newHeight)`  L45
- `String getVedioFileLength()`  L53
### `com.gku.actioncam.sigmastar.videoedit.MediaDecoder$OnGetBitmapListener`
L14 · [interface] public OnGetBitmapListener · `com/gku/actioncam/sigmastar/videoedit/MediaDecoder.java`

方法（1）：
- `void getBitmap(Bitmap bitmap, long timeMs)`  L15
### `com.gku.actioncam.sigmastar.videoedit.MyVideoView`
L8 · [class] public MyVideoView · extends `VideoView` · `com/gku/actioncam/sigmastar/videoedit/MyVideoView.java`

方法（3）：
- `public MyVideoView(Context context)`  L9
- `public MyVideoView(Context context, AttributeSet attrs)`  L13
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L18 @Override
### `com.gku.actioncam.sigmastar.videoedit.RangeSeekBar`
L22 · [class] public RangeSeekBar · extends `View` · `com/gku/actioncam/sigmastar/videoedit/RangeSeekBar.java`

字段/常量（61）：
- `int ACTION_POINTER_INDEX_MASK = 65280`  L23
- `int ACTION_POINTER_INDEX_SHIFT = 8`  L24
- `int INVALID_POINTER_ID = 255`  L25
- `String TAG = "RangeSeekBar"`  L26
- `double absoluteMaxValuePrim`  L27
- `double absoluteMinValuePrim`  L28
- `boolean isMin`  L29
- `boolean isTouchDown`  L30
- `int left_right_gray_height`  L31
- `int left_right_gray_margin`  L32
- `int left_right_gray_width`  L33
- `OnRangeSeekBarChangeListener listener`  L34
- `int mActivePointerId`  L35
- `Bitmap mBitmapBlack`  L36
- `Bitmap mBitmapPro`  L37
- `float mDownMotionX`  L38
- `Paint mGrayPaint`  L39
- `boolean mIsDragging`  L40
- `int mScaledTouchSlop`  L41
- `Paint mShadowPaint`  L42
- `long min_cut_time`  L43
- `double min_width`  L44
- `double normalizedMaxValue`  L45
- `double normalizedMaxValueTime`  L46
- `double normalizedMinValue`  L47
- `double normalizedMinValueTime`  L48
- `boolean notifyWhileDragging`  L49
- `float padding`  L50
- `Paint paint`  L51
- `Thumb pressedThumb`  L52
- `Paint rectPaint`  L53
- `float thumbHalfWidth`  L54
- `int thumbHeight`  L55
- `float thumbPaddingTop`  L56
- `float thumbPressPaddingTop`  L57
- `int thumbWidth`  L58
- `int top_bottom_border_height`  L59
- `Bitmap bitmap = this.mBitmapPro`  L183
- `int i = this.thumbWidth`  L187
- `float f = this.thumbPaddingTop`  L188
- `int i2 = this.thumbWidth`  L198
- `int i3 = this.left_right_gray_width`  L199
- `int i4 = this.thumbWidth`  L202
- `int i5 = this.thumbWidth`  L206
- `int i6 = this.left_right_gray_width`  L207
- `OnRangeSeekBarChangeListener onRangeSeekBarChangeListener`  L217
- `OnRangeSeekBarChangeListener onRangeSeekBarChangeListener2 = this.listener`  L245
- `OnRangeSeekBarChangeListener onRangeSeekBarChangeListener3 = this.listener`  L260
- `int i = action == 0 ? 1 : 0`  L302
- `double d`  L325
- `float f = width`  L327
- `double width2 = screenCoord`  L332
- `double d2 = this.min_cut_time`  L335
- `double d3 = this.absoluteMaxValuePrim`  L336
- `double d5 = fNormalizedToScreen`  L348
- `int i = this.thumbWidth`  L359
- `double d6 = valueLength - AudioStats.AUDIO_AMPLITUDE_NONE`  L363
- `double d7 = fNormalizedToScreen2`  L371
- `double d = this.absoluteMaxValuePrim`  L443
- `double d2 = this.absoluteMinValuePrim`  L444
- `double d = this.absoluteMinValuePrim`  L483

方法（36）：
- `void drawThumb(float screenCoord, boolean pressed, Canvas canvas, boolean isLeft)`  L70
- `public RangeSeekBar(Context context)`  L73
- `public RangeSeekBar(Context context, AttributeSet attrs)`  L88
- `public RangeSeekBar(Context context, AttributeSet attrs, int defStyleAttr)`  L103
- `public RangeSeekBar(Context context, long absoluteMinValuePrim, long absoluteMaxValuePrim)`  L118
- `void init()`  L138
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L166 @Override
- `void onDraw(Canvas canvas)`  L171 @Override
- `boolean onTouchEvent(MotionEvent event)`  L216 @Override
- `void onSecondaryPointerUp(MotionEvent ev)`  L299
- `void trackTouchEvent(MotionEvent event)`  L308
    - 体内字面量："trackTouchEvent: " · " x: "
- `double screenToNormalized(float screenCoord, int position)`  L324
- `int getValueLength()`  L393
- `Thumb evalPressedThumb(float touchX)`  L397
- `boolean isInThumbRange(float touchX, double normalizedThumbValue, double scale)`  L412
- `boolean isInThumbRangeLeft(float touchX, double normalizedThumbValue, double scale)`  L416
- `void attemptClaimDrag()`  L420
- `void onStartTrackingTouch()`  L426
- `void onStopTrackingTouch()`  L430
- `void setMin_cut_time(long min_cut_time)`  L434
- `float normalizedToScreen(double normalizedCoord)`  L438
- `double valueToNormalized(long value)`  L442
- `void setSelectedMinValue(long value)`  L448
- `void setSelectedMaxValue(long value)`  L456
- `void setNormalizedMinValue(double value)`  L464
- `void setNormalizedMaxValue(double value)`  L469
- `long getSelectedMinValue()`  L474
- `long getSelectedMaxValue()`  L478
- `long normalizedToValue(double normalized)`  L482
- `boolean isNotifyWhileDragging()`  L487
- `void setNotifyWhileDragging(boolean flag)`  L491
- `int dip2px(int dip)`  L495
- `void setTouchDown(boolean touchDown)`  L499
- `Parcelable onSaveInstanceState()`  L504 @Override
    - 体内字面量："SUPER" · "MIN" · "MAX" · "MIN_TIME" · "MAX_TIME"
- `void onRestoreInstanceState(Parcelable parcel)`  L515 @Override
    - 体内字面量："SUPER" · "MIN" · "MAX" · "MIN_TIME" · "MAX_TIME"
- `void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener listener)`  L524
### `com.gku.actioncam.sigmastar.videoedit.RangeSeekBar$OnRangeSeekBarChangeListener`
L61 · [interface] public OnRangeSeekBarChangeListener · `com/gku/actioncam/sigmastar/videoedit/RangeSeekBar.java`

方法（1）：
- `void onRangeSeekBarValuesChanged(RangeSeekBar bar, long minValue, long maxValue, int action, boolean isMin, Thumb pressedThumb)`  L62
### `com.gku.actioncam.sigmastar.videoedit.RangeSeekBar$Thumb`
L65 · [enum] public Thumb · `com/gku/actioncam/sigmastar/videoedit/RangeSeekBar.java`

枚举常量（1）：
- `MIN()`  L66
### `com.gku.actioncam.sigmastar.videoedit.TrimVideoAdapter`
L16 · [class] public TrimVideoAdapter · extends `RecyclerView.Adapter` · `com/gku/actioncam/sigmastar/videoedit/TrimVideoAdapter.java`

字段/常量（4）：
- `Context context`  L17
- `LayoutInflater inflater`  L18
- `int itemW`  L19
- `List<VideoEditInfo> list = this.list`  L44

方法（7）：
- `public TrimVideoAdapter(Context context, int itemW)`  L22
- `List<VideoEditInfo> getData()`  L28
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L33 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position)`  L38 @Override
- `int getItemCount()`  L43 @Override
- `void clearData()`  L60
- `void addItemVideoInfo(VideoEditInfo info)`  L64
### `com.gku.actioncam.sigmastar.videoedit.TrimVideoAdapter$VideoHolder`
L51 · [class] private final VideoHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/videoedit/TrimVideoAdapter.java`

字段/常量（1）：
- `ImageView img`  L52
### `com.gku.actioncam.sigmastar.videoedit.UIUtils`
L6 · [class] public UIUtils · `com/gku/actioncam/sigmastar/videoedit/UIUtils.java`

方法（3）：
- `int dp2px(Context context, float dpValue)`  L7
- `int compareFloat(float a, float b)`  L14
- `int getScreenWidth(Context context)`  L23
### `com.gku.actioncam.sigmastar.videoedit.VideoEditActivity`
L46 · [class] public VideoEditActivity · extends `CameraBaseActivity implements AudioListAdapter.OnItemClickLis` · implements `AudioListAdapter.OnItemClickLis` · `com/gku/actioncam/sigmastar/videoedit/VideoEditActivity.java`

字段/常量（60）：
- `String ARG_NAME = "videoName"`  L47
- `String ARG_PATH = "videoPath"`  L48
- `String TAG = "VideoEditActivity"`  L49
- `AudioListAdapter AudioListAdapter`  L50
- `ValueAnimator animator`  L51
- `float averagePxMs`  L52
- `Button btn_cancal`  L53
- `Button btn_cut`  L54
- `int gpsFrameRate`  L55
- `String gpsVideoPath`  L56
- `boolean hasGsp`  L57
- `String has_audios`  L58
- `LinearLayout id_seekBarLayout`  L59
- `boolean isCloseVideoAudio`  L60
- `long leftProgress`  L61
- `ConstraintLayout ll_audio`  L62
- `LinearLayout ll_speed`  L63
- `LinearLayout ll_video`  L64
- `MediaPlayer mMediaPlayer`  L65
- `ImageView positionIcon`  L66
- `RangeSeekBar rangeSeekBar`  L67
- `long rightProgress`  L68
- `RecyclerView rv_audio`  L69
- `TrimVideoAdapter trimVideoAdapter`  L70
- `TextView tv_audio_cut`  L71
- `TextView tv_end_time`  L72
- `TextView tv_more_audio`  L73
- `TextView tv_music`  L74
- `TextView tv_speed`  L75
- `TextView tv_start_time`  L76
- `TextView tv_video_audio_open`  L77
- `TextView tv_video_cut`  L78
- `int videoHeight`  L79
- `String videoName`  L80
- `String videoPath`  L81
- `long videoTime`  L82
- `int videoWidth`  L83
- `RecyclerView video_thumb_listview`  L84
- `MyVideoView videoview`  L85
- `TimerTask task = null`  L87
- `boolean isLoadingImage = false`  L89
- `boolean stopLoadingImage = false`  L90
- `int i2 = this.videoWidth`  L113
- `int i`  L125
- `float f = this.videoWidth / this.videoHeight`  L130
- `VideoEditActivity videoEditActivity = VideoEditActivity.this`  L247
- `VideoEditActivity videoEditActivity2 = VideoEditActivity.this`  L249
- `VideoEditActivity videoEditActivity = VideoEditActivity.this`  L306
- `String str`  L365
- `String str2`  L366
- `long j = time / 3600000`  L367
- `ValueAnimator valueAnimator = this.animator`  L388
- `TimerTask timerTask = this.task`  L433
- `String str`  L491
- `String str2 = this.isCloseVideoAudio ? "-an " : "<binary/metadata>"`  L504
- `String str4 = this.gpsVideoPath`  L506
- `String str = "ffmpeg -i " + this.videoPath + " -framerate " + this.gpsFrameRate + " -i " + saveGpsImagePath + "/img%3d.png -filter_complex [0][1]overlay=60:main_h-overlay_h-30 -y -q:v 1 -max_muxing_queue_size 1080 -vcodec libx264 -acodec copy -crf 35 -preset ultrafast -r 15 -qp 20 -threads 10 " + this.gpsVideoPath`  L542
- `AudioListAdapter audioListAdapter = this.AudioListAdapter`  L626
- `TimerTask timerTask = this.task`  L645
- `Timer timer = this.timer`  L650

方法（45）：
- `void onProgressCancelListener(DialogInterface dialog)`  L93 @Override
- `void start(Context context, String videoPath, String videoName)`  L96
- `void getMediaInfo()`  L103
- `void adjustSurfaceSize()`  L124
- `String createCutFilePath()`  L146
    - 体内字面量："cut/"
- `void initViewId()`  L155
- `boolean canScrollHorizontally()`  L185 @Override
    - 体内字面量："%.0f" · ".00s"
- `void onRangeSeekBarValuesChanged(RangeSeekBar bar, long minValue, long maxValue, int action, boolean isMin, RangeSeekBar.Thumb pressedThumb)`  L199 @Override
    - 体内字面量："-----minValue----->>>>>>" · "-----maxValue----->>>>>>" · ".00s" · ".00s" · "-----leftProgress----->>>>>>" · "-----rightProgress----->>>>>>" · "-----ACTION_DOWN---->>>>>>" · "-----ACTION_MOVE---->>>>>>" · "-----ACTION_UP--leftProgress--->>>>>>"
- `void onPrepared(MediaPlayer mediaPlayer)`  L227 @Override
    - 体内字面量："è§é¢åå¤æ­æ¾"
- `void onCompletion(MediaPlayer mediaPlayer)`  L239 @Override
- `void onClick(View view)`  L246 @Override
- `void run()`  L254 @Override
- `void onClick(View view)`  L262 @Override
- `void onClick(View view)`  L268 @Override
    - 体内字面量："#d5d5d5" · "#5b5b5b"
- `void onClick(View view)`  L283 @Override
    - 体内字面量："#5b5b5b" · "#d5d5d5"
- `void onClick(View view)`  L298 @Override
- `void onClick(View view)`  L305 @Override
- `void loadAudioData()`  L360
- `String getGapTime(long time)`  L364
- `void anim()`  L386
- `void onAnimationUpdate(ValueAnimator animation)`  L401 @Override
- `void startVideo()`  L410
- `void run()`  L416 @Override
- `void run()`  L419 @Override
- `void pauseVideo()`  L430
- `void videoProgressUpdate()`  L441
    - 体内字面量："----onProgressUpdate-cp---->>>>>>>"
- `void run()`  L447 @Override
- `void loadData(int index)`  L455
- `void loadImage(final String videoPath, final String videoName, final int oneTime, final int width, final int hight, final int index)`  L459
- `void run()`  L467 @Override
    - 体内字面量："loadImage   index=" · "loadImage   oneTime=" · "ffmpeg -y -ss " · " -i " · " -s " · " -f image2 -q:v 2 -preset superfast -vframes 1 " · "/image/" · "/img" · "loadImage   commands="
- `void editVideo()`  L482
- `void cutVideo()`  L490
- `void run()`  L522 @Override
- `void mixVoice(String inputPath)`  L531
    - 体内字面量："å½ä»¤2=" · "ffmpeg -y -i " · " -i " · " -filter_complex [0:a]aformat=sample_fmts=fltp:sample_rates=44100:channel_layouts=stereo,volume=1[a0];[1:a]aformat=sample_fmts=fltp:sample_rates=44100:channel_layouts=stereo,volume=0.5[a1];[a0][a1]amix=inputs=2:duration=first[aout] -map [aout] -ac 2 -c:v copy -map 0:v:0 -preset superfast " · "/"
- `void replaceAudio(String inputPath)`  L535
    - 体内字面量："å½ä»¤3=" · "ffmpeg -i " · " -stream_loop -1 -i " · " -vcodec copy -y " · "/"
- `void createGpsVideo()`  L539
    - 体内字面量："/" · "_gps.mp4" · "_gps"
- `void itemClick(int position, AudioDbBean audioDbBean)`  L548 @Override
- `void initView()`  L553 @Override
    - 体内字面量："image/"
- `void addData()`  L566 @Override
- `void run()`  L574 @Override
    - 体内字面量："gpsæ°æ®è·åæå" · "éåº¦\n" · "_gps" · "img00" · "_gps" · "img0" · "_gps" · "æ­¤è§é¢æ²¡ægpsæ°æ®" · "ä¸æ¯æå½åçè§é¢æ ¼å¼"
- `int setContentRes()`  L603 @Override
- `void onResume()`  L608 @Override
    - 体内字面量："123->" · " trimVideoAdapter getItemCount="
- `void onPause()`  L623 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L633 @Override
    - 体内字面量："æ¶å°äºåè°00" · "æ¶å°äºåè°11"
- `void onDestroy()`  L643 @Override
### `com.gku.actioncam.sigmastar.videoedit.VideoEditActivity$AnonymousClass10`
L328 · [class] AnonymousClass10 · implements `View.OnClickListener` · `com/gku/actioncam/sigmastar/videoedit/VideoEditActivity.java`

字段/常量（1）：
- `VideoEditActivity videoEditActivity = VideoEditActivity.this`  L335

方法（3）：
- `void onClick(View view)`  L333 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L339 @Override
    - 体内字面量："å¯¹è¯æ¡æ¶å¤±äº"
- `void run()`  L343 @Override
### `com.gku.actioncam.sigmastar.videoedit.VideoEditInfo`
L6 · [class] public VideoEditInfo · implements `Serializable` · `com/gku/actioncam/sigmastar/videoedit/VideoEditInfo.java`

字段/常量（4）：
- `boolean isSelect`  L7
- `String name`  L8
- `String path`  L9
- `long time`  L10

方法（1）：
- `String toString()`  L12
    - 体内字面量："VideoEditInfo{path='" · "', time='" · "', name='" · "'}"
### `com.gku.actioncam.sigmastar.videoedit.VideoSaveToPhoneDialog`
L15 · [class] public VideoSaveToPhoneDialog · extends `Dialog` · `com/gku/actioncam/sigmastar/videoedit/VideoSaveToPhoneDialog.java`

字段/常量（5）：
- `DialogOkClickLis dialogOkClickLis`  L16
- `EditText edit_video_name`  L17
- `TextView tv_cancal`  L18
- `TextView tv_ok`  L19
- `String videoName`  L20

方法（4）：
- `public VideoSaveToPhoneDialog(Activity context, String videoName, DialogOkClickLis dialogOkClickLis)`  L26
- `void onCreate(Bundle savedInstanceState)`  L33 @Override
- `void onClick(View view)`  L51 @Override
    - 体内字面量："è§é¢åå­ä¸è½ä¸ºç©º"
- `void onClick(View view)`  L62 @Override
### `com.gku.actioncam.sigmastar.videoedit.VideoSaveToPhoneDialog$DialogOkClickLis`
L22 · [interface] public DialogOkClickLis · `com/gku/actioncam/sigmastar/videoedit/VideoSaveToPhoneDialog.java`

方法（1）：
- `void onOkClick(String videoName)`  L23
### `com.gku.actioncam.sigmastar.videoedit.VideoShareActivity`
L38 · [class] public VideoShareActivity · extends `BaseActivity` · `com/gku/actioncam/sigmastar/videoedit/VideoShareActivity.java`

字段/常量（24）：
- `ImageView iv_back`  L39
- `SeekBar sb_video`  L40
- `TextView tv_save`  L41
- `TextView tv_share`  L42
- `TextView tv_time`  L43
- `int videoHeight`  L44
- `String videoPath`  L45
- `long videoTime`  L46
- `int videoWidth`  L47
- `MyVideoView videoview`  L48
- `TimerTask task = null`  L50
- `Uri uriWithAppendedPath = null`  L135
- `OutputStream outputStream`  L162
- `OutputStream outputStream2`  L163
- `Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI`  L169
- `FileInputStream fileInputStream = null`  L172
- `OutputStream outputStreamOpenOutputStream = null`  L175
- `FileInputStream fileInputStream2 = null`  L176
- `byte[] bArr = new byte[4096]`  L214
- `long j = progress`  L242
- `TimerTask timerTask = this.task`  L267
- `int i`  L290
- `int i3 = this.videoWidth`  L299
- `float f = this.videoWidth / this.videoHeight`  L307

方法（22）：
- `void onCreate(Bundle savedInstanceState)`  L53 @Override
    - 体内字面量："videoPath"
- `void onClick(View view)`  L65 @Override
- `void onClick(View view)`  L71 @Override
    - 体内字面量："/"
- `void onOkClick(String videoname)`  L74 @Override
- `void onClick(View view)`  L83 @Override
    - 体内字面量："android.intent.action.SEND" · "android.intent.extra.STREAM" · "åäº«åä¸ªè§é¢"
- `void onProgressChanged(SeekBar seekBar, int i, boolean b)`  L98 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L102 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L107 @Override
- `void onCompletion(MediaPlayer mediaPlayer)`  L115 @Override
- `void shareReportToWX(File file)`  L122
    - 体内字面量："android.intent.action.SEND" · "android.intent.extra.STREAM" · "åäº«å°"
- `Uri getImageContentUri(Context context, File imageFile)`  L132
    - 体内字面量："_data=? "
- `String getAppPackageName()`  L151
- `void copyPrivateToDownload(Context context, String str, String str2)`  L161
- `void startVideo(int progress)`  L239
    - 体内字面量："VideoShareActivity" · "è¦å¼å§æ­æ¾äº"
- `void run()`  L249 @Override
- `void run()`  L252 @Override
    - 体内字面量："/"
- `void pauseVideo()`  L265
- `void videoProgressUpdate()`  L275
    - 体内字面量："VideoShareActivity" · "----onProgressUpdate-cp---->>>>>>>"
- `void run()`  L281 @Override
- `void adjustSurfaceSize()`  L289
- `void onResume()`  L324 @Override
- `void onPause()`  L331 @Override