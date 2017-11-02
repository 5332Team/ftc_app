package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="TeleOp", group = "freshman17")
public class Teleop extends LinearOpMode
{


    //DcMotors Variables
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor Raise;
    private Servo Rclose;
    private Servo Lclose;
    private Servo knocker;

    public void open(){
        Lclose.setPosition(.8);
        Rclose.setPosition(0.2);
    }

    @Override
    public void runOpMode () throws InterruptedException {

        //dcMotors setting
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        Raise = hardwareMap.dcMotor.get("Raise");
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        //Pull = hardwareMap.dcMotor.get("Pull");
        // Knocker = hardwareMap.dcMotor.get("Knock");
        // RelicP = hardwareMap.dcMotor.get("RelicPull");
        //RelicR = hardwareMap.dcMotor.get("RelicExtend");
        Rclose = hardwareMap.servo.get("Rclose");
        Lclose = hardwareMap.servo.get("Lclose");
        //       Relic = hardwareMap.servo.get("Relic");
        //     RelicClaw = hardwareMap.servo.get("Rclaw");
        //   RelicGrab = hardwareMap.servo.get("Rgrab");


        //If wrong change to REVERSE
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        Raise.setDirection(DcMotor.Direction.FORWARD);
        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Raise.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Raise.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        open();

        waitForStart();


        while (opModeIsActive())//Motor Movement
        {

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

            if (gamepad1.right_stick_y ==1) {
                Raise.setPower(1);
            }
            else if (gamepad1.right_stick_y== -1) {
                Raise.setPower(-1);
            }
            else {
                Raise.setPower(0);
            }



            if (gamepad1.b) {
                if(Lclose.getPosition() < 1) {
                    Lclose.setPosition(Lclose.getPosition() + 0.1);
                }
                if(Rclose.getPosition() > 0) {
                    Rclose.setPosition(Rclose.getPosition() - 0.1);
                }
            }
            else if(gamepad1.y) {
                if(Lclose.getPosition() > 0) {
                    Lclose.setPosition(Lclose.getPosition() - 0.1);
                }
                if(Rclose.getPosition() < 1) {
                    Rclose.setPosition(Rclose.getPosition() + 0.1);
                }
            }


        }
    }
}






