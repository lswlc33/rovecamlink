# XTU GO — 类与成员明细：com.gku.module_camera.bluetooth

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 10 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.module_camera.bluetooth.BluetoothConnector`
L32 · [class] public BluetoothConnector · `com/gku/module_camera/bluetooth/BluetoothConnector.java`

字段/常量（6）：
- `int CODE_CHARACTERISTIC_NOT_FOUND = -2`  L33
- `int CODE_SERVICE_NOT_FOUND = -1`  L34
- `UUID CCCD_UUID`  L35
- `Map<ComponentActivity, BluetoothAdapter> mapBluetoothAdapter`  L36
- `Map<ComponentActivity, BluetoothGattCharacteristic> mapBluetoothGattCharacteristic`  L37
- `Map<ComponentActivity, ScanCallback> mapScanCallback`  L38

方法（21）：
- `private BluetoothConnector()`  L58
    - 体内字面量："00002902-0000-1000-8000-00805f9b34fb"
- `BluetoothConnector getInstance()`  L72
- `void startScan(final ComponentActivity componentActivity, final CallbackScan callbackScan, String str)`  L76
    - 体内字面量："bluetooth"
- `void run()`  L83 @Override
- `void onCreate(LifecycleOwner lifecycleOwner)`  L87 @Override
    - 体内字面量："owner"
- `void onPause(LifecycleOwner lifecycleOwner)`  L92 @Override
    - 体内字面量："owner"
- `void onResume(LifecycleOwner lifecycleOwner)`  L97 @Override
    - 体内字面量："owner"
- `void onStart(LifecycleOwner lifecycleOwner)`  L102 @Override
    - 体内字面量："owner"
- `void onStop(LifecycleOwner lifecycleOwner)`  L107 @Override
    - 体内字面量："owner"
- `void onDestroy(LifecycleOwner lifecycleOwner)`  L112 @Override
    - 体内字面量："owner"
- `void onPermissionHave()`  L121 @Override
- `void onScanResult(int i, ScanResult scanResult)`  L124 @Override
- `void onScanFailed(int i)`  L134 @Override
    - 体内字面量："onScanResult æ«æå¤±è´¥: "
- `void stopScan(ComponentActivity componentActivity)`  L147
- `void onPermissionHave()`  L155 @Override
- `void connect(ComponentActivity componentActivity, BluetoothDevice bluetoothDevice, String str, String str2, CallbackConnect callbackConnect)`  L271
- `void sendCmd(Context context, final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final String str)`  L275
- `void onPermissionHave()`  L280 @Override
    - 体内字面量："xs, " · "sendCmd: " · ", res = "
- `void checkBlePermission(Context context, CallbackPermissionSimple callbackPermissionSimple)`  L286
    - 体内字面量："android.permission.BLUETOOTH_SCAN" · "android.permission.BLUETOOTH_CONNECT"
- `void disConnect(Context context, final BluetoothGatt bluetoothGatt)`  L294
- `void onPermissionHave()`  L297 @Override
### `com.gku.module_camera.bluetooth.BluetoothConnector$AnonymousClass4`
L162 · [class] AnonymousClass4 · implements `Runnable` · `com/gku/module_camera/bluetooth/BluetoothConnector.java`

字段/常量（5）：
- `BluetoothDevice val$bluetoothDevice`  L163
- `CallbackConnect val$callbackConnect`  L164
- `ComponentActivity val$componentActivity`  L165
- `String val$uuid_char`  L166
- `String val$uuid_service`  L167

方法（12）：
- `void run()`  L178 @Override
- `void onCreate(LifecycleOwner lifecycleOwner)`  L181 @Override
    - 体内字面量："owner"
- `void onPause(LifecycleOwner lifecycleOwner)`  L186 @Override
    - 体内字面量："owner"
- `void onResume(LifecycleOwner lifecycleOwner)`  L191 @Override
    - 体内字面量："owner"
- `void onStart(LifecycleOwner lifecycleOwner)`  L196 @Override
    - 体内字面量："owner"
- `void onStop(LifecycleOwner lifecycleOwner)`  L201 @Override
    - 体内字面量："owner"
- `void onDestroy(LifecycleOwner lifecycleOwner)`  L206 @Override
    - 体内字面量："owner"
- `void onPermissionHave()`  L213 @Override
- `void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2)`  L216 @Override
    - 体内字面量："xs, " · "BLE å·²è¿æ¥" · "xs, " · "BLE å·²æ­å¼"
- `void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i)`  L228 @Override
    - 体内字面量："xs, " · "Service not found" · "xs, " · "Characteristic not found"
- `void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i)`  L249 @Override
    - 体内字面量："xs, " · "éç¥å·²å¼å¯"
- `void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic)`  L259 @Override
    - 体内字面量："xs, " · "onCharacteristicChanged" · "xs, " · "æ¶å°æ°æ®: "
### `com.gku.module_camera.bluetooth.BluetoothConnector$CallbackConnect`
L40 · [interface] public CallbackConnect · `com/gku/module_camera/bluetooth/BluetoothConnector.java`

方法（5）：
- `void onConnected(BluetoothGatt bluetoothGatt)`  L41
- `void onDisConnected()`  L43
- `void onError(int i)`  L45
- `void onMsgReceived(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str)`  L47
- `void onSendDataAvailable(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic)`  L49
### `com.gku.module_camera.bluetooth.BluetoothConnector$CallbackScan`
L52 · [interface] public CallbackScan · `com/gku/module_camera/bluetooth/BluetoothConnector.java`

方法（2）：
- `void onScanFailed(int i)`  L53
- `void onScanResult(int i, BluetoothDevice bluetoothDevice)`  L55
### `com.gku.module_camera.bluetooth.BluetoothConnector$Holder`
L65 · [class] private static Holder · `com/gku/module_camera/bluetooth/BluetoothConnector.java`

方法（1）：
- `private Holder()`  L68
### `com.gku.module_camera.bluetooth.BluetoothLive`
L22 · [class] public BluetoothLive · `com/gku/module_camera/bluetooth/BluetoothLive.java`

字段/常量（14）：
- `String CHAR_UUID = "00008888-0000-1000-8000-00805f9b34fb"`  L23
- `int CHUNK_SIZE = 100`  L24
- `String SERVICE_UUID = "0000180a-0000-1000-8000-00805f9b34fb"`  L25
- `CallbackPin callbackPin`  L26
- `CallbackSend callbackSend`  L27
- `String deviceName = "<binary/metadata>"`  L28
- `String str3 = "pin:" + str + ";"`  L198
- `char c = 0`  L201
- `int i = 0`  L202
- `int i2 = i + length`  L204
- `int i3 = 0`  L212
- `String str4 = callbackSend.cmd`  L214
- `char c2 = c`  L218
- `Object[] objArr = new Object[5]`  L219

方法（9）：
- `void startScan(ComponentActivity componentActivity, String str, String str2, String str3, String str4)`  L180
- `void sendStr(Context context, String str, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str2, CallbackSend callbackSend)`  L184
- `void sendWifi(Context context, String str, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str2, String str3, CallbackSend callbackSend)`  L188
    - 体内字面量："ssid:%s;pwd:%s;"
- `void sendLive(Context context, String str, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str2, int i, int i2, int i3, String str3, CallbackSend callbackSend)`  L192
    - 体内字面量："live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s;"
- `void sendPacket(Context context, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str, String str2, CallbackSend callbackSend)`  L196
- `String md5(String str)`  L232
    - 体内字面量："%02x"
- `void sendPackets(Context context, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, List<String> list, CallbackSend callbackSend)`  L245
- `void sendNextPacket(Context context, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, CallbackSend callbackSend)`  L253
    - 体内字面量："å¨é¨åéå®æ"
- `void sendPin(Context context, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, CallbackPin callbackPin)`  L263
    - 体内字面量："_"
### `com.gku.module_camera.bluetooth.BluetoothLive$AnonymousClass1`
L32 · [class] AnonymousClass1 · implements `BluetoothConnector.CallbackScan` · `com/gku/module_camera/bluetooth/BluetoothLive.java`

字段/常量（5）：
- `ComponentActivity val$componentActivity`  L33
- `String val$matchDeviceName`  L34
- `String val$pin`  L35
- `String val$pwd`  L36
- `String val$ssid`  L37

方法（2）：
- `void onScanFailed(int i)`  L40 @Override
- `void onScanResult(int i, BluetoothDevice bluetoothDevice)`  L173 @Override
### `com.gku.module_camera.bluetooth.BluetoothLive$AnonymousClass1$C01291`
L52 · [class] C01291 · extends `CallbackPermissionSimple` · `com/gku/module_camera/bluetooth/BluetoothLive.java`

字段/常量（6）：
- `BluetoothDevice val$bluetoothDevice`  L53
- `int iIndexOf`  L114
- `String strSubstring = "<binary/metadata>"`  L115
- `int i = -1`  L117
- `String str3 = strArrSplit[0]`  L121
- `String str4 = BluetoothLive.this.callbackSend.cmd + "ACK"`  L140

方法（10）：
- `void onPermissionHave()`  L62 @Override
    - 体内字面量："xs, " · "XTU_S7Pro_Max_f9be5a" · "xs, " · "XTU_S7Pro_Max_f9be5a stopScan" · "0000180a-0000-1000-8000-00805f9b34fb"
- `void onConnected(BluetoothGatt bluetoothGatt)`  L72 @Override
- `void onDisConnected()`  L76 @Override
- `void onError(int i)`  L80 @Override
- `void onSendDataAvailable(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic)`  L84 @Override
    - 体内字面量："R003"
- `void onSuccess()`  L87 @Override
    - 体内字面量："xs, " · "sendPin onSuccess" · "gkuvision-5G" · "gku88888" · "R006"
- `void onSuccess()`  L94 @Override
    - 体内字面量："xs, " · "sendWifi onSuccess"
- `void onFail(int i)`  L99 @Override
    - 体内字面量："xs, " · "sendWifi onFail"
- `void onFail(int i)`  L106 @Override
    - 体内字面量："xs, " · "sendPin onFail"
- `void onMsgReceived(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str)`  L113 @Override
### `com.gku.module_camera.bluetooth.BluetoothLive$CallbackPin`
L268 · [class] public static abstract CallbackPin · `com/gku/module_camera/bluetooth/BluetoothLive.java`

字段/常量（2）：
- `String cmd`  L269
- `String pin`  L270

方法（3）：
- `void onFail(int i)`  L272
- `void onSuccess()`  L274
- `public CallbackPin(String str, String str2)`  L276
### `com.gku.module_camera.bluetooth.BluetoothLive$CallbackSend`
L282 · [class] public static abstract CallbackSend · `com/gku/module_camera/bluetooth/BluetoothLive.java`

字段/常量（1）：
- `String cmd`  L283

方法（3）：
- `void onFail(int i)`  L285
- `void onSuccess()`  L287
- `public CallbackSend(String str)`  L289