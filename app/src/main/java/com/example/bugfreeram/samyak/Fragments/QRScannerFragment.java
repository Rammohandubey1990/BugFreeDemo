package com.example.bugfreeram.samyak.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bugfreeram.samyak.Custom.MyDialogFragment;
import com.example.bugfreeram.samyak.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRScannerFragment extends Fragment implements ZXingScannerView.ResultHandler {
    private static final int CAMERA_REQUEST_CODE = 100;
    public TextView tv_qr_print;
    Context context;
    Context mContext;
    MyDialogFragment myDialogFragment;
    private ZXingScannerView mScannerView;
    private LinearLayout qrCameraLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.qrscanner_layout, container, false);
        qrCameraLayout = (LinearLayout) fragmentView.findViewById(R.id.ll_qrcamera);
        tv_qr_print = (TextView) fragmentView.findViewById(R.id.tv_qr_print);
        mScannerView = new ZXingScannerView(getActivity().getApplicationContext());
        mScannerView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        qrCameraLayout.addView(mScannerView);
        showCamera();
        return fragmentView;

    }

    @Override
    public void handleResult(Result result) {

        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getActivity().getApplicationContext(), notification);
            r.play();
            tv_qr_print.setText(result.getText());
            Toast.makeText(getActivity(), result.getText(),
                    Toast.LENGTH_SHORT).show();


            AlertDialog.Builder StopDialog = new AlertDialog.Builder(getActivity());
            StopDialog.setTitle("Scan Result : ");
            StopDialog.setMessage(result.getText());
            StopDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    dialog.dismiss();
                }
            });
            StopDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "To be Added", Toast.LENGTH_SHORT).show();

                }
            });
            StopDialog.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Closes box
                    dialog.dismiss();
                }
            });
            AlertDialog alert = StopDialog.create();
            alert.show();
        } catch (Exception e) {
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
        mScannerView.stopCameraPreview();
    }

    private void showCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        CAMERA_REQUEST_CODE);
            } else {
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == CAMERA_REQUEST_CODE
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
    }
}