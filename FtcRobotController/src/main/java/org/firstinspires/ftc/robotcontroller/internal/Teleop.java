package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Teleop", group="freshmen2k16")
public class Teleop extends OpMode {
    //DcMotors Variables
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor LaunchL;
    private DcMotor LaunchR;
    private DcMotor load;
    private Servo block;
    private DcMotor Zip;

    @Override
    public void init() {
        //dcMotors setting
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        LaunchL = hardwareMap.dcMotor.get("LaunchL");
        LaunchR = hardwareMap.dcMotor.get("LaunchR");
        load = hardwareMap.dcMotor.get("load");
        block = hardwareMap.servo.get("bolck");
        Zip = hardwareMap.dcMotor.get("Zip");


        //If wrong change to REVERSE
        Zip.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        LaunchL.setDirection(DcMotorSimple.Direction.FORWARD);
        LaunchR.setDirection(DcMotorSimple.Direction.REVERSE);
        load.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LaunchR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LaunchL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        load.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Zip.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LaunchL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LaunchR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        load.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Zip.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.addData("Init", "Init Completed");
    }
    @Override
    public void start() {

    }

    @Override
    public void loop () {
        //Motor Movement
        if (gamepad1.left_trigger != 0 || gamepad1.right_trigger !=0) {
            FrontLeft.setPower(gamepad1.left_trigger-gamepad1.right_trigger);
            BackLeft.setPower(gamepad1.left_trigger-gamepad1.right_trigger);
            FrontRight.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
            BackRight.setPower(gamepad1.right_trigger-gamepad1.left_trigger);

        }
        else {
            FrontLeft.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y);
            BackRight.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y);
            BackLeft.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y);
            FrontRight.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y);
        }
        if (gamepad1.right_bumper) {
            LaunchL.setPower(1);
            LaunchR.setPower(1);
        }
        if(gamepad1.right_bumper) {
            LaunchL.setPower(0);
            LaunchR.setPower(0);
        }
        if(gamepad1.left_bumper) {
            load.setPower(1);
        }
        if(gamepad1.left_bumper) {
            load.setPower(0);
        }
        if(gamepad1.a) {
            block.setPosition(1);
        }
        if (gamepad1.b) {
            block.setPosition(0.5);
        }
        if(gamepad1.x) {
            Zip.setPower(1);
        }
        if(gamepad1.y) {
            Zip.setPower(0);
        }

        telemetry.addData("Loop", "Running" );
    }

}