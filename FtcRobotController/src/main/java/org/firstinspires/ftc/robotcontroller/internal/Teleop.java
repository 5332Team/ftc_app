package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Teleop", group="freshmen2k16")
public class Teleop extends OpMode {
    //DcMotors Variables
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
   // private DcMotor RelicR;
    private DcMotor Raise;
   // private DcMotor RelicP;
    //private DcMotor Knocker;

    //servo Var

    private Servo Rclose;
    private Servo Lclose;
   // private Servo RelicClaw;
   // private Servo RelicGrab;
    //End of Classifying
    @Override
    public void init() {
        //dcMotors setting
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        Raise = hardwareMap.dcMotor.get("Raise");
        //RelicP = hardwareMap.dcMotor.get("RelicPull");
        //RelicR = hardwareMap.dcMotor.get("RelicExtend");
        Rclose = hardwareMap.servo.get("Rclose");
        Lclose = hardwareMap.servo.get("Lclose");
       // RelicClaw = hardwareMap.servo.get("Rclaw");
        //RelicGrab = hardwareMap.servo.get("Rgrab");



        //If wrong change to REVERSE

        FrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        Raise.setDirection(DcMotorSimple.Direction.FORWARD);
       // RelicP.setDirection(DcMotorSimple.Direction.REVERSE);
       // RelicR.setDirection(DcMotorSimple.Direction.FORWARD);
        //Knocker.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Raise.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // RelicP.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //RelicR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Raise.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     //   RelicR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //RelicP.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

       // RelicClaw.setPosition(0);
       // RelicGrab.setPosition(1);
        Lclose.setPosition(0);
        Rclose.setPosition(0);
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
      if (gamepad1.a) {
          Lclose.setPosition(1);
          Rclose.setPosition(0);
      }
      if (gamepad1.b) {
          Lclose.setPosition(0);
          Rclose.setPosition(1);
      }
      if(gamepad1.right_stick_y != 0); {
          Raise.setPower(gamepad1.right_stick_y);
        }
        telemetry.addData("Loop", "Running" );
    }

}