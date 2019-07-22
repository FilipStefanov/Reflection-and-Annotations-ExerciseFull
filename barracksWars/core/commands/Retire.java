package barracksWars.core.commands;

import barracksWars.interfaces.Repository;

import barracksWars.interfaces.UnitFactory;

public class Retire extends Command{
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String result = "No such units in repository.";

        try {
            this.getRepository().removeUnit(this.getData()[1]);
        }catch (IllegalArgumentException e){
         return result;
        }

        return  this.getData()[1] + " retired!";
    }
}
