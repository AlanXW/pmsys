package net.teamx.bean;

public class Module {
    private String code;
    private String title;
    private int level;
    private String semester;
    private String coordinator;
    private String department;
    private String faculty;
    private int credit;
    private String[] assessment;
    private String[] dependency;
    private String[] outcomes;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String[] getAssessment() {
        return assessment;
    }

    public void setAssessment(String[] assessment) {
        this.assessment = assessment;
    }

    public String[] getDependency() {
        return dependency;
    }

    public void setDependency(String[] dependency) {
        this.dependency = dependency;
    }

    public String[] getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String[] outcomes) {
        this.outcomes = outcomes;
    }
}
