import java.util.Scanner;
//-----------------------------------------------------------------------------
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Gather data
        System.out.print("Enter volume, moles, temperature : ")
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        volume = keyboard.nextDouble();

//----Calculations
        pressure = moles * GAS_CONSTANT * temperature / volume;

//----Display Results
        System.out.println("Pressure is " + pressure);
    }
//-----------------------------------------------------------------------------
//=============================================================================