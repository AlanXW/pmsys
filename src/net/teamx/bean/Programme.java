package net.teamx.bean;

public class Programme {
    private String id;
    private String title;
    private String proposer;
    private int level;
    private String type;
    private String admin;
    private String department;
    private String faculty;
    private String requirements;
    private String[] outcomes;
    private String[] core_modules;
    private String[] optional_modules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String[] getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String[] outcomes) {
        this.outcomes = outcomes;
    }

    public String[] getCore_modules() {
        return core_modules;
    }

    public void setCore_modules(String[] core_modules) {
        this.core_modules = core_modules;
    }

    public String[] getOptional_modules() {
        return optional_modules;
    }

    public void setOptional_modules(String[] optional_modules) {
        this.optional_modules = optional_modules;
    }
}