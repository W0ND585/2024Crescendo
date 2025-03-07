package frc.robot;

import com.pathplanner.lib.util.PIDConstants;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Units;

import frc.lib.config.SwerveModuleConstants;

public final class Constants {

  public static final class ClimbConstants {
    public static final int leftClimbMotorID = 19;
    public static final int rightClimbMotorID = 20;
    public static final double climbSpeed = 1;
  }

  public static final class IntakeConstants {
    public static final int intakeMotorID = 13;
    public static final int deployMotorID = 14;
    public static final double intakeSpeed = -0.6;
    public static final double deploySpeed = -0.2;
    public static final double retractSpeed = 0.2;
    public static double intakeRotations;
    public static final PIDConstants deployPID = new PIDConstants(0, 0, 0);

    //TODO: get the right rotations for deploy intake/intake note commands
    public static final double deployRotations = 0.63;
    public static final double retractRotations = -0.17;
    public static final int beamBreakPort = 0;
    //public static final int retractLimitSwitchPort = 3;
    public static final int deployLimitSwitchPort = 1;
  }
  
  public static final class ShooterConstants {
    //TODO: change me
    public static final int leftKickerMotorId = 15;
    public static final int rightKickerMotorId = 16;
    public static final int leftFeederMotorID = 17;
    public static final int rightFeederMotorId = 18;

    public static final PIDConstants leftPID = new PIDConstants(0.2, 0, 0);
    public static final PIDConstants rightPID = new PIDConstants(0.2, 0, 0);

    public static final Measure<Distance> wheelRadius = Units.Inches.of(10/2);
  }

  public static final class Swerve {
    public static final double stickDeadBand = 0.1;
    public static final int pigeonID = 13;
    public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-

    /* Autonomous Speeds */
    
    /* Drivetrain Constants */
    //TODO: verify this is correct
    public static final double trackWidth = Units.Inches.of(29).in(Units.Meters);
    public static final double wheelBase = Units.Inches.of(29).in(Units.Meters);
    public static final double wheelDiameter = Units.Inches.of(4.0).in(Units.Meters);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double openLoopRamp = 2;
    public static final double closedLoopRamp = 0.0; // seem to be useless

    public static final double driveGearRatio = (6.75 / 1.0); // 6.75:1 for L2

    public static final double angleGearRatio = (12.8 / 1.0); // 12.8:1 for all L's

    public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
        new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
        new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Swerve Compensation */
    public static final double voltageComp = 12.0;

    /* Swerve Current Limiting */
    public static final int angleContinuousCurrentLimit = 20;
    public static final int driveContinuousCurrentLimit = 50;

    /* TODO: test Angle Motor PID Values (these are default, may tune if needed) */
    public static final double angleKP = 0.01;
    public static final double angleKI = 0.0;
    public static final double angleKD = 0.0;
    public static final double angleKFF = 0.0;

    /* Drive Motor PID Values */
    public static final double driveKP = 0.0; // TODO: Tune after charactarization
    public static final double driveKI = 0.0; // leave
    public static final double driveKD = 0.0; // leave
    public static final double driveKFF = 0.0; // leave

    /* TODO: Charactarize drivetrain Drive Motor Characterization Values */
    public static final double driveKS = 0.0;
    public static final double driveKV = 0.0;
    public static final double driveKA = 0.0;

    /* Drive Motor Conversion Factors */
    public static final double driveConversionVelocityFactor = ((wheelDiameter * Math.PI) / driveGearRatio) / 60.0;
    public static final double angleConversionFactor = 360.0 / angleGearRatio;

    /* TODO: set Swerve Profiling Values */
    // private static final double SPEED_MULTIPLIER = 0.2;
    public static final double maxSpeed = 5.5; // meters per second
    public static final double maxAngularVelocity = 5; // TODO: Tune

    /* Neutral Modes */
    public static final IdleMode angleNeutralMode = IdleMode.kBrake;
    public static final IdleMode driveNeutralMode = IdleMode.kBrake;

    // public static final boolean driveInvert = true;
    public static final boolean angleInvert = false;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    public static final class Mod0 {
      public static final int driveMotorID = 1;
      public static final int angleMotorID = 2;
      public static final int canCoderID = 9;

      public static final boolean driveInvert = false;
      public static final double offsetDegree = 331.69;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(offsetDegree);
      public static final Rotation2d balanceOffset = Rotation2d.fromDegrees(offsetDegree + 45);
      public static final double conversionFactor = 0.060509807;

      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveInvert, driveMotorID,
          angleMotorID,
          canCoderID, angleOffset);
    }

    /* Front Right Module - Module 1 */
    public static final class Mod1 {
      public static final boolean driveInvert = false;
      public static final int driveMotorID = 3;
      public static final int angleMotorID = 4;
      public static final int canCoderID = 10;

      public static final double offsetDegree = -103.5;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(offsetDegree);
      public static final Rotation2d balanceOffset = Rotation2d.fromDegrees(offsetDegree - 45);
      public static final double conversionFactor = 0.060509807;

      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveInvert, driveMotorID,
          angleMotorID,
          canCoderID, angleOffset);
    }

    /* Back Left Module - Module 2 */
    public static final class Mod2 {
      public static final boolean driveInvert = true;
      public static final int driveMotorID = 7;
      public static final int angleMotorID = 8;
      public static final int canCoderID = 12;

      public static final double offsetDegree = -161.89;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(offsetDegree);
      public static final Rotation2d balanceOffset = Rotation2d.fromDegrees(offsetDegree + 45);
      public static final double conversionFactor = 0.060509807;

      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveInvert, driveMotorID,
          angleMotorID,
          canCoderID, angleOffset);
    }

    /* Back Right Module - Module 3 */
    public static final class Mod3 {
      public static final boolean driveInvert = true;
      public static final int driveMotorID = 5;
      public static final int angleMotorID = 6;
      public static final int canCoderID = 11;

      public static final double offsetDegree = 58.26;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(offsetDegree);
      public static final Rotation2d balanceOffset = Rotation2d.fromDegrees(offsetDegree - 45);
      public static final double conversionFactor = 0.060509807;

      public static final SwerveModuleConstants constants = new SwerveModuleConstants(driveInvert, driveMotorID,
          angleMotorID,
          canCoderID, angleOffset);
    }
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3.25;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1.8;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;
  }


  /* LED Ports */
  public static final class LEDConstants {
    public static final int LED_PORT = 0;
    public static final int LED_LENGTH = 105;
  }
  public static final class ClawConstants{
  public static final int clawMotor = 50; 

  }
}
