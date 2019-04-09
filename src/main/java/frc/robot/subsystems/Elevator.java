/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.ElevatorDrive;
/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  Spark elevatorMotor = null;

  public Elevator() {
    elevatorMotor = new Spark(RobotMap.ELEVATOR_MOTOR_SPARK);
  }

  public void driveElevator(double elevateSpeed){
    elevatorMotor.set(elevateSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorDrive());
  }
}
