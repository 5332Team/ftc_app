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
    private DcMotor Knocker;
    private DcMotor Raise;
    private DcMotor Pull;
    private Servo Release;
    private Servo Rclose;
    private Servo Lclose;
    private Servo Relic;
    @Override
    public void init() {
        //dcMotors setting
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        Raise = hardwareMap.dcMotor.get("Raise");
        Pull = hardwareMap.dcMotor.get("Pull");
        Knocker = hardwareMap.dcMotor.get("Knock");
        Release = hardwareMap.servo.get("Release");
        Rclose = hardwareMap.servo.get("Rclose");
        Lclose = hardwareMap.servo.get("Lclose");
        Relic = hardwareMap.servo.get("Relic");


        //If wrong change to REVERSE

        FrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        Raise.setDirection(DcMotorSimple.Direction.FORWARD);
        Pull.setDirection(DcMotorSimple.Direction.REVERSE);
        Knocker.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Raise.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Pull.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Knocker.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Raise.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Pull.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Knocker.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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
      if(gamepad1.left_bumper) {
          Release.setPosition(0.5);
      }
      if (gamepad1.right_bumper)
          Pull.setPower(1);
      if(gamepad1.dpad_up){
          Raise.setPower(1);
          //attach facing same orientation as wheels
      }
      if (gamepad1.dpad_down) {
          Raise.setPower(-1);
      }
      if (gamepad1.a) {
          Lclose.setPosition(0.6);
          Rclose.setPosition(0.6);
      }
      if (gamepad1.b) {
          Lclose.setPosition(0);
          Rclose.setPosition(0);
      }
      if(gamepad1.y) {
          Relic.setPosition(1);
      }
        telemetry.addData("Loop", "Running" );
    }

}