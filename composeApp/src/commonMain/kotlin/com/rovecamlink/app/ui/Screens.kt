package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.DownloadItem
import com.rovecamlink.app.LabeledRow
import com.rovecamlink.app.Op
import com.rovecamlink.app.Phase
import com.rovecamlink.app.PrimaryButton
import com.rovecamlink.app.SectionCard
import com.rovecamlink.app.core.media.CameraPreviewView
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.wifi.CameraNetwork
import io.github.alexzhirkevich.cupertino.CupertinoActivityIndicator
import io.github.alexzhirkevich.cupertino.CupertinoButton
import io.github.alexzhirkevich.cupertino.CupertinoSwitch
import io.github.alexzhirkevich.cupertino.CupertinoText
import io.github.alexzhirkevich.cupertino.CupertinoTextField

private fun humanBytes(b: Long): String = when {
    b <= 0 -> "—"
    b < 1024 -> "$b B"
    b < 1024 * 1024 -> "${b / 1024} KB"
    b < 1024L * 1024 * 1024 -> "${b / (1024 * 1024)} MB"
    else -> "${b / (1024L * 1024 * 1024)} GB"
}

@Composable
private fun NotConnected(note: String = "Connect a camera on the Devices tab first.") {
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CupertinoText("Not connected", fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(6.dp))
            CupertinoText(note, fontSize = 13.sp, color = Color(0xFF8E8E93))
        }
    }
}

// ============================ Devices ============================

@Composable
fun DevicesScreen(state: AppState) {
    var manualIp by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<CameraNetwork?>(null) }
    var password by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        SectionCard("Status") {
            LabeledRow("Phase", state.phase.name)
            if (state.statusMessage.isNotEmpty()) LabeledRow("Info", state.statusMessage)
            state.session?.let { s ->
                LabeledRow("Model", s.model)
                LabeledRow("Platform", s.platform.displayName)
                LabeledRow("Host", "${s.host}:${s.port}")
            }
        }

        if (state.phase == Phase.Connected) {
            SectionCard {
                Box(Modifier.fillMaxWidth().padding(12.dp)) {
                    PrimaryButton("Disconnect", onClick = { state.disconnect() })
                }
            }
        } else {
            SectionCard("Camera WiFi") {
                Box(Modifier.fillMaxWidth().padding(12.dp)) {
                    PrimaryButton(
                        "Scan for cameras",
                        busy = state.phase == Phase.ScanningWifi,
                        onClick = { state.scanWifi() },
                    )
                }
                if (state.networks.isEmpty() && state.phase != Phase.ScanningWifi) {
                    LabeledRow("No networks scanned yet", "Tap scan")
                }
                state.networks.forEach { n ->
                    LabeledRow(
                        label = n.ssid,
                        value = if (n.secured) "🔒 ${n.rssi}dBm" else "${n.rssi}dBm",
                        onClick = {
                            if (n.secured) { selected = n; password = "" } else state.connect(n.ssid, null)
                        },
                    )
                }
                selected?.let { n ->
                    Column(Modifier.fillMaxWidth().padding(12.dp)) {
                        CupertinoText("Password for ${n.ssid}", fontSize = 13.sp, color = Color(0xFF8E8E93))
                        Spacer(Modifier.height(6.dp))
                        CupertinoTextField(value = password, onValueChange = { password = it })
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(Modifier.weight(1f)) {
                                PrimaryButton("Join & connect", busy = state.phase == Phase.ConnectingWifi) {
                                    state.connect(n.ssid, password.ifBlank { null }); selected = null
                                }
                            }
                            CupertinoButton(onClick = { selected = null }) { CupertinoText("Cancel") }
                        }
                    }
                }
            }

            SectionCard("Manual connect") {
                Column(Modifier.fillMaxWidth().padding(12.dp)) {
                    CupertinoTextField(
                        value = manualIp,
                        onValueChange = { manualIp = it },
                        placeholder = { CupertinoText("192.168.0.1", color = Color(0xFFB0B0B5)) },
                    )
                    Spacer(Modifier.height(8.dp))
                    PrimaryButton(
                        "Connect to IP (already on camera WiFi)",
                        busy = state.phase == Phase.IdentifyingDevice || state.phase == Phase.ConnectingProtocol,
                    ) {
                        val ip = manualIp.trim()
                        if (ip.isNotEmpty()) state.connect(manualHost = ip)
                    }
                }
            }
        }
    }
}

// ============================ Live ============================

@Composable
fun LiveScreen(state: AppState) {
    val session = state.session
    if (session == null) { NotConnected(); return }
    val protocol = state.protocolOrNull()
    val previewUrl = protocol?.previewUrl(session)
    val st = state.deviceStatus

    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier.fillMaxWidth().height(240.dp).background(Color.Black),
            contentAlignment = Alignment.Center,
        ) {
            CameraPreviewView(previewUrl, Modifier.fillMaxSize())
        }

        Column(Modifier.verticalScroll(rememberScrollState())) {
            SectionCard("Status") {
                Row(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp)) {
                    StatChip("Battery", st?.battery?.let { "$it%" } ?: "—")
                    StatChip("Mode", st?.mode?.displayName ?: "—")
                    StatChip("REC", if (st?.recording == true) formatTime(st.videoTimeSec ?: 0) else "idle")
                    StatChip("SD free", st?.sdFreeMb?.let { "$it MB" } ?: "—")
                }
            }

            SectionCard("Mode") {
                Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    WorkMode.entries.forEach { m ->
                        val active = st?.mode == m
                        Box(Modifier.weight(1f)) {
                            CupertinoButton(
                                onClick = { state.setMode(m) },
                                enabled = !state.isBusy(Op.Mode),
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                CupertinoText(
                                    m.displayName,
                                    color = if (active) Color.White else Color(0xFF007AFF),
                                    fontWeight = FontWeight.Medium,
                                )
                            }
                        }
                    }
                }
            }

            SectionCard("Capture") {
                Column(Modifier.fillMaxWidth().padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    PrimaryButton("📷 Take photo", busy = state.isBusy(Op.Capture)) { state.capture() }
                    val recording = st?.recording == true
                    PrimaryButton(
                        if (recording) "⏹ Stop recording" else "⏺ Start recording",
                        busy = state.isBusy(Op.Record),
                    ) { state.record(!recording) }
                }
            }
        }
    }
}

@Composable
private fun StatChip(label: String, value: String) {
    Column(
        Modifier.padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CupertinoText(label.uppercase(), fontSize = 10.sp, color = Color(0xFF8E8E93))
        CupertinoText(value, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

private fun formatTime(sec: Int): String {
    val m = sec / 60; val s = sec % 60
    return pad(m) + ":" + pad(s)
}
private fun pad(n: Int) = if (n < 10) "0$n" else "$n"

// ============================ Files ============================

@Composable
fun FilesScreen(state: AppState) {
    if (state.session == null) { NotConnected(); return }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        SectionCard {
            Box(Modifier.fillMaxWidth().padding(12.dp)) {
                PrimaryButton("Refresh file list", busy = state.isBusy(Op.Refresh)) { state.refreshFiles() }
            }
        }

        if (state.downloads.isNotEmpty()) {
            SectionCard("Downloads") {
                state.downloads.forEach { d ->
                    DownloadRow(d)
                }
            }
        }

        SectionCard("Files on camera (${state.files.size})") {
            if (state.files.isEmpty()) {
                LabeledRow("No files", "Tap refresh")
            }
            state.files.forEach { f ->
                Column(Modifier.fillMaxWidth().clickable { }.padding(horizontal = 14.dp, vertical = 10.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            CupertinoText(f.name.substringAfterLast('/'), fontSize = 14.sp, fontWeight = FontWeight.Medium)
                            CupertinoText(
                                "${if (f.type == FileType.VIDEO) "Video" else "Photo"} · ${humanBytes(f.sizeBytes)}",
                                fontSize = 12.sp, color = Color(0xFF8E8E93),
                            )
                        }
                        CupertinoButton(onClick = { state.download(f) }, enabled = !state.isBusy(Op.Download)) {
                            CupertinoText("Get", color = Color(0xFF007AFF))
                        }
                        Spacer(Modifier.width(6.dp))
                        CupertinoButton(onClick = { state.deleteFile(f) }, enabled = !state.isBusy(Op.Delete)) {
                            CupertinoText("Del", color = Color(0xFFFF3B30))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DownloadRow(d: DownloadItem) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CupertinoText(d.file.name.substringAfterLast('/'), fontSize = 13.sp, modifier = Modifier.weight(1f))
            when (d.state) {
                DownloadItem.State.Running, DownloadItem.State.Queued -> CupertinoActivityIndicator(Modifier.size(16.dp))
                DownloadItem.State.Done -> CupertinoText("✓", color = Color(0xFF34C759))
                DownloadItem.State.Failed -> CupertinoText("failed", color = Color(0xFFFF3B30), fontSize = 12.sp)
            }
        }
        if (d.state == DownloadItem.State.Running || d.state == DownloadItem.State.Queued) {
            ProgressBar(d.progress)
        }
    }
}

@Composable
private fun ProgressBar(progress: Float) {
    Box(
        Modifier.fillMaxWidth().padding(top = 6.dp).height(4.dp)
            .clip(RoundedCornerShape(2.dp)).background(Color(0xFFE5E5EA)),
    ) {
        Box(
            Modifier.fillMaxWidth(progress.coerceIn(0f, 1f)).height(4.dp)
                .clip(RoundedCornerShape(2.dp)).background(Color(0xFF007AFF)),
        )
    }
}

// ============================ Settings ============================

@Composable
fun SettingsScreen(state: AppState) {
    if (state.session == null) { NotConnected(); return }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        SectionCard {
            Box(Modifier.fillMaxWidth().padding(12.dp)) {
                PrimaryButton("Reload settings", busy = state.isBusy(Op.Settings)) { state.loadSettings() }
            }
        }
        if (state.settings.isEmpty()) {
            SectionCard { LabeledRow("No settings", "Tap reload") }
        } else {
            SectionCard("Camera settings") {
                state.settings.forEach { s ->
                    SettingRow(state, s.id, s.title, s.value, s.options.map { it.value to it.label })
                }
            }
        }
    }
}

@Composable
private fun SettingRow(state: AppState, id: String, title: String, value: String, options: List<Pair<String, String>>) {
    val isBool = options.size == 2 && options.map { it.first }.toSet() == setOf("0", "1")
    if (isBool) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            CupertinoText(title, fontSize = 15.sp, modifier = Modifier.weight(1f))
            CupertinoSwitch(
                checked = value == "1",
                onCheckedChange = { state.setSetting(id, if (it) "1" else "0") },
                enabled = !state.isBusy(Op.Settings),
            )
        }
    } else if (options.isNotEmpty()) {
        Column(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 8.dp)) {
            CupertinoText(title, fontSize = 15.sp)
            Spacer(Modifier.height(6.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                options.forEach { (v, label) ->
                    val active = v == value
                    Box(
                        Modifier.clip(RoundedCornerShape(8.dp))
                            .background(if (active) Color(0xFF007AFF) else Color(0xFFF2F2F7))
                            .clickable(enabled = !state.isBusy(Op.Settings)) { state.setSetting(id, v) }
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                    ) {
                        CupertinoText(label, fontSize = 12.sp, color = if (active) Color.White else Color(0xFF333333))
                    }
                }
            }
        }
    } else {
        var draft by remember(value) { mutableStateOf(value) }
        Column(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 8.dp)) {
            CupertinoText(title, fontSize = 15.sp)
            Spacer(Modifier.height(6.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                CupertinoTextField(value = draft, onValueChange = { draft = it }, modifier = Modifier.weight(1f))
                Spacer(Modifier.width(8.dp))
                CupertinoButton(onClick = { state.setSetting(id, draft) }, enabled = !state.isBusy(Op.Settings)) {
                    CupertinoText("Save", color = Color(0xFF007AFF))
                }
            }
        }
    }
}
