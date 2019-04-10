/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.*;
import frc.robot.*;

public class Drivetrain extends Subsystem {
  //Initalize two sparks, one for left and one for right
  Spark leftSpark = null;
  Spark rightSpark = null;
  //Initalize WPILIB's DifferentialDrive 
  private DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    //Drive motor sparks mapped to a port inside robot map
    leftSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
    rightSpark = new Spark(RobotMap.DRIVETRAIN_RIGHT_SPARK);
    // Feed differential drive which sparks to use
    differentialDrive = new DifferentialDrive(leftSpark, rightSpark);
  }

  public void robotDrive(double moveSpeed, double rotateSpeed) {
    //Feed differential drive the speed for move and rotate which is inputted from controller
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void initDefaultCommand() {
    //Sets the default command to the driving code
    setDefaultCommand(new DriveArcade());
  }
}