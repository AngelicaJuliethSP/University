package model;

public class FullTimeTeacher extends Teacher {

    private int experienceYears;

    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public  double  calculateSalary(){
        return getBaseSalary()*(1.10*experienceYears);
    }

}
