package no.experis.assignment3.exceptions;

public class FranchiseNotFoundException extends EntityNotFoundException{
    public FranchiseNotFoundException (int id){
        super("Franchise does not exist with ID: " + id);
    }
}
