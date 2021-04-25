package vehiclerentalservice.service;

import vehiclerentalservice.models.Branch;
import vehiclerentalservice.models.Vehicle;
import vehiclerentalservice.storage.DataStore;

import java.util.*;

/*

 */
public class VehicleService {
    public void execute(String command){
        //addbranch#gachibowli#1,suv,12#3,sedan,10#3,bikes,20

        String[] tokens = command.split("#");
        if(tokens[0].equalsIgnoreCase("addbranch")){
            addBranch(tokens);
        }else if(tokens[0].equalsIgnoreCase("addvehicle")){
            addvehicle(tokens);
        }else if(tokens[0].equalsIgnoreCase("rentvehicle")){
            rentvehicle(tokens);
        }else if(tokens[0].equalsIgnoreCase("getavailable")){

        }else if(tokens[0].equalsIgnoreCase("printsystemview")){
            printsystemview();
        }
    }

    private void addBranch(String[] tokens){
        //gachibowli#1,suv,12#3,sedan,10#3,bikes,20
        Branch branch = new Branch(tokens[1]);
        for(int i=2; i<tokens.length; i++ ){
            String[] attr = tokens[i].split(",");
            Vehicle v = new Vehicle(attr[0], attr[1], attr[2], branch.getName());
            branch.addVehicle(v);
        }
        if(!DataStore.branchWithCapacity.containsKey(branch.getName())){
            DataStore.branches.add(branch);
            DataStore.branchWithCapacity.put(branch.getName(), branch.getVehicles());
        }
    }

    private void addvehicle(String[] tokens){
        //gachibowli#1#suv

        if(DataStore.branchWithCapacity.containsKey(tokens[1])){
            for(Vehicle v : DataStore.branchWithCapacity.get(tokens[1])){
                if(v.getType().equalsIgnoreCase(tokens[3])){
                    v.setCount(v.getCount()+Integer.parseInt(tokens[2]));
                }
            }
        }else{
            System.err.println("Invalid branch");
        }
    }

    private void rentvehicle(String[] tokens){
        List<Vehicle> desired = new ArrayList<>();

        for(Map.Entry<String , List<Vehicle>> entry : DataStore.branchWithCapacity.entrySet()){
            for(Vehicle v : entry.getValue()){
                if(v.getType().equalsIgnoreCase(tokens[1])){
                    desired.add(v);
                }
            }
        }
        Collections.sort(desired,(a, b) -> (int) (a.getRent() - b.getRent()));
        for (Vehicle v : desired){
            if(v.getCount() > 0 && !v.isBooked()){
                System.out.println("Booked from "+v.getBranch());
                v.setBooked(true);
                v.setCount(v.getCount() - 1);
                return;
            }
        }
        System.out.println("No availability");

        //System.out.println("Vehicle to rent is : "+ desired.get(0));

    }

    private void getavailable(String[] tokens){

    }

    private void printsystemview(){
        for(Map.Entry<String , List<Vehicle>> entry : DataStore.branchWithCapacity.entrySet()){
            System.out.println("\t -> "+entry.getKey());
            for(Vehicle v : entry.getValue()){
                if(v.getCount() == 0){
                    System.out.println("\t\t * All "+v.getType() + " are booked.");
                }else{
                    System.out.println("\t\t * "+v.getCount()+" "+v.getType() + " are available for Rs "+v.getRent());
                }

            }
        }
    }
}
