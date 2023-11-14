package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.List;
 
@TeleOp(name=".Drive", group="Linear Opmode")

public class Drive extends LinearOpMode {
    
    DcMotor leftFront, rightFront, rightBack, leftBack, leftArmLift, rightArmLift;
    Servo Claw;
    ElapsedTime runtime = new ElapsedTime();
    
    double s = 1;
    double rate = 0.001;
    double wheelSpeed = 1, turbo = 1;
    boolean turboMode = false;
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        leftArmLift = hardwareMap.get(DcMotor.class, "LeftArmLift");
        rightArmLift = hardwareMap.get(DcMotor.class, "RightArmLift");
       
        Claw = hardwareMap.get(Servo.class, "Claw");
        
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftArmLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArmLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftArmLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightArmLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
     
        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            double lX1, lY1, rY1;
            
            lX1 = gamepad1.left_stick_x;
            lY1 = gamepad1.left_stick_y;
            rY1 = gamepad1.right_stick_y;
            
            double a = lY1 + lX1;
            double b = rY1 - lX1;
            double c = lY1 - lX1;
            double d = rY1 + lX1;
            
            a = Range.clip(a, -1, 1);
            b = Range.clip(b, -1, 1);
            c = Range.clip(c, -1, 1);
            d = Range.clip(d, -1, 1);
            
            if (gamepad1.guide) {
               turboMode = !turboMode; 
            }
            
            
            if (turboMode) {
                //turbo = 2;
            } else {
                //turbo = 1;
            }
            
            leftFront.setPower(a * wheelSpeed * turbo);
            rightFront.setPower(b * wheelSpeed * turbo);
            leftBack.setPower(c * wheelSpeed * turbo);
            rightBack.setPower(d * wheelSpeed * turbo);
            
            s += gamepad1.left_trigger * rate;
            s -= gamepad1.right_trigger * rate;
            
            if (gamepad1.a) {
                s = 0.53;
            }
            
            if (gamepad1.left_bumper) {
                leftArmLift.setPower(0.75);
                rightArmLift.setPower(-1);
            } else if (gamepad1.right_bumper) {
                leftArmLift.setPower(-1);
                rightArmLift.setPower(0.5);
            } else {
                leftArmLift.setPower(0);
                rightArmLift.setPower(0);
            }
            
            s = Range.clip(s, 0.25, .53);
            
            Claw.setPosition(s);
            
            telemetry.addData("Status", "Turbo: " + turboMode);
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
