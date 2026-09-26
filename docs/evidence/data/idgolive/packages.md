# idGoLive — 包（package）全量清点

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 17202 个类型 / 10685 个反编译源文件 / 994 个包
> OWN = 已确认厂商代码；UNKNOWN = 既非厂商包名也非已知库（多为混淆后的应用层），两者都逐类展开在 `api/`；lib = 第三方库/平台代码，仅清点

---

## OWN（142 个包 / 1100 个类型）

| 包 | 类型数 | 方法数 | 字段数 |
|---|---|---|---|
| com.icatch.bluetooth.sdk | 6 | 0 | 9 |
| com.icatch.golive | 16 | 16 | 1825 |
| com.icatch.golive.Application | 2 | 14 | 4 |
| com.icatch.golive.data.AppInfo | 6 | 15 | 83 |
| com.icatch.golive.data.CustomException | 2 | 4 | 1 |
| com.icatch.golive.data.entity | 16 | 115 | 92 |
| com.icatch.golive.data.GlobalApp | 3 | 23 | 16 |
| com.icatch.golive.data.Hash | 2 | 28 | 14 |
| com.icatch.golive.data.Message | 1 | 0 | 40 |
| com.icatch.golive.data.Mode | 7 | 2 | 17 |
| com.icatch.golive.data.PropertyId | 1 | 0 | 51 |
| com.icatch.golive.data.SystemInfo | 3 | 20 | 21 |
| com.icatch.golive.data.type | 9 | 16 | 31 |
| com.icatch.golive.DataConvert | 3 | 7 | 4 |
| com.icatch.golive.db | 2 | 14 | 14 |
| com.icatch.golive.entity | 4 | 29 | 31 |
| com.icatch.golive.Function | 33 | 99 | 114 |
| com.icatch.golive.Function.CameraAction | 12 | 42 | 57 |
| com.icatch.golive.Function.live.Facebook | 3 | 17 | 13 |
| com.icatch.golive.Function.live.google | 5 | 14 | 19 |
| com.icatch.golive.Function.Setting | 8 | 96 | 85 |
| com.icatch.golive.Function.streaming | 9 | 46 | 127 |
| com.icatch.golive.Function.ThumbnailGetting | 1 | 6 | 4 |
| com.icatch.golive.Function.USB | 6 | 69 | 72 |
| com.icatch.golive.Listener | 18 | 44 | 17 |
| com.icatch.golive.Log | 2 | 14 | 15 |
| com.icatch.golive.MyCamera | 7 | 60 | 75 |
| com.icatch.golive.net | 16 | 263 | 233 |
| com.icatch.golive.Presenter | 48 | 817 | 699 |
| com.icatch.golive.Presenter.Interface | 1 | 8 | 2 |
| com.icatch.golive.SdkApi | 12 | 224 | 246 |
| com.icatch.golive.SdkApi.mobileapi | 8 | 75 | 84 |
| com.icatch.golive.test | 1 | 5 | 10 |
| com.icatch.golive.ui | 2 | 40 | 40 |
| com.icatch.golive.ui.activity | 40 | 1003 | 555 |
| com.icatch.golive.ui.adapter | 59 | 326 | 328 |
| com.icatch.golive.ui.appdialog | 7 | 41 | 27 |
| com.icatch.golive.ui.ExtendComponent | 14 | 167 | 180 |
| com.icatch.golive.ui.Fragment | 20 | 331 | 220 |
| com.icatch.golive.ui.Interface | 16 | 266 | 0 |
| com.icatch.golive.utils | 38 | 251 | 173 |
| com.icatch.golive.utils.fileutils | 6 | 38 | 50 |
| com.icatch.golive.utils.imageloader | 6 | 67 | 32 |
| com.icatch.golive.video | 2 | 26 | 4 |
| com.icatchtek | 1 | 6 | 3 |
| com.icatchtek.basecomponent | 18 | 30 | 3031 |
| com.icatchtek.basecomponent.activitymanager | 2 | 20 | 14 |
| com.icatchtek.basecomponent.customcomponent | 20 | 194 | 339 |
| com.icatchtek.basecomponent.customcomponent.zones | 12 | 115 | 237 |
| com.icatchtek.basecomponent.decorators | 2 | 5 | 2 |
| com.icatchtek.basecomponent.dialog | 8 | 31 | 27 |
| com.icatchtek.basecomponent.imageview | 3 | 45 | 34 |
| com.icatchtek.basecomponent.prompt | 7 | 62 | 29 |
| com.icatchtek.basecomponent.utils | 3 | 23 | 10 |
| com.icatchtek.basecomponent.utils.StatusBar | 1 | 10 | 0 |
| com.icatchtek.baseutil | 37 | 142 | 1917 |
| com.icatchtek.baseutil.awss3v4signer | 2 | 2 | 0 |
| com.icatchtek.baseutil.awss3v4signer.auth | 4 | 19 | 31 |
| com.icatchtek.baseutil.awss3v4signer.util | 2 | 6 | 6 |
| com.icatchtek.baseutil.bitmap | 2 | 28 | 33 |
| com.icatchtek.baseutil.date | 2 | 43 | 18 |
| com.icatchtek.baseutil.download | 4 | 18 | 20 |
| com.icatchtek.baseutil.exceptions | 6 | 8 | 3 |
| com.icatchtek.baseutil.imageloader | 5 | 59 | 39 |
| com.icatchtek.baseutil.info | 6 | 33 | 105 |
| com.icatchtek.baseutil.io | 3 | 25 | 48 |
| com.icatchtek.baseutil.log | 1 | 10 | 16 |
| com.icatchtek.baseutil.mediacodec | 5 | 58 | 30 |
| com.icatchtek.baseutil.network | 3 | 32 | 14 |
| com.icatchtek.baseutil.perference | 1 | 14 | 5 |
| com.icatchtek.baseutil.qrcode | 2 | 12 | 21 |
| com.icatchtek.baseutil.regex | 1 | 18 | 1 |
| com.icatchtek.bluetooth.core | 5 | 19 | 41 |
| com.icatchtek.bluetooth.core.base | 7 | 32 | 18 |
| com.icatchtek.bluetooth.core.client.bt | 1 | 8 | 8 |
| com.icatchtek.bluetooth.core.client.btle | 1 | 13 | 22 |
| com.icatchtek.bluetooth.core.client.transfer | 1 | 3 | 0 |
| com.icatchtek.bluetooth.core.client.transfer.bt | 2 | 11 | 19 |
| com.icatchtek.bluetooth.core.client.transfer.btle | 2 | 12 | 17 |
| com.icatchtek.bluetooth.core.ctrl | 3 | 24 | 10 |
| com.icatchtek.bluetooth.core.event | 5 | 18 | 6 |
| com.icatchtek.bluetooth.customer | 6 | 30 | 16 |
| com.icatchtek.bluetooth.customer.client | 4 | 26 | 0 |
| com.icatchtek.bluetooth.customer.exception | 6 | 12 | 6 |
| com.icatchtek.bluetooth.customer.listener | 3 | 2 | 27 |
| com.icatchtek.bluetooth.customer.type | 4 | 22 | 15 |
| com.icatchtek.control | 1 | 0 | 4 |
| com.icatchtek.control.core | 3 | 11 | 7 |
| com.icatchtek.control.core.feature | 9 | 161 | 48 |
| com.icatchtek.control.core.jni | 10 | 311 | 4 |
| com.icatchtek.control.core.jni.extractor | 3 | 12 | 7 |
| com.icatchtek.control.core.jni.util | 6 | 19 | 194 |
| com.icatchtek.control.core.util.event | 1 | 3 | 1 |
| com.icatchtek.control.core.util.type | 1 | 3 | 0 |
| com.icatchtek.control.customer | 11 | 176 | 6 |
| com.icatchtek.control.customer.exception | 7 | 14 | 7 |
| com.icatchtek.control.customer.type | 23 | 63 | 242 |
| com.icatchtek.pancam | 1 | 0 | 4 |
| com.icatchtek.pancam.core | 1 | 6 | 13 |
| com.icatchtek.pancam.core.feature | 5 | 59 | 31 |
| com.icatchtek.pancam.core.feature.gles | 2 | 22 | 6 |
| com.icatchtek.pancam.core.feature.stream | 4 | 42 | 5 |
| com.icatchtek.pancam.core.feature.type | 2 | 19 | 12 |
| com.icatchtek.pancam.core.feature.utils | 1 | 3 | 4 |
| com.icatchtek.pancam.core.jni | 16 | 214 | 5 |
| com.icatchtek.pancam.core.jni.extractor | 8 | 33 | 179 |
| com.icatchtek.pancam.core.util | 3 | 6 | 1 |
| com.icatchtek.pancam.core.util.event | 1 | 3 | 1 |
| com.icatchtek.pancam.core.util.type | 1 | 4 | 21 |
| com.icatchtek.pancam.customer | 10 | 76 | 9 |
| com.icatchtek.pancam.customer.decoder | 2 | 6 | 0 |
| com.icatchtek.pancam.customer.exception | 16 | 16 | 0 |
| com.icatchtek.pancam.customer.gl | 2 | 17 | 0 |
| com.icatchtek.pancam.customer.stream | 4 | 30 | 0 |
| com.icatchtek.pancam.customer.surface | 2 | 8 | 2 |
| com.icatchtek.pancam.customer.type | 14 | 75 | 76 |
| com.icatchtek.reliant | 1 | 0 | 4 |
| com.icatchtek.reliant.core | 1 | 3 | 0 |
| com.icatchtek.reliant.core.jni | 5 | 33 | 1 |
| com.icatchtek.reliant.core.jni.routines | 1 | 3 | 3 |
| com.icatchtek.reliant.customer.exception | 39 | 70 | 16 |
| com.icatchtek.reliant.customer.transport | 7 | 41 | 7 |
| com.icatchtek.reliant.customer.type | 17 | 157 | 223 |
| com.id221.golive | 21 | 0 | 9070 |
| com.tinyai.libmediacomponent | 17 | 16 | 3489 |
| com.tinyai.libmediacomponent.components | 1 | 5 | 3 |
| com.tinyai.libmediacomponent.components.cameralist | 7 | 106 | 78 |
| com.tinyai.libmediacomponent.components.filelist | 34 | 244 | 273 |
| com.tinyai.libmediacomponent.components.media | 16 | 304 | 379 |
| com.tinyai.libmediacomponent.components.media.audio | 5 | 58 | 65 |
| com.tinyai.libmediacomponent.components.media.interfaces | 1 | 39 | 0 |
| com.tinyai.libmediacomponent.components.media.type | 3 | 0 | 3 |
| com.tinyai.libmediacomponent.components.setting | 18 | 156 | 132 |
| com.tinyai.libmediacomponent.engine | 2 | 12 | 4 |
| com.tinyai.libmediacomponent.engine.listener | 2 | 2 | 0 |
| com.tinyai.libmediacomponent.engine.streaming | 8 | 92 | 70 |
| com.tinyai.libmediacomponent.engine.streaming.exception | 2 | 2 | 1 |
| com.tinyai.libmediacomponent.engine.streaming.Headset | 3 | 13 | 7 |
| com.tinyai.libmediacomponent.engine.streaming.render | 7 | 23 | 69 |
| com.tinyai.libmediacomponent.engine.streaming.type | 12 | 99 | 76 |
| com.tinyai.libmediacomponent.utils | 3 | 16 | 74 |
| com.tinyai.libmediacomponent.utils.log | 1 | 10 | 16 |

## UNKNOWN（4 个包 / 35 个类型）

| 包 | 类型数 | 方法数 | 字段数 |
|---|---|---|---|
| com.android.installreferrer | 2 | 1 | 6 |
| com.android.installreferrer.api | 8 | 22 | 27 |
| com.android.installreferrer.commons | 1 | 2 | 0 |
| com.tonicartos.widget.stickygridheaders | 24 | 155 | 160 |

## lib（848 个包 / 16067 个类型）

| 包 | 类型数 | 方法数 |
|---|---|---|
| _COROUTINE | 4 | 4 |
| android.adservices.topics | 7 | 20 |
| android.support.customtabs | 9 | 48 |
| android.support.v4.app | 6 | 20 |
| android.support.v4.graphics.drawable | 1 | 2 |
| android.support.v4.media | 40 | 268 |
| android.support.v4.media.session | 61 | 911 |
| android.support.v4.os | 13 | 33 |
| androidx.activity | 40 | 254 |
| androidx.activity.contextaware | 6 | 16 |
| androidx.activity.result | 15 | 63 |
| androidx.activity.result.contract | 29 | 87 |
| androidx.annotation | 78 | 17 |
| androidx.annotation.experimental | 4 | 2 |
| androidx.appcompat | 14 | 14 |
| androidx.appcompat.app | 72 | 893 |
| androidx.appcompat.content.res | 1 | 3 |
| androidx.appcompat.graphics.drawable | 16 | 224 |
| androidx.appcompat.resources | 5 | 8 |
| androidx.appcompat.text | 1 | 3 |
| androidx.appcompat.view | 16 | 156 |
| androidx.appcompat.view.menu | 36 | 640 |
| androidx.appcompat.widget | 206 | 2226 |
| androidx.arch.core | 1 | 1 |
| androidx.arch.core.executor | 4 | 21 |
| androidx.arch.core.internal | 8 | 38 |
| androidx.arch.core.util | 1 | 1 |
| androidx.asynclayoutinflater | 11 | 11 |
| androidx.asynclayoutinflater.view | 5 | 13 |
| androidx.browser | 11 | 11 |
| androidx.browser.browseractions | 12 | 42 |
| androidx.browser.customtabs | 14 | 108 |
| androidx.cardview | 6 | 6 |
| androidx.cardview.widget | 9 | 139 |
| androidx.collection | 131 | 2794 |
| androidx.collection.internal | 5 | 18 |
| androidx.concurrent.futures | 17 | 78 |
| androidx.constraintlayout.core | 17 | 206 |
| androidx.constraintlayout.core.dsl | 49 | 353 |
| androidx.constraintlayout.core.motion | 9 | 215 |
| androidx.constraintlayout.core.motion.key | 7 | 88 |
| androidx.constraintlayout.core.motion.parse | 3 | 7 |
| androidx.constraintlayout.core.motion.utils | 54 | 268 |
| androidx.constraintlayout.core.parser | 13 | 119 |
| androidx.constraintlayout.core.state | 33 | 422 |
| androidx.constraintlayout.core.state.helpers | 13 | 125 |
| androidx.constraintlayout.core.utils | 2 | 75 |
| androidx.constraintlayout.core.widgets | 20 | 402 |
| androidx.constraintlayout.core.widgets.analyzer | 24 | 145 |
| androidx.constraintlayout.helper.widget | 8 | 168 |
| androidx.constraintlayout.motion.utils | 48 | 75 |
| androidx.constraintlayout.motion.widget | 43 | 687 |
| androidx.constraintlayout.utils.widget | 7 | 151 |
| androidx.constraintlayout.widget | 41 | 508 |
| androidx.coordinatorlayout | 11 | 11 |
| androidx.coordinatorlayout.widget | 12 | 177 |
| androidx.core | 11 | 11 |
| androidx.core.accessibilityservice | 1 | 6 |
| androidx.core.animation | 2 | 45 |
| androidx.core.app | 209 | 1308 |
| androidx.core.app.unusedapprestrictions | 8 | 20 |
| androidx.core.content | 44 | 241 |
| androidx.core.content.pm | 19 | 134 |
| androidx.core.content.res | 29 | 188 |
| androidx.core.database | 4 | 14 |
| androidx.core.database.sqlite | 3 | 6 |
| androidx.core.graphics | 50 | 386 |
| androidx.core.graphics.drawable | 23 | 205 |
| androidx.core.hardware.display | 1 | 5 |
| androidx.core.hardware.fingerprint | 5 | 34 |
| androidx.core.internal.view | 3 | 26 |
| androidx.core.ktx | 1 | 1 |
| androidx.core.location | 36 | 274 |
| androidx.core.math | 1 | 18 |
| androidx.core.net | 11 | 50 |
| androidx.core.os | 53 | 227 |
| androidx.core.provider | 26 | 117 |
| androidx.core.service.quicksettings | 5 | 20 |
| androidx.core.telephony | 6 | 13 |
| androidx.core.telephony.mbms | 2 | 4 |
| androidx.core.text | 30 | 138 |
| androidx.core.text.method | 1 | 3 |
| androidx.core.text.util | 18 | 67 |
| androidx.core.transition | 2 | 48 |
| androidx.core.util | 41 | 278 |
| androidx.core.view | 163 | 1301 |
| androidx.core.view.accessibility | 42 | 431 |
| androidx.core.view.animation | 3 | 11 |
| androidx.core.view.autofill | 1 | 3 |
| androidx.core.view.contentcapture | 4 | 19 |
| androidx.core.view.inputmethod | 10 | 60 |
| androidx.core.widget | 43 | 404 |
| androidx.cursoradapter | 1 | 1 |
| androidx.cursoradapter.widget | 9 | 58 |
| androidx.customview | 11 | 11 |
| androidx.customview.poolingcontainer | 5 | 14 |
| androidx.customview.view | 1 | 10 |
| androidx.customview.widget | 9 | 139 |
| androidx.documentfile | 1 | 1 |
| androidx.documentfile.provider | 5 | 91 |
| androidx.drawerlayout | 11 | 11 |
| androidx.drawerlayout.widget | 8 | 137 |
| androidx.dynamicanimation | 1 | 1 |
| androidx.dynamicanimation.animation | 19 | 147 |
| androidx.emoji2 | 1 | 1 |
| androidx.emoji2.text | 59 | 301 |
| androidx.emoji2.text.flatbuffer | 47 | 440 |
| androidx.emoji2.viewsintegration | 18 | 92 |
| androidx.exifinterface | 1 | 1 |
| androidx.exifinterface.media | 7 | 121 |
| androidx.fragment | 5 | 5 |
| androidx.fragment.app | 75 | 1060 |
| androidx.fragment.app.strictmode | 17 | 61 |
| androidx.graphics.shapes | 37 | 282 |
| androidx.interpolator | 1 | 1 |
| androidx.interpolator.view.animation | 4 | 8 |
| androidx.legacy.app | 5 | 25 |
| androidx.legacy.content | 1 | 2 |
| androidx.legacy.coreui | 11 | 11 |
| androidx.legacy.coreutils | 11 | 11 |
| androidx.legacy.v4 | 11 | 11 |
| androidx.legacy.widget | 1 | 6 |
| androidx.lifecycle | 92 | 382 |
| androidx.lifecycle.livedata.core | 1 | 1 |
| androidx.lifecycle.process | 1 | 1 |
| androidx.lifecycle.runtime | 2 | 2 |
| androidx.lifecycle.viewmodel | 11 | 20 |
| androidx.lifecycle.viewmodel.savedstate | 1 | 1 |
| androidx.loader | 11 | 11 |
| androidx.loader.app | 6 | 50 |
| androidx.loader.content | 10 | 87 |
| androidx.localbroadcastmanager | 1 | 1 |
| androidx.localbroadcastmanager.content | 3 | 9 |
| androidx.media | 64 | 307 |
| androidx.media.app | 6 | 33 |
| androidx.media.session | 2 | 11 |
| androidx.media.utils | 1 | 1 |
| androidx.multidex | 15 | 46 |
| androidx.print | 5 | 35 |
| androidx.profileinstaller | 26 | 141 |
| androidx.recyclerview | 5 | 5 |
| androidx.recyclerview.widget | 156 | 1960 |
| androidx.resourceinspection.annotation | 3 | 3 |
| androidx.savedstate | 12 | 40 |
| androidx.slidingpanelayout | 11 | 11 |
| androidx.slidingpanelayout.widget | 8 | 87 |
| androidx.startup | 7 | 25 |
| androidx.swiperefreshlayout | 11 | 11 |
| androidx.swiperefreshlayout.widget | 8 | 175 |
| androidx.tracing | 4 | 20 |
| androidx.transition | 107 | 722 |
| androidx.vectordrawable | 11 | 11 |
| androidx.vectordrawable.animated | 11 | 11 |
| androidx.vectordrawable.graphics.drawable | 21 | 284 |
| androidx.versionedparcelable | 13 | 208 |
| androidx.viewpager | 11 | 11 |
| androidx.viewpager.widget | 17 | 187 |
| androidx.viewpager2 | 2 | 2 |
| androidx.viewpager2.adapter | 9 | 68 |
| androidx.viewpager2.widget | 24 | 192 |
| cafe.adriel.androidoauth | 1 | 0 |
| cafe.adriel.androidoauth.callback | 3 | 6 |
| cafe.adriel.androidoauth.model | 1 | 21 |
| cafe.adriel.androidoauth.oauth | 10 | 40 |
| cafe.adriel.androidoauth.view | 2 | 10 |
| cn.jzvd | 24 | 275 |
| com.arthenica.ffmpegkit | 36 | 346 |
| com.arthenica.smartexception | 6 | 70 |
| com.arthenica.smartexception.java | 4 | 42 |
| com.bigkoo.pickerview | 13 | 12 |
| com.bigkoo.pickerview.adapter | 2 | 8 |
| com.bigkoo.pickerview.builder | 2 | 74 |
| com.bigkoo.pickerview.configure | 1 | 1 |
| com.bigkoo.pickerview.listener | 7 | 7 |
| com.bigkoo.pickerview.utils | 3 | 26 |
| com.bigkoo.pickerview.view | 5 | 128 |
| com.bumptech.glide | 37 | 250 |
| com.bumptech.glide.annotation | 5 | 2 |
| com.bumptech.glide.annotation.compiler | 1 | 0 |
| com.bumptech.glide.disklrucache | 7 | 60 |
| com.bumptech.glide.gifdecoder | 8 | 87 |
| com.bumptech.glide.load | 19 | 61 |
| com.bumptech.glide.load.data | 23 | 95 |
| com.bumptech.glide.load.data.mediastore | 7 | 25 |
| com.bumptech.glide.load.engine | 50 | 259 |
| com.bumptech.glide.load.engine.bitmap_recycle | 29 | 166 |
| com.bumptech.glide.load.engine.cache | 24 | 91 |
| com.bumptech.glide.load.engine.executor | 5 | 42 |
| com.bumptech.glide.load.engine.prefill | 7 | 30 |
| com.bumptech.glide.load.model | 67 | 247 |
| com.bumptech.glide.load.model.stream | 16 | 51 |
| com.bumptech.glide.load.resource | 3 | 14 |
| com.bumptech.glide.load.resource.bitmap | 61 | 280 |
| com.bumptech.glide.load.resource.bytes | 3 | 10 |
| com.bumptech.glide.load.resource.drawable | 6 | 32 |
| com.bumptech.glide.load.resource.file | 2 | 3 |
| com.bumptech.glide.load.resource.gif | 17 | 105 |
| com.bumptech.glide.load.resource.transcode | 8 | 18 |
| com.bumptech.glide.manager | 20 | 113 |
| com.bumptech.glide.module | 6 | 9 |
| com.bumptech.glide.provider | 9 | 25 |
| com.bumptech.glide.request | 14 | 228 |
| com.bumptech.glide.request.target | 23 | 186 |
| com.bumptech.glide.request.transition | 19 | 36 |
| com.bumptech.glide.signature | 5 | 24 |
| com.bumptech.glide.util | 18 | 124 |
| com.bumptech.glide.util.pool | 9 | 31 |
| com.contrarywind.adapter | 1 | 3 |
| com.contrarywind.interfaces | 1 | 1 |
| com.contrarywind.listener | 2 | 3 |
| com.contrarywind.timer | 3 | 6 |
| com.contrarywind.view | 11 | 58 |
| com.danikula.videocache | 27 | 168 |
| com.danikula.videocache.file | 11 | 34 |
| com.danikula.videocache.headers | 2 | 2 |
| com.danikula.videocache.sourcestorage | 4 | 15 |
| com.facebook | 111 | 907 |
| com.facebook.all | 1 | 0 |
| com.facebook.appevents | 37 | 348 |
| com.facebook.appevents.aam | 6 | 49 |
| com.facebook.appevents.cloudbridge | 24 | 104 |
| com.facebook.appevents.codeless | 16 | 102 |
| com.facebook.appevents.codeless.internal | 11 | 66 |
| com.facebook.appevents.eventdeactivation | 2 | 10 |
| com.facebook.appevents.gps | 1 | 3 |
| com.facebook.appevents.gps.ara | 1 | 14 |
| com.facebook.appevents.gps.pa | 1 | 10 |
| com.facebook.appevents.gps.topics | 2 | 23 |
| com.facebook.appevents.iap | 25 | 201 |
| com.facebook.appevents.integrity | 8 | 58 |
| com.facebook.appevents.internal | 19 | 139 |
| com.facebook.appevents.ml | 12 | 83 |
| com.facebook.appevents.ondeviceprocessing | 6 | 24 |
| com.facebook.appevents.restrictivedatafilter | 2 | 12 |
| com.facebook.appevents.suggestedevents | 8 | 70 |
| com.facebook.applinks | 17 | 43 |
| com.facebook.bolts | 35 | 190 |
| com.facebook.common | 18 | 16 |
| com.facebook.core | 14 | 12 |
| com.facebook.devicerequests.internal | 1 | 13 |
| com.facebook.gamingservices | 67 | 314 |
| com.facebook.gamingservices.cloudgaming | 11 | 62 |
| com.facebook.gamingservices.cloudgaming.internal | 5 | 21 |
| com.facebook.gamingservices.internal | 6 | 19 |
| com.facebook.gamingservices.model | 15 | 107 |
| com.facebook.internal | 118 | 887 |
| com.facebook.internal.gatekeeper | 3 | 24 |
| com.facebook.internal.instrument | 9 | 62 |
| com.facebook.internal.instrument.anrreport | 2 | 12 |
| com.facebook.internal.instrument.crashreport | 2 | 12 |
| com.facebook.internal.instrument.crashshield | 3 | 11 |
| com.facebook.internal.instrument.errorreport | 2 | 19 |
| com.facebook.internal.instrument.threadcheck | 1 | 5 |
| com.facebook.internal.logging.dumpsys | 2 | 4 |
| com.facebook.internal.qualityvalidation | 2 | 3 |
| com.facebook.internal.security | 1 | 7 |
| com.facebook.login | 71 | 611 |
| com.facebook.login.widget | 14 | 173 |
| com.facebook.messenger | 20 | 46 |
| com.facebook.ppml.receiver | 5 | 12 |
| com.facebook.share | 22 | 55 |
| com.facebook.share.internal | 26 | 210 |
| com.facebook.share.model | 43 | 355 |
| com.facebook.share.widget | 18 | 142 |
| com.fasterxml.jackson.annotation | 71 | 254 |
| com.fasterxml.jackson.core | 41 | 728 |
| com.fasterxml.jackson.core.async | 3 | 4 |
| com.fasterxml.jackson.core.base | 3 | 175 |
| com.fasterxml.jackson.core.exc | 3 | 21 |
| com.fasterxml.jackson.core.filter | 6 | 170 |
| com.fasterxml.jackson.core.format | 5 | 28 |
| com.fasterxml.jackson.core.io | 18 | 217 |
| com.fasterxml.jackson.core.io.doubleparser | 13 | 84 |
| com.fasterxml.jackson.core.io.schubfach | 3 | 53 |
| com.fasterxml.jackson.core.json | 13 | 535 |
| com.fasterxml.jackson.core.json.async | 4 | 130 |
| com.fasterxml.jackson.core.sym | 10 | 110 |
| com.fasterxml.jackson.core.type | 4 | 31 |
| com.fasterxml.jackson.core.util | 22 | 372 |
| com.fasterxml.jackson.databind | 70 | 1524 |
| com.fasterxml.jackson.databind.annotation | 15 | 8 |
| com.fasterxml.jackson.databind.cfg | 28 | 393 |
| com.fasterxml.jackson.databind.deser | 45 | 672 |
| com.fasterxml.jackson.databind.deser.impl | 45 | 355 |
| com.fasterxml.jackson.databind.deser.std | 89 | 827 |
| com.fasterxml.jackson.databind.exc | 9 | 49 |
| com.fasterxml.jackson.databind.ext | 16 | 61 |
| com.fasterxml.jackson.databind.introspect | 65 | 880 |
| com.fasterxml.jackson.databind.jdk14 | 4 | 9 |
| com.fasterxml.jackson.databind.json | 2 | 18 |
| com.fasterxml.jackson.databind.jsonFormatVisitors | 26 | 64 |
| com.fasterxml.jackson.databind.jsonschema | 3 | 8 |
| com.fasterxml.jackson.databind.jsontype | 17 | 114 |
| com.fasterxml.jackson.databind.jsontype.impl | 21 | 168 |
| com.fasterxml.jackson.databind.module | 6 | 68 |
| com.fasterxml.jackson.databind.node | 33 | 650 |
| com.fasterxml.jackson.databind.ser | 24 | 288 |
| com.fasterxml.jackson.databind.ser.impl | 34 | 252 |
| com.fasterxml.jackson.databind.ser.std | 76 | 569 |
| com.fasterxml.jackson.databind.type | 20 | 346 |
| com.fasterxml.jackson.databind.util | 53 | 571 |
| com.fasterxml.jackson.databind.util.internal | 19 | 139 |
| com.github.scribejava.apis | 130 | 432 |
| com.github.scribejava.apis.facebook | 4 | 14 |
| com.github.scribejava.apis.fitbit | 3 | 10 |
| com.github.scribejava.apis.google | 2 | 4 |
| com.github.scribejava.apis.imgur | 1 | 3 |
| com.github.scribejava.apis.instagram | 4 | 20 |
| com.github.scribejava.apis.mailru | 1 | 3 |
| com.github.scribejava.apis.microsoftazureactivedirectory | 6 | 14 |
| com.github.scribejava.apis.odnoklassniki | 1 | 3 |
| com.github.scribejava.apis.openid | 3 | 9 |
| com.github.scribejava.apis.polar | 4 | 11 |
| com.github.scribejava.apis.salesforce | 3 | 9 |
| com.github.scribejava.apis.slack | 3 | 8 |
| com.github.scribejava.apis.tutby | 2 | 4 |
| com.github.scribejava.apis.vk | 3 | 9 |
| com.github.scribejava.apis.wunderlist | 1 | 2 |
| com.github.scribejava.core.base64 | 5 | 19 |
| com.github.scribejava.core.builder | 5 | 58 |
| com.github.scribejava.core.builder.api | 3 | 27 |
| com.github.scribejava.core.exceptions | 3 | 5 |
| com.github.scribejava.core.extractors | 22 | 51 |
| com.github.scribejava.core.httpclient | 5 | 18 |
| com.github.scribejava.core.httpclient.jdk | 5 | 45 |
| com.github.scribejava.core.httpclient.multipart | 5 | 48 |
| com.github.scribejava.core.model | 17 | 127 |
| com.github.scribejava.core.oauth | 6 | 121 |
| com.github.scribejava.core.oauth2 | 1 | 2 |
| com.github.scribejava.core.oauth2.bearersignature | 5 | 9 |
| com.github.scribejava.core.oauth2.clientauthentication | 5 | 9 |
| com.github.scribejava.core.pkce | 4 | 16 |
| com.github.scribejava.core.revoke | 2 | 2 |
| com.github.scribejava.core.services | 7 | 18 |
| com.github.scribejava.core.utils | 3 | 9 |
| com.github.scribejava.java8.base64 | 1 | 2 |
| com.google.android.exoplayer2 | 192 | 2517 |
| com.google.android.exoplayer2.analytics | 23 | 460 |
| com.google.android.exoplayer2.audio | 85 | 676 |
| com.google.android.exoplayer2.common | 2 | 1 |
| com.google.android.exoplayer2.container | 5 | 28 |
| com.google.android.exoplayer2.core | 12 | 11 |
| com.google.android.exoplayer2.database | 8 | 19 |
| com.google.android.exoplayer2.decoder | 21 | 78 |
| com.google.android.exoplayer2.drm | 58 | 368 |
| com.google.android.exoplayer2.extractor | 49 | 270 |
| com.google.android.exoplayer2.extractor.amr | 2 | 26 |
| com.google.android.exoplayer2.extractor.avi | 10 | 64 |
| com.google.android.exoplayer2.extractor.flac | 5 | 24 |
| com.google.android.exoplayer2.extractor.flv | 6 | 44 |
| com.google.android.exoplayer2.extractor.jpeg | 6 | 37 |
| com.google.android.exoplayer2.extractor.mkv | 11 | 84 |
| com.google.android.exoplayer2.extractor.mp3 | 9 | 67 |
| com.google.android.exoplayer2.extractor.mp4 | 34 | 218 |
| com.google.android.exoplayer2.extractor.ogg | 14 | 76 |
| com.google.android.exoplayer2.extractor.ts | 51 | 325 |
| com.google.android.exoplayer2.extractor.wav | 8 | 44 |
| com.google.android.exoplayer2.mediacodec | 30 | 360 |
| com.google.android.exoplayer2.metadata | 8 | 46 |
| com.google.android.exoplayer2.metadata.dvbsi | 2 | 8 |
| com.google.android.exoplayer2.metadata.emsg | 3 | 15 |
| com.google.android.exoplayer2.metadata.flac | 2 | 20 |
| com.google.android.exoplayer2.metadata.icy | 3 | 21 |
| com.google.android.exoplayer2.metadata.id3 | 15 | 119 |
| com.google.android.exoplayer2.metadata.mp4 | 5 | 45 |
| com.google.android.exoplayer2.metadata.scte35 | 10 | 44 |
| com.google.android.exoplayer2.metadata.vorbis | 1 | 3 |
| com.google.android.exoplayer2.offline | 41 | 345 |
| com.google.android.exoplayer2.scheduler | 9 | 53 |
| com.google.android.exoplayer2.source | 104 | 962 |
| com.google.android.exoplayer2.source.ads | 20 | 221 |
| com.google.android.exoplayer2.source.chunk | 22 | 140 |
| com.google.android.exoplayer2.source.mediaparser | 6 | 47 |
| com.google.android.exoplayer2.text | 21 | 125 |
| com.google.android.exoplayer2.text.cea | 11 | 127 |
| com.google.android.exoplayer2.text.dvb | 11 | 36 |
| com.google.android.exoplayer2.text.pgs | 3 | 14 |
| com.google.android.exoplayer2.text.span | 9 | 5 |
| com.google.android.exoplayer2.text.ssa | 8 | 39 |
| com.google.android.exoplayer2.text.subrip | 2 | 12 |
| com.google.android.exoplayer2.text.ttml | 15 | 91 |
| com.google.android.exoplayer2.text.tx3g | 2 | 14 |
| com.google.android.exoplayer2.text.webvtt | 15 | 105 |
| com.google.android.exoplayer2.trackselection | 36 | 454 |
| com.google.android.exoplayer2.ui | 90 | 762 |
| com.google.android.exoplayer2.upstream | 107 | 500 |
| com.google.android.exoplayer2.upstream.cache | 32 | 292 |
| com.google.android.exoplayer2.upstream.crypto | 3 | 19 |
| com.google.android.exoplayer2.upstream.experimental | 18 | 109 |
| com.google.android.exoplayer2.util | 95 | 904 |
| com.google.android.exoplayer2.video | 31 | 329 |
| com.google.android.exoplayer2.video.spherical | 18 | 99 |
| com.google.android.finsky.externalreferrer | 3 | 8 |
| com.google.android.gms | 1 | 6 |
| com.google.android.gms.actions | 4 | 4 |
| com.google.android.gms.auth | 23 | 98 |
| com.google.android.gms.auth.account | 11 | 24 |
| com.google.android.gms.auth.api | 21 | 32 |
| com.google.android.gms.auth.api.accounttransfer | 29 | 71 |
| com.google.android.gms.auth.api.identity | 59 | 282 |
| com.google.android.gms.auth.api.phone | 10 | 22 |
| com.google.android.gms.auth.api.proxy | 10 | 27 |
| com.google.android.gms.auth.api.signin | 16 | 102 |
| com.google.android.gms.auth.api.signin.internal | 28 | 105 |
| com.google.android.gms.base | 7 | 7 |
| com.google.android.gms.common | 65 | 260 |
| com.google.android.gms.common.annotation | 5 | 0 |
| com.google.android.gms.common.api | 62 | 275 |
| com.google.android.gms.common.api.internal | 137 | 734 |
| com.google.android.gms.common.config | 7 | 22 |
| com.google.android.gms.common.data | 20 | 121 |
| com.google.android.gms.common.images | 13 | 56 |
| com.google.android.gms.common.internal | 119 | 468 |
| com.google.android.gms.common.internal.constants | 1 | 0 |
| com.google.android.gms.common.internal.safeparcel | 14 | 151 |
| com.google.android.gms.common.internal.service | 16 | 30 |
| com.google.android.gms.common.logging | 1 | 13 |
| com.google.android.gms.common.moduleinstall | 17 | 49 |
| com.google.android.gms.common.moduleinstall.internal | 20 | 65 |
| com.google.android.gms.common.providers | 3 | 4 |
| com.google.android.gms.common.server | 2 | 5 |
| com.google.android.gms.common.server.converter | 6 | 18 |
| com.google.android.gms.common.server.response | 24 | 170 |
| com.google.android.gms.common.signatureverification | 7 | 6 |
| com.google.android.gms.common.sqlite | 1 | 6 |
| com.google.android.gms.common.stats | 8 | 28 |
| com.google.android.gms.common.util | 36 | 158 |
| com.google.android.gms.common.util.concurrent | 4 | 8 |
| com.google.android.gms.common.wrappers | 4 | 15 |
| com.google.android.gms.dependencies | 23 | 147 |
| com.google.android.gms.dynamic | 22 | 164 |
| com.google.android.gms.dynamite | 23 | 43 |
| com.google.android.gms.fido | 3 | 8 |
| com.google.android.gms.fido.common | 2 | 8 |
| com.google.android.gms.fido.fido2 | 14 | 42 |
| com.google.android.gms.fido.fido2.api.common | 105 | 450 |
| com.google.android.gms.fido.u2f | 4 | 10 |
| com.google.android.gms.fido.u2f.api.common | 31 | 176 |
| com.google.android.gms.fido.u2f.api.messagebased | 3 | 5 |
| com.google.android.gms.internal.auth | 212 | 827 |
| com.google.android.gms.internal.base | 20 | 59 |
| com.google.android.gms.internal.common | 38 | 157 |
| com.google.android.gms.internal.fido | 60 | 207 |
| com.google.android.gms.internal.p000authapi | 56 | 187 |
| com.google.android.gms.internal.p001authapiphone | 23 | 60 |
| com.google.android.gms.internal.tasks | 1 | 2 |
| com.google.android.gms.security | 3 | 7 |
| com.google.android.gms.signin | 6 | 10 |
| com.google.android.gms.signin.internal | 13 | 37 |
| com.google.android.gms.tasks | 46 | 170 |
| com.google.android.material | 17 | 17 |
| com.google.android.material.animation | 13 | 50 |
| com.google.android.material.appbar | 29 | 420 |
| com.google.android.material.badge | 6 | 196 |
| com.google.android.material.behavior | 13 | 113 |
| com.google.android.material.bottomappbar | 9 | 119 |
| com.google.android.material.bottomnavigation | 6 | 24 |
| com.google.android.material.bottomsheet | 13 | 221 |
| com.google.android.material.button | 12 | 250 |
| com.google.android.material.canvas | 2 | 4 |
| com.google.android.material.card | 4 | 134 |
| com.google.android.material.carousel | 24 | 291 |
| com.google.android.material.checkbox | 5 | 62 |
| com.google.android.material.chip | 9 | 419 |
| com.google.android.material.circularreveal | 13 | 106 |
| com.google.android.material.circularreveal.cardview | 1 | 14 |
| com.google.android.material.circularreveal.coordinatorlayout | 1 | 14 |
| com.google.android.material.color | 35 | 164 |
| com.google.android.material.color.utilities | 47 | 653 |
| com.google.android.material.datepicker | 37 | 417 |
| com.google.android.material.dialog | 3 | 52 |
| com.google.android.material.divider | 2 | 42 |
| com.google.android.material.dockedtoolbar | 1 | 7 |
| com.google.android.material.drawable | 5 | 32 |
| com.google.android.material.elevation | 2 | 17 |
| com.google.android.material.expandable | 3 | 12 |
| com.google.android.material.floatingactionbutton | 24 | 385 |
| com.google.android.material.floatingtoolbar | 1 | 7 |
| com.google.android.material.imageview | 2 | 35 |
| com.google.android.material.internal | 69 | 570 |
| com.google.android.material.loadingindicator | 6 | 76 |
| com.google.android.material.materialswitch | 1 | 35 |
| com.google.android.material.math | 1 | 9 |
| com.google.android.material.motion | 10 | 79 |
| com.google.android.material.navigation | 24 | 510 |
| com.google.android.material.navigationrail | 5 | 72 |
| com.google.android.material.progressindicator | 26 | 361 |
| com.google.android.material.radiobutton | 1 | 7 |
| com.google.android.material.resources | 8 | 58 |
| com.google.android.material.ripple | 4 | 33 |
| com.google.android.material.search | 12 | 343 |
| com.google.android.material.shadow | 3 | 34 |
| com.google.android.material.shape | 52 | 490 |
| com.google.android.material.sidesheet | 15 | 216 |
| com.google.android.material.slider | 19 | 509 |
| com.google.android.material.snackbar | 18 | 191 |
| com.google.android.material.stateful | 1 | 7 |
| com.google.android.material.switchmaterial | 1 | 8 |
| com.google.android.material.tabs | 24 | 225 |
| com.google.android.material.textfield | 26 | 642 |
| com.google.android.material.textview | 1 | 11 |
| com.google.android.material.theme | 1 | 5 |
| com.google.android.material.theme.overlay | 1 | 6 |
| com.google.android.material.timepicker | 24 | 255 |
| com.google.android.material.tooltip | 1 | 37 |
| com.google.android.material.transformation | 8 | 66 |
| com.google.android.material.transition | 31 | 277 |
| com.google.android.material.transition.platform | 34 | 295 |
| com.google.api.client.auth.oauth | 10 | 25 |
| com.google.api.client.auth.oauth2 | 28 | 270 |
| com.google.api.client.auth.openidconnect | 5 | 61 |
| com.google.api.client.extensions.java6.auth.oauth2 | 6 | 31 |
| com.google.api.client.googleapis | 3 | 9 |
| com.google.api.client.googleapis.apache | 1 | 2 |
| com.google.api.client.googleapis.auth.clientlogin | 5 | 14 |
| com.google.api.client.googleapis.auth.oauth2 | 25 | 271 |
| com.google.api.client.googleapis.batch | 9 | 35 |
| com.google.api.client.googleapis.batch.json | 1 | 2 |
| com.google.api.client.googleapis.compute | 2 | 15 |
| com.google.api.client.googleapis.extensions.android.accounts | 1 | 6 |
| com.google.api.client.googleapis.extensions.android.gms.auth | 5 | 28 |
| com.google.api.client.googleapis.javanet | 1 | 2 |
| com.google.api.client.googleapis.json | 4 | 29 |
| com.google.api.client.googleapis.media | 7 | 59 |
| com.google.api.client.googleapis.notifications | 8 | 71 |
| com.google.api.client.googleapis.notifications.json | 1 | 2 |
| com.google.api.client.googleapis.services | 5 | 76 |
| com.google.api.client.googleapis.services.json | 4 | 28 |
| com.google.api.client.googleapis.testing | 1 | 2 |
| com.google.api.client.googleapis.testing.auth.oauth2 | 4 | 16 |
| com.google.api.client.googleapis.testing.compute | 1 | 5 |
| com.google.api.client.googleapis.testing.json | 1 | 1 |
| com.google.api.client.googleapis.testing.notifications | 1 | 2 |
| com.google.api.client.googleapis.testing.services | 3 | 16 |
| com.google.api.client.googleapis.testing.services.json | 3 | 16 |
| com.google.api.client.googleapis.util | 3 | 5 |
| com.google.api.client.http | 43 | 429 |
| com.google.api.client.http.apache | 7 | 43 |
| com.google.api.client.http.javanet | 7 | 36 |
| com.google.api.client.http.json | 1 | 7 |
| com.google.api.client.json | 13 | 106 |
| com.google.api.client.json.jackson2 | 5 | 43 |
| com.google.api.client.json.rpc2 | 1 | 9 |
| com.google.api.client.json.webtoken | 6 | 68 |
| com.google.api.client.repackaged.com.google.common.annotations | 4 | 1 |
| com.google.api.client.repackaged.com.google.common.base | 39 | 405 |
| com.google.api.client.repackaged.org.apache.commons.codec | 6 | 12 |
| com.google.api.client.repackaged.org.apache.commons.codec.binary | 3 | 64 |
| com.google.api.client.testing.http | 8 | 68 |
| com.google.api.client.testing.http.apache | 1 | 4 |
| com.google.api.client.testing.http.javanet | 1 | 17 |
| com.google.api.client.testing.json | 3 | 40 |
| com.google.api.client.testing.json.webtoken | 2 | 6 |
| com.google.api.client.testing.util | 6 | 26 |
| com.google.api.client.util | 59 | 324 |
| com.google.api.client.util.escape | 5 | 22 |
| com.google.api.client.util.store | 11 | 46 |
| com.google.api.services.tasks | 19 | 196 |
| com.google.api.services.tasks.model | 4 | 62 |
| com.google.api.services.youtube | 102 | 1428 |
| com.google.api.services.youtube.model | 174 | 2162 |
| com.google.common.annotations | 5 | 0 |
| com.google.common.base | 130 | 863 |
| com.google.common.base.internal | 1 | 8 |
| com.google.common.cache | 88 | 698 |
| com.google.common.collect | 622 | 6262 |
| com.google.common.escape | 13 | 57 |
| com.google.common.eventbus | 20 | 63 |
| com.google.common.graph | 78 | 718 |
| com.google.common.hash | 73 | 468 |
| com.google.common.html | 3 | 2 |
| com.google.common.io | 68 | 570 |
| com.google.common.math | 31 | 276 |
| com.google.common.net | 13 | 149 |
| com.google.common.primitives | 60 | 636 |
| com.google.common.reflect | 44 | 405 |
| com.google.common.util.concurrent | 219 | 1199 |
| com.google.common.util.concurrent.internal | 2 | 4 |
| com.google.common.xml | 3 | 3 |
| com.google.errorprone.annotations | 23 | 4 |
| com.google.errorprone.annotations.concurrent | 4 | 3 |
| com.google.firebase | 3 | 5 |
| com.google.gson | 29 | 260 |
| com.google.gson.annotations | 5 | 4 |
| com.google.gson.internal | 26 | 222 |
| com.google.gson.internal.bind | 29 | 231 |
| com.google.gson.internal.bind.util | 1 | 8 |
| com.google.gson.internal.reflect | 4 | 28 |
| com.google.gson.internal.sql | 4 | 15 |
| com.google.gson.reflect | 1 | 20 |
| com.google.gson.stream | 5 | 79 |
| com.google.thirdparty.publicsuffix | 3 | 8 |
| com.google.zxing | 24 | 113 |
| com.google.zxing.aztec | 3 | 13 |
| com.google.zxing.aztec.decoder | 4 | 11 |
| com.google.zxing.aztec.detector | 3 | 26 |
| com.google.zxing.aztec.encoder | 7 | 56 |
| com.google.zxing.client.result | 37 | 196 |
| com.google.zxing.common | 17 | 163 |
| com.google.zxing.common.detector | 3 | 15 |
| com.google.zxing.common.reedsolomon | 5 | 33 |
| com.google.zxing.datamatrix | 2 | 9 |
| com.google.zxing.datamatrix.decoder | 9 | 46 |
| com.google.zxing.datamatrix.detector | 1 | 11 |
| com.google.zxing.datamatrix.encoder | 20 | 147 |
| com.google.zxing.maxicode | 1 | 4 |
| com.google.zxing.maxicode.decoder | 3 | 14 |
| com.google.zxing.multi | 3 | 12 |
| com.google.zxing.multi.qrcode | 2 | 5 |
| com.google.zxing.multi.qrcode.detector | 3 | 7 |
| com.google.zxing.oned | 33 | 137 |
| com.google.zxing.oned.rss | 6 | 40 |
| com.google.zxing.oned.rss.expanded | 4 | 36 |
| com.google.zxing.oned.rss.expanded.decoders | 21 | 69 |
| com.google.zxing.pdf417 | 4 | 41 |
| com.google.zxing.pdf417.decoder | 12 | 101 |
| com.google.zxing.pdf417.decoder.ec | 3 | 27 |
| com.google.zxing.pdf417.detector | 2 | 14 |
| com.google.zxing.pdf417.encoder | 10 | 59 |
| com.google.zxing.qrcode | 2 | 9 |
| com.google.zxing.qrcode.decoder | 12 | 69 |
| com.google.zxing.qrcode.detector | 7 | 54 |
| com.google.zxing.qrcode.encoder | 13 | 102 |
| com.handmark.pulltorefresh.library | 49 | 283 |
| com.handmark.pulltorefresh.library.extras | 3 | 14 |
| com.handmark.pulltorefresh.library.internal | 12 | 65 |
| com.nostra13.universalimageloader | 1 | 0 |
| com.nostra13.universalimageloader.cache.disc | 1 | 7 |
| com.nostra13.universalimageloader.cache.disc.impl | 3 | 26 |
| com.nostra13.universalimageloader.cache.disc.impl.ext | 8 | 81 |
| com.nostra13.universalimageloader.cache.disc.naming | 3 | 4 |
| com.nostra13.universalimageloader.cache.memory | 3 | 18 |
| com.nostra13.universalimageloader.cache.memory.impl | 8 | 52 |
| com.nostra13.universalimageloader.core | 17 | 198 |
| com.nostra13.universalimageloader.core.assist | 10 | 23 |
| com.nostra13.universalimageloader.core.assist.deque | 8 | 127 |
| com.nostra13.universalimageloader.core.decode | 5 | 27 |
| com.nostra13.universalimageloader.core.display | 9 | 28 |
| com.nostra13.universalimageloader.core.download | 4 | 20 |
| com.nostra13.universalimageloader.core.imageaware | 4 | 39 |
| com.nostra13.universalimageloader.core.listener | 4 | 13 |
| com.nostra13.universalimageloader.core.process | 1 | 1 |
| com.nostra13.universalimageloader.utils | 8 | 44 |
| com.shuyu.gsy.base | 1 | 1 |
| com.shuyu.gsyvideoplayer | 16 | 179 |
| com.shuyu.gsyvideoplayer.builder | 1 | 50 |
| com.shuyu.gsyvideoplayer.cache | 5 | 29 |
| com.shuyu.gsyvideoplayer.ex_so | 1 | 1 |
| com.shuyu.gsyvideoplayer.listener | 9 | 65 |
| com.shuyu.gsyvideoplayer.model | 3 | 35 |
| com.shuyu.gsyvideoplayer.placeholder | 5 | 24 |
| com.shuyu.gsyvideoplayer.player | 6 | 89 |
| com.shuyu.gsyvideoplayer.render | 1 | 26 |
| com.shuyu.gsyvideoplayer.render.effect | 26 | 53 |
| com.shuyu.gsyvideoplayer.render.glrender | 2 | 49 |
| com.shuyu.gsyvideoplayer.render.view | 5 | 129 |
| com.shuyu.gsyvideoplayer.render.view.listener | 3 | 6 |
| com.shuyu.gsyvideoplayer.utils | 27 | 358 |
| com.shuyu.gsyvideoplayer.video | 6 | 129 |
| com.shuyu.gsyvideoplayer.video.base | 6 | 365 |
| com.shuyu.gsyvideoplayer.view | 1 | 2 |
| com.sun.activation.registries | 7 | 50 |
| com.sun.mail.auth | 2 | 26 |
| com.sun.mail.handlers | 7 | 21 |
| com.sun.mail.iap | 16 | 133 |
| com.sun.mail.imap | 33 | 456 |
| com.sun.mail.imap.protocol | 28 | 236 |
| com.sun.mail.pop3 | 18 | 154 |
| com.sun.mail.smtp | 20 | 148 |
| com.sun.mail.util | 32 | 264 |
| com.sun.mail.util.logging | 10 | 281 |
| com.yanzhenjie.album | 32 | 104 |
| com.yanzhenjie.album.api | 16 | 59 |
| com.yanzhenjie.album.api.camera | 2 | 5 |
| com.yanzhenjie.album.api.choice | 4 | 11 |
| com.yanzhenjie.album.api.widget | 5 | 41 |
| com.yanzhenjie.album.app | 7 | 37 |
| com.yanzhenjie.album.app.album | 14 | 101 |
| com.yanzhenjie.album.app.album.data | 10 | 31 |
| com.yanzhenjie.album.app.camera | 1 | 8 |
| com.yanzhenjie.album.app.gallery | 4 | 45 |
| com.yanzhenjie.album.impl | 3 | 4 |
| com.yanzhenjie.album.mvp | 10 | 128 |
| com.yanzhenjie.album.provider | 1 | 1 |
| com.yanzhenjie.album.util | 2 | 37 |
| com.yanzhenjie.album.widget | 7 | 29 |
| com.yanzhenjie.album.widget.divider | 5 | 31 |
| com.yanzhenjie.album.widget.photoview | 14 | 125 |
| com.yanzhenjie.album.widget.photoview.gestures | 6 | 25 |
| com.yanzhenjie.album.widget.photoview.scrollerproxy | 4 | 23 |
| com.yanzhenjie.mediascanner | 4 | 12 |
| javax.activation | 22 | 173 |
| javax.annotation | 24 | 6 |
| javax.annotation.concurrent | 4 | 1 |
| javax.annotation.meta | 7 | 1 |
| javax.mail | 48 | 383 |
| javax.mail.event | 17 | 55 |
| javax.mail.internet | 36 | 476 |
| javax.mail.search | 24 | 98 |
| javax.mail.util | 5 | 39 |
| kotlin | 105 | 827 |
| kotlin.annotation | 6 | 3 |
| kotlin.collections | 104 | 3113 |
| kotlin.collections.builders | 19 | 213 |
| kotlin.collections.jdk8 | 1 | 2 |
| kotlin.collections.unsigned | 7 | 785 |
| kotlin.comparisons | 11 | 131 |
| kotlin.concurrent | 5 | 26 |
| kotlin.contracts | 11 | 8 |
| kotlin.coroutines | 19 | 86 |
| kotlin.coroutines.cancellation | 1 | 3 |
| kotlin.coroutines.intrinsics | 4 | 24 |
| kotlin.coroutines.jvm.internal | 16 | 57 |
| kotlin.enums | 6 | 18 |
| kotlin.experimental | 5 | 8 |
| kotlin.internal | 20 | 20 |
| kotlin.internal.jdk7 | 2 | 4 |
| kotlin.internal.jdk8 | 2 | 4 |
| kotlin.io | 33 | 215 |
| kotlin.io.encoding | 9 | 66 |
| kotlin.io.path | 26 | 209 |
| kotlin.jdk7 | 1 | 2 |
| kotlin.js | 3 | 0 |
| kotlin.jvm | 24 | 20 |
| kotlin.jvm.functions | 24 | 25 |
| kotlin.jvm.internal | 90 | 557 |
| kotlin.jvm.internal.markers | 9 | 0 |
| kotlin.jvm.internal.unsafe | 1 | 2 |
| kotlin.jvm.jdk8 | 1 | 1 |
| kotlin.jvm.optionals | 1 | 7 |
| kotlin.math | 5 | 116 |
| kotlin.properties | 6 | 19 |
| kotlin.random | 14 | 98 |
| kotlin.random.jdk8 | 1 | 5 |
| kotlin.ranges | 42 | 455 |
| kotlin.reflect | 58 | 190 |
| kotlin.sequences | 53 | 436 |
| kotlin.streams.jdk8 | 1 | 15 |
| kotlin.system | 2 | 3 |
| kotlin.text | 59 | 906 |
| kotlin.text.jdk8 | 1 | 1 |
| kotlin.time | 31 | 333 |
| kotlin.time.jdk8 | 1 | 2 |
| kotlinx.coroutines | 174 | 938 |
| kotlinx.coroutines.android | 5 | 40 |
| kotlinx.coroutines.channels | 115 | 620 |
| kotlinx.coroutines.debug | 2 | 7 |
| kotlinx.coroutines.debug.internal | 22 | 163 |
| kotlinx.coroutines.flow | 253 | 1028 |
| kotlinx.coroutines.flow.internal | 56 | 175 |
| kotlinx.coroutines.future | 3 | 25 |
| kotlinx.coroutines.internal | 66 | 398 |
| kotlinx.coroutines.intrinsics | 2 | 12 |
| kotlinx.coroutines.scheduling | 21 | 175 |
| kotlinx.coroutines.selects | 29 | 124 |
| kotlinx.coroutines.stream | 3 | 6 |
| kotlinx.coroutines.sync | 16 | 119 |
| kotlinx.coroutines.tasks | 2 | 43 |
| kotlinx.coroutines.time | 1 | 7 |
| moe.codeest.enviews | 5 | 32 |
| okhttp3 | 86 | 1108 |
| okhttp3.internal | 4 | 79 |
| okhttp3.internal.authenticator | 2 | 5 |
| okhttp3.internal.cache | 12 | 111 |
| okhttp3.internal.cache2 | 4 | 34 |
| okhttp3.internal.concurrent | 10 | 71 |
| okhttp3.internal.connection | 19 | 172 |
| okhttp3.internal.http | 13 | 76 |
| okhttp3.internal.http1 | 8 | 53 |
| okhttp3.internal.http2 | 31 | 349 |
| okhttp3.internal.io | 3 | 18 |
| okhttp3.internal.platform | 19 | 124 |
| okhttp3.internal.platform.android | 21 | 94 |
| okhttp3.internal.proxy | 1 | 3 |
| okhttp3.internal.publicsuffix | 2 | 10 |
| okhttp3.internal.tls | 6 | 25 |
| okhttp3.internal.ws | 15 | 101 |
| okhttp3.logging | 8 | 51 |
| okio | 71 | 1056 |
| okio.internal | 17 | 292 |
| org.apache.commons.io | 38 | 679 |
| org.apache.commons.io.build | 13 | 94 |
| org.apache.commons.io.charset | 2 | 6 |
| org.apache.commons.io.comparator | 10 | 55 |
| org.apache.commons.io.file | 26 | 354 |
| org.apache.commons.io.file.attribute | 1 | 15 |
| org.apache.commons.io.file.spi | 1 | 7 |
| org.apache.commons.io.filefilter | 32 | 289 |
| org.apache.commons.io.function | 30 | 285 |
| org.apache.commons.io.input | 85 | 700 |
| org.apache.commons.io.input.buffer | 3 | 24 |
| org.apache.commons.io.monitor | 7 | 102 |
| org.apache.commons.io.output | 49 | 413 |
| org.apache.commons.io.serialization | 8 | 27 |
| org.checkerframework.checker.builder.qual | 3 | 2 |
| org.checkerframework.checker.calledmethods.qual | 12 | 15 |
| org.checkerframework.checker.compilermsgs.qual | 3 | 0 |
| org.checkerframework.checker.fenum.qual | 18 | 1 |
| org.checkerframework.checker.formatter.qual | 7 | 13 |
| org.checkerframework.checker.guieffect.qual | 10 | 0 |
| org.checkerframework.checker.i18n.qual | 5 | 0 |
| org.checkerframework.checker.i18nformatter.qual | 9 | 10 |
| org.checkerframework.checker.index.qual | 38 | 24 |
| org.checkerframework.checker.initialization.qual | 5 | 0 |
| org.checkerframework.checker.interning.qual | 9 | 0 |
| org.checkerframework.checker.lock.qual | 15 | 6 |
| org.checkerframework.checker.mustcall.qual | 9 | 1 |
| org.checkerframework.checker.nullness.qual | 19 | 16 |
| org.checkerframework.checker.optional.qual | 9 | 6 |
| org.checkerframework.checker.propkey.qual | 3 | 0 |
| org.checkerframework.checker.regex.qual | 5 | 0 |
| org.checkerframework.checker.signature.qual | 25 | 0 |
| org.checkerframework.checker.signedness.qual | 7 | 0 |
| org.checkerframework.checker.tainting.qual | 3 | 0 |
| org.checkerframework.checker.units.qual | 47 | 2 |
| org.checkerframework.common.aliasing.qual | 5 | 0 |
| org.checkerframework.common.initializedfields.qual | 5 | 2 |
| org.checkerframework.common.reflection.qual | 13 | 5 |
| org.checkerframework.common.returnsreceiver.qual | 3 | 0 |
| org.checkerframework.common.subtyping.qual | 2 | 0 |
| org.checkerframework.common.util.report.qual | 8 | 0 |
| org.checkerframework.common.value.qual | 21 | 13 |
| org.checkerframework.dataflow.qual | 7 | 0 |
| org.checkerframework.framework.qual | 41 | 30 |
| org.eclipse.paho.client.mqttv3 | 30 | 363 |
| org.eclipse.paho.client.mqttv3.internal | 32 | 262 |
| org.eclipse.paho.client.mqttv3.internal.security | 2 | 38 |
| org.eclipse.paho.client.mqttv3.internal.websocket | 11 | 64 |
| org.eclipse.paho.client.mqttv3.internal.wire | 23 | 141 |
| org.eclipse.paho.client.mqttv3.logging | 4 | 66 |
| org.eclipse.paho.client.mqttv3.persist | 4 | 28 |
| org.eclipse.paho.client.mqttv3.spi | 1 | 3 |
| org.eclipse.paho.client.mqttv3.util | 2 | 20 |
| org.intellij.lang.annotations | 27 | 4 |
| org.jetbrains.annotations | 30 | 7 |
| org.jspecify.annotations | 4 | 0 |
| org.jzvd.jzvideo | 5 | 8 |
| shuyu.com.androidvideocache | 2 | 1 |
| tv.danmaku.ijk.media.player | 31 | 341 |
| tv.danmaku.ijk.media.player.annotations | 2 | 0 |
| tv.danmaku.ijk.media.player.exceptions | 1 | 0 |
| tv.danmaku.ijk.media.player.ffmpeg | 1 | 1 |
| tv.danmaku.ijk.media.player.misc | 9 | 49 |
| tv.danmaku.ijk.media.player.pragma | 2 | 17 |
| uk.co.senab.photoview | 14 | 184 |
| uk.co.senab.photoview.gestures | 6 | 25 |
| uk.co.senab.photoview.log | 3 | 22 |
| uk.co.senab.photoview.scrollerproxy | 4 | 23 |
