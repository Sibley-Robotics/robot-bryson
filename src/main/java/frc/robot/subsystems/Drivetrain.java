/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark leftFrontSpark = null;
  Spark leftBackSpark = null;
  Spark rightFrontSpark = null;
  Spark rightBackSpark = null;

private DifferentialDrive differentialDrive = null;

public Drivetrain() {
    //Drive motor sparks
leftFrontSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_FRONT_SPARK);
//leftBackSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_BACK_SPARK);
rightFrontSpark = new Spark(RobotMap.DRIVETRAIN_RIGHT_FRONT_SPARK);
//rightBackSpark = new Spark(RobotMap.DRIVETRAIN_RIGHT_BACK_SPARK);



differentialDrive = new DifferentialDrive(leftFrontSpark, rightFrontSpark);
}
  

public void robotDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
}

  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
