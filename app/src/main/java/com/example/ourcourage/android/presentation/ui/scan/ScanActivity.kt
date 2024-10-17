package com.example.ourcourage.android.presentation.ui.scan

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ourcourage.android.R
import com.example.ourcourage.android.databinding.ActivityCustomScannerBinding
import com.example.ourcourage.android.util.BindingActivity
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class ScanActivity : BindingActivity<ActivityCustomScannerBinding>(R.layout.activity_custom_scanner) {
    private lateinit var barcodeScannerView: DecoratedBarcodeView
    private lateinit var captureManager: CaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        barcodeScannerView = binding.viewCustomScanner
        barcodeScannerView.setStatusText("")
        requestCameraPermission()
    }

    private fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                1,
            )
        } else {
            initializeScanner()
        }
    }

    private fun initializeScanner() {
        captureManager = CaptureManager(this, barcodeScannerView)
        captureManager.initializeFromIntent(intent, null)
        captureManager.decode()
    }

    override fun onSaveInstanceState(
        outState: Bundle,
        outPersistentState: PersistableBundle,
    ) {
        super.onSaveInstanceState(outState, outPersistentState)
        captureManager.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        if (captureManager != null) {
            captureManager.onResume()
        }
    }

    override fun onPause() {
        super.onPause()
        if (captureManager != null) {
            captureManager.onPause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (captureManager != null) {
            captureManager.onDestroy()
        }
    }
}
