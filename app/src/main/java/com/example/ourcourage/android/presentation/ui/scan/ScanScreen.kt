package com.example.ourcourage.android.presentation.ui.scan

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.zxing.BarcodeFormat
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.journeyapps.barcodescanner.DefaultDecoderFactory

@Composable
fun QrCodeScanScreen(
    modifier: Modifier,
    onSuccessQrScan: () -> Unit,
) {
    val context = LocalContext.current
    AndroidView(
        factory = { ctx ->
            val barcodeView =
                DecoratedBarcodeView(ctx).apply {
                    setDecoderFactory(DefaultDecoderFactory(listOf(BarcodeFormat.QR_CODE)))
                    resume() // 카메라 시작

                    decodeContinuous(
                        object : BarcodeCallback {
                            override fun barcodeResult(result: BarcodeResult) {
                                // QR 코드가 인식되었을 때의 처리 로직
                                onSuccessQrScan()
                                Toast.makeText(context, "스캔된 QR 코드: ${result.result.text}", Toast.LENGTH_SHORT).show()
                                pause() // 스캔 후 일시 정지 (필요 시)
                            }

                            override fun possibleResultPoints(resultPoints: List<ResultPoint>) {}
                        },
                    )
                }
            barcodeView // DecoratedBarcodeView 반환
        },
        modifier = modifier,
    )
}
