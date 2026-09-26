# idGoLive — 代码内字面量信号清点

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 厂商自有代码字符串字面量 9111 条，按语义分桶如下（明细见同名 tsv）

---

| 分桶 | 条数 | 含义 |
|---|---|---|
| httpPaths | 71 | 以 / 开头的 HTTP 路径 |
| fullUrls | 198 | 完整 URL / RTSP / 自定义协议地址 |
| hosts | 210 | 像域名/主机的字面量 |
| ips | 171 | 含点分四元组的字面量（默认主机、网关、组播地址） |
| fsPaths | 10 | 设备/文件系统路径 |
| cgiCmd | 109 | CGI 命令与查询串（相机 HTTP 控制面） |
| queryStrings | 3 | 查询串样式字面量（a=b&c=d） |
| keyLike | 91 | 看起来像配置/参数键名的字面量 |
| actions | 31 | Intent action / 广播 / 自定义权限名 |
| mime | 16 | MIME 类型 |
| exts | 46 | 文件扩展名 |
| uaSdk | 0 | User-Agent / 客户端标识 |
| hexMagic | 13 | 十六进制魔术值 / 错误码样式 |
| wifiSsid | 194 | SSID / WiFi / AP 相关字面量 |
| crypto | 147 | 加密、密钥、口令相关字面量 |
