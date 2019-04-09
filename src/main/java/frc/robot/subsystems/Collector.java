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
  DoubleSolenoid actuateSolenoid = null;
  Spark clawMotor = null;
  
  public Collector() {
    actuateSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_SOLENOID_OPEN, RobotMap.COLLECTOR_SOLENOID_CLOSE);
    clawMotor = new Spark(RobotMap.CLAW_MOTOR_SPARK);
  }

  public void actuateCollector() {
    actuateSolenoid.set(Value.kForward);
  }
  
  public void intakeCollector(double intakeSpeed) {
      clawMotor.set(intakeSpeed);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CollectorDrive());
  }
}
