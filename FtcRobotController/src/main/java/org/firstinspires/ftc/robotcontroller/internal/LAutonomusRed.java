package org.firstinspires.ftc.robotcontroller.internal;

import android.app.DownloadManager;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import  com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
@Autonomous(name="LautoRed")
public class LAutonomusRed extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor Raise;
    DcMotor Pull;
    Servo knocker;
    Servo Lclose;
    Servo Rclose;
    ColorSensor Jewel;

    public void forward(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void right(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    public void left(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);
    }

    public void backwards(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
    }
    public void jewel(double power) {
    knocker.setPosition(0.5);

        if (Jewel.blue() == 0 && Jewel.red() > 0);
        {
            forward(1);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                telemetry.addData("Error", "Failed to Sleep");
            }
        }

        if(Jewel.blue() > 0 && Jewel.red() == 0) {
            backwards(1);
            try {
                Thread.sleep(150);
            }
            catch (InterruptedException e) {
                telemetry.addData("Error", "Failed to Sleep");
            }
        }

        if(Jewel.blue() == 0 && Jewel.red() == 0 || Jewel.blue() > 0 && Jewel.red() > 0) {
            knocker.setPosition(0);
        }
    }

    public void grab(double power) {
        Lclose.setPosition(0.2);
        Rclose.setPosition(0.8);
    }
    public void open(double power) {
        Lclose.setPosition(0.8);
        Rclose.setPosition(0.2);
    }
    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.dcMotor.get("FrontLeft");
        frontRight = hardwareMap.dcMotor.get("FrontRight");
        backLeft = hardwareMap.dcMotor.get("BackLeft");
        backRight = hardwareMap.dcMotor.get("BackRight");
        Raise = hardwareMap.dcMotor.get("Raise");
        Pull = hardwareMap.dcMotor.get("Pull");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        Raise.setDirection(DcMotorSimple.Direction.FORWARD);
        Pull.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Raise.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Pull.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Raise.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Pull.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        while (!isStarted()) ;
        jewel(1);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            telemetry.addData("Error", "Failed to Sleep");
        }
        forward(1);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            telemetry.addData("Error", "Failed to Sleep");
        }

        requestOpModeStop();
    }
}


