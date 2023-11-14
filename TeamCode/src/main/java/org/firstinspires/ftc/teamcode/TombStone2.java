/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class TombStone2 extends LinearOpMode {

    DcMotor left, right, death;

    @Override
    public void runOpMode() {

        left = hardwareMap.get(DcMotor.class, "Left" );
        right = hardwareMap.get(DcMotor.class, "Right");
        death = hardwareMap.get(DcMotor.class, "Death");
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        waitForStart();
        
        while (opModeIsActive()) {
            double r = gamepad1.right_stick_y;
            double l = gamepad1.left_stick_y;
            
            
            death.setPower(1);
            left.setPower(r);
            right.setPower(-l);
            
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}
*/