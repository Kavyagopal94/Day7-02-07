public class RentalSystem 
{
	//array of objects called fleet
    static Vehicle[] fleet = new Vehicle[10];
    static int vehicleCount = 0;

    static void addVehicle(Vehicle vehicle)
    {
        if (vehicleCount < fleet.length)
        {
            fleet[vehicleCount++] = vehicle;
        } 
        else
        {
            System.out.println("Fleet is full, cannot add more vehicles.");
        }
    }

    static Vehicle findAvailableVehicle(String type)
    {
        for (int i = 0; i < vehicleCount; i++) 
        {
            if (fleet[i].type.equals(type) && !fleet[i].isRented)
            {
                return fleet[i];
            }
        }
        return null;
    }

    static void displayAvailableVehicles() 
    {
        for (int i = 0; i < vehicleCount; i++) 
        {
            if (!fleet[i].isRented) 
            {
                System.out.println(fleet[i].type + " ID: " + fleet[i].id);
            }
        }
    }

    public static void main(String[] args) 
    {
        addVehicle(new Car("C1"));
        addVehicle(new Bike("B1"));
        addVehicle(new Car("C2"));

        System.out.println("Available vehicles:");
        displayAvailableVehicles();

        Vehicle vehicleToRent = findAvailableVehicle("Car");
        
        if (vehicleToRent != null) 
        {
            Rental rental = new Rental(vehicleToRent, 3);
            System.out.println("Rented " + vehicleToRent.type + " ID: " + vehicleToRent.id + " for 3 days.");
            System.out.println("Charges: $" + rental.calculateCharges());
            rental.returnVehicle();
            System.out.println(vehicleToRent.type + " ID: " + vehicleToRent.id + " returned.");
        } 
        else
        {
            System.out.println("No available vehicles of the requested type.");
        }

        System.out.println("Available vehicles after return:");
        
        displayAvailableVehicles();
    }
}
