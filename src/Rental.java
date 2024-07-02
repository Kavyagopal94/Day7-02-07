public class Rental 
{
	Vehicle vehicle;
    int rentalDays;

    Rental(Vehicle vehicle, int rentalDays) 
    {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        vehicle.isRented = true;
    }

    void returnVehicle() 
    {
        vehicle.isRented = false;
    }

    double calculateCharges() 
    {
        double rate = vehicle.type.equals("Car") ? 50.0 : 20.0;
        return rate * rentalDays;
    }

}
