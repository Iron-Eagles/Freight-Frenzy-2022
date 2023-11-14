/*
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.List;
 
@TeleOp(name="DO NOT USE", group="Linear Opmode")

public class DriverControlled extends LinearOpMode {
    
    DcMotor leftFront, rightFront, rightBack, leftBack, armLift;
    Servo claw;
    ElapsedTime runtime = new ElapsedTime();
    
    double s = 0;
    double lift = 0;
    double rate = 0.001;
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        armLift = hardwareMap.get(DcMotor.class, "ArmLift");
        claw = hardwareMap.get(Servo.class, "Claw");
        
        leftFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        armLift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        
        leftFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        armLift.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        
        claw.setPosition(0);
        
        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            
            double lX1, lY1, rX1, rY1, lift;
            
            lX1 = gamepad1.left_stick_x;
            lY1 = gamepad1.left_stick_y;
            rX1 = gamepad1.right_stick_x;
            rY1 = gamepad1.right_stick_y;
            
            double a = lY1 + lX1;
            double b = rY1 - lX1;
            double c = lY1 - lX1;
            double d = rY1 + lX1;
            
            a = Range.clip(a, -1, 1);
            b = Range.clip(b, -1, 1);
            c = Range.clip(c, -1, 1);
            d = Range.clip(d, -1, 1);
            
            leftFront.setPower(a);
            rightFront.setPower(b);
            leftBack.setPower(c);
            rightBack.setPower(d);
            
            
            s -= gamepad1.left_trigger * rate;
            s += gamepad1.right_trigger * rate;
            
            if (gamepad1.a) {
                s = 0.2;
            }
            
            
            if (gamepad1.left_bumper) {
                lift = -1;
            } else if (gamepad1.right_bumper) {
                lift = 1;
            } else {
                lift = 0;
            }
            
            s = Range.clip(s, 0, 1);
            
            armLift.setPower(lift);
            claw.setPosition(s);
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
*/