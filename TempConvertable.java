package minh_nguyen;

/*
Program Name: TempConvertable.java
	Author: Ming
	Date: Aug. 22, 2019 3:51:06 p.m.
Description: 
*/
public interface TempConvertable
{
	 final double ABS_ZERO_K=0;
	 final double ABS_ZERO_C=-273.15;
	 final double ABS_ZERO_F=-459.66999999999996;

	  public abstract double convertFtoC(double fTemp);
	  public abstract double convertCtoF(double cTemp);
	  public abstract double convertCtoK(double cTemp);
	  public abstract double convertKtoC(double kTemp);
	  public abstract double convertFtoK(double fTemp);
	  public abstract double convertKtoF(double kTemp);



}
