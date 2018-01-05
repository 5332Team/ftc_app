package org.firstinspires.ftc.robotcontroller.internal.Robot2k17;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeleOp", group = "freshman17")
public class Teleop extends LinearOpMode
{


    //DcMotors Variables
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor RaiseArmL;
    private DcMotor RaiseArmR;
    private DcMotor clawRotate;
    private DcMotor Slide;
    private Servo FlyWheelL;
    private Servo FlyWheelR;
    private Servo RcloseBottum;
    private Servo LcloseTop;
    private Servo RcloseTop;
    private Servo LcloseBottum;
    private Servo ClawLevel;

    public void open(){
    LcloseBottum.setPosition(1);
    }

    @Override
    public void runOpMode () throws InterruptedException {

        //dcMotors setting
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        RaiseArmL = hardwareMap.dcMotor.get("RaiseL");
        RaiseArmR = hardwareMap.dcMotor.get("RaiseR");
        Slide = hardwareMap.dcMotor.get("Slide");
        clawRotate = hardwareMap.dcMotor.get("RotateClaw");
        FlyWheelL = hardwareMap.servo.get("PullL");
        FlyWheelR = hardwareMap.servo.get("PullR");
        RcloseBottum = hardwareMap.servo.get("RcloseBottum");
        LcloseBottum = hardwareMap.servo.get("LcloseBottum");
        RcloseTop = hardwareMap.servo.get("RcloseTop");
        LcloseTop = hardwareMap.servo.get("LcloseTop");
         ClawLevel = hardwareMap.servo.get("Level");


        //If wrong change to REVERSE
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        RaiseArmL.setDirection(DcMotor.Direction.REVERSE);
        RaiseArmR.setDirection(DcMotor.Direction.FORWARD);
        Slide.setDirection(DcMotor.Direction.FORWARD);
        clawRotate.setDirection(DcMotor.Direction.FORWARD);

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RaiseArmL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RaiseArmR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Slide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawRotate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RaiseArmL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RaiseArmR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        clawRotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        open();

        waitForStart();


        while (opModeIsActive()) {

            //controller 1 controls

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


            //controller 2 controls

            //Lin slide
            if(gamepad2.left_bumper) {
                Slide.setPower(-1);
            }
            if (gamepad2.right_bumper) {
                Slide.setPower(1);
            }
            //Rotate claw
            if(gamepad2.a) {
                clawRotate.setTargetPosition(180);
            }
            if(gamepad2.b) {
                clawRotate.setTargetPosition(0);
            }
            //Raising Claw
            if (gamepad2.left_stick_y !=0) {
                RaiseArmL.setPower(gamepad2.left_stick_y);
                RaiseArmR.setPower(gamepad2.left_stick_y);
            }
            //Leveling
            if (gamepad2.right_stick_y !=0) {
                ClawLevel.setPosition(ClawLevel.getPosition() + 0.01);
            }
            //Grabbing
            if(gamepad2.right_trigger !=0) {
                if (clawRotate.getCurrentPosition() == 360 || clawRotate.getCurrentPosition() == 1)
                    LcloseTop.setPosition(LcloseTop.getPosition() + 0.025);
                    RcloseTop.setPosition(RcloseTop.getPosition() - 0.025);
            }
                else if (clawRotate.getCurrentPosition() == 180) {
                    LcloseBottum.setPosition( LcloseBottum.getPosition() - 0.025);
                    RcloseBottum.setPosition(RcloseBottum.getPosition() + 0.025);
                }
                else {
                LcloseBottum.setPosition( LcloseBottum.getPosition() - 0.025);
                RcloseBottum.setPosition(RcloseBottum.getPosition() + 0.025);
                LcloseTop.setPosition(LcloseTop.getPosition() + 0.025);
                RcloseTop.setPosition(RcloseTop.getPosition() - 0.025);
                }
           //open claw
            if(gamepad2.left_trigger !=0) {
                if (clawRotate.getCurrentPosition() == 360 || clawRotate.getCurrentPosition() == 1)
                    LcloseTop.setPosition(LcloseTop.getPosition() - 0.025);
                RcloseTop.setPosition(RcloseTop.getPosition() + 0.025);
            }
            else if (clawRotate.getCurrentPosition() == 180) {
                LcloseBottum.setPosition( LcloseBottum.getPosition() + 0.025);
                RcloseBottum.setPosition(RcloseBottum.getPosition() - 0.025);
            }
            else {
                LcloseBottum.setPosition( LcloseBottum.getPosition() + 0.025);
                RcloseBottum.setPosition(RcloseBottum.getPosition() + 0.025);
                LcloseTop.setPosition(LcloseTop.getPosition() - 0.025);
                RcloseTop.setPosition(RcloseTop.getPosition() + 0.025);
            }




        }
    }
}






