/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BiobuzzShooter;
import org.firstinspires.ftc.teamcode.Chassis;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="7462 Teleop Chassis", group= "Robot")
public class MecanumTeleOpChassis extends OpMode {

    Chassis chassis;
    BiobuzzShooter shooter;

    @Override
    public void init() {
        chassis = new Chassis(hardwareMap);

        shooter = new BiobuzzShooter(hardwareMap, "shooter", true);
        //shooter.setControllerValues(0.3, 0.0243);
        //Need to set control values, last years 7462 values left in currently
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        chassis.setMaxSpeed(1);
    }

    @Override
    public void loop() {

        shooter.overridePower();

        //TELEMETRY

        telemetry.addData("Shooter Velo", shooter.getVelocity());
        //telemetry.addData("Shooter Target Velo", shooter.targetVelocity);
        //


        //CONTROLS (edit later)

        if (gamepad1.aWasPressed()) {
            chassis.frontLeftDrive.setPower(1);
        }
        else if (gamepad1.aWasReleased()) {
            chassis.frontLeftDrive.setPower(0);
        }

        if (gamepad1.bWasPressed()) {
            chassis.frontRightDrive.setPower(1);
        }
        else if (gamepad1.bWasReleased()) {
            chassis.frontRightDrive.setPower(0);
        }

        if (gamepad1.yWasPressed()) {
            chassis.backLeftDrive.setPower(1);
        }
        else if (gamepad1.yWasReleased()) {
            chassis.backLeftDrive.setPower(0);
        }

        if (gamepad1.x) {
            chassis.backRightDrive.setPower(1);
        }
        else {
            chassis.backRightDrive.setPower(0);
        }

        chassis.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }

}
