/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * The number it is equal to is the PWM port on the RIO or number of axis from driverstation for controllers or CAN bus port for solenoid or talons
 */
public class RobotMap {
    //Drivetrain
  //Set which ports the drivetrain sparks are on
  public static final int DRIVETRAIN_LEFT_SPARK = 2;
  public static final int DRIVETRAIN_RIGHT_SPARK = 1;
      
    //Collector
  public static final int COLLECTOR_SOLENOID_OPEN = 0;
  public static final int COLLECTOR_SOLENOID_CLOSE = 1;
  public static final int CLAW_MOTOR_SPARK = 3;
    //Elevator
  public static final int ELEVATOR_MOTOR_SPARK = 4;
    
    //Joystick
  //Set which port the Driver Controller is on
  public static final int OI_DRIVER_CONTROLLER = 0;
  //Set which port from the driverstation interface is each axis
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 4;
  public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
  public static final int DRIVER_CONTROLLER_RIGHT_TRIGGER = 2;
  public static final int DRIVER_CONTROLLER_LEFT_TRIGGER = 3;
  public static final int DRIVER_CONTROLLER_LEFT_BUMPER = 5;
  public static final int DRIVER_CONTROLLER_RIGHT_BUMPER = 6;
}

// If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;