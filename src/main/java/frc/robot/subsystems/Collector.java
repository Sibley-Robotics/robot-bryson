/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.CollectorDrive;

public class Collector extends Subsystem {
  //Declaring the solenoid and the spark for the claw motors
  DoubleSolenoid actuateSolenoid = null;
  Spark clawMotor = null;
  
  public Collector() {
    //Mapping the open state to one port and closed to another
    actuateSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_SOLENOID_OPEN, RobotMap.COLLECTOR_SOLENOID_CLOSE);
    //Mapping which port the claw motor spark is on
    clawMotor = new Spark(RobotMap.CLAW_MOTOR_SPARK);
  }

  public void actuateCollector() {
    //Sets the collector to actuate
    actuateSolenoid.set(Value.kForward);
  }
  
  public void intakeCollector(double intakeSpeed) {
    //The method feeds a parameter being the speed, which is then set for the spark motor speed
    clawMotor.set(intakeSpeed);
  }

  public void initDefaultCommand() {
    //Runs the CollectorDrive command by default i.e. at startup
    setDefaultCommand(new CollectorDrive());
  }
}
